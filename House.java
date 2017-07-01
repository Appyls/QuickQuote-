package insuranceHelper;

public class House {
	
	private int yearBuilt;
	private String custom;
	private int numFloors;
	private int squareFootage;
	private int basementSize;
	private boolean updated;
	private int price;
	private String hasAlarm;
	
	public House(int yearBuilt, String custom, int numFloors, int squareFootage, int basementSize, String hasAlarm, boolean updated){
		
		this.yearBuilt = yearBuilt;
		this.custom = custom;
		this.numFloors = numFloors;
		this.squareFootage = squareFootage;
		this.basementSize = basementSize;
		this.hasAlarm = hasAlarm;
		
		if (2017-yearBuilt <= 25) // only houses over 25 years old needs update
				this.updated = true;
		else
			this.updated = updated;
		
		
		if (numFloors >= 2 && basementSize > 0)
			this.price = approxRCT_withBasement(squareFootage, custom);
		else if (numFloors >= 2)
			this.price = approxRCT_noBasement(squareFootage, custom);
		else if (numFloors == 1 && basementSize >0){
			this.price = approxRCT_1StoreyBase(squareFootage, custom);
		}
		else if (numFloors == 1)
			this.price = approxRCT_1Storey(squareFootage, custom);
		
	}
	
	public static int approxRCT_withBasement(int sqft, String custom){
		if (custom.equals("standard"))
			return sqft*200;
		else if (custom.equals("semi-custom"))
			return sqft*275;
		else if (custom.equals("custom"))
			return sqft*310;
		else
			return -1;

	}
	public static int approxRCT_noBasement(int sqft, String custom){
		if (custom.equals("standard"))
			return sqft*200;
		else if (custom.equals("semi-custom"))
			return sqft*225;
		else if (custom.equals("custom"))
			return sqft*275;
		else
			return -1;
	}
	public static int approxRCT_1StoreyBase(int sqft, String custom){
		if (custom.equals("standard"))
			return sqft*200;
		else if (custom.equals("semi-custom"))
			return sqft*250;
		else if (custom.equals("custom"))
			return sqft*300;
		else
			return -1;
	}
	public static int approxRCT_1Storey(int sqft, String custom){
		if (custom.equals("standard"))
			return sqft*180;
		else if (custom.equals("semi-custom"))
			return sqft*210;
		else if (custom.equals("custom"))
			return sqft*250;
		else
			return -1;
	}
	
	public int getYearBuilt(){
		return yearBuilt;
	}
	public String getCustom(){
		return custom;
	}
	public int getNumFloors(){
		return numFloors;
	}
	public int getSquareFootage(){
		return squareFootage;
	}
	public int getBasementSize(){
		return basementSize;
	}
	public boolean isUpdated(){
		return updated;
	}
	public int getPrice(){
		return price;
	}
	public String getHasAlarm(){
		return hasAlarm;
	}
}
