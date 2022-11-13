package Third;
import Second.Helicopter;

/**
 * 
 * @author Syed Ayaan Jilani
 */
public class Multirotor extends Helicopter {
	
	private int numOfRotors;

	/**
	 * Default constructor that does not take any parameters and assigns default values of numOfRotors to 2. 
	 * It also calls the default constructor of its parent class to assigns the attributes associated with 
	 * the parent class to their default values.
	 */
	public Multirotor() {
		super();
		this.numOfRotors = 2;
	}

	/**
	 * Copy constructor that takes a multirotor object and assigns the values of 'm' to the newly created object.
	 * It also calls the copy constructor of its parent class and assigns the attributes associated with the parent
	 * class to its respective values. (Notice that in this case, a copy constructor of Multirotor will
	 * call its parent - copy constructor of helicopter class which will in turn call its parent - copy 
	 * constructor of airplane)
	 * @param m multirotor object
	 */
	public Multirotor(Multirotor m) {
		super(m);
		this.numOfRotors = m.numOfRotors;
	}

	/**
	 * Parameterized constructor that assigns the numOfRotors from the parameters passed. It also calls the parameterized 
	 * constructor of its parent class to assigns the attributes associated with the parent class to the parameters passed.
	 * (Notice that in this case, a parameterized constructor of Multirotor will call its parent - parameterized constructor 
	 * of helicopter class which will in turn call its parent - paramaeterized constructor of airplane)
	 * @param brand brand of multirotor
	 * @param price price of multirotor
	 * @param horsepower horsepower of multirotor
	 * @param numOfCylinders no of cylinders of multirotor
	 * @param yearCreated year when the multirotor was created
	 * @param capacity capacity of multirotor
	 * @param numOfRotors number of rotors of the multirotor
	 */
	public Multirotor(String brand, double price, int horsepower, int numOfCylinders, int yearCreated, int capacity, int numOfRotors) {
		super(brand, price, horsepower, numOfCylinders, yearCreated, capacity);
		this.numOfRotors = numOfRotors;
	}

	/**
	 * Getter for numOfRotors
	 * @return the numOfRotors
	 */
	public int getNumOfRotors() {
		return numOfRotors;
	}

	/**
	 * Setter for numOfRotors
	 * @param numOfRotors the numOfRotors to set
	 */
	public void setNumOfRotors(int numOfRotors) {
		this.numOfRotors = numOfRotors;
	}
	
	/**
	 * equals method takes in an Object parameter. First it checks if the parameter is null. It then checks if they belong 
	 * to the same class. If they belong to the same class then, it calls the equals method of its parent class to check 
	 * that the values of attributes associated with the parent class are equal or not. If they are equal,
	 * then the Object is downcasted to a multirotor. If the object passes all these checks, then the values/attributes 
	 * of the multirotor are compared.
	 * @return true or false
	 */
	public boolean equals(Object obj) {
		if (obj == null)
			return true;
		if (getClass() != obj.getClass())
			return false;
		if (!super.equals(obj))
			return false;
		Multirotor other = (Multirotor) obj;
		if (numOfRotors != other.numOfRotors)
			return false;
		return true;
	}
	
	/**
	 * Printing all the information of the multirotor
	 * @return Information of the multirotor
	 */
	public String toString() {
		return "This Multirotor is manufactured by " + brand + " in " + yearCreated + ". It costs " + price + 
				"$ and has horsepower of " + horsepower + "HP. It has " + numOfCylinders + " cylinders and passanger capacity of "
				+ capacity + " passengers. It has " + numOfRotors + " rotors.";
	}
	
	

}
