package com.chacha.bluearchive_tinker.Register;

import com.chacha.bluearchive_tinker.BlueArchiveTinker;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class BlueArchiveSounds {
    private static final DeferredRegister<SoundEvent> sound = DeferredRegister.create(Registries.SOUND_EVENT, BlueArchiveTinker.MODID);
    public static final RegistryObject<SoundEvent> MIKAAHHH = sound.register("mika_ahhh", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(BlueArchiveTinker.MODID, "mika_ahhh")));

    public static void register(IEventBus bus) {
        sound.register(bus);
    }
}
