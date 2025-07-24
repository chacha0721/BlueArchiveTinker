package com.chacha.bluearchive_tinker.Content.Data;

import com.chacha.bluearchive_tinker.Register.BlueArchiveDamageType;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.world.damagesource.DamageEffects;
import net.minecraft.world.damagesource.DamageType;
import org.jetbrains.annotations.NotNull;

public class BlueArchiveTinkerDamageTypeProvider implements RegistrySetBuilder.RegistryBootstrap<DamageType> {
    public static void register(RegistrySetBuilder builder) {
        builder.add(Registries.DAMAGE_TYPE, new BlueArchiveTinkerDamageTypeProvider());
    }

    @Override
    public void run(@NotNull BootstapContext<DamageType> context) {
        context.register(BlueArchiveDamageType.MIKA_EXPLODE, new DamageType("mika_explode", 0.1f, DamageEffects.BURNING));
    }
}
