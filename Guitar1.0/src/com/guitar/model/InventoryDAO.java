package com.guitar.model;

import java.util.List;

public interface InventoryDAO {
	void addInventory(Inventory inventory);
	Guitar getInventory(Inventory inventory);
	void updateInventory(Inventory inventory);
	void deleteInventory(Inventory inventory);
	List<Guitar> getInventorys(Guitar guitar);
}

