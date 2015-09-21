import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;


public class cardDispencer {
	String name;
	double amount;
	
	void readFromCard(BufferedReader br){
		try{
			name = br.readLine();
			amount = (Double.parseDouble(br.readLine())*100);
		}
		catch (IOException x){
			//card damaged
		}
	};
	
	void putOnCard(BufferedWriter bw, double moneyToReturn){
		
		try{
			bw.write(name+"\n");
			bw.write(moneyToReturn+"\n");
		}
		catch (IOException x){
			// card damaged
		}
		
	};
	
	double getAmount(){
		return amount;
	}
}
