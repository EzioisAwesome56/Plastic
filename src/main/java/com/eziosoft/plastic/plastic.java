package com.eziosoft.plastic;

import com.mojang.datafixers.Dynamic;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biomes.v1.OverworldBiomes;
import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.event.registry.RegistryEntryAddedCallback;
import net.fabricmc.fabric.api.tools.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.carver.CarverConfig;
import net.minecraft.world.gen.carver.ConfiguredCarver;
import net.minecraft.world.gen.chunk.OverworldChunkGeneratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.*;

public class plastic implements ModInitializer {


	public static final Item dank = new Item(new Item.Settings());

	public static final ItemGroup plastic_tab = FabricItemGroupBuilder.create(
			new Identifier("plastic", "main"))
			.icon(() -> new ItemStack(dank))
			.build();

	public static final Item plastic = new Item(new Item.Settings().group(plastic_tab));
	public static final Block plastic_ore = new FuckBlock(FabricBlockSettings.of(Material.STONE).breakByHand(false).breakByTool(FabricToolTags.PICKAXES, 2).hardness(2).resistance(0.2F).build());
	public static final Block plastic_box = new FuckBlock(FabricBlockSettings.of(Material.STONE).breakByHand(true).hardness(2).resistance(0.2F).build());
	public static final Item plastic_dust = new Item(new Item.Settings().group(plastic_tab));
	public static final Item plastic_mix = new Item(new Item.Settings().maxCount(1).group(plastic_tab));
	public static final Item raw_plastic = new Item(new Item.Settings().group(plastic_tab));
	public static final Item apple_plastic = new Item(new Item.Settings().group(plastic_tab).maxCount(1).food(new FoodComponent.Builder().hunger(9).saturationModifier(6f).statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 10), 0.2F).build()));
	public static final Item duct_tape = new Item(new Item.Settings().group(plastic_tab));
	public static final Item plastic_bowl = new Item(new Item.Settings().group(plastic_tab).maxCount(1));

	@Override
	public void onInitialize() {

		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		System.out.println("Welcome to Plastic Version 1.0");
		Registry.register(Registry.BLOCK, new Identifier("plastic", "plastic_ore"), plastic_ore);
		Registry.register(Registry.ITEM, new Identifier("plastic", "plastic_ore"), new BlockItem(plastic_ore, new Item.Settings().group(plastic_tab)));
		Registry.register(Registry.BLOCK, new Identifier("plastic", "plastic_box"), plastic_box);
		Registry.register(Registry.ITEM, new Identifier("plastic", "plastic_box"), new BlockItem(plastic_box, new Item.Settings().group(plastic_tab)));
		Registry.register(Registry.ITEM, new Identifier("plastic", "plastic"), plastic);
		Registry.register(Registry.ITEM, new Identifier("plastic", "plastic_dust"), plastic_dust);
		Registry.register(Registry.ITEM, new Identifier("plastic", "plastic_mix"), plastic_mix);
		Registry.register(Registry.ITEM, new Identifier("plastic", "apple_plastic"), apple_plastic);
		Registry.register(Registry.ITEM, new Identifier("plastic", "raw_plastic"), raw_plastic);
		Registry.register(Registry.ITEM, new Identifier("plastic", "plastic_pick"), new PickaxeBase(new PlasticTool(), -2.2f));
		Registry.register(Registry.ITEM, new Identifier("plastic", "duct_tape"), duct_tape);
		Registry.register(Registry.ITEM, new Identifier("plastic", "plastic_bowl"), plastic_bowl);
		Registry.register(Registry.ITEM, new Identifier("plastic", "dank"), dank);

	}

}
