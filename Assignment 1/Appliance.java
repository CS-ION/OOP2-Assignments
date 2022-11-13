/**
 * Syed Ayaan Jilani ; 40209519
 * COMP249
 * Assignment 1
 * 7th October 2022
 */

// -----------------------------------------------------
// Assignment 1
// Question: Part I
// Written by: Syed Ayaan Jilani ; 40209519
// -----------------------------------------------------

/**
 *@author Syed Ayaan Jilani ; 40209519
 */

/*
 *                       PROGRAM DESCRIPTION
 *                       
 *The program/file contains a public class called Appliance. 
 *
 *The Appliance class has the following private instance attributes : 
 *
 *1) type (String)
 *   The type of an appliance can be any of the following: 
 *   Fridge, Air Conditioner, Washer, Dryer, Freezer, Stove, 
 *   Dishwasher, Water Heaters, and Microwave.
 *   
 *2) brand (String)
 *   The brand indicates the vendor/manufacturer of the appliance
 *   (such as LG, Samsung, Bosch, etc.), and can be any string.
 *
 *3) serial number (long)
 *   The serial number represents the serial number of the appliance,
 *   and must be unique. The serial number starts at 1000000 and is 
 *   incremented for every brand that is added.
 *   
 *4) price (double)
 *   The price of an appliance cannot be less than 1$.
 *   
 *In addition to the above instance variables, following private 
 *static variables are also a part of appliance class as follows : 
 *
 *1) st_sl_no (long)
 *   Intialised at the value of 1000000-1, this variable helps to keep
 *   track of the serial number assigned to the appliance object and 
 *   is incremented by 1 everytime a new appliance is added.
 *
 *2) numOfApps (int)
 *   Keeps track of the number of appliances created and is incremented
 *   everytime a new appliance is added.
 *   
 *3) validTypes (String[])
 *   An array that stores the valid types of appliances, which is used to
 *   compare with the user input to see if the user entered the correct type.
 *   
 *The Applicance class has the following instance methods :
 *
 *1) An explicit constructor that takes in the type, brand and price.
 *
 *2) A copy constructor that takes in another Appliance object.
 *
 *3) Setters and getters for type, brand and price to update or obtain
 *   the said values for a particular appliance object. There is no setter or 
 *   getter for Serial Number as it is unique and cannot be changed later.
 *   
 *4) equals() method that compares the type, brand and price of an appliance
 *   object and returns true if all three are equal.
 *   
 *5) toString() that prints out the all information of the appliance object.
 *
 *The Appliance class also has the following static methods : 
 *
 *1) findNumberOfCreatedAppliances() that simply returns the static attribute
 *   numOfApps.
 *   
 *2) checkValidType(String t) that takes in a input by user for type 't' and 
 *   compares it with the values in the array validTypes to see if it is valid.
 *   
 *3) checkBySerialNumber(long s, Appliance[] a) that takes in a user inputted
 *   serial number (s) and compares it with the serial number of the objects in
 *   appliance array-of-objects (a) created in the driver class to find if the 
 *   object with that serial number exists or not.
 *   
 *4) findAppliancesBy(String b, Appliance[] a) that takes in a user inputted
 *   brand (b) and compares it with the brand of the objects in appliance 
 *   array-of-objects (a) created in the driver class to find if the object 
 *   with that brand exists or not.
 *   
 *5) findCheaperThan(double p, Appliance[] a) that takes in a user inputted
 *   price (p) and compares it with the price of the objects in appliance 
 *   array-of-objects (a) created in the driver class to find and output all 
 *   the applaince objects which are cheaper than that price.
 *   
 *More detailed explainations about the methods are provided as and when 
 *they are declared. 
 *
 *The program also converts the type and brand of an appliance into lowercase 
 *while comparing so as to not make it case sensitive for the user. Hence, 
 *making it more user-friendly.
 *
 */

public class Appliance {

	private String type;
	private String brand;
	private long sl_no;
	private double price;
	
	private static long st_sl_no = 1000000-1;
	private static int numOfApps = 0;
	private static String[] validTypes = {"Fridge", "Air Conditioner", "Washer", "Dryer", 
			"Freezer", "Stove", "Dishwasher", "Water Heaters", "Microwave"};
	
	/**
	 * Explicit constructor that takes in type,brand and price of the appliance. The type 
	 * has already been verified in the driver class. The serial number is assigned the 
	 * incremented value of the static st_sl_no and numOfApps is also incremented. Price 
	 * is assigned default value of 1$ if value entered is less than 1$.
	 * 
	 * @param t type of appliance
	 * @param b brand of appliance
	 * @param p price of appliance
	 */
	
	public Appliance(String t, String b, double p) {
		this.type = t;
		this.brand = b;
		this.sl_no = ++st_sl_no;
		
		if (p<1) {
			System.out.println("Please note that price cannot be less than 1$. For now, " + 
		    "the default price assigned to your product is 1$. To change this, please use choice 2");
			this.price = 1;
		}
		else {this.price=p;}
		
		numOfApps++;
	}
	
	/**
	 * Copy constructor that takes in an appliance object and assigns the attributes of 'a'
	 * to the newly created appliance object. numOfApps in incremented.
	 * 
	 * @param a appliance object
	 */
	
	public Appliance(Appliance a) {
		this.type = a.type;
		this.brand = a.brand;
		this.sl_no = ++st_sl_no;
		this.price = a.price;
		numOfApps++;
	}
	
	/**
	 * Getter for type of appliance 
	 * @return type of appliance 
	 */
	
	public String getType() {
		return type;
	}
	
	/**
	 * Setter for type of appliance. Also checks for validity of type.
	 * @param t - user entered value for type
	 */

	public void setType(String t) {
		if (Appliance.checkValidType(t)) {
			this.type = t;
		}
		else {System.out.println("Invalid appliance type. Please try again.");}
	}
	
	/**
	 * Getter for brand of appliance 
	 * @return brand of appliance 
	 */

	public String getBrand() {
		return brand;
	}
	
	/**
	 * Setter for brand of appliance
	 * @param b - user entered value for brand
	 */

	public void setBrand(String b) {
		this.brand = b;
	}
	
	/**
	 * Getter for price of appliance 
	 * @return price of appliance 
	 */

	public double getPrice() {
		return price;
	}
	
	/**
	 * Setter for price
	 * @param p - user entered value for price
	 */

	public void setPrice(double p) {
		this.price = p;
	}
	
	/**
	 * Getter for serial number.
	 * No setter as serial number is unique and cannot be changed
	 * @return serial number of appliance
	 */
	
	public long getSl_no() {
		return this.sl_no;
	}
	
	/**
	 * Compares the price, type and brand of all appliances.
	 * brand and type in lowercase to make it user friendly.
	 * @param a - another appliance object to compare with
	 * @return true or false
	 */
	
	public boolean equals(Appliance a) {
		if (this.price == a.price && this.type.toLowerCase().equals(a.type.toLowerCase()) && 
				this.brand.toLowerCase().equals(a.brand.toLowerCase())){return true;}
		else {return false;}
	}
	
	/**
	 * Printing all the information of the appliance
	 * @return Information of the appliance
	 */

	public String toString() {
		return "Your Appliance is a " + this.type.toLowerCase() + " of brand " + this.brand + 
		" whose serial number is " + this.sl_no + " and the price is " + this.price + ".";
	}
	
	/**
	 * This method helps in various comparisions eg: to check is enough 
	 * space is there in the inventory to add new appliances.
	 * @return the number of appliances created
	 */
	
	public static int findNumberOfCreatedAppliances() {
		return numOfApps;
	}
	
	/**
	 * Constantly used to compare if the user inputted type is valid or not.
	 * Done using the static validTypes[] array. Comparision done in 
	 * lower-case to make it user friendly.
	 * @param t - user entered type of appliance
	 * @return true or false
	 */
	
	public static boolean checkValidType(String t) {
		
		for (String element:validTypes) {

			if (element.toLowerCase().equals(t.toLowerCase())) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 
	 * Checks if an appliance object exists using the serial number and the inventory.
	 * 
	 * @param s - user entered serial number
	 * @param a - inventory (array of appliance objects)
	 * @return Appliance object or null when no object exists
	 */
	
	public static Appliance checkBySerialNumber(long s, Appliance[] a) {
		
		for (Appliance element:a) {
			if (element == null) {
				return null;
			}
			if (element.sl_no == s) {
				return element;
			}
		}
		return null;
	}
	
	/**
	 * 
	 * Checks if an appliance object exists using the brand and the inventory.
	 * Prints appropriate message if no object exists with given brand.
	 * 
	 * @param b - user entered brand
	 * @param a - inventory (array of appliance objects)
	 */
	
	public static void findAppliancesBy(String b, Appliance[] a) {
		
		boolean exists = false;
		
		for (Appliance element:a) {
			
			if (element == null) {
				break;
			}
			if (element.brand.equals(b)) {
				exists = true;
				System.out.println(element.toString());
			}
			
		}
		
		if (!exists) {
			System.out.println("Brand does not exists");
		}
		
	}
	
	/**
	 * Print out all the information of appliances with cheaper prices than 
	 * the user entered price. Displays appropriate message if cheaper
	 * appliances do not exist.
	 * 
	 * @param p - user entered price
	 * @param a - inventory (array of appliance objects)
	 */
	
	public static void findCheaperThan(double p, Appliance[] a) {
		
		boolean exists = false;
		
		for (Appliance element:a) {
			
			if (element == null) {
				break;
			}
			
			if (element.price < p) {
				exists = true;
				System.out.println(element.toString());
			}
			
		}
		
		if (!exists) {
			System.out.println("Cheaper appliances do not exists");
		}
		
	}

}
