package com.options;




import com.main.Cart;
import com.main.EpamTree;
import com.main.Product;


public class ShowCart extends Option{
	
	public ShowCart(String newOptionName){
		setOptionName(newOptionName);
	}
	
	@Override
	public void function() {
		
		Cart yourCart=EpamTree.getYourCart();
		EpamTree.getBranch().add(yourCart);
		EpamTree.displayCurrentBranch("Cart");
		
		String line="------------";
		
		
		if(yourCart.getProductsInCart().isEmpty()) {
			logger.info("Your cart is empty");
			CheckOut.getInstance().function();
		}else {
			int count=0;
			yourCart.setTotalPrice(0);
			for(Product product:yourCart.getProductsInCart()) {
				logger.info("{}{}{}{}{}{}{}",++count,line,product.getProductName(),line,product.getQuantity(),line,product.getPrice()*product.getQuantity());
				yourCart.setTotalPrice(yourCart.getTotalPrice() + product.getPrice()*product.getQuantity());
			}
			logger.info("Total Price="+yourCart.getTotalPrice());
		
		}
		EpamTree.displayCurrentBranch("Cart");
	}
	
}
