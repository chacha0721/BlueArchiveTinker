package com.chacha.bluearchive_tinker.Content.Modifier;

import com.chacha.bluearchive_tinker.Register.BlueArchiveItem;
import com.chacha.bluearchive_tinker.Util.DynamicComponentUtil;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import org.jetbrains.annotations.NotNull;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.ModifierHooks;
import slimeknights.tconstruct.library.modifiers.hook.behavior.ProcessLootModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.combat.MeleeDamageModifierHook;
import slimeknights.tconstruct.library.module.ModuleHookMap;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

import java.util.Arrays;
import java.util.List;

public class MikaCake extends Modifier implements ProcessLootModifierHook , MeleeDamageModifierHook {
    @Override
    protected void registerHooks(ModuleHookMap.Builder hookBuilder) {
        hookBuilder.addHook(this,ModifierHooks.PROCESS_LOOT,ModifierHooks.MELEE_DAMAGE);
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
    public void processLoot(IToolStackView tool, ModifierEntry modifier, List<ItemStack> generatedLoot, LootContext context) {
        //击杀目标最大生命>20的生物随机1-3
        var target=context.getParamOrNull(LootContextParams.THIS_ENTITY);
        if(target instanceof LivingEntity living&&living.getMaxHealth()>20){
            int count=target.level().getRandom().nextInt(3)+1;
            ItemStack mikaCake=new ItemStack(BlueArchiveItem.MikeCake.get(),count);
            generatedLoot.add(mikaCake);
        }
    }

    @Override
    public float getMeleeDamage(IToolStackView tool, ModifierEntry modifier, ToolAttackContext context, float baseDamage, float damage) {
        var player=context.getPlayerAttacker();
        if(player==null)return damage;
        int cakeCount=player.getInventory().countItem(BlueArchiveItem.MikeCake.get());
        return damage * Math.min(1+cakeCount * 0.03f,2.5f);
    }
}
