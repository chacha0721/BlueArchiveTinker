package blue_archive.bluearchive_tinker.Register;

import blue_archive.BlueArchiveModifier.Cake;
import blue_archive.BlueArchiveModifier.MikaStars;
import blue_archive.BlueArchiveModifier.Play;
import blue_archive.BlueArchiveModifier.PlayTwo;
import blue_archive.bluearchive_tinker.Bluearchive_tinker;
import net.minecraftforge.eventbus.api.IEventBus;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.util.ModifierDeferredRegister;
import slimeknights.tconstruct.library.modifiers.util.StaticModifier;

public class BluearchiveModifier {
    public static final ModifierDeferredRegister MODIFIERS = ModifierDeferredRegister.create(Bluearchive_tinker.MODID);
    private static final ModifierDeferredRegister ThermalModifiers = ModifierDeferredRegister.create(Bluearchive_tinker.MODID);
    //工具词条

    //材料词条
    public static final StaticModifier<MikaStars> MikiaStars = MODIFIERS.register("mikastars", MikaStars::new);
    public static final StaticModifier<Play> Play = MODIFIERS.register("play", Play::new);
    public static final StaticModifier<Cake> MikaCake = MODIFIERS.register("mikacake", Cake::new);
    public static final StaticModifier<PlayTwo> PlayTwo = MODIFIERS.register("playtwo", PlayTwo::new);
    public static final StaticModifier<PlayTwo> KaiserBlueAttack = MODIFIERS.register("kaiserblueattack", PlayTwo::new);
    public static final StaticModifier<PlayTwo> KaiserBlueSup = MODIFIERS.register("kaiserbluesup", PlayTwo::new);
    public static final StaticModifier<PlayTwo> KaiserBlueTank= MODIFIERS.register("kaiserbluetank", PlayTwo::new);
    public static final StaticModifier<PlayTwo>  AbsoluteJustice= MODIFIERS.register("absolutejustice", PlayTwo::new);
    public static final StaticModifier<PlayTwo> SandStrom= MODIFIERS.register("sandstrom", PlayTwo::new);
    public static final StaticModifier<PlayTwo> TacticSprotect= MODIFIERS.register("tacticsprotect", PlayTwo::new);
    public static final StaticModifier<PlayTwo> Bha= MODIFIERS.register("bha", PlayTwo::new);
    public static final StaticModifier<PlayTwo> Natived= MODIFIERS.register("natived", PlayTwo::new);
    public static final StaticModifier<PlayTwo> Watery= MODIFIERS.register("watery", PlayTwo::new);
    public static final StaticModifier<PlayTwo> Neverend= MODIFIERS.register("neverend", PlayTwo::new);
    public static final StaticModifier<PlayTwo> TacticSattack= MODIFIERS.register("tacticsattack", PlayTwo::new);
    public static final StaticModifier<PlayTwo> Reliable= MODIFIERS.register("reliable", PlayTwo::new);
    public static final StaticModifier<PlayTwo> Eventually= MODIFIERS.register("eventually", PlayTwo::new);
    public static final StaticModifier<PlayTwo> Transmigration= MODIFIERS.register("transmigration", PlayTwo::new);
    public static final StaticModifier<PlayTwo> Trauma= MODIFIERS.register("trauma", PlayTwo::new);

    public static void register(IEventBus bus){
        MODIFIERS.register(bus);
    }
}

