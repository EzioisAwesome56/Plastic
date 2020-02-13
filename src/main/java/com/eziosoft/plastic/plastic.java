package com.eziosoft.plastic;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tools.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class plastic implements ModInitializer {


	public static final Item plastic = new Item(new Item.Settings().group(ItemGroup.MISC));
	public static final Block plastic_ore = new FuckBlock(FabricBlockSettings.of(Material.STONE).breakByHand(false).breakByTool(FabricToolTags.PICKAXES, 2).hardness(2).resistance(0.2F).build());
	public static final Item plastic_dust = new Item(new Item.Settings().group(ItemGroup.MISC));
	public static final Item plastic_mix = new Item(new Item.Settings().maxCount(1).group(ItemGroup.MISC));
	public static final Item apple_plastic = new Item(new Item.Settings().group(ItemGroup.MISC).maxCount(1).food(new FoodComponent.Builder().hunger(9).saturationModifier(6f).statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 10), 0.2F).build()));

	@Override
	public void onInitialize() {

		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		System.out.println("Welcome to Plastic Version 1.0");
		Registry.register(Registry.BLOCK, new Identifier("plastic", "plastic_ore"), plastic_ore);
		Registry.register(Registry.ITEM, new Identifier("plastic", "plastic_ore"), new BlockItem(plastic_ore, new Item.Settings().group(ItemGroup.MISC)));
		Registry.register(Registry.ITEM, new Identifier("plastic", "plastic"), plastic);
		Registry.register(Registry.ITEM, new Identifier("plastic", "plastic_dust"), plastic_dust);
		Registry.register(Registry.ITEM, new Identifier("plastic", "plastic_mix"), plastic_mix);
		Registry.register(Registry.ITEM, new Identifier("plastic", "apple_plastic"), apple_plastic);
	}

}
