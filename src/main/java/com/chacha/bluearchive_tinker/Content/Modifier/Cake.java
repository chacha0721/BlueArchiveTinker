package com.chacha.bluearchive_tinker.Content.Modifier;

import com.chacha.bluearchive_tinker.Register.BlueArchiveSounds;
import com.chacha.bluearchive_tinker.Util.DynamicComponentUtil;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.NotNull;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.ModifierHooks;
import slimeknights.tconstruct.library.modifiers.hook.armor.DamageBlockModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.armor.EquipmentChangeModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.behavior.AttributesModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.combat.MeleeHitModifierHook;
import slimeknights.tconstruct.library.modifiers.modules.build.VolatileFlagModule;
import slimeknights.tconstruct.library.module.ModuleHookMap;
import slimeknights.tconstruct.library.tools.context.EquipmentChangeContext;
import slimeknights.tconstruct.library.tools.context.EquipmentContext;
import slimeknights.tconstruct.library.tools.item.armor.ModifiableArmorItem;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.function.BiConsumer;

public class Cake extends Modifier implements MeleeHitModifierHook, EquipmentChangeModifierHook, AttributesModifierHook, DamageBlockModifierHook {
    protected void registerHooks(ModuleHookMap.Builder hookBuilder) {
        hookBuilder.addHook(this, ModifierHooks.EQUIPMENT_CHANGE);
        hookBuilder.addModule(new VolatileFlagModule(ModifiableArmorItem.ELYTRA));
        hookBuilder.addHook(this, ModifierHooks.ATTRIBUTES);
        hookBuilder.addHook(this, ModifierHooks.DAMAGE_BLOCK);
        // 其他钩子...
        //身上安装个鞘翅
    }

    public void onEquip(IToolStackView tool, ModifierEntry modifier, EquipmentChangeContext context) {
        if (context.getEntity() instanceof Player player && !player.getAbilities().mayfly && !player.getAbilities().flying && !player.isCreative() && !player.isSpectator()) {
            //判断玩家 没有飞行  不是创造 不是观察者
            player.getAbilities().flying = true;
            //穿上后可以飞行
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

    @Override
    public void addAttributes(IToolStackView tool, ModifierEntry modifier, EquipmentSlot slot, BiConsumer<Attribute, AttributeModifier> consumer) {
        // 生命值算法 = 生命值（唯一id槽位不冲突 生命值，绳）
        float CakeLevel = modifier.getLevel() * 0.25f;
        var AttributeModifier = new AttributeModifier(getUUID(this, slot, Attributes.MAX_HEALTH), Attributes.MAX_HEALTH.getDescriptionId(), CakeLevel, net.minecraft.world.entity.ai.attributes.AttributeModifier.Operation.MULTIPLY_TOTAL);
        consumer.accept(Attributes.MAX_HEALTH, AttributeModifier);

    }

    private UUID getUUID(Modifier modifier, EquipmentSlot slot, Attribute attribute) {
        //类型  名称 = 模组名称+槽位id+attribute项对应的字符串
        String s = modifier.getId() + slot.getName() + attribute.getDescriptionId();
        //返回
        return UUID.nameUUIDFromBytes(s.getBytes());
    }

    @Override
    public @NotNull List<Component> getDescriptionList(int level) {
        int[] color = new int[]{0xFEEAF3, 0xffaaff, 0x55c4ff};
        if (descriptionList == null) {
            descriptionList = Arrays.asList(DynamicComponentUtil.scrollColorfulText.getColorfulText(getTranslationKey() + ".flavor", null, color, 20, 20, true),
                    DynamicComponentUtil.scrollColorfulText.getColorfulText(getTranslationKey() + ".description", null, color, 20, 1000, true))
            ;
        }
        return super.getDescriptionList(level);
    }

    @Override
    public boolean isDamageBlocked(IToolStackView tool, ModifierEntry modifier, EquipmentContext context, EquipmentSlot slotType, DamageSource source, float amount) {
        var random = new Random();
        int number = random.nextInt(100);
        var living = context.getEntity();
        if (number > 95) {
            if (source.getEntity() != null) {
                living.level().playSound(null, living, BlueArchiveSounds.MIKAAHHH.get(), SoundSource.NEUTRAL, 1, 1);
                return true;
            }
        }
        return false;
    }
}
