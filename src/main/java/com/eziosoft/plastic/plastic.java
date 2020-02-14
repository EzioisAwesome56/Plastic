package com.eziosoft.plastic;

import com.eziosoft.plastic.blockent.PlasticBox;
import com.eziosoft.plastic.blockent.PlasticBox2;
import com.eziosoft.plastic.blocks.PboxBlock;
import com.eziosoft.plastic.blocks.PboxBlock2;
import com.eziosoft.plastic.screen.GuiController;
import com.eziosoft.plastic.util.configUtil;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.container.ContainerProviderRegistry;
import net.fabricmc.fabric.api.tools.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.container.BlockContext;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class plastic implements ModInitializer {


	public static final Item dank = new Item(new Item.Settings());

	public static final ItemGroup plastic_tab = FabricItemGroupBuilder.create(
			new Identifier("plastic", "main"))
			.icon(() -> new ItemStack(dank))
			.build();

	public static final Item plastic = new Item(new Item.Settings().group(plastic_tab));
	public static final Block plastic_ore = new FuckBlock(FabricBlockSettings.of(Material.STONE).breakByHand(false).breakByTool(FabricToolTags.PICKAXES, 2).hardness(2).resistance(0.2F).build());
	public static final Block plastic_box = new PboxBlock(FabricBlockSettings.of(Material.STONE).breakByHand(true).hardness(2).resistance(0.2F).build());
	public static final Item plastic_dust = new Item(new Item.Settings().group(plastic_tab));
	public static final Item plastic_mix = new Item(new Item.Settings().maxCount(1).group(plastic_tab));
	public static final Item raw_plastic = new Item(new Item.Settings().group(plastic_tab));
	public static final Item apple_plastic = new Item(new Item.Settings().group(plastic_tab).maxCount(1).food(new FoodComponent.Builder().hunger(9).saturationModifier(6f).statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 10), 0.2F).build()));
	public static final Item duct_tape = new Item(new Item.Settings().group(plastic_tab));
	public static final Item plastic_bowl = new Item(new Item.Settings().group(plastic_tab).maxCount(1));
	public static final Item burnt_plastic = new Item(new Item.Settings().group(plastic_tab));
	public static final Item burnt_bowl = new Item(new Item.Settings().group(plastic_tab).maxCount(1));
	public static final Item strong_plastic = new Item(new Item.Settings().group(plastic_tab));
	public static final Block plastic_boxtwo = new PboxBlock2(FabricBlockSettings.of(Material.STONE).breakByHand(true).hardness(2).resistance(0.2F).build());

	public static BlockEntityType<PlasticBox> plasticBox_ent;
	public static BlockEntityType<PlasticBox2> plasticBox_ent2;

	@Override
	public void onInitialize() {

		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		System.out.println("Welcome to Plastic Version 1.0");
		Registry.register(Registry.BLOCK, new Identifier("plastic", "plastic_ore"), plastic_ore);
		Registry.register(Registry.ITEM, new Identifier("plastic", "plastic_ore"), new BlockItem(plastic_ore, new Item.Settings().group(plastic_tab)));
		Registry.register(Registry.ITEM, new Identifier("plastic", "plastic"), plastic);
		Registry.register(Registry.ITEM, new Identifier("plastic", "plastic_dust"), plastic_dust);
		Registry.register(Registry.ITEM, new Identifier("plastic", "plastic_mix"), plastic_mix);
		Registry.register(Registry.ITEM, new Identifier("plastic", "apple_plastic"), apple_plastic);
		Registry.register(Registry.ITEM, new Identifier("plastic", "raw_plastic"), raw_plastic);
		Registry.register(Registry.ITEM, new Identifier("plastic", "plastic_pick"), new PickaxeBase(new PlasticTool(), -2.2f));
		Registry.register(Registry.ITEM, new Identifier("plastic", "duct_tape"), duct_tape);
		Registry.register(Registry.ITEM, new Identifier("plastic", "plastic_bowl"), plastic_bowl);
		Registry.register(Registry.ITEM, new Identifier("plastic", "dank"), dank);
		Registry.register(Registry.ITEM, new Identifier("plastic", "burnt_plastic"), burnt_plastic);
		Registry.register(Registry.ITEM, new Identifier("plastic", "burnt_bowl"), burnt_bowl);
		Registry.register(Registry.ITEM, new Identifier("plastic", "strong_plastic"), strong_plastic);

		// shit for blocks with inventories
		Registry.register(Registry.BLOCK, new Identifier("plastic", "plastic_box"), plastic_box);
		Registry.register(Registry.ITEM, new Identifier("plastic", "plastic_box"), new BlockItem(plastic_box, new Item.Settings().group(plastic_tab)));
		plasticBox_ent = Registry.register(Registry.BLOCK_ENTITY_TYPE, "plastic:plastic_box_ent", BlockEntityType.Builder.create(PlasticBox::new, plastic_box).build(null));
		plasticBox_ent2 = Registry.register(Registry.BLOCK_ENTITY_TYPE, "plastic:plastic_box_ent2", BlockEntityType.Builder.create(PlasticBox2::new, plastic_boxtwo).build(null));
		ContainerProviderRegistry.INSTANCE.registerFactory(new Identifier("plastic", "plastic_box"), (syncId, id, player, buf) -> new GuiController(configUtil.getControllerConfig(syncId, 1), player.inventory, BlockContext.create(player.world, buf.readBlockPos())));
		Registry.register(Registry.BLOCK, new Identifier("plastic", "plastic_boxtwo"), plastic_boxtwo);
		ContainerProviderRegistry.INSTANCE.registerFactory(new Identifier("plastic", "plastic_box2"), (syncId, id, player, buf) -> new GuiController(configUtil.getControllerConfig(syncId, 0), player.inventory, BlockContext.create(player.world, buf.readBlockPos())));
		Registry.register(Registry.ITEM, new Identifier("plastic", "plastic_boxtwo"), new BlockItem(plastic_boxtwo, new Item.Settings().group(plastic_tab)));

	}
}
