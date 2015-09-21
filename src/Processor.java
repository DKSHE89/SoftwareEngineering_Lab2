public class Processor {
        String[] drinksExist = {"Coke","Sprite","Beer","LightBeer",
                                                        "FunBeer","MineralWater","AppleJuice",
                                                        "OrangeJuice","TomatoJuice","Wine", "ERROR"};
       
        double[] priceExist = {1.1, 1.1, 2.3, 2.4,
                                                        2.1, 1, 1.8,
                                                        1.9, 1.9, 2.8};
       
        int[] quantityInStock = {5, 5, 5, 5,
                                                        5, 5, 5,
                                                        5, 5, 5};
       
        int[] tmpQuantityInStock;
        int [] quantity;
        double cash;
        double totalPrice;
        String message=" ";
       
    // NEW*******************************    
       String printCash(){
    	   String str=null;
    	   return str;
       }
       double giveChange(){
       		double change=(cash-totalPrice)/100;
       		return change;
       	}
//NEW********************************************      
       int getNumberofDrinks(String s){
           int i = getIndex(s);
           return i;
       }
        void coinDispencer(){
                quantity = new int[10];
                totalPrice = 0;
                tmpQuantityInStock = quantityInStock;
        }
       
        int getIndex(String s){
                for(int i=0; i<drinksExist.length; i++){
                        if(s == drinksExist[i]){
                                return i;
                        }
                        else return 11;
                }
                return 0;
        }
       
        void addCash(int cents){ // we call this function each time, when we click any coin/banknote button
                cash += cents / 100;
        }
       
        void chooseDrink(String s){ // choose drink
                int drink;
                drink = getIndex(s);
               
                if(tmpQuantityInStock[drink]==0) {message="NOT IN STOCK"; return;}
                quantity[drink]++;
                calculate();
                tmpQuantityInStock[drink]--;
        }
       
        void calculate(){       // calculate total
                for(int i=0; i<quantity.length; i++){
                        totalPrice += quantity[i]+priceExist[i];
                }
        }
       
        double getTotal(){      // gets total
                return this.totalPrice;
        }
}