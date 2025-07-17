package com.chacha.bluearchive_tinker.Content.Modifier;

import com.chacha.bluearchive_tinker.Util.DynamicComponentUtil;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.event.entity.player.CriticalHitEvent;
import org.jetbrains.annotations.Nullable;
import slimeknights.mantle.client.TooltipKey;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.ModifierHooks;
import slimeknights.tconstruct.library.modifiers.hook.armor.EquipmentChangeModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.combat.MeleeDamageModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.combat.MeleeHitModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.interaction.InventoryTickModifierHook;
import slimeknights.tconstruct.library.module.ModuleHookMap;
import slimeknights.tconstruct.library.tools.context.EquipmentChangeContext;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

import java.util.Arrays;
import java.util.List;


public class MikaStars extends Modifier implements MeleeDamageModifierHook, MeleeHitModifierHook, InventoryTickModifierHook, EquipmentChangeModifierHook {

//EQUIPMENT_CHANGE

    protected void registerHooks(ModuleHookMap.Builder hookBuilder) {
        hookBuilder.addHook(this, ModifierHooks.MELEE_DAMAGE, ModifierHooks.MELEE_HIT, ModifierHooks.INVENTORY_TICK, ModifierHooks.EQUIPMENT_CHANGE);
    }


    public float getMeleeDamage(IToolStackView tool, ModifierEntry modifier, ToolAttackContext context, float baseDamage, float damage) {
        //检测护甲
        var target = context.getLivingTarget();
        var player = context.getPlayerAttacker();
        if (target != null && player instanceof ServerPlayer serverPlayer) {
            if (target.getArmorValue() < player.getArmorValue()) {
                //修改伤害用局部变量缓存
                damage = damage * 2f;

            }
            //不暴击的时候才强制暴击伤害
            if (!context.isCritical()) {
                //获取全局宝具伤害加成
                CriticalHitEvent hitResult = ForgeHooks.getCriticalHit(context.getPlayerAttacker(), context.getLivingTarget(), true, 1.5f);
                //如果呗别的事情取消了，不暴击
                if (hitResult == null) return damage;
                //必须发生服务端
                if (context.getLevel().getServer() != null) {
                    //player的暴击方法，在localplayer执行粒子
                    player.crit(target);
                    //音效
                    serverPlayer.serverLevel().playSound(null, player.getOnPos(), SoundEvents.PLAYER_ATTACK_CRIT, SoundSource.AMBIENT, 1f, 1f);
                    //返回最终伤害
                    return damage * hitResult.getDamageModifier();
                }
            }
        }
        return damage;
    }


    public void onInventoryTick(IToolStackView tool, ModifierEntry modifier, Level world, LivingEntity holder, int itemSlot, boolean isSelected, boolean isCorrectSlot, ItemStack stack) {
        float ArmorPoints = holder.getArmorValue();

    }

    @Override
    public void afterMeleeHit(IToolStackView tool, ModifierEntry modifier, ToolAttackContext context, float damageDealt) {
        var attacker = context.getAttacker();
        var target = context.getLivingTarget();


        //onGround 地面
        if (target != null) {

            target.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 200, 2));
            target.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 200, 2));
            target.addEffect(new MobEffectInstance(MobEffects.HARM, 100, 0));
            target.addEffect(new MobEffectInstance(MobEffects.GLOWING, 2000, 0));
            target.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 100, 2));
            target.setDeltaMovement(new Vec3(0, 0.1, 0));

        }


    }

    @Override
    public List<Component> getDescriptionList(int level) {
        int[] color = new int[]{0xFEEAF3, 0xffaaff, 0x55c4ff};
        if (descriptionList == null) {
            descriptionList = Arrays.asList(DynamicComponentUtil.scrollColorfulText.getColorfulText(getTranslationKey() + ".flavor", null, color, 20, 20, true),
                    DynamicComponentUtil.scrollColorfulText.getColorfulText(getTranslationKey() + ".description", null, color, 20, 1000, true))
            ;
        }
        return super.getDescriptionList(level);
    }

    public void addTooltip(IToolStackView tool, ModifierEntry modifier, @Nullable Player player, List<Component> tooltip, TooltipKey tooltipKey, TooltipFlag tooltipFlag) {
        int[] color = new int[]{0xFEEAF3, 0xffaaff, 0x55c4ff};
        tooltip.add(DynamicComponentUtil.scrollColorfulText.getColorfulText(getTranslationKey() + ".description", null, color, 15, 20, true));
    }

    @Override
    public void onEquip(IToolStackView tool, ModifierEntry modifier, EquipmentChangeContext context) //onEuip 检测穿上
    {
        if (context.getEntity() instanceof Player player && !player.getAbilities().mayfly && !player.getAbilities().flying && !player.isCreative() && !player.isSpectator()) {
            //判断玩家 没有飞行  不是创造 不是观察者
            player.getAbilities().flying = true;
            //穿上后可以飞行
            player.getAbilities().mayfly = true;


        }

    }

    @Override
    public void onUnequip(IToolStackView tool, ModifierEntry modifier, EquipmentChangeContext context) //onUnequip检测 脱下
    {
        if ((context.getEntity() instanceof Player player && player.getAbilities().mayfly && player.getAbilities().flying && !player.isCreative() && !player.isSpectator())) {
            player.getAbilities().flying = false;
            player.getAbilities().mayfly = false;
        }
    }

    @Override
    public float beforeMeleeHit(IToolStackView tool, ModifierEntry modifier, ToolAttackContext context, float damage, float baseKnockback, float knockback) {

        return damage;
    }


}
