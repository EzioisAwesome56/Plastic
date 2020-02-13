package com.eziosoft.plastic;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class PlasticTool implements ToolMaterial {
    @Override
    public int getDurability() {
        return 300;
    }

    @Override
    public float getMiningSpeed() {
        return 3.0f;
    }

    @Override
    public float getAttackDamage() {
        return 1.5f;
    }

    @Override
    public int getMiningLevel() {
        return 1;
    }

    @Override
    public int getEnchantability() {
        return 2;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(plastic.plastic);
    }
}
