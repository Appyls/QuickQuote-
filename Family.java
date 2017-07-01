package insuranceHelper;

import java.util.ArrayList;

public class Family extends Company {
	
	public Family(int birthYear, String postalCode, int yearsClaimsFree, House house){
		super(birthYear, postalCode, yearsClaimsFree, house);
		name = "Family";
	}
	
	public void sewerBackupScore() {
		// TO BE IMPLEMENTED

	}

	public void inTargetMarket() {
		if ((this.getHouse().getPrice())/(this.getHouse().getSquareFootage()) <= 225){
			this.decreaseScore(5);
		}
		if (!this.getHouse().isUpdated()){
			this.decreaseScore(23);
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
		else if (newHomeDiscount < (2017-40)){
			this.decreaseScore(20);
		}
		else if (this.getHouse().getPrice() >= 1000000){
			discountList = new ArrayList<String>();
			discountList.add("No price for this company");
		}
	}

	public void claimsFreeDiscount() {
		if (this.getYearsInsured() > 3){
			this.increaseScore(14);
			discountList.add("Claims Free Discount 14%");
		}
	}

	public void ageDiscount() {
		
		if (2017-this.getBirthYear() >= 60){
			this.increaseScore(15);
			discountList.add("Senior Discount 15%");
		}
	}

	public void alarmDiscount() {
		if (this.getHouse().getHasAlarm().equals("local")){
			this.increaseScore(4);
			discountList.add("Local Alarm Discount 4%");
		}
		else if (this.getHouse().getHasAlarm().equals("monitored")){
			this.increaseScore(9);
			discountList.add("Monitored Alarm Discount 9%");
		}
	}

}
