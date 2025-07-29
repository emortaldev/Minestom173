package ca.spottedleaf.oldgenerator.generator.b173.populator;

import ca.spottedleaf.oldgenerator.generator.b173.LegacyUtil173;
import ca.spottedleaf.oldgenerator.util.BlockConstants;
import net.minestom.server.instance.block.Block;

import java.util.Random;

public class WorldGenLakes173 extends WorldGenerator173 {

    private final Block a;
    private final int minHeight;
    private final int maxHeight;

    public WorldGenLakes173(Block i, int minHeight, int maxHeight) {
        this.a = i;
        this.minHeight = minHeight;
        this.maxHeight = maxHeight;
    }

    @Override
    public boolean populate(Block.Getter blockGetter, Block.Setter blockSetter, Random random, int centerX, int centerY, int centerZ) {
        centerX -= 8;

        for (centerZ -= 8; centerY > minHeight && blockGetter.getBlock(centerX, centerY, centerZ).isAir(); --centerY) {
            ;
        }

        centerY -= 4;
        boolean[] aboolean = new boolean[2048];
        int l = random.nextInt(4) + 4;

        int i1;

        for (i1 = 0; i1 < l; ++i1) {
            double d0 = random.nextDouble() * 6.0D + 3.0D;
            double d1 = random.nextDouble() * 4.0D + 2.0D;
            double d2 = random.nextDouble() * 6.0D + 3.0D;
            double d3 = random.nextDouble() * (16.0D - d0 - 2.0D) + 1.0D + d0 / 2.0D;
            double d4 = random.nextDouble() * (8.0D - d1 - 4.0D) + 2.0D + d1 / 2.0D;
            double d5 = random.nextDouble() * (16.0D - d2 - 2.0D) + 1.0D + d2 / 2.0D;

            for (int j1 = 1; j1 < 15; ++j1) {
                for (int k1 = 1; k1 < 15; ++k1) {
                    for (int l1 = 1; l1 < 7; ++l1) {
                        double d6 = ((double) j1 - d3) / (d0 / 2.0D);
                        double d7 = ((double) l1 - d4) / (d1 / 2.0D);
                        double d8 = ((double) k1 - d5) / (d2 / 2.0D);
                        double d9 = d6 * d6 + d7 * d7 + d8 * d8;

                        if (d9 < 1.0D) {
                            aboolean[(j1 * 16 + k1) * 8 + l1] = true;
                        }
                    }
                }
            }
        }

        boolean flag;
        int i2;
        int j2;

        for (i1 = 0; i1 < 16; ++i1) {
            for (i2 = 0; i2 < 16; ++i2) {
                for (j2 = 0; j2 < 8; ++j2) {
                    flag = !aboolean[(i1 * 16 + i2) * 8 + j2] && (i1 < 15 && aboolean[((i1 + 1) * 16 + i2) * 8 + j2] || i1 > 0 && aboolean[((i1 - 1) * 16 + i2) * 8 + j2] || i2 < 15 && aboolean[(i1 * 16 + i2 + 1) * 8 + j2] || i2 > 0 && aboolean[(i1 * 16 + (i2 - 1)) * 8 + j2] || j2 < 7 && aboolean[(i1 * 16 + i2) * 8 + j2 + 1] || j2 > 0 && aboolean[(i1 * 16 + i2) * 8 + (j2 - 1)]);
                    if (flag) {
                        Block material = blockGetter.getBlock(centerX + i1, centerY + j2, centerZ + i2);

                        if (j2 >= 4 && BlockConstants.isLiquid(material)) {
                            return false;
                        }

                        if (j2 < 4 && !LegacyUtil173.Block_isBuildable(material) && blockGetter.getBlock(centerX + i1, centerY + j2, centerZ + i2) != this.a) {
                            return false;
                        }
                    }
                }
            }
        }

        for (i1 = 0; i1 < 16; ++i1) {
            for (i2 = 0; i2 < 16; ++i2) {
                for (j2 = 0; j2 < 8; ++j2) {
                    if (aboolean[(i1 * 16 + i2) * 8 + j2]) {
                        blockSetter.setBlock(centerX + i1, centerY + j2, centerZ + i2, j2 >= 4 ? Block.AIR : this.a);
                    }
                }
            }
        }

        for (i1 = 0; i1 < 16; ++i1) {
            for (i2 = 0; i2 < 16; ++i2) {
                for (j2 = 4; j2 < 8; ++j2) {
//                    if (aboolean[(i1 * 16 + i2) * 8 + j2] && blockGetter.getBlock(centerX + i1, centerY + j2 - 1, centerZ + i2) == Block.DIRT && world.getLightFromSky(centerX + i1, centerY + j2, centerZ + i2) > 0) { TODO: readd skylight check
                    if (aboolean[(i1 * 16 + i2) * 8 + j2] && blockGetter.getBlock(centerX + i1, centerY + j2 - 1, centerZ + i2) == Block.DIRT) {
                        blockSetter.setBlock(centerX + i1, centerY + j2 - 1, centerZ + i2, Block.GRASS_BLOCK);
                    }
                }
            }
        }

        if (this.a.compare(Block.LAVA)) {
            for (i1 = 0; i1 < 16; ++i1) {
                for (i2 = 0; i2 < 16; ++i2) {
                    for (j2 = 0; j2 < 8; ++j2) {
                        flag = !aboolean[(i1 * 16 + i2) * 8 + j2] && (i1 < 15 && aboolean[((i1 + 1) * 16 + i2) * 8 + j2] || i1 > 0 && aboolean[((i1 - 1) * 16 + i2) * 8 + j2] || i2 < 15 && aboolean[(i1 * 16 + i2 + 1) * 8 + j2] || i2 > 0 && aboolean[(i1 * 16 + (i2 - 1)) * 8 + j2] || j2 < 7 && aboolean[(i1 * 16 + i2) * 8 + j2 + 1] || j2 > 0 && aboolean[(i1 * 16 + i2) * 8 + (j2 - 1)]);
                        if (flag && (j2 < 4 || random.nextInt(2) != 0) && LegacyUtil173.Block_isBuildable(blockGetter.getBlock(centerX + i1, centerY + j2, centerZ + i2))) {
                            blockSetter.setBlock(centerX + i1, centerY + j2, centerZ + i2, Block.STONE);
                        }
                    }
                }
            }
        }

        return true;
    }
}
