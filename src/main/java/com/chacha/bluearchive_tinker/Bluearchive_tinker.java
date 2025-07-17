package com.chacha.bluearchive_tinker;

import com.chacha.bluearchive_tinker.Register.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Bluearchive_tinker.MODID)
public class Bluearchive_tinker {
    public static final String MODID = "bluearchive_tinker";

    public Bluearchive_tinker() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        BluearchiveItem.register(modEventBus);
        BluearchiveTab.register(modEventBus);
        BluearchiveFluid.register(modEventBus);
        BluearchiveModifier.register(modEventBus);
        BlueArchiveSounds.register(modEventBus);
    }

    public static String makeDescriptionId(String type, String name) {
        return type + "." + Bluearchive_tinker.MODID + "." + name;
    }

    public static ResourceLocation getResource(String path) {
        return new ResourceLocation(MODID, path);
    }


}
