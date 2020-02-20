package com.eziosoft.plastic.screen;

import io.github.cottonmc.cotton.gui.client.BackgroundPainter;
import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;
import io.github.cottonmc.cotton.gui.widget.WGridPanel;
import io.github.cottonmc.cotton.gui.widget.WLabel;
import io.github.cottonmc.cotton.gui.widget.WSprite;
import io.github.cottonmc.cotton.gui.widget.WTitle;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;

public class BookPagesGui extends LightweightGuiDescription {

    private int page;

    public BookPagesGui(){
        page = 0;
        WGridPanel root = new WGridPanel();
        setRootPanel(root);
        root.setSize(100, 100);
        WLabel title = new WLabel(new TranslatableText("gui.plastic.book").asString());
        root.add(title, 0, 0);
        root.add(new WSprite(new Identifier("plastic:textures/item/burnt_bowl.png")), 0, 1);


        root.validate(this);
    }

    @Override
    public void addPainters() {
        getRootPanel().setBackgroundPainter(BackgroundPainter.VANILLA); //This is done automatically though
    }
}
