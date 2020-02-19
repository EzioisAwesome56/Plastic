package com.eziosoft.plastic.stuff;

import com.eziosoft.plastic.blockent.PlasticCompressor;
import io.github.cottonmc.cotton.gui.widget.WGridPanel;
import io.github.cottonmc.cotton.gui.widget.WLabel;
import net.minecraft.inventory.Inventory;
import net.minecraft.text.TranslatableText;

public class PlasticCombinerHandler implements Runnable {

    private Inventory blockinv;
    private WGridPanel root;
    private WLabel label;

    public PlasticCombinerHandler(Inventory block, WGridPanel rt, WLabel dank){
        this.blockinv = block;
        this.root = rt;
        this.label = dank;
    }

    @Override
    public void run() {
        // check if something is in the output slot
        if (!blockinv.getInvStack(3).isEmpty()){
            root.remove(label);
            label = new WLabel(new TranslatableText("gui.plastic.full").asString());
            root.add(label, 0, 2);
            return;
        }
        System.out.println("Do more stuff here");
    }
}
