
package com.lupinoore;

import java.util.Random;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;

import net.minecraftforge.fml.common.IWorldGenerator;

public class WorldGenLupinoOre implements IWorldGenerator {

    private final WorldGenMinable generator;

    public WorldGenLupinoOre() {
        IBlockState oreState =
            ModBlocks.LUPINO_ORE.getDefaultState();

        this.generator = new WorldGenMinable(
            oreState,
            3,
            state -> state.getBlock() == Blocks.STONE
        );
    }

    @Override
    public void generate(
        Random random,
        int chunkX,
        int chunkZ,
        World world,
        IChunkGenerator chunkGenerator,
        IChunkProvider chunkProvider
    ) {
        if (world.provider.getDimension() != 0) {
            return;
        }

        // Примерно одна попытка на пять чанков.
        if (random.nextInt(5) != 0) {
            return;
        }

        int x = chunkX * 16 + random.nextInt(16);
        int y = 5 + random.nextInt(21);
        int z = chunkZ * 16 + random.nextInt(16);

        BlockPos pos = new BlockPos(x, y, z);

        generator.generate(world, random, pos);
    }
}
