package net.megatools.items;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Sets;
import net.fabricmc.fabric.api.biomes.v1.FabricBiomes;
import net.megatools.ToolMethods;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public class GreataxeItem extends AxeItem {

    public static final int LOG_BREAK_DELAY = 1;
    private static final Set<Material> EFFECTIVE_MATERIALS;
    private static final Set<Block> EFFECTIVE_BLOCKS;
    protected static final Map<Block, Block> STRIPPED_BLOCKS;
    public int rango;
    public GreataxeItem(ToolMaterial tier, float attackDamageIn, float attackSpeedIn, Settings builder,int prango) {
        super(tier, attackDamageIn, attackSpeedIn, builder);
        rango=prango;
    }

    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        if (!world.isClient && state.getHardness(world, pos) != 0.0F) {
            stack.damage(1, miner, (e) -> {
                e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND);
            });
            if (!attemptFellTree(world, pos,(PlayerEntity) miner)) {
                ToolMethods.attemptBreakNeighbors(world, pos,(PlayerEntity) miner, EFFECTIVE_BLOCKS,EFFECTIVE_MATERIALS, false,rango);
            }
        }

        return true;
    }

    private boolean attemptFellTree(World world, BlockPos pos, PlayerEntity player) {

        ArrayList<BlockPos> logs = new ArrayList<>();
        ArrayList<BlockPos> candidates = new ArrayList<>();
        candidates.add(pos);

        int leaves = 0;

        // Find all connected logs and count all connected leaves
        for (int i = 0; i < candidates.size(); i++) {
            if (logs.size() > 200) return false; // Whatever this is, it's too big! I don't want to know what happens if I let you use this in an all-log RFTDim.

            BlockPos candidate = candidates.get(i);
            Block block = world.getBlockState(candidate).getBlock();

            if (BlockTags.LEAVES.contains(block)) {
                leaves++;
            }
            else if (logs.size() == 0 || BlockTags.LOGS.contains(block)) {
                logs.add(candidate);


                for (int x = -1; x <= 1; x++) {
                    for (int y = 0; y <= 1; y++) {
                        for (int z = -1; z <= 1; z++) {
                            BlockPos neighbor = candidate.add(x, y, z);
                            if (candidates.contains(neighbor)) continue;
                            candidates.add(neighbor);
                        }
                    }
                }
            }
        }

        if (logs.size() == 0) return false;
        System.out.println(leaves);
        if (leaves >= logs.size()/6.0) {

                    int i=0;
                    while (i < logs.size()) {
                        BlockPos log = logs.get(i);
                        System.out.println(i);
                        ToolMethods.attemptBreakk(world, log, player, EFFECTIVE_BLOCKS,EFFECTIVE_MATERIALS, false);
                        i++;
                    }



            return true;
        }

        return false;
    }



    static {
        EFFECTIVE_MATERIALS = Sets.newHashSet(new Material[]{Material.WOOD, Material.NETHER_WOOD, Material.PLANT, Material.REPLACEABLE_PLANT, Material.BAMBOO, Material.GOURD});
        EFFECTIVE_BLOCKS = Sets.newHashSet(new Block[]{Blocks.LADDER, Blocks.SCAFFOLDING, Blocks.OAK_BUTTON, Blocks.SPRUCE_BUTTON, Blocks.BIRCH_BUTTON, Blocks.JUNGLE_BUTTON, Blocks.DARK_OAK_BUTTON, Blocks.ACACIA_BUTTON, Blocks.CRIMSON_BUTTON, Blocks.WARPED_BUTTON});
        STRIPPED_BLOCKS = (new ImmutableMap.Builder()).put(Blocks.OAK_WOOD, Blocks.STRIPPED_OAK_WOOD).put(Blocks.OAK_LOG, Blocks.STRIPPED_OAK_LOG).put(Blocks.DARK_OAK_WOOD, Blocks.STRIPPED_DARK_OAK_WOOD).put(Blocks.DARK_OAK_LOG, Blocks.STRIPPED_DARK_OAK_LOG).put(Blocks.ACACIA_WOOD, Blocks.STRIPPED_ACACIA_WOOD).put(Blocks.ACACIA_LOG, Blocks.STRIPPED_ACACIA_LOG).put(Blocks.BIRCH_WOOD, Blocks.STRIPPED_BIRCH_WOOD).put(Blocks.BIRCH_LOG, Blocks.STRIPPED_BIRCH_LOG).put(Blocks.JUNGLE_WOOD, Blocks.STRIPPED_JUNGLE_WOOD).put(Blocks.JUNGLE_LOG, Blocks.STRIPPED_JUNGLE_LOG).put(Blocks.SPRUCE_WOOD, Blocks.STRIPPED_SPRUCE_WOOD).put(Blocks.SPRUCE_LOG, Blocks.STRIPPED_SPRUCE_LOG).put(Blocks.WARPED_STEM, Blocks.STRIPPED_WARPED_STEM).put(Blocks.WARPED_HYPHAE, Blocks.STRIPPED_WARPED_HYPHAE).put(Blocks.CRIMSON_STEM, Blocks.STRIPPED_CRIMSON_STEM).put(Blocks.CRIMSON_HYPHAE, Blocks.STRIPPED_CRIMSON_HYPHAE).build();
    }
}
