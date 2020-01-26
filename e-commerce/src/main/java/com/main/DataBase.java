package com.main;


public class DataBase {
	
		Category epam=new Category("Epam");
		
			Category electronics=new Category("Electronics");
				Category mobiles=new Category("Mobiles");
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
				
				Product onePlus=new Product("ONEPlus");
				Product realMe=new Product("RealMe");
				Product xiaomi=new Product("Xiaomi");
				
				Product dell=new Product("Dell");
				Product lenovo=new Product("Lenovo");
				Product acer=new Product("Acer");
				
				Product airConditioner=new Product("Air Conditioner");
				Product teleVision=new Product("TeleVision");
				Product washingMachine=new Product("Washing Machine");
				
				Product mensPant=new Product("Mens pant");
				Product mensShirt=new Product("Mens Shirt");
				Product mensShoes=new Product("Mens Shoes");
				
				Product womensPant=new Product("Womens pant");
				Product womensShirt=new Product("Womens Shirt");
				Product womensShoes=new Product("Womens Shoes");
				
				Product hat=new Product("hat");
				Product kidClothesSet=new Product("kid clothes set");
				Product lightShoes=new Product("light shoes");
				
				Product lotion=new Product("Lotion");
				Product sunScreen=new Product("SunScreen");
				Product faceWash=new Product("FaceWash");
				
				Product makeupSet=new Product("MakeupSet");
				Product powder=new Product("Powder");
				Product fairAndLovely=new Product("Fair&Lovely");
				
				Product soap=new Product("Soap");
				Product toothpaste=new Product("Toothpaste");
				Product utensil=new Product("Utensil");
				
				public void intializeCategories() {
		
		
						epam.subCategories.add(electronics);
						epam.subCategories.add(fashion);
						epam.subCategories.add(dailyEssentials);
		
						electronics.subCategories.add(mobiles);
						electronics.subCategories.add(computers);
						electronics.subCategories.add(homeAppliances);
		
						fashion.subCategories.add(mens);
						fashion.subCategories.add(womens);
						fashion.subCategories.add(kids);
		
						dailyEssentials.subCategories.add(healthProducts);
						dailyEssentials.subCategories.add(beautyProducts);
						dailyEssentials.subCategories.add(householdProducts);
		

				}
	
	
				public void intializeProducts() {
					
					mobiles.productsInCategory.add(onePlus);
					mobiles.productsInCategory.add(realMe);
					mobiles.productsInCategory.add(xiaomi);
					
					computers.productsInCategory.add(dell);
					computers.productsInCategory.add(lenovo);
					computers.productsInCategory.add(acer);
					
					homeAppliances.productsInCategory.add(airConditioner);
					homeAppliances.productsInCategory.add(teleVision);
					homeAppliances.productsInCategory.add(washingMachine);
					
					mens.productsInCategory.add(mensPant);
					mens.productsInCategory.add(mensShirt);
					mens.productsInCategory.add(mensShoes);
					
					womens.productsInCategory.add(womensPant);
					womens.productsInCategory.add(womensShirt);
					womens.productsInCategory.add(womensShoes);
					
					kids.productsInCategory.add(hat);
					kids.productsInCategory.add(kidClothesSet);
					kids.productsInCategory.add(lightShoes);
					
					healthProducts.productsInCategory.add(lotion);
					healthProducts.productsInCategory.add(sunScreen);
					healthProducts.productsInCategory.add(faceWash);
					
					beautyProducts.productsInCategory.add(makeupSet);
					beautyProducts.productsInCategory.add(powder);
					beautyProducts.productsInCategory.add(fairAndLovely);
					
					householdProducts.productsInCategory.add(soap);
					householdProducts.productsInCategory.add(toothpaste);
					householdProducts.productsInCategory.add(utensil);
		

				}
				

}
