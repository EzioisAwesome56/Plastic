package com.eziosoft.plastic;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tools.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class testMod implements ModInitializer {


	public static final Item plastic = new Item(new Item.Settings().group(ItemGroup.MISC));
	public static final Block plastic_ore = new FuckBlock(FabricBlockSettings.of(Material.STONE).breakByHand(false).breakByTool(FabricToolTags.PICKAXES, 2).hardness(2).resistance(0.2F).build());
	public static final Item plastic_dust = new Item(new Item.Settings().group(ItemGroup.MISC));

	@Override
	public void onInitialize() {

		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		System.out.println("Loading blocks");
		Registry.register(Registry.BLOCK, new Identifier("plastic", "plastic_ore"), plastic_ore);
		Registry.register(Registry.ITEM, new Identifier("plastic", "plastic_ore"), new BlockItem(plastic_ore, new Item.Settings().group(ItemGroup.MISC)));
		Registry.register(Registry.ITEM, new Identifier("plastic", "plastic"), plastic);
		Registry.register(Registry.ITEM, new Identifier("plastic", "plastic_dust"), plastic_dust);
	}

}
