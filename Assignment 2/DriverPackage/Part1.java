package DriverPackage;
import First.Airplane;
import First.FlyingObject;
import Second.*;
import Third.Multirotor;
import Fourth.UAV;
import Fifth.*;

/**
 * 
 * @author Syed Ayaan Jilani 
 */
public class Part1 {
	
	/**
	 * The method finds the cheapest and the most expensive UAV objects by filtering the UAV 
	 * objects from the array of flying objects passed as the parameter. If only one UAV object 
	 * is present or no UAV objects exist in the array, the method outputs accordingly.
	 * @param array array of flying objects 
	 */
	public static void findLeastAndMostExpensiveUAV(FlyingObject[] array) {
		
		double greatest = Integer.MIN_VALUE;
		double lowest = Integer.MAX_VALUE;
		
		int gIndex = 0;
		int lIndex = 0;
		
		for (int i = 0; i < array.length ; i++) {
			
			if (array[i] instanceof UAV) {           // To check if object is UAV or not
				
				UAV element = (UAV)array[i];         // Downcasting from FlyingObject class to UAV class to compare
				
				if (element.getPrice()>greatest) {
					greatest = element.getPrice();
					gIndex = i;
				}
				
				if (element.getPrice()<lowest) {
					lowest = element.getPrice();
					lIndex = i;
				}
				
			}
		}
		
		if (greatest == lowest) {
			System.out.println("There exists only 1 UAV object and its information is as follows : ");
			System.out.println(array[gIndex]+"\n");
		}
		else if (greatest == Integer.MIN_VALUE){
			System.out.println("UAV objects do not exist.\n");
		}
		else {
			System.out.println("The most expensive UAV object : ");
			System.out.println(array[gIndex]);
			System.out.println("The cheapest UAV object : ");
			System.out.println(array[lIndex]+"\n");
		}
		
	}
	
	
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
		
		System.out.println("ARRAY CONTAINING BOTH UAV AND AIRPLANE OBJECTS");
		Part1.findLeastAndMostExpensiveUAV(array);
		
		FlyingObject[] array2 = new FlyingObject[20];
		
		array2[3] = new Airplane();
		array2[4] = new Airplane("ApBrand1",79,250);
		array2[5] = new Airplane((Airplane)array2[4]);
		
		array2[6] = new Helicopter();
		array2[7] = new Helicopter("HcBrand1",119,200,8,2009,4);
		array2[8] = new Helicopter((Helicopter)array2[6]);
		
		array2[9] = new Quadcopter();
		array2[10] = new Quadcopter("QcBrand1",151,150,7,2021,2,225);
		array2[11] = new Quadcopter((Quadcopter)array2[10]);
		
		array2[12] = new Multirotor();
		array2[13] = new Multirotor("MrBrand1",134,170,6,2016,6,4);
		array2[14] = new Multirotor((Multirotor)array2[12]);
		
		array2[15] = new Airplane();
		array2[16] = new Helicopter();
		array2[17] = new Multirotor();
		array2[18] = new Quadcopter();
		
		System.out.println("ARRAY CONTAINING ONLY AIRPLANE OBJECTS");
		Part1.findLeastAndMostExpensiveUAV(array2);
		
		System.out.println("ARRAY HAVING ONLY ONE UAV OBJECT");
		FlyingObject[] array3 = {new UAV()};
		
		Part1.findLeastAndMostExpensiveUAV(array3);
		
		System.out.println("TESTING THE EQUALS METHOD: ");
		System.out.println(array2[15].equals(array2[16]));  // should be false
		System.out.println(array2[10].equals(array2[11]));  // should be true
		System.out.println(array2[13].equals(array2[14]));  // should be false
		System.out.println(array[1].equals(array[2]));      // should be true
		System.out.println(array[0].equals(array2[13]));    // should be false
		System.out.println(array2[17].equals(array2[16]));  // should be false
	}

}
