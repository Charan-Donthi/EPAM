package com.epam.dev_ecommerce.objects;

public class Category {
	int categoryId;
	String categoryName;
	
	public int getCategoryId() {
		return categoryId;
	}

	public Category setCategoryId(int categoryId) {
		this.categoryId = categoryId;
		return this;
	}

	public Category setCategoryName(String categoryName) {
		this.categoryName = categoryName;
		return this;
	}

	public String getCategoryName() {
		return categoryName;
	}
	
	@Override
	public String toString() {
		return "categoryId:"+categoryId+"  categoryName:"+categoryName;
	}
	
	 @Override
     public boolean equals(Object o) {
         if (this == o) {
             return true;
         }
         if (o == null || getClass() != o.getClass()) {
             return false;
         }
         Category category=(Category)o;
         
         return categoryId==category.categoryId &&
        		 categoryName.equals(category.categoryName);
	 }
	

}
