package com.eziosoft.plastic.screen;

import io.github.cottonmc.cotton.gui.CottonCraftingController;
import io.github.cottonmc.cotton.gui.widget.WGridPanel;
import io.github.cottonmc.cotton.gui.widget.WItemSlot;
import net.minecraft.container.BlockContext;
import net.minecraft.container.PropertyDelegate;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.recipe.RecipeType;

public class GuiController extends CottonCraftingController {
    public GuiController(Integer[] syncId, PlayerInventory playerInventory, BlockContext context) {
        super(RecipeType.SMELTING, syncId[0], playerInventory, getBlockInventory(context), getBlockPropertyDelegate(context));

        WGridPanel root = new WGridPanel();
        setRootPanel(root);
        root.setSize(syncId[1], syncId[2]);

        int slotsPerRow = syncId[3];
        int rows = 2;

        for (int y = 0; y < blockInventory.getInvSize() % slotsPerRow; y++) {
            for (int x = 0; x < Math.min(blockInventory.getInvSize() - (y * slotsPerRow), slotsPerRow); x++) {
                root.add(WItemSlot.of(blockInventory, x + (y * slotsPerRow)), x, y);
            }
        }


        /*for (int i = 0; i < blockInventory.getInvSize(); i++ ){
            root.add(WItemSlot.of(blockInventory, i), i, 0);
        }*/

        /*WItemSlot itemSlot = WItemSlot.of(blockInventory, 0);
        WItemSlot itemSlot2 = WItemSlot.of(blockInventory, 0);
        root.add(itemSlot, 0, 1);
        root.add(itemSlot2, 5, 1);*/

        root.add(this.createPlayerInventoryPanel(), 0, syncId[4]);

        root.validate(this);
    }
}
