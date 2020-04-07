package com.epam.dev_ecommerce.objects;
public class ProductDetails {
	protected int productId;
	protected int subCategoryId;
    protected String productName;
    protected double productPrice;
    protected int productQuantity;
    
    
	public int getProductId() {
		return productId;
	}
	public int getSubCategoryId() {
		return subCategoryId;
	}
	public String getProductName() {
		return productName;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public int getProductQuantity() {
		return productQuantity;
	}
	
	public ProductDetails setProductId(int productId) {
		this.productId = productId;
		return this;
	}
	public ProductDetails setSubCategoryId(int subCategoryId) {
		this.subCategoryId = subCategoryId;
		return this;
	}
	public ProductDetails setProductName(String productName) {
		this.productName = productName;
		return this;
	}
	public ProductDetails setProductPrice(double d) {
		this.productPrice = d;
		return this;
	}
	public ProductDetails setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
		return this;
	}
	
	@Override
	public String toString() {
		return "[\n"
				+"productId: "+productId+"\n"
				+"subCategoryId: "+subCategoryId+"\n"
				+"productName: "+productName+"\n"
				+"productPrice: "+productPrice+"\n"
				+"productQuantity: "+productQuantity+"\n"
				+"]\n";
				
	}
	
	public boolean equalsByCart(ProductDetails cartProduct) {
		return this.productId==cartProduct.productId
        		&& this.productName.equals(cartProduct.productName)
        		&& this.productPrice==cartProduct.productPrice
        		&& this.productQuantity==cartProduct.productQuantity;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
        	System.out.println("i am here");
            return false;
        }
        ProductDetails details=(ProductDetails)o;
        
        return this.productId==details.productId
        		&& this.productName.equals(details.productName)
        		&& this.productPrice==details.productPrice
        		&& this.productQuantity==details.productQuantity
        		&& this.subCategoryId==details.subCategoryId;
	 }
	
	
}
