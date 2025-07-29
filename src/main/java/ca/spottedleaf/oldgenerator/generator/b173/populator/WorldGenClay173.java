package ca.spottedleaf.oldgenerator.generator.b173.populator;

import ca.spottedleaf.oldgenerator.generator.b173.MathHelper173;
import net.minestom.server.instance.block.Block;

import java.util.Random;

public class WorldGenClay173 extends WorldGenerator173 {

    private final Block blockData;
    private final int attempts;

    public WorldGenClay173(int attempts) {
        this.blockData = Block.CLAY;
        this.attempts = attempts;
    }

    @Override
    public boolean populate(Block.Getter blockGetter, Block.Setter blockSetter, Random random, int centerX, int centerY, int centerZ) {
        if (blockGetter.getBlock(centerX, centerY, centerZ) != Block.WATER) {
            return false;
        } else {
            float f = random.nextFloat() * 3.1415927F;
            double d0 = (float) (centerX + 8) + MathHelper173.sin(f) * (float) this.attempts / 8.0F;
            double d1 = (float) (centerX + 8) - MathHelper173.sin(f) * (float) this.attempts / 8.0F;
            double d2 = (float) (centerZ + 8) + MathHelper173.cos(f) * (float) this.attempts / 8.0F;
            double d3 = (float) (centerZ + 8) - MathHelper173.cos(f) * (float) this.attempts / 8.0F;
            double d4 = centerY + random.nextInt(3) + 2;
            double d5 = centerY + random.nextInt(3) + 2;

            for (int l = 0; l <= this.attempts; ++l) {
                double d6 = d0 + (d1 - d0) * (double) l / (double) this.attempts;
                double d7 = d4 + (d5 - d4) * (double) l / (double) this.attempts;
                double d8 = d2 + (d3 - d2) * (double) l / (double) this.attempts;
                double d9 = random.nextDouble() * (double) this.attempts / 16.0D;
                double d10 = (double) (MathHelper173.sin((float) l * 3.1415927F / (float) this.attempts) + 1.0F) * d9 + 1.0D;
                double d11 = (double) (MathHelper173.sin((float) l * 3.1415927F / (float) this.attempts) + 1.0F) * d9 + 1.0D;
                int i1 = MathHelper173.floor(d6 - d10 / 2.0D);
                int j1 = MathHelper173.floor(d6 + d10 / 2.0D);
                int k1 = MathHelper173.floor(d7 - d11 / 2.0D);
                int l1 = MathHelper173.floor(d7 + d11 / 2.0D);
                int i2 = MathHelper173.floor(d8 - d10 / 2.0D);
                int j2 = MathHelper173.floor(d8 + d10 / 2.0D);

                for (int k2 = i1; k2 <= j1; ++k2) {
                    for (int l2 = k1; l2 <= l1; ++l2) {
                        for (int i3 = i2; i3 <= j2; ++i3) {
                            double d12 = ((double) k2 + 0.5D - d6) / (d10 / 2.0D);
                            double d13 = ((double) l2 + 0.5D - d7) / (d11 / 2.0D);
                            double d14 = ((double) i3 + 0.5D - d8) / (d10 / 2.0D);

                            if (d12 * d12 + d13 * d13 + d14 * d14 < 1.0D) {
                                Block j3 = blockGetter.getBlock(k2, l2, i3);

                                if (j3 == Block.SAND) {
                                    blockSetter.setBlock(k2, l2, i3, this.blockData);
                                }
                            }
                        }
                    }
                }
            }

            return true;
        }
    }
}
