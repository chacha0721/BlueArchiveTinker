package com.chacha.bluearchive_tinker.Content.Item.Projectile;

import com.chacha.bluearchive_tinker.Register.BlueArchiveDamageType;
import lombok.Getter;
import lombok.Setter;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.LargeFireball;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;

public class SpecialLargeBall extends LargeFireball {
    @Getter
    @Setter
    private float fireBallDamage;
    public SpecialLargeBall(Level pLevel, LivingEntity pShooter, double pOffsetX, double pOffsetY, double pOffsetZ,float damageAmount) {
        super(pLevel, pShooter, pOffsetX, pOffsetY, pOffsetZ, 0);
        fireBallDamage=damageAmount;
    }

    @Override
    public boolean isInvulnerableTo(DamageSource pSource) {
        return true;
    }

    @Override
    protected void onHit(HitResult pResult) {
        //原projectile的onHit逻辑
        HitResult.Type hitresult$type = pResult.getType();
        if (hitresult$type == HitResult.Type.ENTITY) {
            this.onHitEntity((EntityHitResult)pResult);
            this.level().gameEvent(GameEvent.PROJECTILE_LAND, pResult.getLocation(), GameEvent.Context.of(this, null));
        } else if (hitresult$type == HitResult.Type.BLOCK) {
            BlockHitResult blockhitresult = (BlockHitResult)pResult;
            this.onHitBlock(blockhitresult);
            BlockPos blockpos = blockhitresult.getBlockPos();
            this.level().gameEvent(GameEvent.PROJECTILE_LAND, blockpos, GameEvent.Context.of(this, this.level().getBlockState(blockpos)));
        }
        //自己的逻辑
        if (this.level() instanceof ServerLevel serverLevel) {
            var location=pResult.getLocation();
            serverLevel.sendParticles(ParticleTypes.EXPLOSION,location.x(), location.y(), location.z(), 2, 0, 0, 0, 0);
            this.discard();
        }
    }

    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        if (!this.level().isClientSide) {
            Entity target = pResult.getEntity();
            Entity owner = this.getOwner();
            var source= BlueArchiveDamageType.source(level(),BlueArchiveDamageType.MIKA_EXPLODE,null,null);
            if(owner==null)return;
            this.level().playSound(null,target.blockPosition(), SoundEvents.GENERIC_EXPLODE, SoundSource.AMBIENT,1,1);
            if(target==owner)return;
            target.hurt(source, fireBallDamage);
        }
    }
}
