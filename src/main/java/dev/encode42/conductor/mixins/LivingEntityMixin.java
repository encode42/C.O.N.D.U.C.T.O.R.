package dev.encode42.conductor.mixins;

import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {
    @Inject(method = "isPushable", at = @At(value = "HEAD"), cancellable = true)
    private void cancelPush(CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(false);
    }
}
