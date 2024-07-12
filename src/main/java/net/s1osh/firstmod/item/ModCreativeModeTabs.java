package net.s1osh.firstmod.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.s1osh.firstmod.FirstMod;
import net.s1osh.firstmod.block.ModBlocks;

public class ModCreativeModeTabs {
    // Adding the Creative Mode Tab to the Mod
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, FirstMod.MOD_ID);

    // Creating the Creative Mode Tab
    public static final RegistryObject<CreativeModeTab> MOONK_TAB = CREATIVE_MODE_TABS.register("moonk_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.SAPPHIRE.get())) // Tab Icon
                    .title(Component.translatable("creativetab.moonk_tab")) // Title
                    .displayItems((pParameters, pOutput) -> { // Item List
                        pOutput.accept(ModItems.SAPPHIRE.get());
                        pOutput.accept(ModItems.RAW_SAPPHIRE.get());
                        pOutput.accept(ModItems.MOONK.get());
                        pOutput.accept(ModItems.METAL_DETECTOR.get());

                        pOutput.accept(ModBlocks.CHRIS_BLOCK.get());
                        pOutput.accept(ModBlocks.SAPPHIRE_BLOCK.get());
                        pOutput.accept(ModBlocks.RAW_SAPPHIRE_BLOCK.get());
                    })
                    .build()); // Create

    // Register the Tab in the Mod Event Bus
    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
