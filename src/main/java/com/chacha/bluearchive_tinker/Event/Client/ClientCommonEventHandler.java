package com.chacha.bluearchive_tinker.Event.Client;

import com.chacha.bluearchive_tinker.BlueArchiveTinker;
import com.chacha.bluearchive_tinker.Content.Network.BlueArchiveTinkerChanel;
import com.chacha.bluearchive_tinker.Content.Network.Packet.EXExplodePacket;
import com.chacha.bluearchive_tinker.Register.BlueArchiveKeyBinding;
import com.chacha.bluearchive_tinker.Util.Vec3Helper;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = BlueArchiveTinker.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ClientCommonEventHandler {
    //后面需要监听按键可以来这边
    @SubscribeEvent
    public static void onKeyBindPress(InputEvent.Key event) {
        Player player = Minecraft.getInstance().player;
        if (player != null&&player.level().isClientSide()) {
            if(BlueArchiveKeyBinding.EX_KEY.consumeClick()){
                var entity= Vec3Helper.getPointedEntity(player,player.level(),20, LivingEntity.class,
                        LivingEntity::isAlive,
                        living -> false);
                if(entity!=null){
                    BlueArchiveTinkerChanel.SendToServer(new EXExplodePacket(entity.getUUID()));
                }
            }
        }
    }
}
