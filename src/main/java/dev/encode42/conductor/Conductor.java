package dev.encode42.conductor;

import dev.encode42.conductor.events.PlayerJoin;
import eu.midnightdust.lib.config.MidnightConfig;
import net.fabricmc.api.ModInitializer;

public class Conductor implements ModInitializer {
    @Override
    public void onInitialize() {
        PlayerJoin.init();
    }
	public final static String MOD_ID = "conductor";

		MidnightConfig.init(Conductor.MOD_ID, ConductorConfig.class);

}
