package ca.spottedleaf.oldgenerator.generator.b173.populator;

import ca.spottedleaf.oldgenerator.generator.b173.LegacyUtil173;
import ca.spottedleaf.oldgenerator.util.BlockConstants;
import net.minestom.server.instance.block.Block;

import java.util.Random;

public class WorldGenCactus173 extends WorldGenerator173 {

    public WorldGenCactus173() {}

    @Override
    public boolean populate(Block.Getter blockGetter, Block.Setter blockSetter, Random random, int centerX, int centerY, int centerZ) {
        for (int l = 0; l < 10; ++l) {
            int i1 = centerX + random.nextInt(8) - random.nextInt(8);
            int j1 = centerY + random.nextInt(4) - random.nextInt(4);
            int k1 = centerZ + random.nextInt(8) - random.nextInt(8);

            if (blockGetter.getBlock(i1, j1, k1).isAir()) {
                int l1 = 1 + random.nextInt(random.nextInt(3) + 1);

                for (int i2 = 0; i2 < l1; ++i2) {
                    if (LegacyUtil173.BlockCactus_f(blockGetter, i1, j1 + i2, k1)) {
                        blockSetter.setBlock(i1, j1 + i2, k1, Block.CACTUS);
                    }
                }
            }
        }

        return true;
    }
}
