package DriverPackage;
import First.Airplane;
import First.FlyingObject;
import Second.*;
import Third.Multirotor;
import Fourth.UAV;
import Fifth.*;

/**
 * Part II
 * @author Syed Ayaan Jilani ; 40209519
 */
public class Part2 {
	
	/**
	 * Takes an array containing flying objects. Creates a new array of flying objects and 
	 * copies the elements of original array to the new array while following the restrictions.
	 * @param a array of flying objects 
	 * @return arr the copied array of flying objects 
	 */
	public static FlyingObject[] copyFlyingObjects(FlyingObject[] a){
		
		FlyingObject[] arr = new FlyingObject[a.length];
		
		for (int i = 0; i < arr.length; i++){

			if (a[i] instanceof Airplane) {                 // Restrictions :-
				arr[i] = new Airplane((Airplane)a[i]);      // 1) Do not explicity find the type of object inside the methods
			}                                               // 2) Do not explicity find the type of object inside copy constructor
			else if (a[i] instanceof UAV){                  // 3) Do not use clone
				arr[i] = new UAV((UAV)a[i]);                // Hence, I have only used instanceof to distinguish between Airplane and
			}                                                // UAV and used their respective copy constructors for copying the objects.
		}                                                   // Downcasting all objects or array from FlyingObject class to Airplane/UAV 
		return arr;                                         // in order to pass it as a parameter in the copy constructor and avoid 
	}                                                       // compile time error.

	/**
	 * @param args - an array of sequence of characters (Strings)
	 */
	public static void main(String[] args) {
		
		FlyingObject[] array = new FlyingObject[20];
		
		array[0] = new UAV();
		array[1] = new UAV(10,18);
		array[2] = new UAV((UAV)array[1]);
		
		array[3] = new MAV();
		array[3] = new MAV(20,85,"MavModelOne",17);
		array[4] = new MAV((MAV)array[3]);
		
		array[5] = new AgriculturalDrone();
		array[6] = new AgriculturalDrone(40,65,"AgDrBrand1",4);
		array[7] = new AgriculturalDrone((AgriculturalDrone)array[6]);
		
		array[8] = new Airplane();
		array[9] = new Airplane("ApBrand1",79,250);
		array[10] = new Airplane((Airplane)array[8]);
		
		array[11] = new Helicopter();
		array[12] = new Helicopter("HcBrand1",119,200,8,2009,4);
		array[13] = new Helicopter((Helicopter)array[12]);
		
		array[14] = new Quadcopter();
		array[15] = new Quadcopter("QcBrand1",151,150,7,2021,2,225);
		array[16] = new Quadcopter((Quadcopter)array[15]);
		
		array[17] = new Multirotor();
		array[18] = new Multirotor("MrBrand1",134,170,6,2016,6,4);
		array[19] = new Multirotor((Multirotor)array[18]);
		
		System.out.println("The Flying objects in the original array are :- \n");
		
		for (Object element:array) {
			System.out.println(element);
		}
		
		System.out.println();
		
		FlyingObject[] copy = Part2.copyFlyingObjects(array);
		
		System.out.println("The Flying objects in the copy array are :- \n");
		
		for (Object element:copy) {
			System.out.println(element);
		}

	}

}