package ca.spottedleaf.oldgenerator.generator.b173.populator;

import ca.spottedleaf.oldgenerator.generator.b173.LegacyUtil173;
import net.minestom.server.instance.block.Block;
import java.util.Random;

public class WorldGenFlowers173 extends WorldGenerator173 {

    private final Block block;

    private final int minHeight;
    private final int maxHeight;
    public WorldGenFlowers173(Block block, int minHeight, int maxHeight) {
        this.block = block;
        this.minHeight = minHeight;
        this.maxHeight = maxHeight;
    }

    @Override
    public boolean populate(Block.Getter blockGetter, Block.Setter blockSetter, Random random, int centerX, int centerY, int centerZ) {
        for (int l = 0; l < 64; ++l) {
            int i1 = centerX + random.nextInt(8) - random.nextInt(8);
            int j1 = centerY + random.nextInt(4) - random.nextInt(4);
            int k1 = centerZ + random.nextInt(8) - random.nextInt(8);

            if (blockGetter.getBlock(i1, j1, k1).isAir() && LegacyUtil173.BlockFlower_f(blockGetter, minHeight, maxHeight, i1, j1, k1, this.block)) {
                blockSetter.setBlock(i1, j1, k1, this.block);
            }
        }

        return true;
    }
}
