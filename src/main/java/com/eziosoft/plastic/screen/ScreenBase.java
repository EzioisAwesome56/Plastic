package com.eziosoft.plastic.screen;

import io.github.cottonmc.cotton.gui.client.CottonInventoryScreen;
import net.minecraft.entity.player.PlayerEntity;

public class ScreenBase extends CottonInventoryScreen<GuiController> {
    public ScreenBase(GuiController container, PlayerEntity player) {
        super(container, player);
    }
}
