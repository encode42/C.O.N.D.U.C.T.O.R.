package dev.encode42.conductor.events;

import dev.encode42.conductor.managers.CollisionManager;
import dev.encode42.conductor.managers.InvisibilityManager;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerGamePacketListenerImpl;
import net.minecraft.world.entity.player.Player;

public class PlayerJoinEvent {
	public static void init() {
		ServerPlayConnectionEvents.JOIN.register((ServerGamePacketListenerImpl packetListener, PacketSender packetSender, MinecraftServer minecraftServer) -> {
			Conductor.updateInvisibility(packetListener.getPlayer());
			Player player = packetListener.getPlayer();
			CollisionManager.updateCollision(minecraftServer, player);
		});
	}
}
