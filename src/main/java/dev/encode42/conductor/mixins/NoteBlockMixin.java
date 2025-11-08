package dev.encode42.conductor.mixins;

import dev.encode42.conductor.ConductorConfig;
import net.minecraft.world.level.block.NoteBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(NoteBlock.class)
public class NoteBlockMixin {
    @ModifyArg(
            method = "triggerEvent",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/level/Level;playSeededSound(Lnet/minecraft/world/entity/Entity;DDDLnet/minecraft/core/Holder;Lnet/minecraft/sounds/SoundSource;FFJ)V"
            ),
            index = 6
    )
    private float noteVolume(float volume) {
        return ConductorConfig.noteBlockVolume;
    }
}
