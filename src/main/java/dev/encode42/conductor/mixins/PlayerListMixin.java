package dev.encode42.conductor.mixins;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.ChatType;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.PlayerChatMessage;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.players.PlayerList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerList.class)
public class PlayerListMixin {
    @Unique
    private final Component message = Component.literal("Chat is disabled for this event!").withStyle(ChatFormatting.RED);

    @Inject(method = "broadcastChatMessage(Lnet/minecraft/network/chat/PlayerChatMessage;Lnet/minecraft/server/level/ServerPlayer;Lnet/minecraft/network/chat/ChatType$Bound;)V", at = @At(value = "HEAD"), cancellable = true)
    private void cancelMessage(PlayerChatMessage playerChatMessage, ServerPlayer serverPlayer, ChatType.Bound bound, CallbackInfo ci) {
        if (serverPlayer.getPermissionLevel() > 1) {
            return;
        }
		if (serverPlayer.getPermissionLevel() > 2) {

        serverPlayer.sendSystemMessage(message);

        ci.cancel();
    }
}
