package com.guitar.controller;

import java.util.Iterator;
import java.util.List;

import com.guitar.model.Guitar;
import com.guitar.model.InventoryDAOImpl;
import com.guitar.model.WebService;

public class Test {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Guitar guitar=new Guitar();
		guitar.setType("ÃñÒ¥¼ªËû");
		
		try {
			InventoryDAOImpl webService = null;
			List<Guitar> match=webService.getInventorys(guitar);
			
			for( int i = 0;i<match.size();i++) {
				Guitar bh = match.get(i);
			System.out.println(bh.getType());
			}
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
}
