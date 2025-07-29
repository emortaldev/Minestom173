# Minestom173
Beta 1.7.3 generation for Minestom

Port of Spottedleaf's [OldGenerator](https://github.com/Spottedleaf/OldGenerator/)

## Usage:
```java
var im = MinecraftServer.getInstanceManager();
var instance = im.createInstanceContainer();

// create overworld generator with seed 1234
long seed = 1234;
var overworldGenerator = OldChunkGenerator.getOverworldGenerator(seed);

// set the generator on the instance
instance.setChunkLoader(overworldGenerator);

LegacyPopulateHack.registerEvents(instance.eventNode()); // register populate events
```
