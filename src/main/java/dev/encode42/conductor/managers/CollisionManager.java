package dev.encode42.conductor.managers;

import dev.encode42.conductor.Conductor;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.scores.PlayerTeam;
import net.minecraft.world.scores.Scoreboard;
import net.minecraft.world.scores.Team;

public class CollisionManager {
	private final static String NO_COLLISION_TEAM_NAME = Conductor.MOD_ID + "_no_collision";

	public static PlayerTeam getCollisionTeam(MinecraftServer minecraftServer) {
		Scoreboard scoreboard = minecraftServer.getScoreboard();

		PlayerTeam playerTeam = scoreboard.getPlayerTeam(NO_COLLISION_TEAM_NAME);

		if (playerTeam == null) {
			playerTeam = scoreboard.addPlayerTeam(NO_COLLISION_TEAM_NAME);
			playerTeam.setCollisionRule(Team.CollisionRule.NEVER);
		}

		return playerTeam;
	}

	public static void updateCollision(MinecraftServer minecraftServer, Player player) {
		PlayerTeam playerTeam = getCollisionTeam(minecraftServer);

		if (player.getTeam() == playerTeam) {
			return;
		}

		Scoreboard scoreboard = minecraftServer.getScoreboard();

		scoreboard.addPlayerToTeam(player.getScoreboardName(), playerTeam);
	}
}
