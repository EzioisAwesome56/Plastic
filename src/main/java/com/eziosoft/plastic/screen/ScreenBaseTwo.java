package com.eziosoft.plastic.screen;

import io.github.cottonmc.cotton.gui.client.CottonInventoryScreen;
import net.minecraft.entity.player.PlayerEntity;

public class ScreenBaseTwo extends CottonInventoryScreen<CompressorGUI> {
    public ScreenBaseTwo(CompressorGUI container, PlayerEntity player) {
        super(container, player);
    }
}
