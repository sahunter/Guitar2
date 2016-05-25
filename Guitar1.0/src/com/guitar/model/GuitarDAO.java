package com.guitar.model;

import java.util.List;

public interface GuitarDAO {
	void addGuitar(Guitar guitar);
	Guitar getGuitar(Guitar guitar);
	void updateGuitar(Guitar guitar);
	void deleteGuitar(Guitar guitar);
	List<Guitar> getGuitars(Guitar guitar);
	
	
	
}
