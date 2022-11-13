package First;

/**
 * Part I
 * @author Syed Ayaan Jilani ; 40209519
 */
public class Airplane extends FlyingObject {
	
	protected String brand;
	protected double price;
	protected  int horsepower;
	
	/**
	 * Default constructor that does not take any parameters and assigns default values of brand to null, price to 
	 * 1 dollars and horsepower to 5 when called.
	 */
	public Airplane() {
		this.brand = null;
		this.price = 1;
		this.horsepower = 5 ;
	}
	
	/**
	 * Parameterized constructor that assigns the brand, price and horsepower from the parameters passed
	 * 
	 * @param brand brand of airplane
	 * @param price price of airplane
	 * @param horsepower horsepower of airplane
	 */
	public Airplane(String brand, double price, int horsepower) {
		this.brand = brand;
		this.price = price;
		this.horsepower = horsepower;
	}
	
	/**
	 * Copy constructor that takes in an airplane object and assigns the attributes of 'plane'
	 * to the newly created appliance object.
	 * 
	 * @param plane airplane object
	 */
	
	public Airplane(Airplane plane) {
		this.brand = plane.brand;
		this.price = plane.price;
		this.horsepower = plane.horsepower;
	}
	
	/**
	 * Getter for brand of airplane
	 * @return the brand
	 */
	public String getBrand() {
		return brand;
	}

	/**
	 * Setter for brand of airplane
	 * @param brand the brand to set
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}

	/**
	 * Getter for price of airplane
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Setter for price of airplane
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * Getter for horsepower of airplane
	 * @return the horsepower
	 */
	public int getHorsepower() {
		return horsepower;
	}

	/**
	 * Setter for horsepower of airplane
	 * @param horsepower the horsepower to set
	 */
	public void setHorsepower(int horsepower) {
		this.horsepower = horsepower;
	}
	
	/**
	 * equals method takes in an Object parameter. First it checks if the parameter is null. If it is not null then it checks if 
	 * they belong to the same class. If they belong to the same class then the Object is downcasted to an airplane.
	 * It also checks whether one or both airplane have brand value as null in order to avoid the program to crash.
	 * If the object passes all these checks, then the values/attributes of the airplanes are compared.
	 * @return true or false
	 */
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Airplane other = (Airplane) obj;
		if (brand == null) {
			if (other.brand != null)
				return false;
		} 
		else if (!brand.equals(other.brand)) {
			return false;
		}
		if (horsepower != other.horsepower) {
			return false;
		}
		if (price != other.price) {
			return false;
		}
		return true;
	}
	
	/**
	 * Printing all the information of the airplane
	 * @return Information of the airplane
	 */
	public String toString() {
		return "This Airplane is manufactured by " + brand + ". It costs " + price + "$ and has horsepower of " + horsepower + "HP.";
	}	
}