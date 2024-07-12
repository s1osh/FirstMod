package net.s1osh.firstmod.block;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.s1osh.firstmod.FirstMod;
import net.s1osh.firstmod.block.custom.SoundBlock;
import net.s1osh.firstmod.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    // Register BLOCK (Does not include the item associated with it, see registerBlockItem method below)
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, FirstMod.MOD_ID);

    // SAPPHIRE BLOCK
    public static final RegistryObject<Block> SAPPHIRE_BLOCK = registerBlock("sapphire_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)));
    // RAW SAPPHIRE BLOCK
    public static final RegistryObject<Block> RAW_SAPPHIRE_BLOCK = registerBlock("raw_sapphire_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).sound(SoundType.COPPER)));
    // RAW SAPPHIRE BLOCK
    public static final RegistryObject<Block> CHRIS_BLOCK = registerBlock("chris_block",
            () -> new SoundBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block); // Register Block
        registerBlockItem(name, toReturn); // Register Block Item
        return toReturn; // Return Block
    }

    // Register Item Associated with Item Path
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
