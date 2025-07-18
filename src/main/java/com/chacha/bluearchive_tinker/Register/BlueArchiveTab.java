package com.chacha.bluearchive_tinker.Register;

import com.chacha.bluearchive_tinker.BlueArchiveTinker;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class BlueArchiveTab {
    private static final DeferredRegister<CreativeModeTab> creative_mode_tab = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, BlueArchiveTinker.MODID);
    private final static String BlueArchiveTab = "tab.bluearchivetab.ingot";
    public static final Supplier<CreativeModeTab> BLUEARCHIVETAB = creative_mode_tab.register("bluearchivetab", () -> CreativeModeTab.builder()
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .title(Component.translatable(BlueArchiveTab))
            .icon(BlueArchiveItem.Hoshino.get()::getDefaultInstance)
            .displayItems((itemDisplayParameters, output) -> {
                for (RegistryObject<Item> itemsDeferredRegister : BlueArchiveItem.getMaterials()) {
                    if (itemsDeferredRegister.isPresent()) {
                        output.accept(itemsDeferredRegister.get());
                    }
                }
            })
            .build()
    );
    private final static String FavoriteTab = "tab.favoritetab.ingot";
    public static final Supplier<CreativeModeTab> FAVORITETAB = creative_mode_tab.register("favoritetab", () -> CreativeModeTab.builder()
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .title(Component.translatable(FavoriteTab))
            .icon(BlueArchiveItem.hand_cream.get()::getDefaultInstance)
            .displayItems((itemDisplayParameters, output) -> {
                for (RegistryObject<Item> itemsDeferredRegister : BlueArchiveItem.getFavorite()) {
                    if (itemsDeferredRegister.isPresent()) {
                        output.accept(itemsDeferredRegister.get());
                    }
                }
            })
            .build()
    );

    public static void register(IEventBus bus) {
        creative_mode_tab.register(bus);
    }


}
