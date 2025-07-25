package com.chacha.bluearchive_tinker.Content.Modifier;

import com.chacha.bluearchive_tinker.BlueArchiveTinker;
import net.minecraft.resources.ResourceLocation;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.ModifierHooks;
import slimeknights.tconstruct.library.modifiers.hook.build.ToolStatsModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.combat.MeleeDamageModifierHook;
import slimeknights.tconstruct.library.module.ModuleHookMap;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IToolContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.library.tools.nbt.ToolStack;
import slimeknights.tconstruct.library.tools.stat.ModifierStatsBuilder;
import slimeknights.tconstruct.library.tools.stat.ToolStats;

public class SetStats extends Modifier implements MeleeDamageModifierHook , ToolStatsModifierHook {
    private static final ResourceLocation extraDurability=new ResourceLocation(BlueArchiveTinker.MODID,"extradurability");
    @Override
    protected void registerHooks(ModuleHookMap.Builder hookBuilder) {
        hookBuilder.addHook(this, ModifierHooks.MELEE_DAMAGE,ModifierHooks.TOOL_STATS);
    }

    @Override
    public float getMeleeDamage(IToolStackView tool, ModifierEntry modifier, ToolAttackContext context, float baseDamage, float damage) {
        if(context.getPlayerAttacker()==null)return damage;
        int addDurability=tool.getPersistentData().getInt(extraDurability);
        tool.getPersistentData().putInt(extraDurability,addDurability+20);
        var toolStack=ToolStack.from(context.getPlayerAttacker().getMainHandItem());
        toolStack.rebuildStats();
        return damage;
    }

    @Override
    public void addToolStats(IToolContext context, ModifierEntry modifier, ModifierStatsBuilder builder) {
        int addDurability=context.getPersistentData().getInt(extraDurability);
        if(addDurability>0){
            ToolStats.DURABILITY.add(builder,addDurability);
        }
    }
}
