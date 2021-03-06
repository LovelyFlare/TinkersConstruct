package slimeknights.tconstruct.tools.item;

import com.google.common.collect.ImmutableSet;

import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

import java.util.List;

import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.tinkering.Category;
import slimeknights.tconstruct.library.tinkering.PartMaterialType;
import slimeknights.tconstruct.library.tools.AoeToolCore;
import slimeknights.tconstruct.tools.TinkerTools;

public class Pickaxe extends AoeToolCore {

  public static final ImmutableSet<net.minecraft.block.material.Material> effective_materials =
      ImmutableSet.of(net.minecraft.block.material.Material.IRON,
                      net.minecraft.block.material.Material.ANVIL,
                      net.minecraft.block.material.Material.ROCK,
                      net.minecraft.block.material.Material.ICE,
                      net.minecraft.block.material.Material.GLASS,
                      net.minecraft.block.material.Material.PACKED_ICE,
                      net.minecraft.block.material.Material.PISTON);

  // Pick-head, binding, tool-rod
  public Pickaxe() {
    this(PartMaterialType.handle(TinkerTools.toolRod),
         PartMaterialType.head(TinkerTools.pickHead),
         PartMaterialType.extra(TinkerTools.binding));
  }

  public Pickaxe(PartMaterialType... requiredComponents) {
    super(requiredComponents);

    addCategory(Category.HARVEST);

    // set the toolclass, actual harvestlevel is done by the overridden callback
    this.setHarvestLevel("pickaxe", 0);
  }

  @Override
  public void getSubItems(Item itemIn, CreativeTabs tab, List<ItemStack> subItems) {
    addDefaultSubItems(subItems);
    addInfiTool(subItems, "InfiHarvester");
  }

  @Override
  public boolean isEffective(IBlockState block) {
    return effective_materials.contains(block.getMaterial()) || ItemPickaxe.EFFECTIVE_ON.contains(block);
  }

  @Override
  public float damagePotential() {
    return 1f;
  }

  @Override
  public double attackSpeed() {
    return 1.2f;
  }

  @Override
  public NBTTagCompound buildTag(List<Material> materials) {
    return buildDefaultTag(materials).get();
  }
}
