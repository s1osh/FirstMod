package net.s1osh.firstmod;

// FEATURES IN THIS MOD
/*

 - CUSTOM CREATIVE MENU (MOONK TAB)
 - SAPPHIRE
 - RAW SAPPHIRE
 - SAPPHIRE BLOCK
 - RAW SAPPHIRE BLOCK
 - CRAFTING EACH WAY (BLOCK to SAPPHIRE, and the reverse)
 - SMELTING / BLAST FURNACE

*/

import com.mojang.logging.LogUtils;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.s1osh.firstmod.block.ModBlocks;
import net.s1osh.firstmod.item.ModCreativeModeTabs;
import net.s1osh.firstmod.item.ModItems;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(FirstMod.MOD_ID)
public class FirstMod
{
    public static final String MOD_ID = "s1oshfirstmod";
    private static final Logger LOGGER = LogUtils.getLogger();

    public FirstMod()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Creative Mode Tab
        ModCreativeModeTabs.register(modEventBus);
        // Mod Items
        ModItems.register(modEventBus);
        // Mod Block Items
        ModBlocks.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);


        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        // Adding the Mod Items to the "Ingredients" Creative Mode Tab (Commented out because... yeah... fuck you that's why)
//        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
//            event.accept(ModItems.SAPPHIRE);
//            event.accept(ModItems.RAW_SAPPHIRE);
//            event.accept(ModItems.MOONK);
//        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {

        }
    }
}
