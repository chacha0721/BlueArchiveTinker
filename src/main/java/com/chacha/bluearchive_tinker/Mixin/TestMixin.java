package com.chacha.bluearchive_tinker.Mixin;

import com.chacha.bluearchive_tinker.Register.BlueArchiveModifier;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import slimeknights.tconstruct.library.tools.helper.ModifierUtil;

@Mixin(Player.class)
public abstract class TestMixin extends LivingEntity {
    protected TestMixin(EntityType<? extends LivingEntity> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    @Inject(method = "getAttackStrengthScale",at = @At("HEAD"), cancellable = true)
    private void setAttackStrength(float pAdjustTicks, CallbackInfoReturnable<Float> cir){
        if(ModifierUtil.getModifierLevel(this.getMainHandItem(), BlueArchiveModifier.MikiaStars.getId())>0){
            cir.setReturnValue(1f);
        }
    }
}
