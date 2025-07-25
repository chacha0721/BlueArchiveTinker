package com.chacha.bluearchive_tinker.Content.Modifier;

import com.chacha.bluearchive_tinker.Content.Item.Projectile.SpecialLargeBall;
import com.chacha.bluearchive_tinker.Register.BlueArchiveToolNBTKey;
import com.chacha.bluearchive_tinker.Util.DynamicComponentUtil;
import com.chacha.bluearchive_tinker.Util.compound.MobEffectUtil;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.LargeFireball;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.event.entity.player.CriticalHitEvent;
import org.jetbrains.annotations.NotNull;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.ModifierHooks;
import slimeknights.tconstruct.library.modifiers.hook.armor.EquipmentChangeModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.build.ConditionalStatModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.combat.MeleeDamageModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.combat.MeleeHitModifierHook;
import slimeknights.tconstruct.library.module.ModuleHookMap;
import slimeknights.tconstruct.library.tools.context.EquipmentChangeContext;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;


public class MikaStars extends Modifier implements MeleeDamageModifierHook, MeleeHitModifierHook, EquipmentChangeModifierHook{
    @Override
    protected void registerHooks(ModuleHookMap.Builder hookBuilder) {
        hookBuilder.addHook(this, ModifierHooks.MELEE_DAMAGE, ModifierHooks.MELEE_HIT, ModifierHooks.EQUIPMENT_CHANGE);
    }

    private static final Map<UUID, Float> MIKA_FIRE_BALL_DAMAGE_SHOULD_BE = new ConcurrentHashMap<>();


    public float getMeleeDamage(IToolStackView tool, ModifierEntry modifier, ToolAttackContext context, float baseDamage, float damage) {
        var target = context.getLivingTarget();
        var player = context.getPlayerAttacker();
        if (player == null) return damage;
        if (target != null && player instanceof ServerPlayer serverPlayer) {
            if (target.getArmorValue() < player.getArmorValue()) {
                damage = damage * 2f;
            }
            if (!context.isCritical()) {
                CriticalHitEvent hitResult = ForgeHooks.getCriticalHit(context.getPlayerAttacker(), context.getLivingTarget(), true, 1.5f);
                if (hitResult != null && context.getLevel().getServer() != null) {
                    player.crit(target);
                    serverPlayer.serverLevel().playSound(null, player.getOnPos(), SoundEvents.PLAYER_ATTACK_CRIT, SoundSource.AMBIENT, 1f, 1f);
                    damage = damage * hitResult.getDamageModifier();
                }
            }
        }
        MIKA_FIRE_BALL_DAMAGE_SHOULD_BE.put(player.getUUID(), damage);
        return damage;
    }

    @Override
    public int getPriority() {
        return 99;
    }

    @Override
    public void afterMeleeHit(IToolStackView tool, ModifierEntry modifier, ToolAttackContext context, float damageDealt) {
        var target = context.getLivingTarget();
        var attacker = context.getAttacker();
        if (!(attacker instanceof Player player)) return;
        if (target == null) return;
        target.setDeltaMovement(new Vec3(0, 0.1, 0));
        var data = tool.getPersistentData();
        int time = data.getInt(BlueArchiveToolNBTKey.MIKA_ATTACK);
        if (time < 3) {
            if (time == 2) {
                attacker.level().playSound(null, player, SoundEvents.PLAYER_LEVELUP, SoundSource.AMBIENT, 1, 0.5f);
            }
            data.putInt(BlueArchiveToolNBTKey.MIKA_ATTACK, time + 1);
        } else {
            var targetPosition = target.position();
            for (int b = 0; b < 7; b++) {
                int pas = target.level().getRandom().nextInt(8) - 4;
                var spawnPos = targetPosition.add(pas, 7, pas);
                var angle = targetPosition.subtract(spawnPos);
                float lastCauseDamage = MIKA_FIRE_BALL_DAMAGE_SHOULD_BE.getOrDefault(player.getUUID(),0f);
                LargeFireball fireball = new SpecialLargeBall(player.level(), player, angle.x(), angle.y(), angle.z(), lastCauseDamage);
                fireball.setPos(spawnPos);
                player.level().addFreshEntity(fireball);
            }
            data.putInt(BlueArchiveToolNBTKey.MIKA_ATTACK, 0);
        }
    }

    @Override
    public @NotNull List<Component> getDescriptionList(int level) {
        int[] color = new int[]{0xFEEAF3, 0xffaaff, 0x55c4ff};
        if (descriptionList == null) {
            descriptionList = Arrays.asList(
                    DynamicComponentUtil.scrollColorfulText.getColorfulText(getTranslationKey() + ".flavor", null, color, 20, 20, true),
                    DynamicComponentUtil.scrollColorfulText.getColorfulText(getTranslationKey() + ".description", null, color, 20, 1000, true));
        }
        return super.getDescriptionList(level);
    }

    @Override
    public void onEquip(IToolStackView tool, ModifierEntry modifier, EquipmentChangeContext context) {
        if (context.getEntity() instanceof Player player && !player.getAbilities().mayfly && !player.getAbilities().flying && !player.isCreative() && !player.isSpectator()) {
            player.getAbilities().flying = true;
            player.getAbilities().mayfly = true;
        }
    }

    @Override
    public void onUnequip(IToolStackView tool, ModifierEntry modifier, EquipmentChangeContext context) {
        if ((context.getEntity() instanceof Player player && player.getAbilities().mayfly && player.getAbilities().flying && !player.isCreative() && !player.isSpectator())) {
            player.getAbilities().flying = false;
            player.getAbilities().mayfly = false;
        }
    }
}
