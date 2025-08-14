package com.chacha.bluearchive_tinker.Register;


import com.chacha.bluearchive_tinker.BlueArchiveTinker;
import com.chacha.bluearchive_tinker.Content.Item.ColorFulItem;
import lombok.Getter;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class BlueArchiveItem {

    // 这个物品的tab可以使用游戏中的tab，也可以自己创建，并注册。
    private static final DeferredRegister<Item> ITEM = DeferredRegister.create(Registries.ITEM, BlueArchiveTinker.MODID);
    //堆叠64的物品
    private static final Item.Properties commonItem = new Item.Properties().stacksTo(64).fireResistant();
    @Getter
    private final static List<RegistryObject<Item>> Materials = new ArrayList<>(List.of());
    @Getter
    private final static List<RegistryObject<Item>> Favorite = new ArrayList<>(List.of());
    public static final Supplier<Item> mika_ingot = registerToList(ITEM, "mika_ingot", () -> new ColorFulItem(commonItem, 0xf2d6b3, new Component[]{
            Component.literal("嗯！久等了吧？").withStyle(style -> style.withColor(0xFEEAF3)),
            Component.literal("该轮到我出场啦☆").withStyle(style -> style.withColor(0xFEEAF3))
    }), Materials);
    public static final Supplier<Item> mikaSwimsuit = registerToList(ITEM, "mika_swimsuit", () -> new ColorFulItem(commonItem, 0xf2d6b3, new Component[]{
            Component.literal("圣园未花，以泳装姿态再度登场~☆是这种感觉吧？").withStyle(style -> style.withColor(0xFEEAF3)),
            Component.literal("今后也请多多指教啦，老师！").withStyle(style -> style.withColor(0xFEEAF3))
    }), Materials);
    public static final Supplier<Item> Seia = registerToList(ITEM, "seia", () -> new ColorFulItem(commonItem, 0xFEEAF3, new Component[]{
            Component.literal("终于又与你重逢……").withStyle(style -> style.withColor(0xffefdd)),
            Component.literal("我想我应该如此说").withStyle(style -> style.withColor(0xffefdd)),
            Component.literal("我已久候，老师").withStyle(style -> style.withColor(0xffefdd))
    }), Materials);
    public static final Supplier<Item> SeiaSwimsuit = registerToList(ITEM, "seia_swimsuit", () -> new ColorFulItem(commonItem, 0xFEEAF3, new Component[]{
            Component.literal("大海......不知已期盼此刻多久").withStyle(style -> style.withColor(0xffefdd)),
            Component.literal("何不共赏这浮生一瞬的泡沫光华").withStyle(style -> style.withColor(0xffefdd))
    }), Materials);
    public static final Supplier<Item> NagisaSwimsuit = registerToList(ITEM, "nagisa_swimsuit", () -> new ColorFulItem(commonItem, 0xfce5c3, new Component[]{
            Component.literal("您好，老师").withStyle(style -> style.withColor(0xfdeacf)),
            Component.literal("愿您能在这短暂的休息中得到些许放松").withStyle(style -> style.withColor(0xfdeacf))
    }), Materials);
    public static final Supplier<Item> Hoshino = registerToList(ITEM, "hoshino", () -> new ColorFulItem(commonItem, 0xFFE5F9, new Component[]{
            Component.literal("呼哇，随便搞搞就行了吧").withStyle(style -> style.withColor(0xFFAAFF)),
            Component.literal("适当摸鱼一下也是很重要的嘛").withStyle(style -> style.withColor(0xFFAAFF))
    }), Materials);
    public static final Supplier<Item> InvertHoshino = registerToList(ITEM, "invert_hoshino", () -> new ColorFulItem(commonItem, 0xD93570, new Component[]{
            Component.literal("......这份痛苦，根本没人能够体会").withStyle(style -> style.withColor(0xC82d57)),
            Component.literal("明明就什么也不知道").withStyle(style -> style.withColor(0xC82d57))
    }), Materials);
    public static final Supplier<Item> HoshinoSwimsuit = registerToList(ITEM, "hoshino_swimsuit", () -> new ColorFulItem(commonItem, 0xFFE5F9, new Component[]{
            Component.literal("唔哇~...啊，老师~").withStyle(style -> style.withColor(0xFFAAFF)),
            Component.literal("难得来一次，休闲地度过吧~").withStyle(style -> style.withColor(0xFFAAFF))
    }), Materials);
    public static final Supplier<Item> Yuzu = registerToList(ITEM, "yuzu", () -> new ColorFulItem(commonItem, 0xFFE5F9, new Component[]{
            Component.literal("游戏开发部，部长……柚子").withStyle(style -> style.withColor(0xFFAAFF)),
            Component.literal("真…真的要……把我带上吗？").withStyle(style -> style.withColor(0xFFAAFF))
    }), Materials);
    public static final Supplier<Item> AzusaSwimsuit = registerToList(ITEM, "azusa_swimsuit", () -> new ColorFulItem(commonItem, 0xf4e8e0, new Component[]{
            Component.literal("白洲梓，到达目标地点大海").withStyle(style -> style.withColor(0xfcf8f6)),
            Component.literal("马上开始进行预定的任务").withStyle(style -> style.withColor(0xfcf8f6)),
            Component.literal("……并没有感觉兴奋什么的，才没有这样的事").withStyle(style -> style.withColor(0xfcf8f6))
    }), Materials);

    public static final Supplier<Item> KaiserBlue = registerToList(ITEM, "kaiser_blue.json", () -> new ColorFulItem(commonItem, 0x94b8c6, new Component[]{
            Component.literal("凯撒科技之一的材料").withStyle(style -> style.withColor(0x696a6b)),
    }), Materials);
    public static final Supplier<Item> violane = registerToList(ITEM, "violane", () -> new ColorFulItem(commonItem, 0xE4A60C, new Component[]{
            Component.literal("阿罗娜！！！还我青辉石！！！").withStyle(style -> style.withColor(0xCE0101)),
    }), Materials);
    public static final Supplier<Item> BlueArchive = registerToList(ITEM, "bluearchive", () -> new ColorFulItem(commonItem, 0xFFE5F9, new Component[]{
    }), Materials);
    public static final Supplier<Item> hand_cream = registerToList(ITEM, "hand_cream", () -> new ColorFulItem(commonItem, 0xE4A60C, new Component[]{
            Component.literal("高档化妆品品牌“Samuela”推出的热卖产品").withStyle(style -> style.withColor(0xFFF159)),
            Component.literal("让皮肤变得非常白皙透明，能更加自然地贴合皮肤，营造出健康的肤色").withStyle(style -> style.withColor(0xFFF159))
    }), Favorite);
    public static final Supplier<Item> the_beyond = registerToList(ITEM, "the_beyond", () -> new ColorFulItem(commonItem, 0xE4A60C, new Component[]{
            Component.literal("高级化妆品厂商「Samuela」发售的最高级香水").withStyle(style -> style.withColor(0xFFF159)),
            Component.literal("是以「试一次，让可爱萦绕此身」的广告词而爆火的产品，也是旷世奇才调香师「Beyond」调制的12杰作之一").withStyle(style -> style.withColor(0xFFF159))
    }), Favorite);
    public static final Supplier<Item> sponge_cake = registerToList(ITEM, "sponge_cake", () -> new ColorFulItem(commonItem.food(new FoodProperties.Builder()
            .nutrition(20).saturationMod(1.5f)
            .effect(() -> new MobEffectInstance(MobEffects.LUCK, 12000, 0), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.LUCK, 12000, 4), 0.1f)
            .build()), 0xE4A60C, new Component[]{
            Component.literal("给你嘴里塞一整根瑞士卷").withStyle(style -> style.withColor(0xFFF159)),
            Component.literal("喜欢吃瑞士卷的孩子~会变成的很幸运呢~").withStyle(style -> style.withColor(0xFFF159))
    }), Favorite);
    public static final Supplier<Item> parfait = registerToList(ITEM, "parfait", () -> new ColorFulItem(commonItem.food(new FoodProperties.Builder()
            .nutrition(5)
            .saturationMod(2f)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 600, 2), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.NIGHT_VISION, 10000, 4), 1)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 600, 4), 1)
            .effect(() -> new MobEffectInstance(MobEffects.HEAL, 60, 2), 1)
            .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 600, 2), 1)
            .build()), 0xE4A60C, new Component[]{
            Component.literal("在三一的著名甜品店，咖啡厅千层出售的芭菲").withStyle(style -> style.withColor(0xFFF159)),
            Component.literal("在柔软的冰激凌上层层堆叠的点心、糖浆、鲜奶油、水果和谐地融为了一体 果然正宗！").withStyle(style -> style.withColor(0xFFF159))
    }), Favorite);
    public static final Supplier<Item> MikaCake = registerToList(ITEM, "mika_cake", () -> new ColorFulItem(commonItem.food(new FoodProperties.Builder()
            .nutrition(20)
            .saturationMod(3f)
            .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 600, 2), 1)
            .build()), 0xFEEAF3, new Component[]{
            Component.literal("出自圣三一茶话会每日必备甜点~").withStyle(style -> style.withColor(0xFEEAF3)),
            Component.literal("相信我~吃过后你一定会爱上它的！").withStyle(style -> style.withColor(0xFEEAF3))
    }), Favorite);

    //以后不要再去tab类里面手动添加这些普通物品了,已经可以自动添加了

    /**
     * @param register     注册器,你无脑ITEM就行
     * @param name         名,小写
     * @param sup          supplier
     * @param registryList 添加到哪个分类列表,比如你有的是爱用品有的是材料,方便后面tab注册
     * @return ...
     */
    public static RegistryObject<Item> registerToList(DeferredRegister<Item> register, String name, Supplier<? extends Item> sup, List<RegistryObject<Item>> registryList) {
        RegistryObject<Item> object = register.register(name, sup);
        registryList.add(object);
        return object;
    }

    public static void register(IEventBus bus) {
        ITEM.register(bus);
    }

}


