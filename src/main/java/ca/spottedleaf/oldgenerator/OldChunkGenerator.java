package ca.spottedleaf.oldgenerator;

import net.minestom.server.instance.IChunkLoader;
import net.minestom.server.instance.block.Block;

public interface OldChunkGenerator extends IChunkLoader {

    void populateChunk(int chunkX, int chunkZ, Block.Getter blockGetter, Block.Setter blockSetter);

}
