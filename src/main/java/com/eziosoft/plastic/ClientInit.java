package com.eziosoft.plastic;

import com.eziosoft.plastic.screen.PboxController;
import com.eziosoft.plastic.screen.PboxScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.screen.ScreenProviderRegistry;
import net.minecraft.container.BlockContext;
import net.minecraft.util.Identifier;

public class ClientInit implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ScreenProviderRegistry.INSTANCE.registerFactory(new Identifier("plastic", "plastic_box"), (syncId, identifier, player, buf) -> new PboxScreen(new PboxController(syncId, player.inventory, BlockContext.create(player.world, buf.readBlockPos())), player));
    }
}
