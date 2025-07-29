package ca.spottedleaf.oldgenerator.generator.b173.populator;

import net.minestom.server.instance.block.Block;
import java.util.Random;

public class WorldGenHellLava173 extends WorldGenerator173 {

    private final Block block;

    public WorldGenHellLava173(Block i) {
        this.block = i;
    }

    @Override
    public boolean populate(Block.Getter blockGetter, Block.Setter blockSetter, Random random, int centerX, int centerY, int centerZ) {
        if (!blockGetter.getBlock(centerX, centerY + 1, centerZ).compare(Block.NETHERRACK)) {
            return false;
        } else if (!blockGetter.getBlock(centerX, centerY, centerZ).isAir() && !blockGetter.getBlock(centerX, centerY, centerZ).compare(Block.NETHERRACK)) {
            return false;
        } else {
            int l = 0;

            if (blockGetter.getBlock(centerX - 1, centerY, centerZ).compare(Block.NETHERRACK)) {
                ++l;
            }

            if (blockGetter.getBlock(centerX + 1, centerY, centerZ).compare(Block.NETHERRACK)) {
                ++l;
            }

            if (blockGetter.getBlock(centerX, centerY, centerZ - 1).compare(Block.NETHERRACK)) {
                ++l;
            }

            if (blockGetter.getBlock(centerX, centerY, centerZ + 1).compare(Block.NETHERRACK)) {
                ++l;
            }

            if (blockGetter.getBlock(centerX, centerY - 1, centerZ).compare(Block.NETHERRACK)) {
                ++l;
            }

            int i1 = 0;

            if (blockGetter.getBlock(centerX - 1, centerY, centerZ).isAir()) {
                ++i1;
            }

            if (blockGetter.getBlock(centerX + 1, centerY, centerZ).isAir()) {
                ++i1;
            }

            if (blockGetter.getBlock(centerX, centerY, centerZ - 1).isAir()) {
                ++i1;
            }

            if (blockGetter.getBlock(centerX, centerY, centerZ + 1).isAir()) {
                ++i1;
            }

            if (blockGetter.getBlock(centerX, centerY - 1, centerZ).isAir()) {
                ++i1;
            }

            if (l == 4 && i1 == 1) {
                blockSetter.setBlock(centerX, centerY, centerZ, this.block); // want physics here so the lava falls. // TODO: add physics here
            }

            return true;
        }
    }
}
