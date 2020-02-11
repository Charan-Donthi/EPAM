package com.options;




import com.inputoutput.IO;
import com.main.Cart;
import com.main.EpamTree;
import com.main.Product;



public class RemoveProductFromCart extends RemoveProduct{

	public RemoveProductFromCart(String newOptionName) {
		super(newOptionName);
	}

	
	@Override
	public void function() {
		
		Cart yourCart=EpamTree.getYourCart();
		logger.info("Select Product to remove::::");
		int index=IO.readIntInput();
		
		try {
			
			Product product=(Product)yourCart.getProductsInCart().toArray()[index-1];
		
			if(removeProduct(yourCart,product)) {
				logger.info("Product removed successfully");
			}else {
				logger.warn("Product not in Cart");
			}
		}catch(IndexOutOfBoundsException e) {
			logger.error("Select from the given numbers");
		}
		
	}
	
	private boolean removeProduct(Cart yourCart,Product product) {
		return yourCart.getProductsInCart().remove(product);
	}
}
