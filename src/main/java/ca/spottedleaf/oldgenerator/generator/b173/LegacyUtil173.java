package ca.spottedleaf.oldgenerator.generator.b173;

import ca.spottedleaf.oldgenerator.util.BlockConstants;
import net.minestom.server.coordinate.CoordConversion;
import net.minestom.server.instance.Chunk;
import net.minestom.server.instance.block.Block;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class LegacyUtil173 {
    // Source code for b173 server can be found here: https://github.com/Bukkit/mc-dev/tree/1a792ed860ebe2c6d4c40c52f3bc7b9e0789ca23

    // NOTE: The following methods are supposed to mirror beta 1.7.3 behaviour! They are not guaranteed to mirror
    // NEW behaviour.

    private static final Set<Block> REPLACABLE_BlockS = new HashSet<>();

    static {
        REPLACABLE_BlockS.addAll(BlockConstants.AIRS);
        REPLACABLE_BlockS.add(Block.WATER);
        REPLACABLE_BlockS.add(Block.LAVA);
        REPLACABLE_BlockS.add(Block.SNOW); // TODO SNOW_BLOCK?
        REPLACABLE_BlockS.add(Block.FIRE);
    }

    public static boolean Block_isReplacable(final Block Block) {
        return REPLACABLE_BlockS.contains(Block);
    }

    private static final Set<Block> NON_BUILDABLE_BlockS = new HashSet<>();

    static {
        NON_BUILDABLE_BlockS.addAll(BlockConstants.AIRS);
        NON_BUILDABLE_BlockS.add(Block.FIRE);
        NON_BUILDABLE_BlockS.add(Block.WATER);
        NON_BUILDABLE_BlockS.add(Block.LAVA);
        NON_BUILDABLE_BlockS.add(Block.NETHER_PORTAL);
        NON_BUILDABLE_BlockS.add(Block.SNOW); // TODO SNOW_BLOCK?
        NON_BUILDABLE_BlockS.addAll(BlockConstants.BUTTONS);
        NON_BUILDABLE_BlockS.add(Block.REPEATER);
        NON_BUILDABLE_BlockS.add(Block.LADDER);
        NON_BUILDABLE_BlockS.add(Block.LEVER);
        NON_BUILDABLE_BlockS.add(Block.RAIL);
        NON_BUILDABLE_BlockS.addAll(BlockConstants.RAILS);
        NON_BUILDABLE_BlockS.add(Block.REDSTONE_WIRE);
        NON_BUILDABLE_BlockS.addAll(BlockConstants.GENERIC_TORCHS);
        NON_BUILDABLE_BlockS.add(Block.SUGAR_CANE);
        NON_BUILDABLE_BlockS.addAll(BlockConstants.FLOWERS);
        NON_BUILDABLE_BlockS.add(Block.RED_MUSHROOM);
        NON_BUILDABLE_BlockS.add(Block.BROWN_MUSHROOM);
        NON_BUILDABLE_BlockS.add(Block.DEAD_BUSH);
        NON_BUILDABLE_BlockS.add(Block.SHORT_GRASS);
        NON_BUILDABLE_BlockS.add(Block.FERN);
        NON_BUILDABLE_BlockS.addAll(BlockConstants.SAPLINGS);
        NON_BUILDABLE_BlockS.add(Block.WHEAT);
    }

    public static boolean Block_isBuildable(final Block Block) {
        return !NON_BUILDABLE_BlockS.contains(Block);
    }

    private static final Set<Block> Block_F = new HashSet<>();

    static {
        Block_F.add(Block.CACTUS);
        Block_F.add(Block.SNOW); // TODO SNOW_BLOCK?
        Block_F.add(Block.ICE);
        Block_F.add(Block.TNT);
        Block_F.add(Block.GLASS);
        Block_F.addAll(BlockConstants.LEAVES);
    }

    private static final Set<Block> NOT_Block_b = new HashSet<>();

    static {
        NOT_Block_b.addAll(BlockConstants.BEDS);
        NOT_Block_b.addAll(BlockConstants.BUTTONS);
        NOT_Block_b.add(Block.CACTUS);
        NOT_Block_b.add(Block.CAKE);
        NOT_Block_b.add(Block.REPEATER);
        NOT_Block_b.addAll(BlockConstants.DOORS);
        NOT_Block_b.addAll(BlockConstants.WOODEN_FENCES);
        NOT_Block_b.add(Block.FIRE);
        NOT_Block_b.addAll(BlockConstants.FLOWERS);
        NOT_Block_b.add(Block.WHEAT);
        NOT_Block_b.add(Block.DEAD_BUSH);
        NOT_Block_b.add(Block.SHORT_GRASS);
        NOT_Block_b.add(Block.FERN);
        NOT_Block_b.add(Block.RED_MUSHROOM);
        NOT_Block_b.add(Block.BROWN_MUSHROOM);
        NOT_Block_b.addAll(BlockConstants.SAPLINGS);
        NOT_Block_b.add(Block.WATER);
        NOT_Block_b.add(Block.LAVA);
        NOT_Block_b.add(Block.LADDER);
        NOT_Block_b.add(Block.LEVER);
        NOT_Block_b.addAll(BlockConstants.RAILS);
        NOT_Block_b.add(Block.PISTON);
        NOT_Block_b.add(Block.STICKY_PISTON);
        NOT_Block_b.add(Block.PISTON_HEAD);
        NOT_Block_b.add(Block.MOVING_PISTON);
        NOT_Block_b.add(Block.NETHER_PORTAL);
        NOT_Block_b.addAll(BlockConstants.PRESSURE_PLATES);
        NOT_Block_b.add(Block.REDSTONE_WIRE);
        NOT_Block_b.add(Block.SUGAR_CANE);
        NOT_Block_b.addAll(BlockConstants.SIGNS);
        NOT_Block_b.add(Block.SNOW); // TODO SNOW_BLOCK?
        NOT_Block_b.add(Block.FARMLAND);
        NOT_Block_b.addAll(BlockConstants.WOODEN_STAIRS);
        // TODO slabs
        NOT_Block_b.addAll(BlockConstants.GENERIC_TORCHS);
        NOT_Block_b.addAll(BlockConstants.TRAP_DOORS);
        NOT_Block_b.add(Block.COBWEB);
    }

    public static boolean Block_b(final Block Block) {
        return !NOT_Block_b.contains(Block);
    }

    public static boolean World_e(final Block.Getter blockGetter, final int x, final int y, final int z) {
        final Block Block = blockGetter.getBlock(x, y, z);
        if (Block.isAir()) {
            return false;
        }
        return (!Block_F.contains(Block) && Block_isSolid(Block)) && Block_b(Block);
    }


    private static final Map<Block, Integer> BlockFire_a = new HashMap<>();
    private static final Map<Block, Integer> BlockFire_b = new HashMap<>();

    static {
        /*
        this.a(Block.WOOD.id, 5, 20);
        this.a(Block.FENCE.id, 5, 20);
        this.a(Block.WOOD_STAIRS.id, 5, 20);
        this.a(Block.LOG.id, 5, 5);
        this.a(Block.LEAVES.id, 30, 60);
        this.a(Block.BOOKSHELF.id, 30, 20);
        this.a(Block.TNT.id, 15, 100);
        this.a(Block.LONG_GRASS.id, 60, 100);
        this.a(Block.WOOL.id, 30, 60);
         */
        for (final Block wood : BlockConstants.WOODS) {
            BlockFire_a.put(wood, 5);
            BlockFire_b.put(wood, 20);
        }

        for (final Block fence : BlockConstants.WOODEN_FENCES) {
            BlockFire_a.put(fence, 5);
            BlockFire_b.put(fence, 20);
        }

        for (final Block stair : BlockConstants.WOODEN_STAIRS) {
            BlockFire_a.put(stair, 5);
            BlockFire_b.put(stair, 20);
        }

        for (final Block log : BlockConstants.LOGS) {
            BlockFire_a.put(log, 5);
            BlockFire_b.put(log, 5);
        }

        for (final Block leaves : BlockConstants.LEAVES) {
            BlockFire_a.put(leaves, 30);
            BlockFire_b.put(leaves, 60);
        }

        BlockFire_a.put(Block.BOOKSHELF, 30);
        BlockFire_b.put(Block.BOOKSHELF, 20);

        BlockFire_a.put(Block.TNT, 15);
        BlockFire_b.put(Block.TNT, 100);

        BlockFire_a.put(Block.SHORT_GRASS, 60);
        BlockFire_b.put(Block.SHORT_GRASS, 100);
        BlockFire_a.put(Block.FERN, 60);
        BlockFire_b.put(Block.FERN, 100);

        for (final Block wool : BlockConstants.WOOLS) {
            BlockFire_a.put(wool, 30);
            BlockFire_b.put(wool, 60);
        }
    }


    public static boolean BlockFire_b(final Block.Getter blockGetter, final int x, final int y, final int z) {
        return BlockFire_a.getOrDefault(blockGetter.getBlock(x, y, z), -1) > 0;
    }

    private static final Set<Block> NOT_Block_a = new HashSet<>();

    static {
        NOT_Block_a.addAll(BlockConstants.BEDS);
        NOT_Block_a.addAll(BlockConstants.BUTTONS);
        NOT_Block_a.add(Block.CACTUS);
        NOT_Block_a.add(Block.CAKE);
        NOT_Block_a.add(Block.REPEATER);
        NOT_Block_a.addAll(BlockConstants.DOORS);
        NOT_Block_a.addAll(BlockConstants.WOODEN_FENCES);
        NOT_Block_a.add(Block.FIRE);
        NOT_Block_a.addAll(BlockConstants.FLOWERS);
        NOT_Block_a.add(Block.WHEAT);
        NOT_Block_a.add(Block.DEAD_BUSH);
        NOT_Block_a.add(Block.SHORT_GRASS);
        NOT_Block_a.add(Block.FERN);
        NOT_Block_a.add(Block.RED_MUSHROOM);
        NOT_Block_a.add(Block.BROWN_MUSHROOM);
        NOT_Block_a.addAll(BlockConstants.SAPLINGS);
        NOT_Block_a.add(Block.WATER);
        NOT_Block_a.add(Block.LAVA);
        NOT_Block_a.add(Block.LADDER);
        NOT_Block_a.add(Block.LEVER);
        NOT_Block_a.addAll(BlockConstants.RAILS);
        NOT_Block_a.add(Block.PISTON);
        NOT_Block_a.add(Block.STICKY_PISTON);
        NOT_Block_a.add(Block.PISTON_HEAD);
        NOT_Block_a.add(Block.MOVING_PISTON);
        NOT_Block_a.add(Block.NETHER_PORTAL);
        NOT_Block_a.addAll(BlockConstants.PRESSURE_PLATES);
        NOT_Block_a.add(Block.REDSTONE_WIRE);
        NOT_Block_a.add(Block.SUGAR_CANE);
        NOT_Block_a.addAll(BlockConstants.SIGNS);
        NOT_Block_a.add(Block.SNOW); // TODO SNOW_BLOCK?
        NOT_Block_a.add(Block.FARMLAND);
        NOT_Block_a.addAll(BlockConstants.WOODEN_STAIRS);
        // TODO slabs
        NOT_Block_a.addAll(BlockConstants.GENERIC_TORCHS);
        NOT_Block_a.addAll(BlockConstants.TRAP_DOORS);
        NOT_Block_a.add(Block.COBWEB);

        // new additions
        NOT_Block_a.add(Block.GLASS);
        NOT_Block_a.add(Block.ICE);
        NOT_Block_a.add(Block.NETHER_PORTAL);
        //NOT_Block_a.addAll(BlockConstants.LEAVES); // overrides but always is true
        NOT_Block_a.add(Block.SPAWNER);
    }

    public static boolean Block_o(final Block Block) {
        // As there is no block with air, mojang opted to use a boolean array to avoid NPE... And to decide that air should return false
        return !Block.isAir() && Block_a(Block);
    }

    public static boolean Block_a(final Block Block) {
        if (Block.isAir()) {
            throw new NullPointerException();
        }
        return !NOT_Block_a.contains(Block);
    }

    public static boolean Block_isSolid(final Block Block) {
        return Block_isBuildable(Block);
    }

    public static boolean BlockChest_g(final Block.Getter blockGetter, final int x, final int y, final int z) {
        return blockGetter.getBlock(x, y, z).compare(Block.CHEST) && (blockGetter.getBlock(x - 1, y, z).compare(Block.CHEST) || (blockGetter.getBlock(x + 1, y, z).compare(Block.CHEST) || (blockGetter.getBlock(x, y, z - 1).compare(Block.CHEST) || blockGetter.getBlock(x, y, z + 1).compare(Block.CHEST))));
    }

    public static boolean BlockTorch_g(final Block.Getter blockGetter, final int x, final int y, final int z) {
        return World_e(blockGetter, x, y, z) || BlockConstants.isWoodenFence(blockGetter.getBlock(x, y, z));
    }

    public static boolean BlockFlower_c(final Block type, final Block param) {
        if (type == Block.WHEAT) {
            return param == Block.FARMLAND;
        }
        if (type == Block.DEAD_BUSH) {
            return param == Block.SAND;
        }
        if (type == Block.RED_MUSHROOM || type == Block.BROWN_MUSHROOM) {
            return Block_o(param);
        }

        return param == Block.GRASS_BLOCK || param == Block.DIRT || param == Block.FARMLAND;
    }

    public static boolean BlockFlower_f(final Block.Getter blockGetter, int minHeight, int maxHeight, final int x, final int y, final int z, final Block type) {
        if (type == Block.RED_MUSHROOM || type == Block.BROWN_MUSHROOM) {
//            return y >= minHeight && y < (maxHeight + 1) && blockGetter.getLightLevel(x, y, z) < 13 && BlockFlower_c(type, blockGetter.getBlock(x, y - 1, z)); // TODO: readd light level check
            return y >= minHeight && y < (maxHeight + 1) && BlockFlower_c(type, blockGetter.getBlock(x, y - 1, z));
        }

        // default
        // we can always assume the chunk is loaded when calling

        if (y == 0) return false;

        final Block Block = blockGetter.getBlock(x, y - 1, z);
        return BlockFlower_c(type, Block);
    }

    public static boolean BlockCactus_f(final Block.Getter blockGetter, final int x, final int y, final int z) {
        if (Block_isBuildable(blockGetter.getBlock(x - 1, y, z))) {
            return false;
        } else if (Block_isBuildable(blockGetter.getBlock(x + 1, y, z))) {
            return false;
        } else if (Block_isBuildable(blockGetter.getBlock(x, y, z - 1))) {
            return false;
        } else if (Block_isBuildable(blockGetter.getBlock(x, y, z + 1))) {
            return false;
        } else {
            Block l = blockGetter.getBlock(x, y - 1, z);

            return l == Block.CACTUS || l == Block.SAND;
        }
    }

    public static boolean Block_canPlace(final Block.Getter blockGetter, int maxHeight, final int x, final int y, final int z, final Block block) {
        if (BlockConstants.isButton(block)) {
            return World_e(blockGetter, x - 1, y, z) || (World_e(blockGetter, x + 1, y, z) || (World_e(blockGetter, x, y, z - 1) || World_e(blockGetter, x, y, z + 1)));
        }
        if (block.compare(Block.CACTUS)) {
            return Block_isReplacable(blockGetter.getBlock(x, y, z)) && BlockCactus_f(blockGetter, x, y, z);
        }
        if (block.compare(Block.CAKE)) {
            return Block_isReplacable(blockGetter.getBlock(x, y, z)) && Block_isBuildable(blockGetter.getBlock(x, y - 1, z));
        }
        if (block.compare(Block.CHEST)) {
            int l = 0;

            if (blockGetter.getBlock(x - 1, y, z).compare(net.minestom.server.instance.block.Block.CHEST)) {
                ++l;
            }

            if (blockGetter.getBlock(x + 1, y, z).compare(net.minestom.server.instance.block.Block.CHEST)) {
                ++l;
            }

            if (blockGetter.getBlock(x, y, z - 1).compare(net.minestom.server.instance.block.Block.CHEST)) {
                ++l;
            }

            if (blockGetter.getBlock(x, y, z + 1).compare(net.minestom.server.instance.block.Block.CHEST)) {
                ++l;
            }

            return l <= 1 && (!BlockChest_g(blockGetter, x - 1, y, z) && (!BlockChest_g(blockGetter, x + 1, y, z) && (!BlockChest_g(blockGetter, x, y, z - 1) && !BlockChest_g(blockGetter, x, y, z + 1))));
        }
        if (block == Block.REPEATER) {
            return World_e(blockGetter, x, y - 1, z) && Block_isReplacable(blockGetter.getBlock(x, y, z));
        }
        if (BlockConstants.isDoor(block)) {
            return y < maxHeight && World_e(blockGetter, x, y - 1, z) && Block_isReplacable(blockGetter.getBlock(x, y, z)) && Block_isReplacable(blockGetter.getBlock(x, y + 1, z));
        }
        if (block == Block.FIRE) {
            if (World_e(blockGetter, x, y - 1, z)) {
                return true;
            }

            return BlockFire_b(blockGetter, x + 1, y, z) || (BlockFire_b(blockGetter, x - 1, y, z) || (BlockFire_b(blockGetter, x, y - 1, z) || (BlockFire_b(blockGetter, x, y + 1, z) || (BlockFire_b(blockGetter, x, y, z - 1) || BlockFire_b(blockGetter, x, y, z + 1)))));
        }
        if (BlockConstants.isFlower(block)) {
            if (!Block_isReplacable(blockGetter.getBlock(x, y, z))) {
                return false;
            }
            final Block below = blockGetter.getBlock(x, y - 1, z);
            return below == Block.GRASS_BLOCK || below == Block.DIRT || below == Block.FARMLAND;
        }
        if (block == Block.LADDER) {
            return World_e(blockGetter, x - 1, y, z) || (World_e(blockGetter, x + 1, y, z) || (World_e(blockGetter, x, y, z - 1) || World_e(blockGetter, x, y, z + 1)));
        }
        if (block == Block.LEVER) {
            return World_e(blockGetter, x - 1, y, z) || (World_e(blockGetter, x + 1, y, z) || (World_e(blockGetter, x, y, z - 1) || (World_e(blockGetter, x, y, z + 1) || World_e(blockGetter, x, y - 1, z))));
        }
        // locked_chest no longer exists.
        if (BlockConstants.isRail(block)) {
            return World_e(blockGetter, x, y - 1, z);
        }
        if (block == Block.PISTON_HEAD || block == Block.MOVING_PISTON) {
            return false;
        }
        if (BlockConstants.isPressurePlate(block)) {
            return World_e(blockGetter, x, y - 1, z);
        }
        if (block == Block.CARVED_PUMPKIN) {
            return Block_isReplacable(blockGetter.getBlock(x, y, z)) && World_e(blockGetter, x, y - 1, z);
        }
        if (block == Block.REDSTONE_WIRE) {
            return World_e(blockGetter, x, y - 1, z);
        }
        if (block == Block.SUGAR_CANE) {
            final Block below = blockGetter.getBlock(x, y - 1, z);

            return below == Block.SUGAR_CANE || ((below == Block.GRASS_BLOCK || below == Block.DIRT) && (blockGetter.getBlock(x - 1, y - 1, z) == Block.WATER || (blockGetter.getBlock(x + 1, y - 1, z) == Block.WATER || (blockGetter.getBlock(x, y - 1, z - 1) == Block.WATER || blockGetter.getBlock(x, y - 1, z + 1) == Block.WATER))));
        }
        if (block == Block.SNOW) { // TODO SNOW_BLOCK?
            final Block below = blockGetter.getBlock(x, y - 1, z);
            return !below.isAir() && Block_a(below) && Block_isSolid(below);
        }
        // stairs maps to either Block.WOOD or Block.COBBLESTONE, depending on the type of the stairs.
        // both do not override canPlace, so they aren't checked here (as they enter the default case)
        if (BlockConstants.isGenericTorch(block)) {
            return World_e(blockGetter, x - 1, y, z) || (World_e(blockGetter, x + 1, y, z) || (World_e(blockGetter, x, y, z - 1) || (World_e(blockGetter, x, y, z + 1) || BlockTorch_g(blockGetter, x, y - 1, z))));
        }


        // default
        return Block_isReplacable(blockGetter.getBlock(x, y, z));
    }

    /*
     * For reference, Chunks used to store block data as a single byte in a giant array. Indexing was done as follows:
     * index = x << 11 | z << 7 | y where x and z are in [0, 15] and y is in [0, 127]
     */

    // helper functions to easily convert code using the old byte[] access for chunk data

    public static Block getBlockIndex(final Block.Getter blockGetter, final int index) {
        return blockGetter.getBlock(index >>> 11, index & 127, (index >>> 7) & 15, Block.Getter.Condition.TYPE);
    }

    public static void setBlockIndex(final Block.Setter blockSetter, final int index, final Block block) {
        blockSetter.setBlock(index >>> 11, index & 127, (index >>> 7) & 15, block);
    }

    // due to very questionable decisions by spigot, the getHighestBlockYAt function was changed to return
    // the actual block y, after returning the block y + 1 for about 9 years. Move the correction here just in case
    // spigot breaks it again, so we can account for it easily.
    public static int getHighestBlockYAt(final Block.Getter blockGetter, int minHeight, int maxHeight, final int x, final int z) {
        // TODO: double check this is correct

        for (int i = minHeight; i < maxHeight; i++) {
            if (blockGetter.getBlock(x, i, z, Block.Getter.Condition.TYPE).isAir()) {
                return i;
            }
        }

        return 1;
    }

    public static boolean isFallingBlock(final Block block) {
        return block == Block.SAND || block == Block.GRAVEL;
    }
}