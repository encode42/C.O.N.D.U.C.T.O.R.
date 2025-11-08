package dev.encode42.conductor.events;

import dev.encode42.conductor.Conductor;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerGamePacketListenerImpl;

public class PlayerJoinEvent {
	public static void init() {
		ServerPlayConnectionEvents.JOIN.register((ServerGamePacketListenerImpl packetListener, PacketSender packetSender, MinecraftServer minecraftServer) -> {
			Conductor.updateInvisibility(packetListener.getPlayer());
		});
	}
}
