package com.mtihc.minecraft.treasurechest.v8.core;

import org.bukkit.Location;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;

/**
 * Interface representing a block with an inventory.
 * 
 * @author Mitch
 *
 */
public interface IBlockInventory extends ConfigurationSerializable {

	/**
	 * Returns the location
	 * @return the location
	 */
	public Location getLocation();
	
	/**
	 * Returns the inventory type
	 * @return the inventory type
	 */
	public InventoryType getType();
	
	/**
	 * Returns the inventory size
	 * @return the inventory size
	 */
	public int getSize();
	
	/**
	 * Gets the inventory contents
	 * @return the inventory contents
	 */
	public ItemStack[] getContents();
	
	/**
	 * Sets the inventory contents
	 * @param contents the inventory contents
	 */
	public void setContents(ItemStack[] contents);
	
}
