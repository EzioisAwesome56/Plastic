package com.eziosoft.plastic.items;

import com.eziosoft.plastic.screen.BookPagesGui;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import io.github.cottonmc.cotton.gui.client.CottonClientScreen;

public class RecipeBook extends Item {
    public RecipeBook(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (world.isClient) {
            // open the recipe book gui
            MinecraftClient.getInstance().openScreen(new CottonClientScreen(new BookPagesGui()));
        }
        return super.use(world, user, hand);
    }
}
