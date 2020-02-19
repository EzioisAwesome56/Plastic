package com.eziosoft.plastic.stuff;

import com.eziosoft.plastic.blockent.PlasticCompressor;
import io.github.cottonmc.cotton.gui.widget.WGridPanel;
import io.github.cottonmc.cotton.gui.widget.WLabel;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.RunArgs;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.crash.CrashCallable;
import net.minecraft.util.crash.CrashException;
import net.minecraft.util.crash.CrashReport;
import net.minecraft.util.crash.CrashReportSection;

import java.util.concurrent.BlockingQueue;

public class PlasticCombinerHandler implements Runnable {

    private Inventory blockinv;
    private WGridPanel root;
    private WLabel label;
    private Inventory play;

    public PlasticCombinerHandler(Inventory block, WGridPanel rt, WLabel dank, Inventory play){
        this.blockinv = block;
        this.root = rt;
        this.label = dank;
        this.play = play;
    }

    @Override
    public void run() {
        // clear the label right at the start
        root.remove(label);
        // check if something is in the output slot
        if (!blockinv.getInvStack(3).isEmpty()){
            label = new WLabel(new TranslatableText("gui.plastic.full").asString());
            root.add(label, 0, 2);
            return;
        }
        // check if all the input slots are empty
        if (blockinv.getInvStack(0).isEmpty() && blockinv.getInvStack(1).isEmpty() && blockinv.getInvStack(2).isEmpty()){
            label = new WLabel(new TranslatableText("gui.plastic.empty").asString());
            root.add(label, 0, 2);
            return;
        }
        // from this point forwards, check all crafting recipes
        if (blockinv.countInInv(Items.STICK) == 2){
            // clear all the slots
            blockinv.clear();
            // give player something
            blockinv.setInvStack(3, new ItemStack(Items.ACACIA_DOOR, 7));
            play.setInvStack(6, new ItemStack(Items.ACACIA_DOOR, 7));
            // update status
            label = new WLabel(new TranslatableText("gui.plastic.compressed").asString());
            root.add(label, 0, 2);

            return;
        }
        System.out.println("Do more stuff here");
    }
}
