package dev.encode42.conductor;

import dev.encode42.conductor.commands.PlayersInvisibleCommand;
import dev.encode42.conductor.events.PlayerJoinEvent;
import eu.midnightdust.lib.config.MidnightConfig;
import net.fabricmc.api.ModInitializer;

public class Conductor implements ModInitializer {
	public final static String MOD_ID = "conductor";

	@Override
	public void onInitialize() {
		MidnightConfig.init(Conductor.MOD_ID, ConductorConfig.class);

		PlayersInvisibleCommand.init();

		PlayerJoinEvent.init();
	}
}
