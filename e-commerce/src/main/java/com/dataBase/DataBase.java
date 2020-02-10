package com.dataBase;

import java.util.Arrays;
import java.util.LinkedHashSet;

import com.main.Category;
import com.main.Product;


public class DataBase {
	
		public Category epam=new Category("Epam");
		
			Category electronics=new Category("Electronics");
				public Category mobiles=new Category("Mobiles");
				Category computers=new Category("Computers");
				Category homeAppliances=new Category("Home Appliances");
			
			Category fashion=new Category("Fashion");
				Category mens=new Category("Mens");
				Category womens=new Category("Womens");
				Category kids=new Category("Kids");
				
			Category dailyEssentials=new Category("Daily Essentials");
				Category healthProducts=new Category("Health Products");
				Category beautyProducts=new Category("Beauty Products");
				Category householdProducts=new Category("Household Products");
				
			    Product onePlus=new Product("ONEPlus",30,2);
				Product realMe=new Product("RealMe",20,3);
				Product xiaomi=new Product("Xiaomi",40,1);
				
				Product dell=new Product("Dell",100,2);
				Product lenovo=new Product("Lenovo",200,1);
				Product acer=new Product("Acer",300,3);
				
				Product airConditioner=new Product("Air Conditioner",200,8);
				Product teleVision=new Product("TeleVision",400,2);
				Product washingMachine=new Product("Washing Machine",100,3);
				
				Product mensPant=new Product("Mens pant",300,1);
				Product mensShirt=new Product("Mens Shirt",500,3);
				Product mensShoes=new Product("Mens Shoes",100,3);
				
				Product womensPant=new Product("Womens pant",2,10);
				Product womensShirt=new Product("Womens Shirt",1,12);
				Product womensShoes=new Product("Womens Shoes",5,7);
				
				Product hat=new Product("hat",12,8);
				Product kidClothesSet=new Product("kid clothes set",50,2);
				Product lightShoes=new Product("light shoes",11,4);
				
				Product lotion=new Product("Lotion",3,3);
				Product sunScreen=new Product("SunScreen",2,3);
				Product faceWash=new Product("FaceWash",4,2);
				
				Product makeupSet=new Product("MakeupSet",1,4);
				Product powder=new Product("Powder",5,10);
				Product fairAndLovely=new Product("Fair&Lovely",3,5);
				
				Product soap=new Product("Soap",11,5);
				Product toothpaste=new Product("Toothpaste",5,10);
				Product utensil=new Product("Utensil",3,5);
				
				
				
				
				public void intializeCategories() {
					
					epam.addSubCategories(new LinkedHashSet<Category>(Arrays.asList(electronics,fashion,dailyEssentials)));
					electronics.addSubCategories(new LinkedHashSet<Category>(Arrays.asList(mobiles,computers,homeAppliances)));
					fashion.addSubCategories(new LinkedHashSet<Category>(Arrays.asList(mens,womens,kids)));
					dailyEssentials.addSubCategories(new LinkedHashSet<Category>(Arrays.asList(healthProducts,beautyProducts,householdProducts)));

				}
	
				
				
	
				public void intializeProducts() {
					
					mobiles.addProducts(new LinkedHashSet<Product>(Arrays.asList(onePlus,realMe,xiaomi)));
					computers.addProducts(new LinkedHashSet<Product>(Arrays.asList(dell,lenovo,acer)));
					homeAppliances.addProducts(new LinkedHashSet<Product>(Arrays.asList(airConditioner,teleVision,washingMachine)));
					
					mens.addProducts(new LinkedHashSet<Product>(Arrays.asList(mensPant,mensShirt,mensShoes)));
					womens.addProducts(new LinkedHashSet<Product>(Arrays.asList(womensPant,womensShirt,womensShoes)));
					kids.addProducts(new LinkedHashSet<Product>(Arrays.asList(hat,kidClothesSet,lightShoes)));
					
					healthProducts.addProducts(new LinkedHashSet<Product>(Arrays.asList(lotion,sunScreen,faceWash)));
					beautyProducts.addProducts(new LinkedHashSet<Product>(Arrays.asList(makeupSet,powder,fairAndLovely)));
					householdProducts.addProducts(new LinkedHashSet<Product>(Arrays.asList(soap,toothpaste,utensil)));
		

				}
				

}
