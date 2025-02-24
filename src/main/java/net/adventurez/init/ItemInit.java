package net.adventurez.init;

import java.util.List;

import net.adventurez.item.*;
import net.adventurez.item.armor.*;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.OnAStickItem;
import net.minecraft.item.SmithingTemplateItem;
import net.minecraft.potion.Potions;
import net.minecraft.recipe.BrewingRecipeRegistry;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;

public class ItemInit {

    // Item Group
    public static final ItemGroup ADVENTUREZ_ITEM_GROUP = FabricItemGroup.builder(new Identifier("adventurez", "item_group"))
            .icon(() -> new ItemStack(ItemInit.HANDBOOK))
            .displayName(Text.translatable("item.adventurez.item_group"))
            .build();

    // Items
    public static final Item GILDED_BLACKSTONE_SHARD = register("gilded_blackstone_shard", new GildedBlackstoneShard(new Item.Settings().fireproof(), () -> EntityInit.GILDED_BLACKSTONE_SHARD));
    public static final Item BLACKSTONE_GOLEM_HEART = register("blackstone_golem_heart", new BlackstoneGolemHeart(new Item.Settings().fireproof()));
    public static final Item BLACKSTONE_GOLEM_ARM = register("blackstone_golem_arm", new BlackstoneGolemArm(new Item.Settings().maxDamage(2506).fireproof()));
    public static final Item GILDED_NETHERITE_FRAGMENT = register("gilded_netherite_fragment", new GildedNetheriteFragment(new Item.Settings().fireproof()));
    public static final Item PRIME_EYE = register("prime_eye", new PrimeEyeItem(new Item.Settings().maxDamage(64)));
    public static final Item ORC_SKIN = register("orc_skin", new Item(new Item.Settings()));
    public static final Item DRAGON_SADDLE = register("dragon_saddle", new Item(new Item.Settings().maxCount(1)));
    public static final Item SOURCE_STONE = register("source_stone", new SourceStone(new Item.Settings().maxCount(1)));
    public static final Item CHORUS_FRUIT_ON_A_STICK = register("chorus_fruit_on_a_stick", new OnAStickItem<>((new Item.Settings()).maxDamage(100), EntityInit.ENDER_WHALE, 1));
    public static final Item ENDER_FLUTE = register("ender_flute", new EnderFlute(new Item.Settings().maxDamage(32)));
    public static final Item IGUANA_HIDE = register("iguana_hide", new Item(new Item.Settings()));
    public static final Item MAMMOTH_LEATHER = register("mammoth_fur", new Item(new Item.Settings()));
    public static final Item ENDER_WHALE_SKIN = register("ender_whale_skin", new Item(new Item.Settings()));
    public static final Item IVORY_ARROW = register("ivory_arrow", new ArrowItem(new Item.Settings()));
    public static final Item MAMMOTH_TUSK = register("mammoth_tusk", new Item(new Item.Settings()));
    public static final Item RHINO_LEATHER = register("rhino_leather", new Item(new Item.Settings()));
    public static final Item WARTHOG_SHELL_PIECE = register("warthog_shell_piece", new Item(new Item.Settings()));
    public static final Item HANDBOOK = register("handbook", new Handbook(new Item.Settings().maxCount(1)));
    public static final Item GILDED_UPGRADE_SMITHING_TEMPLATE = register("gilded_upgrade_smithing_template",
            new SmithingTemplateItem(Text.translatable("item.minecraft.smithing_template.gilded_upgrade.applies_to").formatted(Formatting.BLUE),
                    Text.translatable("item.minecraft.smithing_template.gilded_upgrade.ingredients").formatted(Formatting.BLUE),
                    Text.translatable("item.adventurez.gilded_upgrade").formatted(Formatting.GRAY), Text.translatable("item.smithing_template.gilded_upgrade.base_slot_description"),
                    Text.translatable("item.adventurez.smithing_template.gilded_upgrade.additions_slot_description"), List.of(new Identifier("item/empty_armor_slot_helmet"),
                            new Identifier("item/empty_armor_slot_chestplate"), new Identifier("item/empty_armor_slot_leggings"), new Identifier("item/empty_armor_slot_boots")),
                    List.of(new Identifier("adventurez:item/empty_slot_gilded_netherite_fragment"))));

    // Food
    public static final Item MAMMOTH_MEAT = register("mammoth_meat", new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(3).saturationModifier(0.3F).meat().build())));
    public static final Item COOKED_MAMMOTH_MEAT = register("cooked_mammoth_meat", new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(8).saturationModifier(0.8F).meat().build())));
    public static final Item IGUANA_MEAT = register("iguana_meat", new Item(
            new Item.Settings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.3F).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 600, 0), 0.3F).meat().build())));
    public static final Item COOKED_IGUANA_MEAT = register("cooked_iguana_meat", new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(6).saturationModifier(0.6F).meat().build())));
    public static final Item ENDER_WHALE_MEAT = register("ender_whale_meat", new Item(
            new Item.Settings().food(new FoodComponent.Builder().hunger(3).saturationModifier(0.3F).statusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 100, 0), 0.5F).meat().build())));
    public static final Item COOKED_ENDER_WHALE_MEAT = register("cooked_ender_whale_meat", new Item(
            new Item.Settings().food(new FoodComponent.Builder().hunger(8).saturationModifier(0.9F).statusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING, 600, 0), 1.0F).meat().build())));
    public static final Item RHINO_MEAT = register("rhino_meat", new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(3).saturationModifier(0.3F).meat().build())));
    public static final Item COOKED_RHINO_MEAT = register("cooked_rhino_meat", new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(8).saturationModifier(0.8F).meat().build())));
    public static final Item RAW_VENISON = register("raw_venison", new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(3).saturationModifier(0.3F).meat().build())));
    public static final Item COOKED_VENISON = register("cooked_venison", new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(6).saturationModifier(0.8F).meat().build())));
    public static final Item WARTHOG_MEAT = register("warthog_meat", new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(3).saturationModifier(0.3F).meat().build())));
    public static final Item COOKED_WARTHOG_MEAT = register("cooked_warthog_meat", new Item(
            new Item.Settings().food(new FoodComponent.Builder().hunger(6).saturationModifier(0.8F).statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 600, 0), 1.0F).meat().build())));
    // Armor
    public static final ArmorMaterial GILDED_NETHERITE_ARMOR_MATERIAL = new GildedNetheriteArmorMaterial();
    public static final Item GILDED_NETHERITE_HELMET = register("gilded_netherite_helmet", new GildedNetheriteArmor(GILDED_NETHERITE_ARMOR_MATERIAL, ArmorItem.Type.HELMET));
    public static final Item GILDED_NETHERITE_CHESTPLATE = register("gilded_netherite_chestplate", new GildedNetheriteArmor(GILDED_NETHERITE_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE));
    public static final Item GILDED_NETHERITE_LEGGINGS = register("gilded_netherite_leggings", new GildedNetheriteArmor(GILDED_NETHERITE_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS));
    public static final Item GILDED_NETHERITE_BOOTS = register("gilded_netherite_boots", new GildedNetheriteArmor(GILDED_NETHERITE_ARMOR_MATERIAL, ArmorItem.Type.BOOTS));

    private static Item register(String id, Item item) {
        return register(new Identifier("adventurez", id), item);
    }

    private static Item register(Identifier id, Item item) {
        ItemGroupEvents.modifyEntriesEvent(ADVENTUREZ_ITEM_GROUP).register(entries -> entries.add(item));
        return Registry.register(Registries.ITEM, id, item);
    }

    public static void init() {
        BrewingRecipeRegistry.registerPotionRecipe(Potions.AWKWARD, ItemInit.ORC_SKIN, Potions.TURTLE_MASTER);
        BrewingRecipeRegistry.registerPotionRecipe(Potions.AWKWARD, ItemInit.ENDER_WHALE_SKIN, Potions.SLOW_FALLING);
    }

}