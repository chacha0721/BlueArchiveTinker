package com.chacha.bluearchive_tinker.Register;


import com.chacha.bluearchive_tinker.BlueArchiveTinker;
import com.chacha.bluearchive_tinker.Content.Modifier.*;
import net.minecraftforge.eventbus.api.IEventBus;
import slimeknights.tconstruct.library.modifiers.util.ModifierDeferredRegister;
import slimeknights.tconstruct.library.modifiers.util.StaticModifier;

public class BlueArchiveModifier {
    private static final ModifierDeferredRegister MODIFIERS = ModifierDeferredRegister.create(BlueArchiveTinker.MODID);
    //材料词条
    public static final StaticModifier<MikaStars> MikiaStars = MODIFIERS.register("mikastars", MikaStars::new);
    public static final StaticModifier<Play> Play = MODIFIERS.register("play", Play::new);
    public static final StaticModifier<Cake> Cake = MODIFIERS.register("cake", Cake::new);
    public static final StaticModifier<MikaCake> MikaCake = MODIFIERS.register("mikacake", MikaCake::new);
    public static final StaticModifier<SetStats> setstat = MODIFIERS.register("setstat", SetStats::new);
    public static final StaticModifier<MikaNs> MikaNs = MODIFIERS.register("mikans", MikaNs::new);
    public static final StaticModifier<KaiserBlueAttack> KaiserBlueAttack  = MODIFIERS.register("kaiserblueattack",KaiserBlueAttack::new);
    public static final StaticModifier<GameStart> GameStart = MODIFIERS.register("gamestart", GameStart::new);
    public static final StaticModifier<GameMaster> GameMaster = MODIFIERS.register("gamemaster", GameMaster::new);
    public static final StaticModifier<UZQueen> UZQueen = MODIFIERS.register("uzqueen", UZQueen::new);
    public static final StaticModifier<Courage> Courage = MODIFIERS.register("courage", Courage::new);
    public static final StaticModifier<Combo> Combo = MODIFIERS.register("combo", Combo::new);
    public static final StaticModifier<SAD> SAD = MODIFIERS.register("sad", SAD::new);
    public static final StaticModifier<GameFriendship> GameFriendship = MODIFIERS.register("gamefriendship", GameFriendship::new);
    public static void register(IEventBus bus) {
        MODIFIERS.register(bus);
    }
}

