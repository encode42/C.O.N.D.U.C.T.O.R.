package dev.encode42.conductor.events;

import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerGamePacketListenerImpl;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;

public class PlayerJoin {
    public static void init() {
        MobEffectInstance invisibility = new MobEffectInstance(MobEffects.INVISIBILITY, -1, 0, true, false);

        ServerPlayConnectionEvents.JOIN.register((ServerGamePacketListenerImpl packetListener, PacketSender packetSender, MinecraftServer minecraftServer) -> {
            Player player = packetListener.getPlayer();

            if (player.getPermissionLevel() > 1) {
                return;
            }

            player.addEffect(invisibility);
        });
    }
}
