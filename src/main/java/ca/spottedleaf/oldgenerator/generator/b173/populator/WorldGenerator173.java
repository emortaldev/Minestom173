package ca.spottedleaf.oldgenerator.generator.b173.populator;

import net.minestom.server.instance.block.Block;

import java.util.Random;

public abstract class WorldGenerator173 {

    public WorldGenerator173() {}

    public abstract boolean populate(Block.Getter blockGetter, Block.Setter blockSetter, Random random, int centerX, int centerY, int centerZ);

    public void scale(double scaleX, double scaleY, double scaleZ) {}

}
