package com.epam.dev_ecommerce.objects;

public class SubCategory {
	
	int subCategoryId;
	int CategoryId;
	String subCategoryName;
	
	
	public int getSubCategoryId() {
		return subCategoryId;
	}
	public SubCategory setSubCategoryId(int subCategoryId) {
		this.subCategoryId = subCategoryId;
		return this;
	}
	public int getCategoryId() {
		return CategoryId;
	}
	public SubCategory setCategoryId(int categoryId) {
		CategoryId = categoryId;
		return this;
	}
	public String getSubCategoryName() {
		return subCategoryName;
	}
	public SubCategory setSubCategoryName(String subCategoryName) {
		this.subCategoryName = subCategoryName;
		return this;
	}
	
	@Override
	public String toString() {
		return " subCategoryId:"+subCategoryId+" subCategoryName:"+subCategoryName+" categoryId:"+CategoryId;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SubCategory subcategory=(SubCategory)o;
        
        return subCategoryId==subcategory.subCategoryId 
        		&& subCategoryName.equals(subcategory.subCategoryName)
        		&& CategoryId==subcategory.CategoryId;
	 }
	

}
