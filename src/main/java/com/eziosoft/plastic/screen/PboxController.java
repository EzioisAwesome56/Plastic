package com.eziosoft.plastic.screen;

import io.github.cottonmc.cotton.gui.CottonCraftingController;
import io.github.cottonmc.cotton.gui.widget.WGridPanel;
import io.github.cottonmc.cotton.gui.widget.WItemSlot;
import net.minecraft.container.BlockContext;
import net.minecraft.container.PropertyDelegate;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.recipe.RecipeType;

public class PboxController extends CottonCraftingController {
    public PboxController(int syncId, PlayerInventory playerInventory, BlockContext context) {
        super(RecipeType.SMELTING, syncId, playerInventory, getBlockInventory(context), getBlockPropertyDelegate(context));

        WGridPanel root = new WGridPanel();
        setRootPanel(root);
        root.setSize(200, 100);

        for (int i = 0; i < blockInventory.getInvSize(); i++ ){
            root.add(WItemSlot.of(blockInventory, i), i, 0);
        }

        /*WItemSlot itemSlot = WItemSlot.of(blockInventory, 0);
        WItemSlot itemSlot2 = WItemSlot.of(blockInventory, 0);
        root.add(itemSlot, 0, 1);
        root.add(itemSlot2, 5, 1);*/

        System.out.println(root.getX());

        root.add(this.createPlayerInventoryPanel(), 5, 3);

        root.validate(this);
    }
}
