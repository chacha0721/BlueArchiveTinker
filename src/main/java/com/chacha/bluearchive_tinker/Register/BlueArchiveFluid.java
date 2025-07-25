package com.chacha.bluearchive_tinker.Register;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraftforge.common.SoundActions;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import slimeknights.mantle.registration.deferred.FluidDeferredRegister;
import slimeknights.mantle.registration.object.FluidObject;

import java.util.HashMap;
import java.util.Map;

import static com.chacha.bluearchive_tinker.BlueArchiveTinker.MODID;
import static slimeknights.tconstruct.fluids.block.BurningLiquidBlock.createBurning;

public class BlueArchiveFluid {

    public static final FluidDeferredRegister FLUIDS = new FluidDeferredRegister(MODID);
    protected static Map<FluidObject<ForgeFlowingFluid>, Boolean> FLUID_MAP = new HashMap<>();
    public static final FluidObject<ForgeFlowingFluid> mikafluid = registerHotBurning(FLUIDS, "mikafluid", 1000, 5, 5, 20f);

    private static FluidType.Properties hot(String name, int Temp) {
        return FluidType.Properties.create().density(2000).viscosity(10000).temperature(Temp)
                .descriptionId("fluid." + MODID + "." + name)
                .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL_LAVA)
                .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY_LAVA)
                .motionScale(0.0023333333333333335D)
                .canSwim(false).canDrown(false)
                .pathType(BlockPathTypes.LAVA).adjacentPathType(null);
    }

    private static FluidObject<ForgeFlowingFluid> registerHotBurning(FluidDeferredRegister register, String name, int temp, int lightLevel, int burnTime, float damage) {
        FluidObject<ForgeFlowingFluid> object = register.register(name).type(hot(name, temp)).bucket().block(createBurning(MapColor.COLOR_GRAY, lightLevel, burnTime, damage)).commonTag().flowing();
        FLUID_MAP.put(object, false);
        return object;
    }

    public static void register(IEventBus bus) {
        FLUIDS.register(bus);
    }
}

