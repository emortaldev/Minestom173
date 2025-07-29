package ca.spottedleaf.oldgenerator.generator.b173.populator;

import ca.spottedleaf.oldgenerator.generator.b173.MathHelper173;
import net.minestom.server.instance.block.Block;

import java.util.Random;

public class WorldGenMinable173 extends WorldGenerator173 {

    private final Block blockData;
    private final int attempts;

    public WorldGenMinable173(Block i, int j) {
        this.blockData = i;
        this.attempts = j;
    }

    @Override
    public boolean populate(Block.Getter blockGetter, Block.Setter blockSetter, Random random, int centerX, int centerY, int centerZ) {
        float f = random.nextFloat() * 3.1415927F;
        double d0 = (double) ((float) (centerX + 8) + MathHelper173.sin(f) * (float) this.attempts / 8.0F);
        double d1 = (double) ((float) (centerX + 8) - MathHelper173.sin(f) * (float) this.attempts / 8.0F);
        double d2 = (double) ((float) (centerZ + 8) + MathHelper173.cos(f) * (float) this.attempts / 8.0F);
        double d3 = (double) ((float) (centerZ + 8) - MathHelper173.cos(f) * (float) this.attempts / 8.0F);
        double d4 = (double) (centerY + random.nextInt(3) + 2);
        double d5 = (double) (centerY + random.nextInt(3) + 2);

        for (int l = 0; l <= this.attempts; ++l) {
            double d6 = d0 + (d1 - d0) * (double) l / (double) this.attempts;
            double d7 = d4 + (d5 - d4) * (double) l / (double) this.attempts;
            double d8 = d2 + (d3 - d2) * (double) l / (double) this.attempts;
            double d9 = random.nextDouble() * (double) this.attempts / 16.0D;
            double d10 = (double) (MathHelper173.sin((float) l * 3.1415927F / (float) this.attempts) + 1.0F) * d9 + 1.0D;
            double d11 = (double) (MathHelper173.sin((float) l * 3.1415927F / (float) this.attempts) + 1.0F) * d9 + 1.0D;
            int i1 = MathHelper173.floor(d6 - d10 / 2.0D);
            int j1 = MathHelper173.floor(d7 - d11 / 2.0D);
            int k1 = MathHelper173.floor(d8 - d10 / 2.0D);
            int l1 = MathHelper173.floor(d6 + d10 / 2.0D);
            int i2 = MathHelper173.floor(d7 + d11 / 2.0D);
            int j2 = MathHelper173.floor(d8 + d10 / 2.0D);

            for (int k2 = i1; k2 <= l1; ++k2) {
                double d12 = ((double) k2 + 0.5D - d6) / (d10 / 2.0D);

                if (d12 * d12 < 1.0D) {
                    for (int l2 = j1; l2 <= i2; ++l2) {
                        double d13 = ((double) l2 + 0.5D - d7) / (d11 / 2.0D);

                        if (d12 * d12 + d13 * d13 < 1.0D) {
                            for (int i3 = k1; i3 <= j2; ++i3) {
                                double d14 = ((double) i3 + 0.5D - d8) / (d10 / 2.0D);

                                if (d12 * d12 + d13 * d13 + d14 * d14 < 1.0D && blockGetter.getBlock(k2, l2, i3) == Block.STONE) {
                                    blockSetter.setBlock(k2, l2, i3, this.blockData);
                                }
                            }
                        }
                    }
                }
            }
        }

        return true;
    }
}
