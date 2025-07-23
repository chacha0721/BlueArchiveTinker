package com.chacha.bluearchive_tinker.Content.Network.Packet;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;

import java.util.UUID;
import java.util.function.Supplier;

public class EXExplodePacket {
    private final UUID targetUUID;
    public EXExplodePacket(UUID uuid) {
        this.targetUUID=uuid;
    }

    public EXExplodePacket(FriendlyByteBuf buf) {
        targetUUID=buf.readUUID();
    }

    public void toByte(FriendlyByteBuf buf) {
        buf.writeUUID(targetUUID);
    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            ServerPlayer player = context.getSender();
            if (player != null) {
                ServerLevel level = player.serverLevel();
                var entity=level.getEntity(targetUUID);
                if (entity != null) {
                    entity.getPersistentData().putBoolean("blue_archive_tinker:should_explode",true);
                }
            }
        });
        return true;
    }
}
