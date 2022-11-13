import java.util.Scanner;

/**
 * Syed Ayaan Jilani ; 40209519
 * COMP249
 * Assignment 1
 * 7th October 2022
 */

//-----------------------------------------------------
//Assignment 1 
//COMP249
//Question: Part II
//Written by: Syed Ayaan Jilani ; 40209519
//-----------------------------------------------------

/**
 *@author Syed Ayaan Jilani ; 40209519
 */

 /*                                PROGRAM DESCRIPTION
 *                       
 *The following DriverClass contains a main() method that :
 *
 *1) Displays a welcome message.
 *
 *2) Prompt the store owner for the maximum number of appliances his/her store can contain. 
 * 
 *3) Create an empty array, called inventory, that will have the potential of keeping track of the created Appliance objects.
 *
 *4) Display a main menu with 5 choices and keep prompting the user until they enter a number between 1 and 5 inclusive.
 *
 *In order to create and append or update an Appliance object, the user is required to enter a security password which
 *is specified as a constant (final) of type String. 
 *
 *The choices from 1-5 perform the following functions :
 *
 *1) Prompt the user for his/her password. The user has a maximum of 3 attempts to enter the correct password. After the 3rd 
 *   illegal entry, the main menu is re-displayed again. Additionally after this process is repeated 4 consecutive times 
 *   (i.e. total failed attempts is 12 consecutive attempts by now), the program displays a caution message and terminates.
 *   
 *   If the correct password is entered (which will reset the counter of failed attempts), the user is prompted to enter how 
 *   many appliances he/she wants to enter. Then the program checks if the number is valid (>0) and if it exceeds the inventory.
 *   In both cases, the user is informed (current no. items in inventory in second case) and is asked again for the input until
 *   a valid number is entered. The user can simply enter 0 if they change their mind.
 *   
 *   Then the program prompts the user for appliance details. The program also checks if the appliance type is valid by using the
 *   checkValidTypes(String t) method. If the user enters an invalid type, he/she is prompted till a valid type is entered. Keep
 *   in mind that if the user enters a price less than 1$, the price is assigned 1$ by default and the user will be promted to 
 *   change it using the setter if they wish so. After creating and adding all the appliances, the program displays a success message.
 *   
 *2) Prompt the user for his/her password. Again the user has 3 attempts to enter the correct password. However, after the 3rd illegal 
 *   entry, the main menu in Figure 1 is simply re-displayed again. No termination involved unlike first case.
 *   
 *   The program then prompts the user of the serial number of the appliance he/she wishes to update. If there is no object with that 
 *   serial number in the array inventory, a message is displayed indicating that and ask the user if he/she wishes to re-enter another 
 *   serial number, or quit this operation and go back to the main menu. 
 *   
 *   If the entered serial number exists, the current information of that appliance is displayed. The user is again prompted until they
 *   enter a valid choice from 1-3 -> update type,brand,price. If the user enters 4, the prompt stops. Based on the input, the setters 
 *   are used to update the values. Note: here also we check for valid type of appliance.
 *   
 *3) Prompt the user for a brand name and display all appliances with that brand name using the findAppliancesBy(String b, Appliance[] a)
 *   method. Note: also check if the brand exists or not and displays message that it doesnt exist.
 *   
 *4) Prompt the user for a price and display all appliances that have lower price than the value entered using the 
 *   findCheaperThan(double p, Appliance[] a) method. Also checks if cheaper brands exists and displays message if it doesnt exist.
 *   
 *5) Exits (terminates) the program.
 *
 *The program also checks if the user enters a valid value between 1-5 and informs the user if invalid value is entered and keeps
 *prompting until a valid value is entered.
 *
 */

public class DriverClass {
	
	/**
	 * @param args - an array of sequence of characters (Strings)
	 */
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		final String PASS = "c249";
		
		int tries = 0;  //counter for option 1 
		
		System.out.println("WELCOME TO APPLIANCE INVENOTRY MANAGEMENT (created by Syed Ayaan Jilani)\n");
		
		System.out.print("Please enter the maximum number of appliances your store can contain : ");
		int maxAppliances = input.nextInt();
		input.nextLine();
		
		Appliance[] inventory = new Appliance[maxAppliances];
		
		String menu = "\nWhat do you want to do?\n"
				+ "1. Enter new appliances (password required)\n"
				+ "2. Change information of an appliance (password required)\n"
				+ "3. Display all appliances by a specific brand\n"
				+ "4. Display all appliances under a certain a price.\n"
				+ "5. Quit\n"
				+ "Please enter your choice >";
		
		while(true) {
			
			System.out.print(menu);
			
			int choice = input.nextInt();
			input.nextLine();
			
			if (choice == 1) {
				
				boolean access = false;
				
				for(int i = 0 ; i<3 && !access ; i++) {
					
					access = true;
					
					System.out.print("\nPlease enter the password : ");
					
					if (input.nextLine().equals(PASS)) {
						
						tries = 0;
						
						while (true) {
							
							System.out.print("\nHow many appliances do you want to enter ?");
							
							int n = input.nextInt();
							input.nextLine();
							
							if (n > inventory.length - Appliance.findNumberOfCreatedAppliances()) { //check if space is there for n objects to be added
								System.out.println("\nThe number of appliances exceeds the store inventory");
								System.out.println("Max number of Appliances : " + inventory.length);
								System.out.println("No of created appliances : " + Appliance.findNumberOfCreatedAppliances());
								System.out.println("Please try again\n");
							}
							
							else if (n<0){
								System.out.println("Please enter a valid number (>0)");
							}
							
							else {
								
								for (int j = 0 ; j < n ; j ++) {
									
									String t;
									while (true) {
										System.out.print("\nEnter the type : ");
										t = input.nextLine();
								
										if (Appliance.checkValidType(t)) { //checks for type validity
											break;
										}
										else {
											System.out.println("Invalid appliance type. Please try again.");
										}
									}
									
									System.out.print("Enter the brand name : ");
									String b = input.nextLine();
									
									System.out.print("Enter the price : ");
									double p = input.nextDouble();
									input.nextLine();
									
									inventory[Appliance.findNumberOfCreatedAppliances()] = new Appliance(t,b,p);
									
								}
								
								System.out.println("\nSuccess! " + n + " appliances added to inventory.");
								
								break;
							}
							
						}
						
					}
					
					else {
						System.out.println("Incorrect password.");
						tries++;
					}
					
					if (tries == 12) {
						System.out.println("\nProgram detected suspicious activities and will terminate immediately!");
						System.exit(0);
					}
			
				}
				
			}
			
			else if (choice == 2) {
				
				boolean access = false;
				
				for(int i = 0 ; i<3 && !access; i++) {
					
					access = true;
		
					System.out.print("\nPlease enter the password : ");
		
					if (input.nextLine().equals(PASS)) {
					
						System.out.print("\nEnter the Serial Number of the appliance you wish to update : ");
						long serialNumber = input.nextLong();
						input.nextLine();
						
						Appliance obj = Appliance.checkBySerialNumber(serialNumber, inventory); //checks if appliance exists
						
						if (obj!=null) {
							
							System.out.println("Appliance Serial # " + obj.getSl_no() + "\n"
									+ "Brand: "+ obj.getBrand() + "\n"
									+ "Type: " + obj.getType() + "\n"
									+ "Price: "+ obj.getPrice());
							
							while (true) {
								
								System.out.print("What information would you like to change?\n"
										+ "1. brand\n"
										+ "2. type\n"
										+ "3. price\n"
										+ "4. Quit\n"
										+ "Enter your choice >");
								
								int c = input.nextInt();
								input.nextLine();
								
								if (c==1) {
									System.out.print("Enter the updated brand name : ");
									obj.setBrand(input.nextLine());
									System.out.println("Information updated\n");
								}
								
								else if (c==2) {
									System.out.print("Enter the updated type name : ");
									String t = input.nextLine();
									if (Appliance.checkValidType(t)) { //checks type validity
										obj.setType(t);
										System.out.println("Information updated\n");
									}
									else {
										System.out.println("Incorrect type. Please try again.\n");
									}
								}
								
								else if (c==3) {
									System.out.print("Enter the updated price : ");
									obj.setPrice(input.nextDouble()); // will assign 1$ by default if input <1$
									input.nextLine();
									System.out.println("Information updated\n");
								}
								
								else if (c==4) {
									break;
								}
								
								else {
									System.out.println("Please enter a valid choice between 1-4\n");
								}
							}
						}
						else {System.out.println("\nAppliance with the given serial number does not exist.");}
					}
					else {System.out.println("Incorrect pass");}
				}
			}
			
			else if (choice == 3) {
				System.out.print("Enter the Brand name of your appliance : ");
				Appliance.findAppliancesBy(input.nextLine(), inventory);
			}
			
			else if (choice == 4) {
				System.out.print("Enter the Price of your appliance : ");
				Appliance.findCheaperThan(input.nextDouble(), inventory);
				input.nextLine();
			}
			
			else if (choice == 5) {
				System.out.println("\nTHANKYOU FOR USING THE APPLIANCE INVENOTRY MANAGEMENT");
				break;
			}
			
			else {
				System.out.println("Please enter a valid choice between 1-5\n");
			}
		
		}input.close();
		
	}
}


