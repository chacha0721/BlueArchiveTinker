package com.chacha.bluearchive_tinker.Content.Data;

import com.chacha.bluearchive_tinker.BlueArchiveTinker;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = BlueArchiveTinker.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class BlueArchiveDataGenerator {
    @SubscribeEvent(priority = EventPriority.NORMAL)
    public static void gatherData(@NotNull GatherDataEvent event) {
        RegistrySetBuilder registrySetBuilder = new RegistrySetBuilder();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        net.minecraft.data.DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        boolean server = event.includeServer();
        DatapackBuiltinEntriesProvider datapackRegistryProvider = new DatapackBuiltinEntriesProvider(output, lookupProvider, registrySetBuilder, Set.of(BlueArchiveTinker.MODID));

        generator.addProvider(server, datapackRegistryProvider);
        BlueArchiveTinkerDamageTypeProvider.register(registrySetBuilder);
        generator.addProvider(server, new BlueArchiveTinkerBucketModelProvider(output, BlueArchiveTinker.MODID));
        generator.addProvider(server, new BlueArchiveTinkerDamageTypeTagProvider(output, datapackRegistryProvider.getRegistryProvider(), existingFileHelper));
    }
}

