package blue_archive.bluearchive_tinker;

import blue_archive.bluearchive_tinker.Register.*;
import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;

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




    public void onServerStarting(ServerStartingEvent event) {
    }
    public static String makeDescriptionId(String type, String name) {
        return type + "." + Bluearchive_tinker.MODID + "." + name;
    }


}
