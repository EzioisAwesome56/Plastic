package com.eziosoft.plastic.items;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.client.util.TextFormat;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.World;

import java.util.List;

public class itemWithTooltip extends Item {

    private String tiptext;

    public itemWithTooltip(Settings settings, String tip) {
        super(settings);
        this.tiptext = tip;
    }

    @Override
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
        //super.appendTooltip(stack, world, tooltip, context);
        tooltip.add(new TranslatableText(tiptext));
    }
}
