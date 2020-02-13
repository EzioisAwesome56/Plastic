package com.eziosoft.plastic;

import net.fabricmc.fabric.api.container.ContainerProviderRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class PboxBlock extends Block implements BlockEntityProvider {
    public PboxBlock(Settings settings) {
        super(settings);
    }

    @Override
    public BlockEntity createBlockEntity(BlockView blockView) {
        return new PlasticBox();
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (world.isClient) return ActionResult.PASS;

        BlockEntity be = world.getBlockEntity(pos);
        if (be!=null && be instanceof PlasticBox) {
            ContainerProviderRegistry.INSTANCE.openContainer(new Identifier("plastic", "plastic_box"), player, (packetByteBuf -> packetByteBuf.writeBlockPos(pos)));
        }

        return ActionResult.SUCCESS;
    }


}
