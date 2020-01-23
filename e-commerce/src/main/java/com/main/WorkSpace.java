/**
 * 
 */
package com.main;

/**
 * @author Charan_Donthi
 *
 */
public class WorkSpace {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DataBase db=new DataBase();
		db.intializeCategories();
		db.intializeProducts();
		
		Cart cart=new Cart();
		cart.addProduct(db.acer);
		cart.addProduct(db.fairAndLovely);
		cart.addProduct(db.hat);
		
		cart.showCart();
		cart.showCart();
		
		
	}

}
