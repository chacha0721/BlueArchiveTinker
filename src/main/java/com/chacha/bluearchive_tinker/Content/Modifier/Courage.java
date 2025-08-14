package com.chacha.bluearchive_tinker.Content.Modifier;

import com.chacha.bluearchive_tinker.Util.DynamicComponentUtil;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;
import slimeknights.tconstruct.library.modifiers.Modifier;

import java.util.Arrays;
import java.util.List;

public class Courage extends Modifier {
    @Override
    public @NotNull List<Component> getDescriptionList(int level) {
        int[] color = new int[]{0x3ffcc79, 0xc66f4a, 0xe58686};
        if (descriptionList == null) {
            descriptionList = Arrays.asList(
                    DynamicComponentUtil.scrollColorfulText.getColorfulText(getTranslationKey() + ".flavor", null, color, 20, 20, true),
                    DynamicComponentUtil.scrollColorfulText.getColorfulText(getTranslationKey() + ".description", null, color, 20, 1000, true));
        }
        return super.getDescriptionList(level);
    }
}
