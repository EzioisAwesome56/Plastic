package com.eziosoft.plastic.screen;

import io.github.cottonmc.cotton.gui.client.CottonInventoryScreen;
import net.minecraft.entity.player.PlayerEntity;

public class PboxScreen extends CottonInventoryScreen<PboxController> {
    public PboxScreen(PboxController container, PlayerEntity player) {
        super(container, player);
    }
}
