package ca.spottedleaf.oldgenerator.generator.b173.populator;

import ca.spottedleaf.oldgenerator.generator.b173.LegacyUtil173;
import net.minestom.server.instance.block.Block;

import java.util.Random;

public class WorldGenReed173 extends WorldGenerator173 {

    private final int maxHeight;

    public WorldGenReed173(int maxHeight) {
        this.maxHeight = maxHeight;
    }

    @Override
    public boolean populate(Block.Getter blockGetter, Block.Setter blockSetter, Random random, int centerX, int centerY, int centerZ) {
        for (int l = 0; l < 20; ++l) {
            int i1 = centerX + random.nextInt(4) - random.nextInt(4);
            int j1 = centerY;
            int k1 = centerZ + random.nextInt(4) - random.nextInt(4);

            if (blockGetter.getBlock(i1, centerY, k1).isAir() && (blockGetter.getBlock(i1 - 1, centerY - 1, k1) == Block.WATER || blockGetter.getBlock(i1 + 1, centerY - 1, k1) == Block.WATER || blockGetter.getBlock(i1, centerY - 1, k1 - 1) == Block.WATER || blockGetter.getBlock(i1, centerY - 1, k1 + 1) == Block.WATER)) {
                int l1 = 2 + random.nextInt(random.nextInt(3) + 1);

                for (int i2 = 0; i2 < l1; ++i2) {
                    if (LegacyUtil173.Block_canPlace(blockGetter, maxHeight, i1, j1 + i2, k1, Block.SUGAR_CANE)) { // f just calls canPlace
                        blockSetter.setBlock(i1, j1 + i2, k1, Block.SUGAR_CANE);
                    }
                }
            }
        }

        return true;
    }
}
