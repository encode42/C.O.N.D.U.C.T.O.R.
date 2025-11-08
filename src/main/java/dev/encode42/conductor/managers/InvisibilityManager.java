package dev.encode42.conductor.managers;

import dev.encode42.conductor.ConductorConfig;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;

public class InvisibilityManager {
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
}
