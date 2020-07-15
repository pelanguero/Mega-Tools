package net.megatools;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.*;
import net.minecraft.world.RayTraceContext;
import net.minecraft.world.World;

import java.util.Set;

public class ToolMethods {
    public static void attemptBreakNeighbors(World world,
                                             BlockPos pos,
                                             PlayerEntity player,
                                             Set<Block> effectiveOn,
                                             Set<Material> effectiveMaterials,
                                             boolean checkHarvestLevel,int radioImpar) {

        world.setBlockState(pos, Blocks.GLASS.getDefaultState());
        BlockHitResult trace = rayTrace(world, player, RayTraceContext.FluidHandling.ANY);
        world.setBlockState(pos, Blocks.AIR.getDefaultState());

        if (trace.getType() == BlockHitResult.Type.BLOCK) {
            BlockHitResult blockTrace = (BlockHitResult) trace;
            Direction face = blockTrace.getSide();


            for (int a = ((radioImpar-1)/2)*(-1); a <= ((radioImpar-1)/2); a++) {
                for (int b = ((radioImpar-1)/2)*(-1); b <= ((radioImpar-1)/2); b++) {
                    if (a == 0 && b == 0) continue;

                    BlockPos target = null;

                    if (face == Direction.UP    || face == Direction.DOWN)  target = pos.add(a, 0, b);
                    if (face == Direction.NORTH || face == Direction.SOUTH) target = pos.add(a, b, 0);
                    if (face == Direction.EAST  || face == Direction.WEST)  target = pos.add(0, a, b);

                    attemptBreakk(world, target, player, effectiveOn,effectiveMaterials,  checkHarvestLevel);
                }
            }
        }
    }

    public static void attemptBreak(World world,
                                    BlockPos pos,
                                    PlayerEntity player,
                                    Set<Block> effectiveOn,
                                    int fortuneLevel,
                                    int silkLevel,
                                    boolean checkHarvestLevel) {
        BlockState state = world.getBlockState(pos);

        boolean validHarvest = !checkHarvestLevel || player.getMainHandStack().isEffectiveOn(state);
        boolean isEffective = effectiveOn.contains(state.getBlock());
        boolean witherImmune = BlockTags.WITHER_IMMUNE.contains(state.getBlock());

        if (validHarvest && isEffective && !witherImmune) {
            Block.dropStacks(state, world, pos, null, player, player.getMainHandStack());
            world.breakBlock(pos,false);
        }
    }

    public static void attemptBreakk(World world,
                                    BlockPos pos,
                                    PlayerEntity player,
                                    Set<Block> effectiveOn,
                                    Set<Material> effectiveMaterials,
                                    boolean checkHarvestLevel) {
        BlockState state = world.getBlockState(pos);

        boolean validHarvest = !checkHarvestLevel || player.getMainHandStack().isEffectiveOn(state);
        boolean isEffective = effectiveOn.contains(state.getBlock()) || effectiveMaterials.contains(state.getMaterial());
        boolean witherImmune = BlockTags.WITHER_IMMUNE.contains(state.getBlock());

        if (validHarvest && isEffective && !witherImmune) {
            Block.dropStacks(state, world, pos, null, player, player.getMainHandStack());
            world.breakBlock(pos,false);
        }
    }

    public static BlockHitResult rayTrace(World world, PlayerEntity player, RayTraceContext.FluidHandling fluidHandling) {
        float f = player.pitch;
        float g = player.yaw;
        Vec3d vec3d = player.getCameraPosVec(1.0F);
        float h = MathHelper.cos(-g * 0.017453292F - 3.1415927F);
        float i = MathHelper.sin(-g * 0.017453292F - 3.1415927F);
        float j = -MathHelper.cos(-f * 0.017453292F);
        float k = MathHelper.sin(-f * 0.017453292F);
        float l = i * j;
        float n = h * j;
        double d = 5.0D;
        Vec3d vec3d2 = vec3d.add((double)l * 5.0D, (double)k * 5.0D, (double)n * 5.0D);
        return world.rayTrace(new RayTraceContext(vec3d, vec3d2, RayTraceContext.ShapeType.OUTLINE, fluidHandling, player));
    }


}
