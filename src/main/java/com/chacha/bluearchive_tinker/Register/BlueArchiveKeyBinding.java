package com.chacha.bluearchive_tinker.Register;

import com.chacha.bluearchive_tinker.BlueArchiveTinker;
import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.client.settings.KeyConflictContext;
import org.lwjgl.glfw.GLFW;

public class BlueArchiveKeyBinding {
    //族群名
    private static final String KEY_CATEGORY_BLUE_ARCHIVE_TINKER = "key.category."+ BlueArchiveTinker.MODID;
    //具体按键名
    private static final String KEY_ADJUST_DIGGING_SPEED = "key."+ BlueArchiveTinker.MODID+".digging_speed";

    public static final KeyMapping EX_KEY = new KeyMapping(KEY_CATEGORY_BLUE_ARCHIVE_TINKER, KeyConflictContext.IN_GAME, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_Y, KEY_ADJUST_DIGGING_SPEED);

    public static void register(RegisterKeyMappingsEvent event){
        event.register(EX_KEY);
    }
}
