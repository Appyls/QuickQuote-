package insuranceHelper;

public class Wawanesa extends Company {
	
	public Wawanesa(int birthYear, String postalCode, int yearsClaimsFree, House house){
		super(birthYear, postalCode, yearsClaimsFree, house);
		name = "Wawanesa";
	}
	

	public void sewerBackupScore() {
		// TO BE IMPLEMENTED

	}


	public void inTargetMarket() {
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
		if (this.getYearsInsured() > 3){
			this.increaseScore(15);
			discountList.add("Claims Free Discount 15%");
		}

	}


	public void ageDiscount() {
		if (2017-this.getBirthYear() >= 50){
			this.increaseScore(15);
			discountList.add("Senior Discount 15%");
		}

	}


	public void alarmDiscount() {
		if (this.getHouse().getHasAlarm().equals("local")){
			this.increaseScore(10);
			discountList.add("Local Alarm Discount 10%");
		}
		else if (this.getHouse().getHasAlarm().equals("monitored")){
			this.increaseScore(10);
			discountList.add("Monitored Alarm Discount 10%");
		}

	}

}
