package com.epam.dev_ecommerce.dataproviders;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class Data {
	
	@DataProvider
	public static Object[][] categoryListToCheck(){
		return new Object[][] {
			{"Electronics"},
			{"Fashion"},
			{"Books and Audible"},
			{"Home Appliances"}
		};
		
	}
	
	public static class data{
		public int categoryId;
		public String subcategoryName;
		
		public data setCategoryId(int categoryId) {
			this.categoryId = categoryId;
			return this;
		}

		public data setSubcategoryName(String subategoryName) {
			this.subcategoryName = subategoryName;
			return this;
		}
	}
	
	@DataProvider
	public static Object[][] subcategoryListToCheck(){
		
		return new Object[][] {
			{new data().setCategoryId(1).setSubcategoryName("TV")},
			{new data().setCategoryId(1).setSubcategoryName("Washing Machine")},
			{new data().setCategoryId(1).setSubcategoryName("Men's Wear")},
			{new data().setCategoryId(1).setSubcategoryName("")},
			{new data().setCategoryId(2).setSubcategoryName("TV")},
			{new data().setCategoryId(2).setSubcategoryName("Washing Machine")},
			{new data().setCategoryId(2).setSubcategoryName("Men's Wear")},
			{new data().setCategoryId(2).setSubcategoryName("")},
			{new data().setCategoryId(3).setSubcategoryName("TV")},
			{new data().setCategoryId(3).setSubcategoryName("Washing Machine")},
			{new data().setCategoryId(3).setSubcategoryName("Men's Wear")},
			{new data().setCategoryId(3).setSubcategoryName("")},
			{new data().setCategoryId(4).setSubcategoryName("TV")},
			{new data().setCategoryId(4).setSubcategoryName("Washing Machine")},
			{new data().setCategoryId(4).setSubcategoryName("Men's Wear")},
			{new data().setCategoryId(4).setSubcategoryName("")},
		
		};
		
	}
	
	@DataProvider
	public static Object[][] productsToCheck(){
		return new Object[][] {
			{1},
			{2},
			{3},
			{4}
		};
		
	}
	
	@DataProvider
	public static Object[][] productsListToCheck(){
		return new Object[][] {
			{1,"Onida"},
			{2,"LG"},
			{3,"Shirt"},
			{4,"Tops"},
			{5,"Sofa"},
			{6,"Table"},
			{7,"Matress"},
		};
		
	}
	
	@SuppressWarnings("serial")
	public static class ProductSerializer extends StdSerializer<ProductDetails> {

	    public ProductSerializer(Class<ProductDetails> t) {
	        super(t);
	    }

		@Override
		public void serialize(ProductDetails value, JsonGenerator gen, SerializerProvider provider) throws IOException {
			gen.writeStartObject();
	        gen.writeEndObject();
			
		}
	}
	
	
	public static class ProductDetails{
	    private int productId;
	    private int subCategoryId;
	    private String productName;
	    public int getProductId() {
			return productId;
		}
		public int getSubCategoryId() {
			return subCategoryId;
		}
		public String getProductName() {
			return productName;
		}
		public float getProductPrice() {
			return productPrice;
		}
		public int getProductQuantity() {
			return productQuantity;
		}
		private float productPrice;
	    private int productQuantity;
	    
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
		public ProductDetails setProductPrice(float productPrice) {
			this.productPrice = productPrice;
			return this;
		}
		public ProductDetails setProductQuantity(int productQuantity) {
			this.productQuantity = productQuantity;
			return this;
		}
	}
	
	@DataProvider
	public Object[][] dataToAddProductThroughPost(){
		return new Object[][] {
			{new ProductDetails().setProductName("asdjna").setSubCategoryId(2).setProductId(1)},
			{new ProductDetails().setProductName("HHH").setSubCategoryId(2)},
			{new ProductDetails().setProductName("YYYY").setSubCategoryId(3)},
			{new ProductDetails().setProductName("NNNNNNNNNN").setSubCategoryId(4)}
		};
	}

	

}
