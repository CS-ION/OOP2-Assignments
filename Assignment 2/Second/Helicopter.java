package Second;
import First.Airplane;

/**
 * Part I
 * @author Syed Ayaan Jilani ; 40209519
 */

public class Helicopter extends Airplane {
	
	protected int numOfCylinders;
	protected int yearCreated;
	protected int capacity;
	
	/**
	 * Default constructor that does not take any parameters and assigns default values of capacity to 2, numOfCylinders
	 * to 4 and yearsCreated to 2000. It also calls the default constructor of its parent class to assigns the attributes 
	 * associated with the parent class to their default values.
	 */
	public Helicopter() {
		super();
		this.capacity = 2;
		this.numOfCylinders = 4;
		this.yearCreated = 2000;
		
	}
	
	/**
	 * Copy constructor that takes an helicopter object and assigns the values of 'h' to the newly 
	 * created object. It also calls the copy constructor of its parent class to assigns the attributes 
	 * associated with the parent class its respective values.
	 * @param h helicopter object
	 */
	public Helicopter(Helicopter h) {
		super(h);
		this.capacity = h.capacity;
		this.numOfCylinders = h.numOfCylinders;
		this.yearCreated = h.yearCreated;
	}

	/**
	 * Parameterized constructor that assigns the numOfCylinders, yearsCreated and capacity from the parameters passed.
	 * It also calls the parameterized constructor of its parent class to assigns the attributes associated with the 
	 * parent class to the parameters passed.
	 * @param brand of helicopter
	 * @param price of helicopter
	 * @param horsepower of helicopter
	 * @param numOfCylinders of helicopter
	 * @param yearCreated of helicopter
	 * @param capacity of helicopter
	 */
	public Helicopter(String brand, double price, int horsepower, int numOfCylinders, int yearCreated, int capacity) {
		super(brand, price, horsepower);
		this.numOfCylinders = numOfCylinders;
		this.yearCreated = yearCreated;
		this.capacity = capacity;
	}

	/**
	 * Getter for numOfCylinders
	 * @return the numOfCylinders
	 */
	public int getNumOfCylinders() {
		return numOfCylinders;
	}

	/**
	 * Setter for numOfCylinders
	 * @param numOfCylinders the numOfCylinders to set
	 */
	public void setNumOfCylinders(int numOfCylinders) {
		this.numOfCylinders = numOfCylinders;
	}

	/**
	 * Getter for yearCreated
	 * @return the yearCreated
	 */
	public int getYearCreated() {
		return yearCreated;
	}

	/**
	 * Setter for yearCreated
	 * @param yearCreated the yearCreated to set
	 */
	public void setYearCreated(int yearCreated) {
		this.yearCreated = yearCreated;
	}

	/**
	 * Getter for capacity
	 * @return the capacity
	 */
	public int getCapacity() {
		return capacity;
	}

	/**
	 * Setter for capacity
	 * @param capacity the capacity to set
	 */
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	/**
	 * equals method takes in an Object parameter. First it checks if the parameter is null. It then checks if they belong 
	 * to the same class. If they belong to the same class then, it calls the equals method of its parent class to check 
	 * that the values of attributes associated with the parent class are equal or not. If they are equal, 
	 * then the Object is downcasted to a helicopter. If the object passes all these checks, then the values/attributes 
	 * of the helicopters are compared.
	 * @return true or false
	 */
	public boolean equals(Object obj) {
		if (obj == null)
			return true;
		if (getClass() != obj.getClass())
			return false;
		if (!super.equals(obj))
			return false;
		Helicopter other = (Helicopter) obj;
		if (capacity != other.capacity)
			return false;
		if (numOfCylinders != other.numOfCylinders)
			return false;
		if (yearCreated != other.yearCreated)
			return false;
		return true;
	}
	
	/**
	 * Printing all the information of the helicopter
	 * @return Information of the helicopter
	 */
	public String toString() {
		return "This Helicopter is manufactured by " + brand + " in " + yearCreated + ". It costs " + price + 
				"$ and has horsepower of " + horsepower + "HP. It has " + numOfCylinders + " cylinders and passanger capacity of "
				+ capacity + " passengers.";
	}
	
	

	
}
