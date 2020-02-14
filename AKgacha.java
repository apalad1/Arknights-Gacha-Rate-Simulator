import java.util.*;

public class AKgacha {

	static int rollcounter = 1;
	
	public static void main(String[] args) {
		
		//initial prompt
		Scanner userinput = new Scanner(System.in);
		System.out.println("Do you want to roll? press y to roll anything else will not");
		String yousaid = userinput.nextLine();
		
		
		while(yousaid.equals("y")) {
			System.out.println("roll# " + rollcounter);
			
			
			int x = roll();
			System.out.println("probability % hit is " + x);
			
			rarity(x, rollcounter);
			
			//asks if you wanna roll again or not, changes 'yousaid' if you dont want to keep going*****
			System.out.println("stop? press n");
			String response = userinput.nextLine();
			if(response.equals("n")) {
				yousaid = "n";
			}
			
			rollcounter++;
		}
		
		
	}
	
	public static int roll(){
        Random rand = new Random();
        int r = rand.nextInt(100)+1;
        return r;
    }
	
	public static int rarity(int x, int roll_counter) {
		
		//*****PITY COUNTER INCREASE if rollcounter is 51 or higher*********************************
		if(rollcounter>=3) {
			int pitycounter = rollcounter - 2;
			x = x - (pitycounter*2);
			System.out.println("6* rate up increase!!! " + (2+(pitycounter*2)) + "%");
		}else {
			int pitycounter = 0;
			x = x - pitycounter;
		}
		
		//*****DETERMINE THE RARITY, if its '6star' set the rollcounter to 0*************************
		if(x<10) {
			System.out.println("GOLD");
			if(x<3) {
				System.out.println("6stars!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
				rollcounter = 0;
				return rollcounter;
			} else
				System.out.println("5stars");
		} else {
			System.out.println("meh");
			if(x<60) {
				System.out.println("4stars");
			} else {
				System.out.println("3stars");
			}
		}
		
		
		//at this point rollcounter is still 0 if it did hit 6*
		return 0;
	}
}
