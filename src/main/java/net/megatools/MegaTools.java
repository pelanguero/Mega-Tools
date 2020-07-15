package net.megatools;

import net.fabricmc.api.ModInitializer;
import net.megatools.items.ExcavatorItem;
import net.megatools.items.GreataxeItem;
import net.megatools.items.HammerItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.ToolMaterials;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class MegaTools implements ModInitializer {
    public static final ExcavatorItem excavatorD=new ExcavatorItem(ToolMaterials.WOOD,0.5f,0.5f,new Item.Settings().group(ItemGroup.TOOLS),7);
    public static final HammerItem hammerD=new HammerItem(ToolMaterials.DIAMOND,1,0.5f,new Item.Settings().group(ItemGroup.TOOLS),3);
    public static final GreataxeItem greatAxe=new GreataxeItem(ToolMaterials.DIAMOND,0.5f,0.5f,new Item.Settings().group(ItemGroup.TOOLS),7);
    public void onInitialize()
    {
        Registry.register(Registry.ITEM,new Identifier("megatools","wooden_excavator"),excavatorD);
        Registry.register(Registry.ITEM,new Identifier("megatools","diamond_hammer"),hammerD);
        Registry.register(Registry.ITEM,new Identifier("megatools","diamond_greataxe"),greatAxe);
    }
}
