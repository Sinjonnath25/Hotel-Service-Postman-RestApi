package com.cognizant.HotelService.bean;
import java.util.ArrayList;

public class Cart {
	
	private ArrayList<MenuItem> menuItemList;
	private double total;
	
	public Cart(ArrayList<MenuItem> menuItemList) {
		this.menuItemList = menuItemList;
	}
	public Cart(ArrayList<MenuItem> menuItemList, double total) {
		this.menuItemList = menuItemList;
		this.total = total;
	}
	
	public ArrayList<MenuItem> getMenuItemList() {
		return menuItemList;
	}
	public void setMenuItemList(ArrayList<MenuItem> menuItemList) {
		this.menuItemList = menuItemList;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Cart [menuItemList=" + menuItemList + ", total=" + total + "]";
	}
	
	

}