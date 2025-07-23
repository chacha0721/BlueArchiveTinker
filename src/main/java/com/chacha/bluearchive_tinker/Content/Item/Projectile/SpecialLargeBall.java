package com.chacha.bluearchive_tinker.Content.Item.Projectile;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.LargeFireball;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;

public class SpecialLargeBall extends LargeFireball {
    public SpecialLargeBall(Level pLevel, LivingEntity pShooter, double pOffsetX, double pOffsetY, double pOffsetZ, int pExplosionPower) {
        super(pLevel, pShooter, pOffsetX, pOffsetY, pOffsetZ, pExplosionPower);
    }

    @Override
    public boolean isInvulnerableTo(DamageSource pSource) {
        return true;
    }

    @Override
    protected void onHit(HitResult pResult) {
        super.onHit(pResult);
        if (this.level() instanceof ServerLevel serverLevel) {
            var location=pResult.getLocation();
            serverLevel.sendParticles(ParticleTypes.EXPLOSION,location.x(), location.y(), location.z(), 2, 0, 0, 0, 0);
            this.discard();
        }
    }
}
