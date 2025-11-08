package dev.encode42.conductor;

import eu.midnightdust.lib.config.MidnightConfig;

public class ConductorConfig extends MidnightConfig {
    public static final String PLAYERS = "players";
    public static final String WORLD = "world";

    @Entry(category = PLAYERS)
    public static boolean playersInvisible = true;

    @Entry(category = WORLD)
    public static float noteBlockVolume = 6.0f;
}
