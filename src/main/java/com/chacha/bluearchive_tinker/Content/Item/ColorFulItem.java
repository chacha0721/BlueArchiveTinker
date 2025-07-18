package com.chacha.bluearchive_tinker.Content.Item;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.List;

public class ColorFulItem extends Item {
    private final int color;
    private final Component[] tooltip;

    public ColorFulItem(Properties pProperties, int color, Component[] tooltip) {
        super(pProperties);
        this.color = color;
        this.tooltip = tooltip;
    }

    @Override
    public Component getName(ItemStack pStack) {
        return Component.translatable(this.getDescriptionId(pStack)).withStyle(style -> style.withColor(color));
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable net.minecraft.world.level.Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        Collections.addAll(pTooltipComponents, tooltip);
    }
}