package com.chacha.bluearchive_tinker.Content.Network;

import com.chacha.bluearchive_tinker.BlueArchiveTinker;
import com.chacha.bluearchive_tinker.Content.Network.Packet.EXExplodePacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.simple.SimpleChannel;

public class BlueArchiveTinkerChanel {
    private static SimpleChannel INSTANCE;
    public static int packetID = 0;

    public static int id() {
        return packetID++;
    }

    public static void register() {
        SimpleChannel net = NetworkRegistry.ChannelBuilder
                .named(new ResourceLocation(BlueArchiveTinker.MODID, "messages"))
                .networkProtocolVersion(() -> "1.0")
                .clientAcceptedVersions(s -> true)
                .serverAcceptedVersions(s -> true)
                .simpleChannel();
        INSTANCE = net;
        net.messageBuilder(EXExplodePacket.class,id(), NetworkDirection.PLAY_TO_SERVER)
                .decoder(EXExplodePacket::new)
                .encoder(EXExplodePacket::toByte)
                .consumerMainThread(EXExplodePacket::handle)
                .add();
    }

    public static <MSG> void SendToServer(MSG msg) {
        INSTANCE.sendToServer(msg);
    }

    public static <MSG> void SendToPlayer(MSG msg, ServerPlayer player) {
        INSTANCE.send(PacketDistributor.PLAYER.with(() -> player), msg);
    }
    public static <MSG> void sendToClient(MSG msg) {
        INSTANCE.send(PacketDistributor.ALL.noArg(), msg);
    }
    public static <MSG> void sendToTrackingAndSelf(MSG msg, ServerPlayer player) {
        INSTANCE.send(PacketDistributor.TRACKING_ENTITY_AND_SELF.with(() -> player), msg);
    }
}