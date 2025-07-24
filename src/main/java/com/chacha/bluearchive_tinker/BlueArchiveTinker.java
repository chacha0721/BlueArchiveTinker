package com.chacha.bluearchive_tinker;

import com.chacha.bluearchive_tinker.Content.Network.BlueArchiveTinkerChanel;
import com.chacha.bluearchive_tinker.Register.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(BlueArchiveTinker.MODID)
public class BlueArchiveTinker {
    public static final String MODID = "bluearchive_tinker";

    public BlueArchiveTinker() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        BlueArchiveItem.register(modEventBus);
        BlueArchiveTab.register(modEventBus);
        BlueArchiveFluid.register(modEventBus);
        BlueArchiveModifier.register(modEventBus);
        BlueArchiveSounds.register(modEventBus);
        BlueArchiveTinkerChanel.register();
        BlueArchiveDamageType.init();
    }

    public static String makeDescriptionId(String type, String name) {
        return type + "." + BlueArchiveTinker.MODID + "." + name;
    }

    public static ResourceLocation getResource(String path) {
        return new ResourceLocation(MODID, path);
    }


}
