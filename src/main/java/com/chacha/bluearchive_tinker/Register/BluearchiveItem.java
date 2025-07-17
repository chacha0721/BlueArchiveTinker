package com.chacha.bluearchive_tinker.Register;


import com.chacha.bluearchive_tinker.Bluearchive_tinker;
import com.chacha.bluearchive_tinker.Content.Item.ColorFulItem;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class BluearchiveItem {

    //invert_hoshino
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Bluearchive_tinker.MODID);
    // 这个物品的tab可以使用游戏中的tab，也可以自己创建，并注册。
//    public static final RegistryObject<Item> mika_spindle = ITEMS.register
//            ("mika_spindle",() ->new ColorFulItem(new Item.Properties().tab(BluearchiveTab.BLUEARCHIVETAB),0xFEEAF3));
    private static final DeferredRegister<Item> ITEM = DeferredRegister.create(Registries.ITEM, Bluearchive_tinker.MODID);
    public static final Supplier<Item> bluearchives = ITEM.register("bluearchives", () -> new Item(new Item.Properties()));
    public static List<RegistryObject<Item>> commonItem = new ArrayList<>(List.of());
    public static final Supplier<Item> Hoshino = registerCommonMaterials(ITEM, "hoshino", () -> new ColorFulItem(new Item.Properties(), 0xFFE5F9, new Component[]
            {
                    Component.literal("呼哇，随便搞搞就行了吧").withStyle(style -> style.withColor(0xFFAAFF)),
                    Component.literal("适当摸鱼一下也是很重要的嘛").withStyle(style -> style.withColor(0xFFAAFF))
            }));
    public static final Supplier<Item> InvertHoshino = registerCommonMaterials(ITEM, "invert_hoshino", () -> new ColorFulItem(new Item.Properties(), 0xD93570, new Component[]
            {
                    Component.literal("......这份痛苦，根本没人能够体会").withStyle(style -> style.withColor(0xC82d57)),
                    Component.literal("明明就什么也不知道").withStyle(style -> style.withColor(0xC82d57))
            }));
    public static final Supplier<Item> mika_ingot = registerCommonMaterials(ITEM, "mika_ingot", () -> new ColorFulItem(new Item.Properties(), 0xFEEAF3, new Component[]
            {
                    Component.literal("嗯！久等了吧？").withStyle(style -> style.withColor(0xFEEAF3)),
                    Component.literal("该轮到我出场啦☆").withStyle(style -> style.withColor(0xFEEAF3))
            }));
    public static final Supplier<Item> HoshinoSwimsuit = registerCommonMaterials(ITEM, "hoshino_swimsuit", () -> new ColorFulItem(new Item.Properties(), 0xFFE5F9, new Component[]
            {
                    Component.literal("唔哇~...啊，老师~").withStyle(style -> style.withColor(0xFFAAFF)),
                    Component.literal("难得来一次，休闲地度过吧~").withStyle(style -> style.withColor(0xFFAAFF))
            }));
    public static final Supplier<Item> KaiserBlue = registerCommonMaterials(ITEM, "kaiser_blue", () -> new ColorFulItem(new Item.Properties(), 0x94b8c6, new Component[]
            {
                    Component.literal("凯撒科技之一的材料").withStyle(style -> style.withColor(0x696a6b)),

            }));
    public static final Supplier<Item> hand_cream = registerCommonMaterials(ITEM, "hand_cream", () -> new ColorFulItem(new Item.Properties(), 0xE4A60C, new Component[]
            {
                    Component.literal("高档化妆品品牌“Samuela”推出的热卖产品").withStyle(style -> style.withColor(0xFFF159)),
                    Component.literal("让皮肤变得非常白皙透明，能更加自然地贴合皮肤，营造出健康的肤色").withStyle(style -> style.withColor(0xFFF159))
            }));
    public static final Supplier<Item> the_beyond = registerCommonMaterials(ITEM, "the_beyond", () -> new ColorFulItem(new Item.Properties(), 0xE4A60C, new Component[]
            {
                    Component.literal("高级化妆品厂商「Samuela」发售的最高级香水").withStyle(style -> style.withColor(0xFFF159)),
                    Component.literal("是以「试一次，让可爱萦绕此身」的广告词而爆火的产品，也是旷世奇才调香师「Beyond」调制的12杰作之一").withStyle(style -> style.withColor(0xFFF159))
            }));
    public static final Supplier<Item> violane = registerCommonMaterials(ITEM, "violane", () -> new ColorFulItem(new Item.Properties(), 0xE4A60C, new Component[]
            {
                    Component.literal("阿罗娜！！！还我青辉石！！！").withStyle(style -> style.withColor(0xCE0101)),

            }));
    public static final Supplier<Item> sponge_cake = registerCommonMaterials(ITEM, "sponge_cake", () -> new ColorFulItem(new Item.Properties().food
            (new FoodProperties.Builder().
                    nutrition(20).saturationMod(1.5f)
                    .effect(()->new MobEffectInstance(MobEffects.LUCK, 12000, 0), 1.0F)
                    .effect(()->new MobEffectInstance(MobEffects.LUCK, 12000, 4), 0.1f)
                    .build()), 0xE4A60C, new Component[]
            {
                    Component.literal("给你嘴里塞一整根瑞士卷").withStyle(style -> style.withColor(0xFFF159)),
                    Component.literal("喜欢吃瑞士卷的孩子~会变成的很幸运呢~").withStyle(style -> style.withColor(0xFFF159))

            }));
    public static final Supplier<Item> parfait = registerCommonMaterials(ITEM, "parfait", () -> new ColorFulItem(new Item.Properties().food
            (new FoodProperties.Builder().nutrition(5).saturationMod(2f).
                    effect(()-> new MobEffectInstance(MobEffects.REGENERATION, 600, 2), 1.0F).
                    effect(()->new MobEffectInstance(MobEffects.NIGHT_VISION, 10000, 4), 1).
                    effect(()->new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 600, 4), 1).
                    effect(()->new MobEffectInstance(MobEffects.HEAL, 60, 2), 1).
                    effect(()->new MobEffectInstance(MobEffects.ABSORPTION, 600, 2), 1)
                    .build()), 0xE4A60C, new Component[]
            {
                    Component.literal("在三一的著名甜品店，咖啡厅千层出售的芭菲").withStyle(style -> style.withColor(0xFFF159)),
                    Component.literal("在柔软的冰激凌上层层堆叠的点心、糖浆、鲜奶油、水果和谐地融为了一体 果然正宗！").withStyle(style -> style.withColor(0xFFF159))

            }));
    public static final Supplier<Item> MikeCake = registerCommonMaterials(ITEM, "mikacake", () -> new ColorFulItem(new Item.Properties().food
            (new FoodProperties.Builder().nutrition(20).saturationMod(3f).

                    effect(()->new MobEffectInstance(MobEffects.ABSORPTION, 600, 2), 1)

                    .build()), 0xFEEAF3, new Component[]
            {
                    Component.literal("出自圣三一茶话会每日必备甜点~").withStyle(style -> style.withColor(0xFEEAF3)),
                    Component.literal("相信我~吃过后你一定会爱上它的！").withStyle(style -> style.withColor(0xFEEAF3))

            }));

    public static RegistryObject<Item> registerCommonMaterials(DeferredRegister<Item> register, String name, Supplier<? extends Item> sup) {
        RegistryObject<Item> object = register.register(name, sup);
        commonItem.add(object);
        return object;
    }

    public static void register(IEventBus bus) {
        ITEM.register(bus);
    }

}


