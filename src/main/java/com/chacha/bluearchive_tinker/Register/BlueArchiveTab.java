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
    public static final DeferredRegister<CreativeModeTab> creative_mode_tab = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, BlueArchiveTinker.MODID);
    public final static String BlueArchiveTab = "tab.bluearchivetab.ingot";
    public final static String FavoriteTab = "tab.favoritetab.ingot";

    public static final Supplier<CreativeModeTab> BLUEARCHIVETAB = creative_mode_tab.register("bluearchivetab", () -> CreativeModeTab.builder()
            //槽位位置
            .withTabsBefore(CreativeModeTabs.COMBAT)
            //物品栏名称
            .title(Component.translatable(BlueArchiveTab))
            //图标
            .icon(BlueArchiveItem.bluearchives.get()::getDefaultInstance)
            .displayItems((itemDisplayParameters, output) -> {
                for (RegistryObject<Item> itemsDeferredRegister : BlueArchiveItem.getCommonItem()) {
                    if (itemsDeferredRegister.isPresent()) {
                        output.accept(itemsDeferredRegister.get());
                    }
                }
            })
            .build()
    );


    public static final Supplier<CreativeModeTab> FAVORITETAB = creative_mode_tab.register("favoritetab", () -> CreativeModeTab.builder()
            //槽位位置
            .withTabsBefore(CreativeModeTabs.COMBAT)
            //物品栏名称
            .title(Component.translatable(FavoriteTab))
            //图标
            .icon(BlueArchiveItem.hand_cream.get()::getDefaultInstance)
            .displayItems((itemDisplayParameters, output) -> {

                output.accept(BlueArchiveItem.parfait.get());
                output.accept(BlueArchiveItem.hand_cream.get());
                output.accept(BlueArchiveItem.the_beyond.get());
                output.accept(BlueArchiveItem.sponge_cake.get());
                output.accept(BlueArchiveItem.MikeCake.get());

            })

            .build()
    );


    public static void register(IEventBus bus) {
        creative_mode_tab.register(bus);
    }


}
