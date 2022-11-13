package Fifth;
import Fourth.UAV;

/**
 * 
 * @author Syed Ayaan Jilani
 */
public class AgriculturalDrone extends UAV{
	
	private String brand;
	private int carryCapacity;
	
	/**
	 * Default constructor that does not take any parameters and assigns default values of brand to null, 
	 * carryCapacity to 1. It also calls the default constructor of its parent class to assigns the attributes 
	 * associated with the parent class to their default values.
	 */
	public AgriculturalDrone() {
		super();
		this.brand = null;
		this.carryCapacity = 1;
	}
	
	/**
	 * Parameterized constructor that assigns the brand and Carrycapacity from the parameters passed.It also 
	 * calls the parameterized constructor of its parent class to assigns the attributes associated with the 
	 * parent class to the parameters passed.
	 * @param weight weight of Agricultural Drone
	 * @param price price of Agricultural Drone
	 * @param brand brand of Agricultural Drone
	 * @param carryCapacity Carry Capacity of Agricultural Drone
	 */
	public AgriculturalDrone(double weight, double price, String brand, int carryCapacity) {
		super(weight, price);
		this.brand = brand;
		this.carryCapacity = carryCapacity;
	}
	
	/**
	 * Copy constructor that takes a AgriculturalDrone object and assigns the values of 'a' to the newly created object.
	 * It also calls the copy constructor of its parent class and assigns the attributes associated with the parent
	 * class to its respective values.
	 * @param a AgriculturalDrone object
	 */
	public AgriculturalDrone(AgriculturalDrone a) {
		super(a);
		this.brand = a.brand;
		this.carryCapacity = a.carryCapacity;
	}
	
	/**
	 * Getter for brand
	 * @return the brand
	 */
	public String getBrand() {
		return brand;
	}
	
	/**
	 * Setter fro brand
	 * @param brand the brand to set
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	/**
	 * Getter for carryCapacity
	 * @return the carryCapacity
	 */
	public int getCarryCapacity() {
		return carryCapacity;
	}
	
	/**
	 * Setter for carryCapacity
	 * @param carryCapacity the carryCapacity to set
	 */
	public void setCarryCapacity(int carryCapacity) {
		this.carryCapacity = carryCapacity;
	}
	
	/**
	 * equals method takes in an Object parameter. First it checks if the parameter is null. It then checks if they belong 
	 * to the same class. If they belong to the same class then, it calls the equals method of its parent class to check 
	 * that the values of attributes associated with the parent class are equal or not. If they are equal, 
	 * then the Object is downcasted to a AgriculturalDrone. It also checks whether one or both AD's have brand value 
	 * as null in order to avoid the program to crash. If the object passes all these checks, then the 
	 * values/attributes of the AgriculturalDrones are compared.
	 * @return true or false
	 */
	public boolean equals(Object obj) {
		if (obj == null)
			return true;
		if (getClass() != obj.getClass())
			return false;
		if (!super.equals(obj))
			return false;
		AgriculturalDrone other = (AgriculturalDrone) obj;
		if (brand == null) {
			if (other.brand != null)
				return false;
		} else if (!brand.equals(other.brand))
			return false;
		if (carryCapacity != other.carryCapacity)
			return false;
		return true;
	}
	
	/**
	 * Printing all the information of the AgriculturalDrone
	 * @return Information of the AgriculturalDrone
	 */
	public String toString() {
		return "This Agricultural Drone is manufactured by " + brand + ". It weighs " + weight + 
				" pounds, and costs " + price + "$. It can carry up to " + carryCapacity + " Kg";
	}

}
