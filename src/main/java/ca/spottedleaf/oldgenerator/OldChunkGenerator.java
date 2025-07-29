package ca.spottedleaf.oldgenerator;

import ca.spottedleaf.oldgenerator.generator.b173.nether.ChunkProviderHell173;
import ca.spottedleaf.oldgenerator.generator.b173.overworld.ChunkProviderOverworld173;
import ca.spottedleaf.oldgenerator.generator.b173.sky.ChunkProviderSky173;
import net.minestom.server.instance.IChunkLoader;
import net.minestom.server.instance.block.Block;

public interface OldChunkGenerator extends IChunkLoader {

    void populateChunk(int chunkX, int chunkZ, Block.Getter blockGetter, Block.Setter blockSetter);

    static ChunkProviderOverworld173 getOverworldGenerator(long seed) {
        return new ChunkProviderOverworld173(0, 127, seed);
    }

    static ChunkProviderHell173 getNetherGenerator(long seed) {
        return new ChunkProviderHell173(0, 127, seed);
    }

    static ChunkProviderSky173 getSkyGenerator(long seed) {
        return new ChunkProviderSky173(0, 127, seed);
    }

}
