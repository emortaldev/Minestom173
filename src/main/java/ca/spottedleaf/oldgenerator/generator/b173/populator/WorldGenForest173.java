package ca.spottedleaf.oldgenerator.generator.b173.populator;

import ca.spottedleaf.oldgenerator.generator.b173.LegacyUtil173;
import ca.spottedleaf.oldgenerator.util.BlockConstants;
import net.minestom.server.instance.block.Block;

import java.util.Random;

public class WorldGenForest173 extends WorldGenerator173 {

    private final int minHeight;
    private final int maxHeight;
    public WorldGenForest173(int minHeight, int maxHeight) {
        this.minHeight = minHeight;
        this.maxHeight = maxHeight;
    }

    @Override
    public boolean populate(Block.Getter blockGetter, Block.Setter blockSetter, Random random, int centerX, int centerY, int centerZ) {
        int l = random.nextInt(3) + 5;
        boolean flag = true;

        if (centerY >= (minHeight + 1) && centerY + l + 1 <= (maxHeight + 1)) {
            int i1;
            int j1;
            int k1;
            int l1;
            Block type;

            for (i1 = centerY; i1 <= centerY + 1 + l; ++i1) {
                byte b0 = 1;

                if (i1 == centerY) {
                    b0 = 0;
                }

                if (i1 >= centerY + 1 + l - 2) {
                    b0 = 2;
                }

                for (j1 = centerX - b0; j1 <= centerX + b0 && flag; ++j1) {
                    for (k1 = centerZ - b0; k1 <= centerZ + b0 && flag; ++k1) {
                        if (i1 >= minHeight && i1 < (maxHeight + 1)) {
                            type = blockGetter.getBlock(j1, i1, k1);
                            if (!type.isAir() && !BlockConstants.isLeaves(type)) {
                                flag = false;
                            }
                        } else {
                            flag = false;
                        }
                    }
                }
            }

            if (!flag) {
                return false;
            } else {
                type = blockGetter.getBlock(centerX, centerY - 1, centerZ);
                if ((type == Block.GRASS_BLOCK || type == Block.DIRT) && centerY < 128 - l - 1) {
                    blockSetter.setBlock(centerX, centerY - 1, centerZ, Block.DIRT);

                    int i2;

                    for (i2 = centerY - 3 + l; i2 <= centerY + l; ++i2) {
                        j1 = i2 - (centerY + l);
                        k1 = 1 - j1 / 2;

                        for (l1 = centerX - k1; l1 <= centerX + k1; ++l1) {
                            int j2 = l1 - centerX;

                            for (int k2 = centerZ - k1; k2 <= centerZ + k1; ++k2) {
                                int l2 = k2 - centerZ;

                                if ((Math.abs(j2) != k1 || Math.abs(l2) != k1 || random.nextInt(2) != 0 && j1 != 0) && !LegacyUtil173.Block_o(blockGetter.getBlock(l1, i2, k2))) {
                                    blockSetter.setBlock(l1, i2, k2, Block.BIRCH_LEAVES);
                                }
                            }
                        }
                    }

                    for (i2 = 0; i2 < l; ++i2) {
                        type = blockGetter.getBlock(centerX, centerY + i2, centerZ);
                        if (type.isAir() || BlockConstants.isLeaves(type)) {
                            blockSetter.setBlock(centerX, centerY + i2, centerZ, Block.BIRCH_LOG);
                        }
                    }

                    return true;
                } else {
                    return false;
                }
            }
        } else {
            return false;
        }
    }
}
