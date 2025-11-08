package dev.encode42.conductor.commands;

import com.mojang.brigadier.arguments.BoolArgumentType;
import com.mojang.brigadier.context.CommandContext;
import dev.encode42.conductor.Conductor;
import dev.encode42.conductor.ConductorConfig;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.entity.player.Player;

public class PlayersInvisibleCommand {
	private static final String enabledArgument = "isEnabled";

	public static void init() {
		CommandRegistrationCallback.EVENT.register((commandDispatcher, commandBuildContext, commandSelection) -> {
			commandDispatcher.register(
				Commands.literal("playersInvisible")
					.requires(requirement -> requirement.hasPermission(3))
					.then(Commands.argument(enabledArgument, BoolArgumentType.bool()).executes(PlayersInvisibleCommand::execute)));
		});
	}

	public static int execute(CommandContext<CommandSourceStack> commandContext) {
		boolean isEnabled = BoolArgumentType.getBool(commandContext, enabledArgument);

		ConductorConfig.playersInvisible = isEnabled;
		ConductorConfig.write(Conductor.MOD_ID);

		MinecraftServer server = commandContext.getSource().getServer();

		for (Player player : server.getPlayerList().getPlayers()) {
			Conductor.updateInvisibility(player);
		}

		commandContext.getSource().sendSuccess(() -> Component.literal("Player invisibility is now set to: %s".formatted(isEnabled)), false);

		return 1;
	}
}
