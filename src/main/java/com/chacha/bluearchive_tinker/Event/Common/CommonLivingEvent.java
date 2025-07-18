package com.chacha.bluearchive_tinker.Event.Common;

import com.chacha.bluearchive_tinker.BlueArchiveTinker;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = BlueArchiveTinker.MODID)
public class CommonLivingEvent {
    @SubscribeEvent
    public static void onDeath(LivingDeathEvent event) {

    }
}
