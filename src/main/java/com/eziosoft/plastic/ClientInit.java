package com.eziosoft.plastic;

import com.eziosoft.plastic.screen.GuiController;
import com.eziosoft.plastic.screen.ScreenBase;
import com.eziosoft.plastic.util.configUtil;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.screen.ScreenProviderRegistry;
import net.minecraft.container.BlockContext;
import net.minecraft.util.Identifier;

public class ClientInit implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ScreenProviderRegistry.INSTANCE.registerFactory(new Identifier("plastic", "plastic_box"), (syncId, identifier, player, buf) -> new ScreenBase(new GuiController(configUtil.getControllerConfig(syncId, 1), player.inventory, BlockContext.create(player.world, buf.readBlockPos())), player));
        ScreenProviderRegistry.INSTANCE.registerFactory(new Identifier("plastic", "plastic_boxtwo"), (syncId, identifier, player, buf) -> new ScreenBase(new GuiController(configUtil.getControllerConfig(syncId, 2), player.inventory, BlockContext.create(player.world, buf.readBlockPos())), player));
    }
}
