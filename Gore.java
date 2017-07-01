package insurance;

public class Gore extends Company{

	public Gore(int birthYear, String postalCode, int yearsClaimsFree, House house){
		super(birthYear, postalCode, yearsClaimsFree, house);
		name = "Gore";
	}
/*
 * @explanation: sewerBackupScore() will determine the territory of the house based on its
 * getPosatlCode. If the water territory is desirable, it will boost the score
 * 
 * @example: say that this.postalCode() returns "V4N XXX" and "V4N" is a desirable territory,
 * then this.increaseScore(int x) will be invoked.
 * 
 * @template: below is an example template made of pseudo code:
 * public void sewerBackupScore(){
 *    if (this.postalCode() *** Code to determine if postal code is in most desired territory***){
 *       this.increaseScore(*** increase score by integer value, varies per company***)
 *    }
 *    else if (this.postalCode() *** Code to determine if postal code is in somewhat desired territory***){
 *       this.increaseScore(*** increase score by lesser integer value, varies per company***)
 *    }
 *    else if (this.postalCode() *** Code to determine if postal code is in least desired territory***){
 *       this.increaseScore(*** increase score by lesser integer value, varies per company***)
 *    }
 *    else{ //postalCode is not in desired territory
 *       this.decreaseScore(***decrease score by integer value, varies per company***)
 * }
 * 
 */
	public void sewerBackupScore() {
		// TO BE IMPLEMENTED
	}

	public void inTargetMarket() {
		if ((this.getHouse().getPrice())/(this.getHouse().getSquareFootage()) < 275){
			this.decreaseScore(15);
		}
		if (!this.getHouse().isUpdated()){
			this.decreaseScore(10);
		}
		else if (this.getHouse().getYearBuilt() < (2017-40)){
			this.decreaseScore(20);
		}
		
		int newHomeDiscount = this.getHouse().getYearBuilt();
		if (newHomeDiscount > (2007)){
			this.increaseScore(15);
			discountList.add("New Home Discount 15%");
		}
		else if (newHomeDiscount > 2002){
			newHomeDiscount = (newHomeDiscount - 2002)*3;
			this.increaseScore(newHomeDiscount);
			discountList.add("New Home Discount " + newHomeDiscount + "%");
		}
	}

	public void claimsFreeDiscount() {
		if (this.getYearsInsured() >= 5){
			this.increaseScore(14);
			discountList.add("Claims Free Discount 14%");
		}
		else if (this.getYearsInsured() >= 3){
			this.increaseScore(9);
			discountList.add("Claims Free Discount 9%");
		}
	}

	public void ageDiscount() {
		if (2017-this.getBirthYear() >= 50){
			this.increaseScore(19);
			discountList.add("Senior Discount 19%");
		}
	}
	
	public void alarmDiscount(){
		if (this.getHouse().getHasAlarm().equals("local")){
			this.increaseScore(3);
			discountList.add("Local Alarm Discount 3%");
		}
		else if (this.getHouse().getHasAlarm().equals("monitored")){
			this.increaseScore(8);
			discountList.add("Monitored Alarm Discount 8%");
		}
	}
}
