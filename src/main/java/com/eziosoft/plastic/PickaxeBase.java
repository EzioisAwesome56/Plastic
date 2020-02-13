package com.eziosoft.plastic;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;

public class PickaxeBase extends PickaxeItem {
    protected PickaxeBase(ToolMaterial material, float dank) {
        super(material, -1, dank, new Item.Settings().group(ItemGroup.MISC));
    }
}
