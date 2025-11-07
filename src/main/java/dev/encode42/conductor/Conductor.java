package dev.encode42.conductor;

import dev.encode42.conductor.events.PlayerJoin;
import net.fabricmc.api.ModInitializer;

public class Conductor implements ModInitializer {
    @Override
    public void onInitialize() {
        PlayerJoin.init();
    }
}
