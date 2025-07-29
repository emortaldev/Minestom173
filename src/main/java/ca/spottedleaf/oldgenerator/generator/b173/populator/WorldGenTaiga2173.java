package ca.spottedleaf.oldgenerator.generator.b173.populator;

import ca.spottedleaf.oldgenerator.generator.b173.LegacyUtil173;
import ca.spottedleaf.oldgenerator.util.BlockConstants;
import net.minestom.server.instance.block.Block;

import java.util.Random;

public class WorldGenTaiga2173 extends WorldGenerator173 {

    private final int minHeight;
    private final int maxHeight;
    public WorldGenTaiga2173(int minHeight, int maxHeight) {
        this.minHeight = minHeight;
        this.maxHeight = maxHeight;
    }

    @Override
    public boolean populate(Block.Getter blockGetter, Block.Setter blockSetter, Random random, int centerX, int centerY, int centerZ) {
        int l = random.nextInt(4) + 6;
        int i1 = 1 + random.nextInt(2);
        int j1 = l - i1;
        int k1 = 2 + random.nextInt(2);
        boolean flag = true;

        if (centerY >= (minHeight + 1) && centerY + l + 1 <= (maxHeight + 1)) {
            int l1;
            int i2;
            int j2;
            int k2;
            Block type;

            for (l1 = centerY; l1 <= centerY + 1 + l && flag; ++l1) {
                boolean flag1 = true;

                if (l1 - centerY < i1) {
                    k2 = 0;
                } else {
                    k2 = k1;
                }

                for (i2 = centerX - k2; i2 <= centerX + k2 && flag; ++i2) {
                    for (int l2 = centerZ - k2; l2 <= centerZ + k2 && flag; ++l2) {
                        if (l1 >= minHeight && l1 < (maxHeight + 1)) {
                            type = blockGetter.getBlock(i2, l1, l2);
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
                if ((type == Block.GRASS_BLOCK || type == Block.DIRT) && centerY < (maxHeight + 1) - l - 1) {
                    blockSetter.setBlock(centerX, centerY - 1, centerZ, Block.DIRT);
                    k2 = random.nextInt(2);
                    i2 = 1;
                    byte b0 = 0;

                    int i3;
                    int j3;

                    for (j2 = 0; j2 <= j1; ++j2) {
                        j3 = centerY + l - j2;

                        for (i3 = centerX - k2; i3 <= centerX + k2; ++i3) {
                            int k3 = i3 - centerX;

                            for (int l3 = centerZ - k2; l3 <= centerZ + k2; ++l3) {
                                int i4 = l3 - centerZ;

                                if ((Math.abs(k3) != k2 || Math.abs(i4) != k2 || k2 <= 0) && !LegacyUtil173.Block_o(blockGetter.getBlock(i3, j3, l3))) {
                                    blockSetter.setBlock(i3, j3, l3, Block.SPRUCE_LEAVES);
                                }
                            }
                        }

                        if (k2 >= i2) {
                            k2 = b0;
                            b0 = 1;
                            ++i2;
                            if (i2 > k1) {
                                i2 = k1;
                            }
                        } else {
                            ++k2;
                        }
                    }

                    j2 = random.nextInt(3);

                    for (j3 = 0; j3 < l - j2; ++j3) {
                        type = blockGetter.getBlock(centerX, centerY + j3, centerZ);
                        if (type.isAir() || BlockConstants.isLeaves(type)) {
                            blockSetter.setBlock(centerX, centerY + j3, centerZ, Block.SPRUCE_LOG);
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
