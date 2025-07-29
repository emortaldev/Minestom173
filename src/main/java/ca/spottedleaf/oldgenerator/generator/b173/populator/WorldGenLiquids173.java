package ca.spottedleaf.oldgenerator.generator.b173.populator;

import ca.spottedleaf.oldgenerator.util.BlockConstants;
import net.minestom.server.instance.block.Block;

import java.util.Random;

public class WorldGenLiquids173 extends WorldGenerator173 {

    private final Block blockData;

    public WorldGenLiquids173(Block i) {
        this.blockData = i;
    }

    @Override
    public boolean populate(Block.Getter blockGetter, Block.Setter blockSetter, Random random, int centerX, int centerY, int centerZ) {
        if (blockGetter.getBlock(centerX, centerY + 1, centerZ) != Block.STONE) {
            return false;
        } else if (blockGetter.getBlock(centerX, centerY - 1, centerZ) != Block.STONE) {
            return false;
        } else if (!blockGetter.getBlock(centerX, centerY, centerZ).isAir() && blockGetter.getBlock(centerX, centerY, centerZ) != Block.STONE) {
            return false;
        } else {
            int l = 0;

            if (blockGetter.getBlock(centerX - 1, centerY, centerZ) == Block.STONE) {
                ++l;
            }

            if (blockGetter.getBlock(centerX + 1, centerY, centerZ) == Block.STONE) {
                ++l;
            }

            if (blockGetter.getBlock(centerX, centerY, centerZ - 1) == Block.STONE) {
                ++l;
            }

            if (blockGetter.getBlock(centerX, centerY, centerZ + 1) == Block.STONE) {
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

            if (l == 3 && i1 == 1) {
                blockSetter.setBlock(centerX, centerY, centerZ, this.blockData); // want physics here so the water flows TODO: add physics
            }

            return true;
        }
    }
}
