package ca.spottedleaf.oldgenerator.util;

import net.minestom.server.instance.block.Block;

import java.util.HashSet;
import java.util.Set;

public final class BlockConstants {

    /*
     * In order to avoid map lookups for converting from Block->NMS IBlockData we cache the block datas
     * here.
     */

    public static final Set<Block> AIRS = new HashSet<>();
    static {
        AIRS.add(Block.AIR);
        AIRS.add(Block.VOID_AIR);
        AIRS.add(Block.CAVE_AIR);
    }

    public static final Set<Block> LIQUIDS = new HashSet<>();
    static {
        LIQUIDS.add(Block.WATER);
        LIQUIDS.add(Block.LAVA);
    }

    public static boolean isLiquid(final Block Block) {
        return LIQUIDS.contains(Block);
    }

    public static final Set<Block> SAPLINGS = new HashSet<>();
    static {
        SAPLINGS.add(Block.ACACIA_SAPLING);
        SAPLINGS.add(Block.BIRCH_SAPLING);
        SAPLINGS.add(Block.DARK_OAK_SAPLING);
        SAPLINGS.add(Block.JUNGLE_SAPLING);
        SAPLINGS.add(Block.SPRUCE_SAPLING);
        SAPLINGS.add(Block.OAK_SAPLING);
    }

    public static final Set<Block> LEAVES = new HashSet<>();
    static {
        LEAVES.add(Block.ACACIA_LEAVES);
        LEAVES.add(Block.BIRCH_LEAVES);
        LEAVES.add(Block.DARK_OAK_LEAVES);
        LEAVES.add(Block.JUNGLE_LEAVES);
        LEAVES.add(Block.SPRUCE_LEAVES);
        LEAVES.add(Block.OAK_LEAVES);
    }

    public static boolean isLeaves(final Block Block) {
        return LEAVES.contains(Block);
    }

    public static final Set<Block> WOODS = new HashSet<>();
    static {
        WOODS.add(Block.ACACIA_WOOD);
        WOODS.add(Block.BIRCH_WOOD);
        WOODS.add(Block.DARK_OAK_WOOD);
        WOODS.add(Block.JUNGLE_WOOD);
        WOODS.add(Block.SPRUCE_WOOD);
        WOODS.add(Block.OAK_WOOD);
    }

    public static boolean isWood(final Block Block) {
        return WOODS.contains(Block);
    }

    public static final Set<Block> LOGS = new HashSet<>();
    static {
        LOGS.add(Block.ACACIA_LOG);
        LOGS.add(Block.BIRCH_LOG);
        LOGS.add(Block.DARK_OAK_LOG);
        LOGS.add(Block.JUNGLE_LOG);
        LOGS.add(Block.SPRUCE_LOG);
        LOGS.add(Block.OAK_LOG);
    }

    public static boolean isLog(final Block Block) {
        return LOGS.contains(Block);
    }

    public static final Set<Block> BUTTONS = new HashSet<>();
    static {
        BUTTONS.add(Block.STONE_BUTTON);

        BUTTONS.add(Block.ACACIA_BUTTON);
        BUTTONS.add(Block.BIRCH_BUTTON);
        BUTTONS.add(Block.DARK_OAK_BUTTON);
        BUTTONS.add(Block.JUNGLE_BUTTON);
        BUTTONS.add(Block.SPRUCE_BUTTON);
        BUTTONS.add(Block.OAK_BUTTON);
    }

    public static boolean isButton(final Block Block) {
        return BUTTONS.contains(Block);
    }

    public static final Set<Block> WOODEN_FENCES = new HashSet<>();
    static {
        WOODEN_FENCES.add(Block.ACACIA_FENCE);
        WOODEN_FENCES.add(Block.BIRCH_FENCE);
        WOODEN_FENCES.add(Block.DARK_OAK_FENCE);
        WOODEN_FENCES.add(Block.JUNGLE_FENCE);
        WOODEN_FENCES.add(Block.SPRUCE_FENCE);
        WOODEN_FENCES.add(Block.OAK_FENCE);
    }

    public static boolean isWoodenFence(final Block Block) {
        return WOODEN_FENCES.contains(Block);
    }

    public static final Set<Block> WOODEN_STAIRS = new HashSet<>();
    static {
        WOODEN_STAIRS.add(Block.ACACIA_STAIRS);
        WOODEN_STAIRS.add(Block.BIRCH_STAIRS);
        WOODEN_STAIRS.add(Block.DARK_OAK_STAIRS);
        WOODEN_STAIRS.add(Block.JUNGLE_STAIRS);
        WOODEN_STAIRS.add(Block.SPRUCE_STAIRS);
        WOODEN_STAIRS.add(Block.OAK_STAIRS);
    }

    public static boolean isWoodenStair(final Block Block) {
        return WOODEN_STAIRS.contains(Block);
    }

    public static final Set<Block> FLOWERS = new HashSet<>();
    static {
        FLOWERS.add(Block.DANDELION);
        FLOWERS.add(Block.POPPY);
        FLOWERS.add(Block.BLUE_ORCHID);
        FLOWERS.add(Block.ALLIUM);
        FLOWERS.add(Block.AZURE_BLUET);
        FLOWERS.add(Block.RED_TULIP);
        FLOWERS.add(Block.ORANGE_TULIP);
        FLOWERS.add(Block.WHITE_TULIP);
        FLOWERS.add(Block.PINK_TULIP);
        FLOWERS.add(Block.OXEYE_DAISY);
        FLOWERS.add(Block.CORNFLOWER);
        FLOWERS.add(Block.LILY_OF_THE_VALLEY);
    }

    public static boolean isFlower(final Block Block) {
        return FLOWERS.contains(Block);
    }

    public static final Set<Block> RAILS = new HashSet<>();
    static {
        RAILS.add(Block.RAIL);
        RAILS.add(Block.ACTIVATOR_RAIL);
        RAILS.add(Block.DETECTOR_RAIL);
        RAILS.add(Block.POWERED_RAIL);
    }

    public static boolean isRail(final Block Block) {
        return RAILS.contains(Block);
    }

    public static final Set<Block> WOOLS = new HashSet<>();
    static {
        WOOLS.add(Block.BLACK_WOOL);
        WOOLS.add(Block.BLUE_WOOL);
        WOOLS.add(Block.BROWN_WOOL);
        WOOLS.add(Block.CYAN_WOOL);
        WOOLS.add(Block.GRAY_WOOL);
        WOOLS.add(Block.GREEN_WOOL);
        WOOLS.add(Block.LIGHT_BLUE_WOOL);
        WOOLS.add(Block.LIGHT_GRAY_WOOL);
        WOOLS.add(Block.LIME_WOOL);
        WOOLS.add(Block.MAGENTA_WOOL);
        WOOLS.add(Block.ORANGE_WOOL);
        WOOLS.add(Block.PINK_WOOL);
        WOOLS.add(Block.PURPLE_WOOL);
        WOOLS.add(Block.RED_WOOL);
        WOOLS.add(Block.WHITE_WOOL);
        WOOLS.add(Block.YELLOW_WOOL);
    }

    public static boolean isWool(final Block Block) {
        return WOOLS.contains(Block);
    }

    public static final Set<Block> DOORS = new HashSet<>();
    static {
        DOORS.add(Block.ACACIA_DOOR);
        DOORS.add(Block.BIRCH_DOOR);
        DOORS.add(Block.DARK_OAK_DOOR);
        DOORS.add(Block.JUNGLE_DOOR);
        DOORS.add(Block.SPRUCE_DOOR);
        DOORS.add(Block.OAK_DOOR);

        DOORS.add(Block.IRON_DOOR);
    }

    public static boolean isDoor(final Block Block) {
        return DOORS.contains(Block);
    }

    public static final Set<Block> PRESSURE_PLATES = new HashSet<>();
    static {
        PRESSURE_PLATES.add(Block.STONE_PRESSURE_PLATE);

        PRESSURE_PLATES.add(Block.LIGHT_WEIGHTED_PRESSURE_PLATE);
        PRESSURE_PLATES.add(Block.HEAVY_WEIGHTED_PRESSURE_PLATE);

        PRESSURE_PLATES.add(Block.ACACIA_PRESSURE_PLATE);
        PRESSURE_PLATES.add(Block.BIRCH_PRESSURE_PLATE);
        PRESSURE_PLATES.add(Block.DARK_OAK_PRESSURE_PLATE);
        PRESSURE_PLATES.add(Block.JUNGLE_PRESSURE_PLATE);
        PRESSURE_PLATES.add(Block.SPRUCE_PRESSURE_PLATE);
        PRESSURE_PLATES.add(Block.OAK_PRESSURE_PLATE);
    }

    public static boolean isPressurePlate(final Block Block) {
        return PRESSURE_PLATES.contains(Block);
    }

    public static final Set<Block> TRAP_DOORS = new HashSet<>();
    static {
        TRAP_DOORS.add(Block.IRON_TRAPDOOR);

        TRAP_DOORS.add(Block.ACACIA_TRAPDOOR);
        TRAP_DOORS.add(Block.BIRCH_TRAPDOOR);
        TRAP_DOORS.add(Block.DARK_OAK_TRAPDOOR);
        TRAP_DOORS.add(Block.JUNGLE_TRAPDOOR);
        TRAP_DOORS.add(Block.SPRUCE_TRAPDOOR);
        TRAP_DOORS.add(Block.OAK_TRAPDOOR);
    }

    public static boolean isTrapDoor(final Block Block) {
        return TRAP_DOORS.contains(Block);
    }

    public static final Set<Block> GENERIC_TORCHS = new HashSet<>();
    static {
        GENERIC_TORCHS.add(Block.TORCH);
        GENERIC_TORCHS.add(Block.WALL_TORCH);
        GENERIC_TORCHS.add(Block.REDSTONE_TORCH);
        GENERIC_TORCHS.add(Block.REDSTONE_WALL_TORCH);
    }

    public static boolean isGenericTorch(final Block Block) {
        return GENERIC_TORCHS.contains(Block);
    }

    public static final Set<Block> BEDS = new HashSet<>();
    static {
        BEDS.add(Block.RED_BED);
        BEDS.add(Block.BLACK_BED);
        BEDS.add(Block.BLUE_BED);
        BEDS.add(Block.BROWN_BED);
        BEDS.add(Block.CYAN_BED);
        BEDS.add(Block.GRAY_BED);
        BEDS.add(Block.GREEN_BED);
        BEDS.add(Block.LIGHT_BLUE_BED);
        BEDS.add(Block.LIGHT_GRAY_BED);
        BEDS.add(Block.LIME_BED);
        BEDS.add(Block.MAGENTA_BED);
        BEDS.add(Block.ORANGE_BED);
        BEDS.add(Block.PINK_BED);
        BEDS.add(Block.PURPLE_BED);
        BEDS.add(Block.WHITE_BED);
        BEDS.add(Block.YELLOW_BED);
    }

    public static boolean isBed(final Block Block) {
        return BEDS.contains(Block);
    }

    public static final Set<Block> SIGNS = new HashSet<>();
    static {
        SIGNS.add(Block.ACACIA_SIGN);
        SIGNS.add(Block.BIRCH_SIGN);
        SIGNS.add(Block.DARK_OAK_SIGN);
        SIGNS.add(Block.JUNGLE_SIGN);
        SIGNS.add(Block.SPRUCE_SIGN);
        SIGNS.add(Block.OAK_SIGN);

        SIGNS.add(Block.ACACIA_WALL_SIGN);
        SIGNS.add(Block.BIRCH_WALL_SIGN);
        SIGNS.add(Block.DARK_OAK_WALL_SIGN);
        SIGNS.add(Block.JUNGLE_WALL_SIGN);
        SIGNS.add(Block.SPRUCE_WALL_SIGN);
        SIGNS.add(Block.OAK_WALL_SIGN);
    }

    public static boolean isSign(final Block Block) {
        return SIGNS.contains(Block);
    }
}
