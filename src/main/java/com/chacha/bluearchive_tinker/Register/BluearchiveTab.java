package com.chacha.bluearchive_tinker.Register;

import com.chacha.bluearchive_tinker.Bluearchive_tinker;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class BluearchiveTab {
    public static final DeferredRegister<CreativeModeTab> creative_mode_tab = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Bluearchive_tinker.MODID);
    public final static String BlueArchiveTab = "tab.bluearchivetab.ingot";
    public final static String FavoriteTab = "tab.favoritetab.ingot";

    public static final Supplier<CreativeModeTab> BLUEARCHIVETAB = creative_mode_tab.register("bluearchivetab", () -> CreativeModeTab.builder()
            //槽位位置
            .withTabsBefore(CreativeModeTabs.COMBAT)
            //物品栏名称
            .title(Component.translatable(BlueArchiveTab))
            //图标
            .icon(BluearchiveItem.bluearchives.get()::getDefaultInstance)
            .displayItems((itemDisplayParameters, output) -> {

                output.accept(BluearchiveItem.mika_ingot.get());
                output.accept(BluearchiveItem.HoshinoSwimsuit.get());
                output.accept(BluearchiveItem.Hoshino.get());
                output.accept(BluearchiveItem.InvertHoshino.get());
                output.accept(BluearchiveItem.KaiserBlue.get());
                output.accept(BluearchiveItem.violane.get());


            })
            .build()
    );


    public static final Supplier<CreativeModeTab> FAVORITETAB = creative_mode_tab.register("favoritetab", () -> CreativeModeTab.builder()
            //槽位位置
            .withTabsBefore(CreativeModeTabs.COMBAT)
            //物品栏名称
            .title(Component.translatable(FavoriteTab))
            //图标
            .icon(BluearchiveItem.hand_cream.get()::getDefaultInstance)
            .displayItems((itemDisplayParameters, output) -> {

                output.accept(BluearchiveItem.parfait.get());
                output.accept(BluearchiveItem.hand_cream.get());
                output.accept(BluearchiveItem.the_beyond.get());
                output.accept(BluearchiveItem.sponge_cake.get());
                output.accept(BluearchiveItem.MikeCake.get());

            })

            .build()
    );


    public static void register(IEventBus bus) {
        creative_mode_tab.register(bus);
    }


}
