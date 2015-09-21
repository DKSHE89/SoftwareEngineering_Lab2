public class drinks {
	String[] drinksExist = {"Coke","Sprite","Beer","LightBeer",
			"FunBeer","MineralWater","AppleJuice",
			"OrangeJuice","TomatoJuice","Wine"};

	double[] priceExist = {110, 110, 230, 240, // prices of drinks that exist
						   210, 100, 180, 190,
						   190, 280};

	int[] quantityInStock = {20, 20, 20, 20,	//amount of drinks in stock
			 				 20, 20, 20, 20,
			 				 20, 20};

	//int[] tmpQuantityInStock; // temporary quantity of drinks, while buying
	int [] selectedQuantity;		 //  drinks that user has selected
	
	drinks(){
		//tmpQuantityInStock = new int[priceExist.length]; // creating an array to keep track of selected drinks
		//tmpQuantityInStock = quantityInStock;
		selectedQuantity = new int[quantityInStock.length];
	}
	
	int getDrinkIndex(String s){		// get an index of a drink in an array
		for(int i=0; i<drinksExist.length; i++){
			if(s == drinksExist[i]){
				return i;
			}	
		}
		return 0;
	}
}
