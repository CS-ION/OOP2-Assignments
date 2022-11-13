package Second;

/**
 * 
 * @author Syed Ayaan Jilani 
 */
public class Quadcopter extends Helicopter {
	
	private int maxFlyingSpeed;

	/**
	 * Default constructor that does not take any parameters and assigns default value of maxFlyingSpeed to 250. 
	 * It also calls the default constructor of its parent class to assigns the attributes associated with the 
	 * parent class to their default values. (Notice that in this case, a default constructor of Quadcopter will
	 * call its parent - default constructor of helicopter class which will in turn call its parent - default 
	 * constructor of airplane)
	 */
	public Quadcopter() {
		super();
		this.maxFlyingSpeed = 250;
	}

	/**
	 * Copy constructor that takes a quadcopter object and assigns the values of 'q' to the newly created object.
	 * It also calls the copy constructor of its parent class and assigns the attributes associated with the parent
	 * class to its respective values. (Notice that in this case, a copy constructor of Quadcopter will
	 * call its parent - copy constructor of helicopter class which will in turn call its parent - copy 
	 * constructor of airplane)
	 * @param q quadcopter object
	 */
	public Quadcopter(Quadcopter q) {
		super(q);	
		this.maxFlyingSpeed = q.maxFlyingSpeed;
	}

	/**
	 * Parameterized constructor that assigns the maxFlyingSpeed from the parameters passed. It also calls the parameterized 
	 * constructor of its parent class to assigns the attributes associated with the parent class to the parameters passed.
	 * (Notice that in this case, a parameterized constructor of Quadcopter will call its parent - parameterized constructor 
	 * of helicopter class which will in turn call its parent - parameterized constructor of airplane)
	 * @param brand of quadcopter
	 * @param price of quadcopter
	 * @param horsepower of quadcopter
	 * @param numOfCylinders of quadcopter
	 * @param yearCreated of quadcopter
	 * @param capacity of quadcopter
	 * @param maxFlyingSpeed maximum flying speed of quadcopter
	 */
	public Quadcopter(String brand, double price, int horsepower, int numOfCylinders, int yearCreated, int capacity, int maxFlyingSpeed) {
		super(brand, price, horsepower, numOfCylinders, yearCreated, capacity);
		this.maxFlyingSpeed = maxFlyingSpeed;
	}
	
	/**
	 * Getter for maxFlyingSpeed
	 * @return the maxFlyingSpeed
	 */
	public int getMaxFlyingSpeed() {
		return maxFlyingSpeed;
	}

	/**
	 * Setter for maxFlyingSpeed
	 * @param maxFlyingSpeed the maxFlyingSpeed to set
	 */
	public void setMaxFlyingSpeed(int maxFlyingSpeed) {
		this.maxFlyingSpeed = maxFlyingSpeed;
	}
	
	
	/**
	 * equals method takes in an Object parameter. First it checks if the parameter is null. It then checks if they belong 
	 * to the same class. If they belong to the same class then, it calls the equals method of its parent class to check 
	 * that the values of attributes associated with the parent class are equal or not. If they are equal, 
	 * then the Object is downcasted to a quadcopter. If the object passes all these checks, then the values/attributes 
	 * of the quadcopters are compared.
	 * @return true or false
	 */
	public boolean equals(Object obj) {
		if (obj == null)
			return true;
		if (getClass() != obj.getClass())
			return false;
		if (!super.equals(obj))
			return false;
		Quadcopter other = (Quadcopter) obj;
		if (maxFlyingSpeed != other.maxFlyingSpeed)
			return false;
		return true;
	}
	
	/**
	 * Printing all the information of the quadcopter
	 * @return Information of the quadcopter
	 */
	public String toString() {
		return "This Quadcopter is manufactured by " + brand + " in " + yearCreated + ". It costs " + price + 
				"$ and has horsepower of " + horsepower + "HP. It has " + numOfCylinders + " cylinders and passanger capacity of "
				+ capacity + " passengers. It has maximum flying speed of " + maxFlyingSpeed + " mph.";
	}
	
	

}
