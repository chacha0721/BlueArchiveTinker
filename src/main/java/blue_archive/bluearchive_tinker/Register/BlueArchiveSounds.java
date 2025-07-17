package blue_archive.bluearchive_tinker.Register;

import blue_archive.bluearchive_tinker.Bluearchive_tinker;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class BlueArchiveSounds {
    public  static  final DeferredRegister<SoundEvent> sound=DeferredRegister.create(Registries.SOUND_EVENT, Bluearchive_tinker.MODID);
    public  static  final RegistryObject<SoundEvent> MIKAAHHH=sound.register("mika_ahhh",()->SoundEvent.createVariableRangeEvent(new ResourceLocation(Bluearchive_tinker.MODID,"mika_ahhh")));
    public  static  void register(IEventBus bus)
    {
        sound.register(bus);
    }
}
