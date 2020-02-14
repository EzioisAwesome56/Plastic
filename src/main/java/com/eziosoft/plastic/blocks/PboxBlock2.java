package com.eziosoft.plastic.blocks;

import com.eziosoft.plastic.blockent.PlasticBox;
import com.eziosoft.plastic.blockent.PlasticBox2;
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

public class PboxBlock2 extends Block implements BlockEntityProvider {
    public PboxBlock2(Settings settings) {
        super(settings);
    }

    @Override
    public BlockEntity createBlockEntity(BlockView blockView) {
        return new PlasticBox2();
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (world.isClient) return ActionResult.PASS;

        BlockEntity be = world.getBlockEntity(pos);
        if (be!=null && be instanceof PlasticBox2) {
            ContainerProviderRegistry.INSTANCE.openContainer(new Identifier("plastic", "plastic_boxtwo"), player, (packetByteBuf -> packetByteBuf.writeBlockPos(pos)));
        }

        return ActionResult.SUCCESS;
    }


}
