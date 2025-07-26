package com.chacha.bluearchive_tinker.Content.Modifier;

import com.chacha.bluearchive_tinker.BlueArchiveTinker;
import com.chacha.bluearchive_tinker.Content.Data.BlueArchiveTinkerBucketModelProvider;
import com.chacha.bluearchive_tinker.Content.Item.Projectile.SpecialLargeBall;
import com.chacha.bluearchive_tinker.Register.BlueArchiveModifier;
import com.chacha.bluearchive_tinker.Register.BlueArchiveToolNBTKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.LargeFireball;
import net.minecraft.world.phys.Vec3;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.ModifierHooks;
import slimeknights.tconstruct.library.modifiers.hook.combat.MeleeDamageModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.combat.MeleeHitModifierHook;
import slimeknights.tconstruct.library.module.ModuleHookMap;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.library.tools.nbt.ModDataNBT;

import java.util.UUID;

public class MikaNs extends Modifier implements MeleeDamageModifierHook, MeleeHitModifierHook {
    // 定义存储键 ResourceLocation 是 Minecraft 中用于唯一标识游戏内资源的类 通过 “命名空间（namespace）+ 路径（path）” 的格式
    private final ResourceLocation tool_count_key = BlueArchiveTinker.getResource("tool_attack_count");
    private static final float HEALTH_BONUS_PER_LEVEL = 0.2f;
    @Override
    public float getMeleeDamage(IToolStackView tool, ModifierEntry modifier, ToolAttackContext context, float baseDamage, float damage) {
        //获取工具容器
        ModDataNBT data = tool.getPersistentData();
        int attackCount =  data.getInt(tool_count_key);
        {if (attackCount >= 4) {
            damage *= 1.66f;
            attackCount = 0;
        }}
        data.putInt(tool_count_key, attackCount+1);
        LivingEntity target = context.getLivingTarget();
        if (target != null) {
            // healthPercent = 目标当前生命值 / 目前最大生命值
            float healthPercent = target.getHealth() / target.getMaxHealth();
            // 每级按目标生命百分比提供额外伤害（满血时达到最大值）
            float healthBonus = 1 + (healthPercent * HEALTH_BONUS_PER_LEVEL * modifier.getLevel());
            damage *= healthBonus;
        }
        return damage;
    }
    protected void registerHooks(ModuleHookMap.Builder hookBuilder) {
        hookBuilder.addHook(this, ModifierHooks.MELEE_DAMAGE, ModifierHooks.MELEE_HIT);
    }


}
