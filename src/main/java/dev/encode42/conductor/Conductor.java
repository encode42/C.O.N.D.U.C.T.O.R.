package dev.encode42.conductor;

import dev.encode42.conductor.commands.PlayersInvisibleCommand;
import dev.encode42.conductor.events.PlayerJoinEvent;
import eu.midnightdust.lib.config.MidnightConfig;
import net.fabricmc.api.ModInitializer;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;

public class Conductor implements ModInitializer {
	public final static String MOD_ID = "conductor";

	private final static MobEffectInstance INVISIBILITY_EFFECT_INSTANCE = new MobEffectInstance(MobEffects.INVISIBILITY, -1, 0, true, false);
	private final static Holder<MobEffect> INVISIBILITY_EFFECT = INVISIBILITY_EFFECT_INSTANCE.getEffect();

	public static void updateInvisibility(Player player) {
		if (ConductorConfig.playersInvisible) {
			addInvisibility(player);

			return;
		}

		removeInvisibility(player);
	}

	public static void addInvisibility(Player player) {
		if (player.getPermissionLevel() > 1) {
			return;
		}

		player.addEffect(INVISIBILITY_EFFECT_INSTANCE);
	}

	public static void removeInvisibility(Player player) {
		player.removeEffect(INVISIBILITY_EFFECT);
	}

	@Override
	public void onInitialize() {
		MidnightConfig.init(Conductor.MOD_ID, ConductorConfig.class);

		PlayersInvisibleCommand.init();

		PlayerJoinEvent.init();
	}
}
