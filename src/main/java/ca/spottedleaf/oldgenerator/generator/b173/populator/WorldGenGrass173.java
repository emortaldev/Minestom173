package ca.spottedleaf.oldgenerator.generator.b173.populator;

import ca.spottedleaf.oldgenerator.generator.b173.LegacyUtil173;
import ca.spottedleaf.oldgenerator.util.BlockConstants;
import net.minestom.server.instance.block.Block;

import java.util.Random;

public class WorldGenGrass173 extends WorldGenerator173 {

    private final Block blockData;
    private final int minHeight;
    private final int maxHeight;

    public WorldGenGrass173(Block i, int minHeight, int maxHeight) {
        this.blockData = i;
        this.minHeight = minHeight;
        this.maxHeight = maxHeight;
    }

    @Override
    public boolean populate(Block.Getter blockGetter, Block.Setter blockSetter, Random random, int centerX, int centerY, int centerZ) {
        Block l;

        for (boolean flag = false; ((l = blockGetter.getBlock(centerX, centerY, centerZ)).isAir() || BlockConstants.isLeaves(l)) && centerY > 0; --centerY) {
            ;
        }

        for (int i1 = 0; i1 < 128; ++i1) {
            int j1 = centerX + random.nextInt(8) - random.nextInt(8);
            int k1 = centerY + random.nextInt(4) - random.nextInt(4);
            int l1 = centerZ + random.nextInt(8) - random.nextInt(8);


            if (blockGetter.getBlock(j1, k1, l1).isAir() && LegacyUtil173.BlockFlower_f(blockGetter, minHeight, maxHeight, j1, k1, l1, this.blockData)) {
                blockSetter.setBlock(j1, k1, l1, this.blockData);
            }
        }

        return true;
    }
}
