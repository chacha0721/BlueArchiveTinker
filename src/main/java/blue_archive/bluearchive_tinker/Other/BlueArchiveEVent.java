package blue_archive.bluearchive_tinker.Other;

import blue_archive.bluearchive_tinker.Bluearchive_tinker;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;
@Mod.EventBusSubscriber(modid = Bluearchive_tinker.MODID,bus =Mod.EventBusSubscriber.Bus.MOD)


public  class BlueArchiveEVent {

    @SubscribeEvent(priority = EventPriority.NORMAL)

    public static void gatherData(@NotNull GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        boolean server = event.includeServer();
        generator.addProvider(server, new BlueArchiveTinkerBucketModelProvider(output, Bluearchive_tinker.MODID));

    }
}

