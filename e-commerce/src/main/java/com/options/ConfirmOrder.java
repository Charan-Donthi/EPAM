package com.options;


import com.main.Cart;
import com.main.EpamTree;
import com.main.Product;



public class ConfirmOrder extends Option{

	
	public ConfirmOrder(String newOptionName){
		setOptionName(newOptionName);
	}
	
	@Override
	public void function() {
		
		Cart yourCart=EpamTree.getYourCart();
		
		Option showcart=new ShowCart("show cart");
		showcart.function();
		
		if(!yourCart.getProductsInCart().isEmpty()) {
			deductQuantityFromDataBase(yourCart);
			logger.info("---------------Your Order-----------------");
			logger.info("---Is on its way make sure to collect-----");
			System.exit(0);
		}
		
	}
	
	
	private void deductQuantityFromDataBase(Cart yourCart) {
		for(Product cartProduct:yourCart.getProductsInCart()) {
			Product originalProduct=EpamTree.getAllProducts().get(cartProduct.getProductName());
			originalProduct.setQuantity(originalProduct.getQuantity() - cartProduct.getQuantity());
		}
	}
}
