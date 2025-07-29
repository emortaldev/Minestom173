package ca.spottedleaf.oldgenerator.generator.b173;

import net.minestom.server.instance.block.Block;
import java.util.Random;

public class MapGenBase173 {
    protected final int offset = 8;
    protected final Random random = new Random();

    public MapGenBase173() {}

    public void generate(Block.Getter blockGetter, Block.Setter blockSetter, int minHeight, int maxHeight, long seed, int cx, int cz) {
        int k = this.offset;

        this.random.setSeed(seed);
        long l = this.random.nextLong() / 2L * 2L + 1L;
        long i1 = this.random.nextLong() / 2L * 2L + 1L;

        for (int j1 = cx - k; j1 <= cx + k; ++j1) {
            for (int k1 = cz - k; k1 <= cz + k; ++k1) {
                this.random.setSeed((long) j1 * l + (long) k1 * i1 ^ seed);
                this.generate(blockGetter, blockSetter, minHeight, maxHeight, j1, k1, cx, cz);
            }
        }
    }

    protected void generate(Block.Getter blockGetter, Block.Setter blockSetter, int minHeight, int maxHeight, int i, int j, int k, int l) {}

}
