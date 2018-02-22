package insuranceHelper;

public class Intact extends Company {
	
	public Intact(int birthYear, String postalCode, int yearsClaimsFree, House house){
		super(birthYear, postalCode, yearsClaimsFree, house);
		name = "Intact";
	}

	public void sewerBackupScore() {
		// TO BE IMPLEMENTED

	}


	public void inTargetMarket() {
		if ((this.getHouse().getPrice())/(this.getHouse().getSquareFootage()) < 275){
			this.decreaseScore(25);
		}
		if (!this.getHouse().isUpdated()){
			this.decreaseScore(10);
		}

	}


	public void claimsFreeDiscount() {
		double cfd = (this.getYearsInsured() <= 10) ? (this.getYearsInsured()*2.7) : 27;
		int rounded_cfd = (int)(cfd+0.5); //rounds cfd to nearest integer
		this.increaseScore(rounded_cfd);
		discountList.add("Claims Free Discount " + rounded_cfd + "%"); 

	}


	public void ageDiscount() {
		
		if (2017-this.getBirthYear() >= 60){
			this.increaseScore(60);
			discountList.add("Senior Discount 30%");
		}

		else if (2017-this.getBirthYear() >= 50){
			this.increaseScore(22);
			discountList.add("Senior Discount 22%");
		}
	}


	public void alarmDiscount() {
		if (this.getHouse().getHasAlarm().equals("local")){
			this.increaseScore(18);
			discountList.add("Local Alarm Discount 18%");
		}
		else if (this.getHouse().getHasAlarm().equals("monitored")){
			this.increaseScore(18);
			discountList.add("Monitored Alarm Discount 18%");
		}

	}

}
