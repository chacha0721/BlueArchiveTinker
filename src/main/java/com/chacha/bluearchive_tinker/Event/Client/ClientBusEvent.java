package com.chacha.bluearchive_tinker.Event.Client;

import com.chacha.bluearchive_tinker.BlueArchiveTinker;
import com.chacha.bluearchive_tinker.Register.BlueArchiveKeyBinding;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = BlueArchiveTinker.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientBusEvent {
    //注册实体渲染器来这边
    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {

    }
    //注册按键来这边
    @SubscribeEvent
    public static void onKeyRegister(RegisterKeyMappingsEvent event) {
        BlueArchiveKeyBinding.register(event);
    }
}
