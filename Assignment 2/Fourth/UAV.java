package Fourth;
import First.FlyingObject;

/**
 *
 * @author Syed Ayaan Jilani
 */
public class UAV extends FlyingObject {
	
	protected double weight;
	protected double price;
	
	/**
	 * Default constructor that does not take any parameters and assigns default values of weight and price to 1.
	 */
	public UAV() {
		this.weight = 1;
		this.price = 1;
	}
	
	/**
	 * Copy constructor that takes a UAV object and assigns the values of 'u' to the newly created object.
	 * @param u UAV object
	 */
	public UAV(UAV u) {
		this.weight = u.weight;
		this.price = u.price;
	}
	
	/**
	 * Parameterized constructor that assigns weight and price from the parameters passed.
	 * @param weight weight of UAV
	 * @param price price of UAV
	 */
	public UAV(double weight, double price) {
		this.weight = weight;
		this.price = price;
	}

	/**
	 * Getter for weight
	 * @return the weight
	 */
	public double getWeight() {
		return weight;
	}

	/**
	 * Setter for weight
	 * @param weight the weight to set
	 */
	public void setWeight(double weight) {
		this.weight = weight;
	}

	/**
	 * Getter for price
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Setter for price
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	
	/**
	 * equals method takes in an Object parameter. First it checks if the parameter is null. Then it checks if they belong
	 * to the same class. If they belong to the same class then the Object is downcasted to a UAV. If the object 
	 * passes all these checks, then the values/attributes of the UAV's are compared.
	 * @return true or false
	 */
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UAV other = (UAV) obj;
		if (price != other.price)
			return false;
		if (weight != other.weight)
			return false;
		return true;
	}
	
	/**
	 * Printing all the information of the UAV
	 * @return Information of the UAV
	 */
	public String toString() {
		return "This Unmaned Aerial Vehicle / Drone weighs " + weight + " grams and costs " + price + "$.";
	}
	
}
