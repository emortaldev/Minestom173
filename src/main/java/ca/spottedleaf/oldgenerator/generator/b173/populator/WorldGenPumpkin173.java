package ca.spottedleaf.oldgenerator.generator.b173.populator;

import ca.spottedleaf.oldgenerator.generator.b173.LegacyUtil173;
import ca.spottedleaf.oldgenerator.util.BlockConstants;
import net.minestom.server.instance.block.Block;
import net.minestom.server.instance.block.BlockFace;
import java.util.Random;

public class WorldGenPumpkin173 extends WorldGenerator173 {

    private static final Block[] RANDOM_CARVED_PUMPKIN_FACING;
    static {
        final BlockFace[] facings = new BlockFace[] {
                BlockFace.SOUTH, BlockFace.WEST, BlockFace.NORTH, BlockFace.EAST
        };

        RANDOM_CARVED_PUMPKIN_FACING = new Block[facings.length];
        for (int i = 0, len = facings.length; i < len; ++i) {
            RANDOM_CARVED_PUMPKIN_FACING[i] = Block.CARVED_PUMPKIN.withProperty("facing", facings[i].name().toLowerCase());
        }
    }

    public static Block getRandomCarvedPumpkin(final Random random) {
        return RANDOM_CARVED_PUMPKIN_FACING[random.nextInt(RANDOM_CARVED_PUMPKIN_FACING.length)];
    }

    private final int maxHeight;

    public WorldGenPumpkin173(int maxHeight) {
        this.maxHeight = maxHeight;
    }

    @Override
    public boolean populate(Block.Getter blockGetter, Block.Setter blockSetter, Random random, int centerX, int centerY, int centerZ) {
        for (int l = 0; l < 64; ++l) {
            int i1 = centerX + random.nextInt(8) - random.nextInt(8);
            int j1 = centerY + random.nextInt(4) - random.nextInt(4);
            int k1 = centerZ + random.nextInt(8) - random.nextInt(8);

            if (blockGetter.getBlock(i1, j1, k1).isAir() && blockGetter.getBlock(i1, j1 - 1, k1) == Block.GRASS_BLOCK && LegacyUtil173.Block_canPlace(blockGetter, maxHeight, i1, j1, k1, Block.PUMPKIN)) {
                blockSetter.setBlock(i1, j1, k1, getRandomCarvedPumpkin(random));
            }
        }

        return true;
    }
}
