package com.chacha.bluearchive_tinker.Content.Modifier;
import com.chacha.bluearchive_tinker.Register.BlueArchiveItem;
import com.chacha.bluearchive_tinker.Util.DynamicComponentUtil;
import com.chacha.bluearchive_tinker.Util.method.ModifierLevel;
import net.minecraft.client.Minecraft;
import net.minecraft.core.NonNullList;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.Event;
import org.jetbrains.annotations.Nullable;
import slimeknights.mantle.client.TooltipKey;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.ModifierHooks;
import slimeknights.tconstruct.library.modifiers.hook.combat.MeleeDamageModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.interaction.InventoryTickModifierHook;
import slimeknights.tconstruct.library.module.ModuleHookMap;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

import java.util.Arrays;
import java.util.List;

public class MikaCake extends Modifier implements MeleeDamageModifierHook, InventoryTickModifierHook {
    @Override
    public List<Component> getDescriptionList(int level) {
        int[] color = new int[]{0xFEEAF3, 0xffaaff, 0x55c4ff};
        if (descriptionList == null) {
            descriptionList = Arrays.asList(DynamicComponentUtil.scrollColorfulText.getColorfulText(getTranslationKey() + ".flavor", null, color, 20, 20, true),
                    DynamicComponentUtil.scrollColorfulText.getColorfulText(getTranslationKey() + ".description", null, color, 20, 1000, true))
            ;
        }
        return super.getDescriptionList(level);
    }

    public void addTooltip(IToolStackView tool, ModifierEntry modifier, @Nullable Player player, List<Component> tooltip, TooltipKey tooltipKey, TooltipFlag tooltipFlag) {
        int[] color = new int[]{0xFEEAF3, 0xffaaff, 0x55c4ff};
        tooltip.add(DynamicComponentUtil.scrollColorfulText.getColorfulText(getTranslationKey() + ".description", null, color, 15, 20, true));
    }
    @Override
    public float getMeleeDamage(IToolStackView tool, ModifierEntry modifier, ToolAttackContext context, float baseDamage, float damage) {
        LivingEntity attacker = context.getAttacker();
        return   damage;
    }

    @Override
    public void onInventoryTick(IToolStackView tool, ModifierEntry modifier, Level world, LivingEntity holder, int itemSlot, boolean isSelected, boolean isCorrectSlot, ItemStack stack) {
               ItemStack Mikacake=new ItemStack(BlueArchiveItem.MikeCake.get(),1);
        if (holder instanceof ServerPlayer player&&player.tickCount %1200 ==0) {
            if (ModifierLevel.EquipHasModifierlevel(player, this.getId())&&isCorrectSlot) {
                if(!player.addItem(Mikacake)) {
                    player.drop(Mikacake,false);
                }
            }
        }
    }

    protected void registerHooks(ModuleHookMap.Builder hookBuilder) {
        hookBuilder.addHook(this, ModifierHooks.MELEE_DAMAGE);
        hookBuilder.addHook(this, ModifierHooks.INVENTORY_TICK);
    }
    public MikaCake() {
        MinecraftForge.EVENT_BUS.addListener(this::LivingHurtEvent);
        //添加受伤事件的监听器，监听 活实体受伤事件
    }

    private void LivingHurtEvent(LivingHurtEvent event) {
        LivingEntity entity = event.getEntity();
        Entity attack = event.getSource().getEntity();
        //获取收集者 entityy 和攻击者 attack 攻击者 attack 可能不是活体（箭矢之类）
        if (attack instanceof LivingEntity attackers) {
            //if else if 是判断攻击者 attack 是不是活体 是活体变量名未 attacker
            if (ModifierLevel.EquipHasModifierlevel(attackers, this.getId())) {
                if (attackers instanceof Player player) { // 将LivingEntity转换为Player
                    NonNullList<ItemStack> playerInv = player.getInventory().items;
                    int count = 0;
                    for (ItemStack stack : playerInv) {
                        if (stack.is(BlueArchiveItem.MikeCake.get())) {
                            count += stack.getCount();
                        }
                    }
                    if (count >= 64&& count <128) {
                        float damage = event.getAmount();
                        event.setAmount(damage * 1.5f);// 伤害提高50%
                    } else if (count >= 128&& count <192) {
                        float damage = event.getAmount();
                        event.setAmount(damage * 2f);
                    } else if (count >= 192 && count <256) {
                        float damage = event.getAmount();
                        event.setAmount(damage * 2.5f);
                    } else if (count >= 256) {
                        float damage = event.getAmount();
                        event.setAmount(damage * 3f);
                    }
                }
            } else if (attack instanceof Projectile projectile && projectile.getOwner() instanceof LivingEntity attacker) {
                if (attackers instanceof Player player) { // 将LivingEntity转换为Player
                    NonNullList<ItemStack> playerInv = player.getInventory().items;
                    int count = 0;
                    for (ItemStack stack : playerInv) {
                        if (stack.is(BlueArchiveItem.MikeCake.get())) {
                            count += stack.getCount();
                        }
                    }
                    if (count >= 64&& count <128) {
                        float damage = event.getAmount();
                        event.setAmount(damage * 1.5f);// 伤害提高50%
                    } else if (count >= 128&& count <192) {
                        float damage = event.getAmount();
                        event.setAmount(damage * 2f);
                    } else if (count >= 192 && count <256) {
                        float damage = event.getAmount();
                        event.setAmount(damage * 2.5f);
                    } else if (count >= 256) {
                        float damage = event.getAmount();
                        event.setAmount(damage * 3f);
                    }
                }

            }
        }
    }
}
