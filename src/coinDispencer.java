public class coinDispencer {
	
	int [] coinsInMachine = {20, 20, 20, 20,
							 20, 20, 20, 20};
	int [] coinsValue = {10, 20, 50, 100,
						 200, 500, 1000, 2000};
	
	int getCoinIndex(int coin){			// method used to detect which coin was inserted
		for(int i=0; i<coinsValue.length; i++){
			if(coin==coinsValue[i]) return i;
		}
		return 42;
	}
	
	coinDispencer(){
		// constructor
	}
	
	boolean getCoinQuantity(int coin){
		if (coinsInMachine[getCoinIndex(coin)]==0) return false;
		return true;
	}
	
	void reduceCoins(int coin){
		if(getCoinQuantity(coin))
		coinsInMachine[getCoinIndex(coin)]--;
		 
	};
	
	void addCoins(int coin){
		coinsInMachine[getCoinIndex(coin)]++;	// uses getCoinIndex
	};
}
