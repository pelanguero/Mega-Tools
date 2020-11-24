package net.megatools;

import net.fabricmc.api.ModInitializer;
import net.megatools.items.*;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.ToolMaterials;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class MegaTools implements ModInitializer {
    public static final VoidHammer voidHammer=new VoidHammer(ToolMaterials.NETHERITE,1,0.5f,new Item.Settings().group(ItemGroup.TOOLS).fireproof(),3);
    public static final ExcavatorItem excavatorIron=new ExcavatorItem(ToolMaterials.IRON,0.5f,0.5f,new Item.Settings().group(ItemGroup.TOOLS),3);
    public static final ExcavatorItem excavatorIronGilded=new ExcavatorItem(ToolMaterials.IRON,0.5f,0.5f,new Item.Settings().group(ItemGroup.TOOLS),5);
    public static final ExcavatorItem excavatorDiamond=new ExcavatorItem(ToolMaterials.DIAMOND,0.5f,0.5f,new Item.Settings().group(ItemGroup.TOOLS),3);
    public static final ExcavatorItem excavatorDiamondGilded=new ExcavatorItem(ToolMaterials.DIAMOND,0.5f,0.5f,new Item.Settings().group(ItemGroup.TOOLS),5);
    public static final ExcavatorItem excavatorDiamondCorrupted=new ExcavatorItem(ToolMaterials.DIAMOND,0.5f,0.5f,new Item.Settings().group(ItemGroup.TOOLS).fireproof(),7);
    public static final ExcavatorItem excavatorNetherite=new ExcavatorItem(ToolMaterials.NETHERITE,0.5f,0.5f,new Item.Settings().group(ItemGroup.TOOLS).fireproof(),3);
    public static final ExcavatorItem excavatorNetheriteGilded=new ExcavatorItem(ToolMaterials.NETHERITE,0.5f,0.5f,new Item.Settings().group(ItemGroup.TOOLS).fireproof(),5);
    public static final ExcavatorItem excavatorNetheriteDiamond=new ExcavatorItem(ToolMaterials.NETHERITE,0.5f,0.5f,new Item.Settings().group(ItemGroup.TOOLS).fireproof(),7);

    public static final Paxel paxeel=new Paxel(ToolMaterials.NETHERITE,1,0.5f,new Item.Settings().group(ItemGroup.TOOLS).fireproof(),5);

    public static final HammerItem hammerGold=new HammerItem(ToolMaterials.DIAMOND,1,0.5f,new Item.Settings().group(ItemGroup.TOOLS),3);
    public static final HammerItem hammerIron=new HammerItem(ToolMaterials.DIAMOND,1,0.5f,new Item.Settings().group(ItemGroup.TOOLS),3);
    public static final HammerItem hammerIronGilded=new HammerItem(ToolMaterials.DIAMOND,1,0.5f,new Item.Settings().group(ItemGroup.TOOLS),5);
    public static final HammerItem hammerDiamond=new HammerItem(ToolMaterials.DIAMOND,1,0.5f,new Item.Settings().group(ItemGroup.TOOLS),3);
    public static final HammerItem hammerDiamondGilded=new HammerItem(ToolMaterials.DIAMOND,1,0.5f,new Item.Settings().group(ItemGroup.TOOLS),5);
    public static final HammerItem hammerDiamondCorrupted=new HammerItem(ToolMaterials.DIAMOND,1,0.5f,new Item.Settings().group(ItemGroup.TOOLS).fireproof(),7);
    public static final HammerItem hammerNetherite=new HammerItem(ToolMaterials.DIAMOND,1,0.5f,new Item.Settings().group(ItemGroup.TOOLS).fireproof(),3);
    public static final HammerItem hammerNetheriteGilded=new HammerItem(ToolMaterials.NETHERITE,1,0.5f,new Item.Settings().group(ItemGroup.TOOLS).fireproof(),5);
    public static final HammerItem hammerNetheriteDiamond=new HammerItem(ToolMaterials.NETHERITE,1,0.5f,new Item.Settings().group(ItemGroup.TOOLS).fireproof(),7);

    public static final GreataxeItem greatAxeIron=new GreataxeItem(ToolMaterials.IRON,14f,0.5f,new Item.Settings().group(ItemGroup.TOOLS),3);
    public static final GreataxeItem greatAxeDiamond=new GreataxeItem(ToolMaterials.DIAMOND,16f,0.5f,new Item.Settings().group(ItemGroup.TOOLS),3);
    public static final GreataxeItem greatAxeNetherite=new GreataxeItem(ToolMaterials.NETHERITE,30f,0.5f,new Item.Settings().group(ItemGroup.TOOLS).fireproof(),3);
    public void onInitialize()
    {
        Registry.register(Registry.ITEM,new Identifier("megatools","void_hammer"),voidHammer);
        Registry.register(Registry.ITEM,new Identifier("megatools","excavator_iron"),excavatorIron);
        Registry.register(Registry.ITEM,new Identifier("megatools","excavator_iron_gilded"),excavatorIronGilded);
        Registry.register(Registry.ITEM,new Identifier("megatools","excavator_diamond"),excavatorDiamond);
        Registry.register(Registry.ITEM,new Identifier("megatools","excavator_diamond_gilded"),excavatorDiamondGilded);
        Registry.register(Registry.ITEM,new Identifier("megatools","excavator_diamond_corrupted"),excavatorDiamondCorrupted);
        Registry.register(Registry.ITEM,new Identifier("megatools","excavator_netherite"),excavatorNetherite);
        Registry.register(Registry.ITEM,new Identifier("megatools","excavator_netherite_gilded"),excavatorNetheriteGilded);
        Registry.register(Registry.ITEM,new Identifier("megatools","excavator_netherite_diamond"),excavatorNetheriteDiamond);
        Registry.register(Registry.ITEM,new Identifier("megatools","hammer_gold"),hammerGold);
        Registry.register(Registry.ITEM,new Identifier("megatools","hammer_iron"),hammerIron);
        Registry.register(Registry.ITEM,new Identifier("megatools","hammer_iron_gilded"),hammerIronGilded);
        Registry.register(Registry.ITEM,new Identifier("megatools","hammer_diamond"),hammerDiamond);
        Registry.register(Registry.ITEM,new Identifier("megatools","hammer_diamond_gilded"),hammerDiamondGilded);
        Registry.register(Registry.ITEM,new Identifier("megatools","hammer_diamond_corrupted"),hammerDiamondCorrupted);
        Registry.register(Registry.ITEM,new Identifier("megatools","hammer_netherite"),hammerNetherite);
        Registry.register(Registry.ITEM,new Identifier("megatools","hammer_netherite_gilded"),hammerNetheriteGilded);
        Registry.register(Registry.ITEM,new Identifier("megatools","hammer_netherite_diamond"),hammerNetheriteDiamond);
        Registry.register(Registry.ITEM,new Identifier("megatools","great_axe_iron"),greatAxeIron);
        Registry.register(Registry.ITEM,new Identifier("megatools","great_axe_diamond"),greatAxeDiamond);
        Registry.register(Registry.ITEM,new Identifier("megatools","great_axe_netherite"),greatAxeNetherite);

        Registry.register(Registry.ITEM,new Identifier("megatools","great_paxel"),paxeel);

    }
}
