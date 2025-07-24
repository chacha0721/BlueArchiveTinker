package com.chacha.bluearchive_tinker.Content.Data;

import com.chacha.bluearchive_tinker.BlueArchiveTinker;
import com.chacha.bluearchive_tinker.Register.BlueArchiveDamageType;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.DamageTypeTagsProvider;
import net.minecraft.tags.DamageTypeTags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class BlueArchiveTinkerDamageTypeTagProvider extends DamageTypeTagsProvider {
    public BlueArchiveTinkerDamageTypeTagProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookup, @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, lookup, BlueArchiveTinker.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider pProvider) {
        tag(DamageTypeTags.BYPASSES_COOLDOWN).add(BlueArchiveDamageType.MIKA_EXPLODE);
        tag(DamageTypeTags.IS_EXPLOSION).add(BlueArchiveDamageType.MIKA_EXPLODE);
    }
}
