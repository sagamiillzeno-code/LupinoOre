package com.lupinoore;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;

import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = LupinoOre.MODID)
public class ModBlocks {

public static final Block LUPINO_ORE = createOre();

private static Block createOre() {
    Block block = new Block(Material.ROCK) {

        @Override
        public int quantityDropped(
            IBlockState state,
            int fortune,
            Random random
        ) {
            return 1;
        }

        @Override
        public Item getItemDropped(
            IBlockState state,
            Random random,
            int fortune
        ) {
            return Item.getItemFromBlock(this);
        }
    };

    block.setRegistryName(
        new ResourceLocation(
            LupinoOre.MODID,
            "lupino_ore"
        )
    );

    block.setUnlocalizedName(
        LupinoOre.MODID + ".lupino_ore"
    );

    block.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    block.setHardness(3.0F);
    block.setResistance(5.0F);
    block.setHarvestLevel("pickaxe", 2);

    return block;
}

@SubscribeEvent
public static void registerBlocks(
    RegistryEvent.Register<Block> event
) {
    event.getRegistry().register(LUPINO_ORE);
}

@SubscribeEvent
public static void registerItems(
    RegistryEvent.Register<Item> event
) {
    ItemBlock itemBlock = new ItemBlock(LUPINO_ORE);

    itemBlock.setRegistryName(
        LUPINO_ORE.getRegistryName()
    );

    event.getRegistry().register(itemBlock);
}

}
