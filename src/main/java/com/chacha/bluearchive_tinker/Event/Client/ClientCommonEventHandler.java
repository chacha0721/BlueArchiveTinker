package com.chacha.bluearchive_tinker.Event.Client;

import com.chacha.bluearchive_tinker.BlueArchiveTinker;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = BlueArchiveTinker.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ClientCommonEventHandler {
    //后面需要监听按键可以来这边
    @SubscribeEvent
    public static void onKeyBindPress(InputEvent.Key event) {

    }
}
