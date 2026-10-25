
package com.lupinoore;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

@Mod.EventBusSubscriber(modid = LupinoOre.MODID)
public class ModBlocks {

    @ObjectHolder("lupinoore:lupino_ore")
    public static final Block LUPINO_ORE = null;

    public static final Block LUPINO_ORE_BLOCK =
        new Block(Material.ROCK) {
            @Override
            public int quantityDropped(
                IBlockState state,
                int fortune,
                java.util.Random random
            ) {
                return 1;
            }

            @Override
            public Item getItemDropped(
                IBlockState state,
                java.util.Random random,
                int fortune
            ) {
                return Item.getItemFromBlock(this);
            }
        }
        .setRegistryName(
            new ResourceLocation("lupinoore", "lupino_ore")
        )
        .setUnlocalizedName("lupino_ore")
        .setHardness(3.0F)
        .setResistance(5.0F);

    @SubscribeEvent
    public static void registerBlocks(
        RegistryEvent.Register<Block> event
    ) {
        event.getRegistry().register(LUPINO_ORE_BLOCK);
    }

    @SubscribeEvent
    public static void registerItemBlocks(
        RegistryEvent.Register<Item> event
    ) {
        event.getRegistry().register(
            new ItemBlock(LUPINO_ORE_BLOCK)
                .setRegistryName(LUPINO_ORE_BLOCK.getRegistryName())
        );
    }
}
