package ca.spottedleaf.oldgenerator.generator.b173.populator;

import net.minestom.server.instance.block.Block;

import java.util.Random;

public class WorldGenFire173 extends WorldGenerator173 {

    public WorldGenFire173() {}

    @Override
    public boolean populate(Block.Getter blockGetter, Block.Setter blockSetter, Random random, int centerX, int centerY, int centerZ) {
        for (int l = 0; l < 64; ++l) {
            int i1 = centerX + random.nextInt(8) - random.nextInt(8);
            int j1 = centerY + random.nextInt(4) - random.nextInt(4);
            int k1 = centerZ + random.nextInt(8) - random.nextInt(8);

            if (blockGetter.getBlock(i1, j1, k1).isAir() && blockGetter.getBlock(i1, j1 - 1, k1) == Block.NETHERRACK) {
                blockSetter.setBlock(i1, j1, k1, Block.FIRE);
            }
        }

        return true;
    }
}
