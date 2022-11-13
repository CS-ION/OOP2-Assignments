package Fifth;
import Fourth.UAV;

/**
 * 
 * @author Syed Ayaan Jilani 
 */
public class MAV extends UAV {
	
	private String model;
	private double size;
	
	/**
	 * Default constructor that does not take any parameters and assigns default values of model to null, 
	 * size to 15. It also calls the default constructor of its parent class to assigns the attributes 
	 * associated with the parent class to their default values.
	 */
	public MAV() {
		super();
		this.model = null;
		this.size = 15;
	}
	/**
	 * Parameterized constructor that assigns the model and size from the parameters passed. It also 
	 * calls the parameterized constructor of its parent class to assign the attributes associated with 
	 * the parent class to the parameters passed. (Note : size cannot be greater than 15)
	 * @param weight weight of MAV
	 * @param price price of MAV
	 * @param model model of MAV
	 * @param size size of MAV
	 */
	public MAV(double weight, double price, String model, double size) {
		super(weight, price);
		this.model = model;
		if (size>15) {this.size = 15;} 
		else {this.size = size;}
	}
	/**
	 * Copy constructor that takes a MAV object and assigns the values of 'M' to the newly created object.
	 * It also calls the copy constructor of its parent class and assigns the attributes associated with the parent
	 * class to its respective values.
	 * @param m MAV object
	 */
	public MAV(MAV m) {
		super(m);
		this.model = m.model;
		this.size = m.size;
	}
	
	/**
	 * Getter for model
	 * @return the model
	 */
	public String getModel() {
		return model;
	}
	
	/**
	 * Setter for model
	 * @param model the model to set
	 */
	public void setModel(String model) {
		this.model = model;
	}
	
	/**
	 * Getter for size
	 * @return the size
	 */
	public double getSize() {
		return size;
	}
	
	/**
	 * Setter for size
	 * @param size the size to set
	 */
	public void setSize(double size) {
		if (size>15) {
			System.out.println("Size is greater than 15cm. Assigning 15cm as default size. Can change value using mutators");
		}else {this.size = size;}
	}
	
	/**
	 * equals method takes in an Object parameter. First it checks if the parameter is null. It then checks if they belong 
	 * to the same class. If they belong to the same class then, it calls the equals method of its parent class to check 
	 * that the values of attributes associated with the parent class are equal or not. If they are equal, then the Object 
	 * is downcasted to an MAV. It also checks whether one or both MAV'S have brand value as null in order to avoid the program to crash.
	 * If the object passes all these checks, then the values/attributes of the MAV'S are compared.
	 * @return true or false
	 */
	public boolean equals(Object obj) {
		if (obj == null)
			return true;
		if (getClass() != obj.getClass())
			return false;
		if (!super.equals(obj))
			return false;
		MAV other = (MAV) obj;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (size != other.size)
			return false;
		return true;
	}
	
	/**
	 * Printing all the information of the MAV
	 * @return Information of the MAV
	 */
	public String toString() {
		return "This Micro Air Vehicle is of model : " + model + ". It weighs " + weight + 
				" pounds, and costs " + price + "$. It has size : " + size + " cm";
	}
	
	

}
