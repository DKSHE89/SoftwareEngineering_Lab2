import java.io.BufferedReader;
import java.io.BufferedWriter;

public class controller {
	coinDispencer coinD;
	cardDispencer cardD;
	drinks drinkSelect;
	int cash;
	int totalPrice;
	int change;
	double moneyToReturn;
	String message = " ";
	String changeMessage = " ";
	String displayChange = " ";
	String cardMessage = " "; 
	int [] tmpcoinsInMachine;
	
	controller(){
		coinD = new coinDispencer();
		cardD = new cardDispencer();
		drinkSelect = new drinks();
		tmpcoinsInMachine = new int[coinD.coinsValue.length];
	}
	
	int getNumberOfDrinks(String s){
		int i = drinkSelect.getDrinkIndex(s);
		return i;
	}
	
	
	
	void addCash(int cents){ // we call this function each time, when we click any coin/banknote button 
		cash += cents;
		coinD.addCoins(cents);
		if(cash>=totalPrice){
			if(calculateCoinsChange() == true){
				checkout();
			}
			else
				changeMessage = "suck my balls";
		}
		else changeMessage = "Add money: " + Double.toString((double)Math.abs(this.cash-this.totalPrice)/100) + " Ђ";
	}
	
	void checkout(){
		displayChange = Double.toString((double)Math.abs(this.cash-this.totalPrice)/100) + " Ђ";
		for(int i=0; i< coinD.coinsValue.length ; i++){
			coinD.coinsInMachine[i] -= tmpcoinsInMachine[i];
		}
		
		for(int i=0; i< drinkSelect.selectedQuantity.length ; i++){	
			drinkSelect.selectedQuantity[i] = 0;
		}
		cash = 0;
		totalPrice = 0;
		changeMessage = "do not suck my balls";
		
	}
	
	boolean calculateCoinsChange(){
		boolean haveChange = false;
		change = cash - totalPrice; //calculate the amount of change
		for(int i=0;i<coinD.coinsValue.length;i++){
			if(change / coinD.coinsValue[i] <= coinD.coinsInMachine[i])//check if we have enough coins in machine
				tmpcoinsInMachine[i] = (int) (change / coinD.coinsValue[i]); //assign to tmp the number of coins we use
				change = change % coinD.coinsValue[i]; //calculate the updated number of coins
		}
		if(change == 0) haveChange = true;
		return haveChange;
	}
	
	void removeDrink(String s){ //remove a drink
		int drink;
		drink = drinkSelect.getDrinkIndex(s);
		if(drinkSelect.selectedQuantity[drink]==0) {message="Drink is not selected"; return;} 
		
		message=drinkSelect.drinksExist[drink];	//display which drink has been selected
		drinkSelect.selectedQuantity[drink]--;	// increase quantity of drinks selected
		calculate();	// recalculate the price
		drinkSelect.quantityInStock[drink]++;	// temporarily reduce number of drinks in dispenser
	}
	
	void chooseDrink(String s){ // choose a drink
		int drink;
		
		drink = drinkSelect.getDrinkIndex(s);
		if(drinkSelect.quantityInStock[drink]==0) {message="NOT IN STOCK"; return;} 
		
		message=drinkSelect.drinksExist[drink];	//display which drink has been selected
		drinkSelect.selectedQuantity[drink]++;	// increase quantity of drinks selected
		calculate();	// recalculate the price
		drinkSelect.quantityInStock[drink]--;	// temporarily reduce number of drinks in dispencer
	}
	
	void calculate(){	// calculate total price
		totalPrice=0;
		for(int i=0; i<drinkSelect.selectedQuantity.length; i++){
			totalPrice += (int) (drinkSelect.selectedQuantity[i]*drinkSelect.priceExist[i]);
		}
	}
	
	int getTotal(){	// gets total
		return this.totalPrice;
	}	
	String getDifference(){	//method used to find out amount needed to be inserted
		return changeMessage;
	}
	
	String getChangeMessage(){ //displays the change
		return displayChange;
	}
	
	//paying by CARD (VISA ONLY)
	void discardFromCard(BufferedReader br){
		double cardCash;
		cardD.readFromCard(br);
		cardCash = cardD.getAmount();
		if(cardCash>=totalPrice){
			moneyToReturn = (double)((cardCash - totalPrice)/100);
			cardMessage = "your transaction was successful and do not suck my balls";
		}
		else{
			cardMessage = "not enough money and suck my balls";
			totalPrice = 0;
		}
	}
	
	void putOnCard(BufferedWriter bw){
		cardD.putOnCard(bw, moneyToReturn);
	}
	
	String getcardMessage(){//display if payment by card was successful
		return cardMessage;
	}
}
