package blue_archive.BlueArchiveModifier;

import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.ForgeRegistries;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.ModifierHooks;
import slimeknights.tconstruct.library.modifiers.hook.combat.MeleeHitModifierHook;
import slimeknights.tconstruct.library.module.ModuleHookMap;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

public class PlayTwo extends Modifier implements MeleeHitModifierHook {
    @Override
    protected void registerHooks(ModuleHookMap.Builder hookBuilder) {
        hookBuilder.addHook(this, ModifierHooks.MELEE_HIT);
    }

    @Override
    public void afterMeleeHit(IToolStackView tool, ModifierEntry modifier, ToolAttackContext context, float damageDealt) {
        var collcetion= ForgeRegistries.ITEMS.getValues();
        if (context.getAttacker()instanceof Player player&&context.getLivingTarget()!=null)
        {

            var target =context.getLivingTarget();
            var source= player.level().getRandom();
            int a=source.nextInt(collcetion.size());
            var list=collcetion.stream().toList();
            var itemStack =new ItemStack(list.get(a));
            var itemEntity=new ItemEntity(target.level(),target.getX(),target.getY(),target.getZ(),itemStack);
            player.level().addFreshEntity(itemEntity);
        }
    }
}
