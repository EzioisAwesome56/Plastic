package com.eziosoft.plastic.screen;

import com.eziosoft.plastic.stuff.PlasticCombinerHandler;
import com.sun.javafx.image.IntPixelGetter;
import io.github.cottonmc.cotton.gui.CottonCraftingController;
import io.github.cottonmc.cotton.gui.widget.*;
import net.minecraft.client.MinecraftClient;
import net.minecraft.container.BlockContext;
import net.minecraft.container.SlotActionType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.RecipeType;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.crash.CrashReport;
import sun.jvm.hotspot.utilities.soql.Callable;

import java.lang.reflect.WildcardType;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class CompressorGUI extends CottonCraftingController {

    public CompressorGUI(int syncId, PlayerInventory playerInventory, BlockContext context) {
        super(RecipeType.SMELTING, syncId, playerInventory, getBlockInventory(context), getBlockPropertyDelegate(context));

        WLabel status = new WLabel(new TranslatableText("gui.plastic.wait").asString());

        WGridPanel root = new WGridPanel();
        setRootPanel(root);
        root.setSize(100, 100);
        WLabel label = new WLabel(new TranslatableText("block.plastic.plastic_compressor").asString());
        blockInventory = getBlockInventory(context);

        // handle crafting
        if (blockInventory.getInvStack(3).isEmpty()) {
            if (blockInventory.countInInv(Items.STICK) == 2) {
                // clear all the slots
                blockInventory.clear();
                // give player something
                blockInventory.setInvStack(3, new ItemStack(Items.ACACIA_DOOR, 7));
                status = new WLabel(new TranslatableText("gui.plastic.compressed").asString());
            }
        } else {
            status = new WLabel(new TranslatableText("gui.plastic.full").asString());
        }


        root.add(label, 0, 0);

        for (int x = 0; x < blockInventory.getInvSize() - 1; x++){
            root.add(WItemSlot.of(blockInventory, x), x, 1);
        }
        root.add(WItemSlot.of(blockInventory, 3), 5, 1);

        root.add(status, 0, 2);
        playerInventory.updateItems();


        root.add(this.createPlayerInventoryPanel(), 0, 4);

        root.validate(this);
    }
}
