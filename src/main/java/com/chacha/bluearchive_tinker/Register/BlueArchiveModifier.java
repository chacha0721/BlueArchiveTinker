package com.chacha.bluearchive_tinker.Register;


import com.chacha.bluearchive_tinker.BlueArchiveTinker;
import com.chacha.bluearchive_tinker.Content.Modifier.Cake;
import com.chacha.bluearchive_tinker.Content.Modifier.MikaStars;
import com.chacha.bluearchive_tinker.Content.Modifier.Play;
import com.chacha.bluearchive_tinker.Content.Modifier.PlayTwo;
import net.minecraftforge.eventbus.api.IEventBus;
import slimeknights.tconstruct.library.modifiers.util.ModifierDeferredRegister;
import slimeknights.tconstruct.library.modifiers.util.StaticModifier;

public class BlueArchiveModifier {
    private static final ModifierDeferredRegister MODIFIERS = ModifierDeferredRegister.create(BlueArchiveTinker.MODID);
    //材料词条
    public static final StaticModifier<MikaStars> MikiaStars = MODIFIERS.register("mikastars", MikaStars::new);
    public static final StaticModifier<Play> Play = MODIFIERS.register("play", Play::new);
    public static final StaticModifier<Cake> MikaCake = MODIFIERS.register("mikacake", Cake::new);
    public static final StaticModifier<PlayTwo> PlayTwo = MODIFIERS.register("playtwo", PlayTwo::new);
    public static final StaticModifier<PlayTwo> KaiserBlueAttack = MODIFIERS.register("kaiserblueattack", PlayTwo::new);
    public static final StaticModifier<PlayTwo> KaiserBlueSup = MODIFIERS.register("kaiserbluesup", PlayTwo::new);
    public static final StaticModifier<PlayTwo> KaiserBlueTank = MODIFIERS.register("kaiserbluetank", PlayTwo::new);
    public static final StaticModifier<PlayTwo> AbsoluteJustice = MODIFIERS.register("absolutejustice", PlayTwo::new);
    public static final StaticModifier<PlayTwo> SandStrom = MODIFIERS.register("sandstrom", PlayTwo::new);
    public static final StaticModifier<PlayTwo> TacticSprotect = MODIFIERS.register("tacticsprotect", PlayTwo::new);
    public static final StaticModifier<PlayTwo> Bha = MODIFIERS.register("bha", PlayTwo::new);
    public static final StaticModifier<PlayTwo> Natived = MODIFIERS.register("natived", PlayTwo::new);
    public static final StaticModifier<PlayTwo> Watery = MODIFIERS.register("watery", PlayTwo::new);
    public static final StaticModifier<PlayTwo> Neverend = MODIFIERS.register("neverend", PlayTwo::new);
    public static final StaticModifier<PlayTwo> TacticSattack = MODIFIERS.register("tacticsattack", PlayTwo::new);
    public static final StaticModifier<PlayTwo> Reliable = MODIFIERS.register("reliable", PlayTwo::new);
    public static final StaticModifier<PlayTwo> Eventually = MODIFIERS.register("eventually", PlayTwo::new);
    public static final StaticModifier<PlayTwo> Transmigration = MODIFIERS.register("transmigration", PlayTwo::new);
    public static final StaticModifier<PlayTwo> Trauma = MODIFIERS.register("trauma", PlayTwo::new);
    public static void register(IEventBus bus) {
        MODIFIERS.register(bus);
    }
}

