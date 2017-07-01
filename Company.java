package insuranceHelper;

import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public abstract class Company implements Comparable<Company>{
	private int birthYear;
	private int score;
	private String postalCode;
	private int numYearsInsured;
	private House house;
	public String name;
	
	public List<String> discountList = new ArrayList<String>();
	
	public Company(int birthYear, String postalCode, int yearsClaimsFree, House house){
		
		this.birthYear = birthYear;
		
		this.postalCode = postalCode;
		this.numYearsInsured = yearsClaimsFree;
		this.house = house;
		
		score = 0;
		this.sewerBackupScore();
		this.inTargetMarket();
		this.claimsFreeDiscount();
		this.ageDiscount();
		this.alarmDiscount();
	}
	
	// determines if full coverage, half coverage, or no coverage is available for this postal code
	public abstract void sewerBackupScore();
	// checks if building price puts house in target market. score boost if true. Check if house is updated. minus score if false.
	public abstract void inTargetMarket();
	// checks if the client can be given claimsFreeDiscount, and by how much
	public abstract void claimsFreeDiscount();
	// determines if client qualifies for age discount
	public abstract void ageDiscount();
	// checks if client has local alarm or monitored alarm. boosts score if criteria met
	public abstract void alarmDiscount();
	/*
	 * Compares two Company objects based on the score
	 * @param b a second company to compare with
	 * @precondition b is a company
	 * @postcondition a integer has been returned
	 * @returns a integer, 1 if Company a is greater, 0 if a and b are equal, -1 if b is greater
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(Company b){
		if (score > b.getScore())
			return 1;
		else if (score < b.getScore())
			return -1;
		else
			return 0;
	}
	/*
	 * increaseScore(a) increases the score instance variable by a
	 * @param a the amount to increase the score by
	 * @precondition a is an integer
	 * @postcondition score has been increased by a
	 */
	public void increaseScore(int a){
		score += a;
	}
	/*
	 * decreaseScore(a) decreases the score instance variable by a
	 * @param a the amount to decrease the score by
	 * @precondiion a is an integer
	 * @postcondition score has been decrease by a, score can be < 0
	 */
	public void decreaseScore(int a){
		score -= a;
	}
	
	//accessor methods
	
	public int getBirthYear(){
		return birthYear;
	}
	public int getScore(){
		return score;
	}
	public String postalCode(){
		return postalCode;
	}
	public int getYearsInsured(){
		return numYearsInsured;
	}
	public House getHouse(){
		return house;
	}
	public String getName(){
		return name;
	}
}
