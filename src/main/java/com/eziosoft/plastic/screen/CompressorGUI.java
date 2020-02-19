package com.eziosoft.plastic.screen;

import com.eziosoft.plastic.stuff.PlasticCombinerHandler;
import com.sun.javafx.image.IntPixelGetter;
import io.github.cottonmc.cotton.gui.CottonCraftingController;
import io.github.cottonmc.cotton.gui.widget.*;
import net.minecraft.container.BlockContext;
import net.minecraft.container.SlotActionType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.RecipeType;
import net.minecraft.text.TranslatableText;
import sun.jvm.hotspot.utilities.soql.Callable;

import java.lang.reflect.WildcardType;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class CompressorGUI extends CottonCraftingController {

    private static WLabel status = new WLabel(new TranslatableText("gui.plastic.wait").asString());

    public CompressorGUI(int syncId, PlayerInventory playerInventory, BlockContext context) {
        super(RecipeType.SMELTING, syncId, playerInventory, getBlockInventory(context), getBlockPropertyDelegate(context));

        WGridPanel root = new WGridPanel();
        setRootPanel(root);
        root.setSize(100, 100);
        WLabel label = new WLabel(new TranslatableText("block.plastic.plastic_compressor").asString());
        blockInventory = getBlockInventory(context);
        WButton craft = new WButton(new TranslatableText("gui.plastic.compress")).setOnClick(new PlasticCombinerHandler(blockInventory, root, status, playerInventory));
        root.add(label, 0, 0);

        for (int x = 0; x < blockInventory.getInvSize() - 1; x++){
            root.add(WItemSlot.of(blockInventory, x), x, 1);
        }
        root.add(WItemSlot.of(blockInventory, 3), 5, 1);

        root.add(status, 0, 2);
        root.add(craft, 0, 3, 4, 1);
        playerInventory.updateItems();


        root.add(this.createPlayerInventoryPanel(), 0, 5);

        root.validate(this);
    }
}
