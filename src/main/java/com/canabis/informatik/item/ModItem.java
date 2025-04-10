package com.canabis.informatik.item;

import com.canabis.informatik.CanabisInformatik;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModItem {

    public static final Item CUSTOM_ITEM = registerItem("custom_item", Item::new, new Item.Settings());

    public static Item registerItem(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {
        final RegistryKey<Item> registerKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CanabisInformatik.MOD_ID, name));
        return Items.register(registerKey, factory, settings);
    }

    private static void customIngredients(FabricItemGroupEntries entries) { //Sorgt dafür das Custom Item im Inventar angezeigt wird
       entries.add(CUSTOM_ITEM);

    }

    public static void registerModItem () {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItem::customIngredients);

    }
}