package ca.spottedleaf.oldgenerator.generator.b173.populator;

import ca.spottedleaf.oldgenerator.util.BlockConstants;
import net.minestom.server.instance.block.Block;

import java.util.Random;

public class WorldGenLightStone1173 extends WorldGenerator173 {

    public WorldGenLightStone1173() {}

    @Override
    public boolean populate(Block.Getter blockGetter, Block.Setter blockSetter, Random random, int centerX, int centerY, int centerZ) {
        if (!blockGetter.getBlock(centerX, centerY, centerZ).isAir()) {
            return false;
        } else if (blockGetter.getBlock(centerX, centerY + 1, centerZ) != Block.NETHERRACK) {
            return false;
        } else {
            blockSetter.setBlock(centerX, centerY, centerZ, Block.GLOWSTONE);

            for (int l = 0; l < 1500; ++l) {
                int i1 = centerX + random.nextInt(8) - random.nextInt(8);
                int j1 = centerY - random.nextInt(12);
                int k1 = centerZ + random.nextInt(8) - random.nextInt(8);

                if (blockGetter.getBlock(i1, j1, k1).isAir()) {
                    int l1 = 0;

                    for (int i2 = 0; i2 < 6; ++i2) {
                        Block j2 = Block.AIR;

                        if (i2 == 0) {
                            j2 = blockGetter.getBlock(i1 - 1, j1, k1);
                        }

                        if (i2 == 1) {
                            j2 = blockGetter.getBlock(i1 + 1, j1, k1);
                        }

                        if (i2 == 2) {
                            j2 = blockGetter.getBlock(i1, j1 - 1, k1);
                        }

                        if (i2 == 3) {
                            j2 = blockGetter.getBlock(i1, j1 + 1, k1);
                        }

                        if (i2 == 4) {
                            j2 = blockGetter.getBlock(i1, j1, k1 - 1);
                        }

                        if (i2 == 5) {
                            j2 = blockGetter.getBlock(i1, j1, k1 + 1);
                        }

                        if (j2 == Block.GLOWSTONE) {
                            ++l1;
                        }
                    }

                    if (l1 == 1) {
                        blockSetter.setBlock(i1, j1, k1, Block.GLOWSTONE);
                    }
                }
            }

            return true;
        }
    }
}
