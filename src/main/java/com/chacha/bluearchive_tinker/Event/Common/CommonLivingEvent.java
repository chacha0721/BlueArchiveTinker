package com.chacha.bluearchive_tinker.Event.Common;

import com.chacha.bluearchive_tinker.BlueArchiveTinker;
import com.chacha.bluearchive_tinker.Register.BlueArchiveItem;
import com.chacha.bluearchive_tinker.Register.BlueArchiveModifier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import slimeknights.tconstruct.library.tools.helper.ModifierUtil;

@Mod.EventBusSubscriber(modid = BlueArchiveTinker.MODID)
public class CommonLivingEvent {
    @SubscribeEvent
    public static void onAttackWithMikaCake(LivingHurtEvent event) {
        var entity=event.getSource().getEntity();
        boolean hasMikaCakeModifier=false;
        if(entity instanceof Player player){
            for(ItemStack stack:player.getInventory().armor){
                if(ModifierUtil.getModifierLevel(stack, BlueArchiveModifier.MikaCake.getId())>0){
                    hasMikaCakeModifier=true;
                    break;
                }
            }
            int cakeCount=player.getInventory().countItem(BlueArchiveItem.MikaCake.get());
            if(hasMikaCakeModifier){
                event.setAmount(event.getAmount() * Math.min(1+cakeCount * 0.03f,2.5f));
            }
        }
    }
    @SubscribeEvent
    public static void onLivingExplodeFromData(LivingEvent.LivingTickEvent event){
        var entity=event.getEntity();
        if(entity.level().isClientSide())return;
        if(entity.getPersistentData().getBoolean("blue_archive_tinker:should_explode")){
            entity.level().explode(null,entity.getX(),entity.getY(),entity.getZ(),5,true, Level.ExplosionInteraction.TNT);
        }
    }
}
