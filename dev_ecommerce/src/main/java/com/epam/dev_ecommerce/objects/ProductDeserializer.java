package com.epam.dev_ecommerce.objects;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

@SuppressWarnings("serial")
public class ProductDeserializer extends StdDeserializer<ProductDetails>{
	
	    public ProductDeserializer() { 
	        this(null); 
	    } 
	 
	    public ProductDeserializer(Class<?> vc) { 
	        super(vc); 
	    }
	 
	    @Override
	    public ProductDetails deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
	        JsonNode node = jp.getCodec().readTree(jp);
	        int cartQuantity= (Integer) (node.get("cartQuantity")).numberValue();
	        int productid=(node.path("productId")).asInt();
	        String productName=(node.path("productName")).asText();
	        double productPrice=(node.path("productPrice")).asDouble();
	        int subCategoryId=(node.path("subCategoryId")).asInt();
	        return new ProductDetails().setProductQuantity(cartQuantity)
	        							.setProductId(productid)
	        							.setProductName(productName)
	        							.setProductPrice(productPrice)
	        							.setSubCategoryId(subCategoryId);
	    }

}
