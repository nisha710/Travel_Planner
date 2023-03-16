package Travel;

import java.util.*;
public class User {
	int choice1;
	String startLocation;
	String destination;
	String route;

	Scanner scn = new Scanner(System.in);
	Graph graph = new Graph(true,true,true,true,true,true,true);

	public void userLogin() {
		System.out.println(graph.cities.size());
		System.out.println("YOU ARE LOGGED IN AS USER");
		System.out.println("1.MAKE A TRIP");
		System.out.println("2.SHOW PREVIOUS TRIPS");
		System.out.print("\nENTER YOUR CHOICE: ");
		choice1 = scn.nextInt();

		switch(choice1) {
		case 1:
			makeTrip();
			break;
		case 2:
			prevTrip();
			break;
		}
	}

	public void makeTrip() {
		int choice;
		City check_sLocation = null;
		City check_destination = null;
		String check_route;
		System.out.print("\nENTER START LOCATION: ");
		startLocation = scn.next();
		check_sLocation=checkCity(startLocation);
		if(check_sLocation!=null) {
			System.out.print("\nENTER DESTINATION: ");
			destination = scn.next();
			check_destination=checkDestination(destination);
			if(check_destination!=null) {
				System.out.print("\nENTER ROUTE (BUS/TRAIN): ");
				route = scn.next();
				if(route.equalsIgnoreCase("bus") || route.equalsIgnoreCase("train")) {
					System.out.println("\nYOU HAVE BOOKED FOR "+route.toUpperCase()+"!!");
				}
				while(!route.equalsIgnoreCase("bus") && !route.equalsIgnoreCase("train")) {		
					System.out.print("\nINVALID ROUTE SELECTED!!\nENTER VAILD ROUTE (BUS/TRAIN) OR TO EXIT TYPE EXIT: ");
					route = scn.next();
					if(route.equalsIgnoreCase("exit")) {
						System.out.println("\nYOU HAVE QUIT SUCCESSFULLY!!!");
						break;
				}
					else if(route.equalsIgnoreCase("bus") || route.equalsIgnoreCase("train")) {
						System.out.println("\nYOU HAVE BOOKED FOR "+route.toUpperCase()+"!!");
					}
				}
			}
		}
	}
	public City checkCity(String city) {
		City checksLocation=null;
		checksLocation = graph.getCityByValue(city);
		int choice=0;
		while(checksLocation==null) {
			System.out.println("\nCITY NOT PRESENT");
			System.out.print("STILL WANT TO CONTINUE???\nPRESS 1 FOR EXIT: ");
			choice = scn.nextInt();
			if(choice!=1) {
				System.out.print("\nENTER START LOCATION: ");
				city = scn.next();
				checksLocation = graph.getCityByValue(city
						);
			}
			else {
				System.out.println("\nYOU HAVE QUIT SUCCESSFULLY!!!");
				break;
			}

		}
		return checksLocation;
	}
	public City checkDestination(String city) {
		City checksLocation=null;
		checksLocation = graph.getCityByValue(city);
		int choice=0;
		while(checksLocation==null) {
			System.out.println("\nCITY NOT PRESENT");
			System.out.print("STILL WANT TO CONTINUE???\nPRESS 1 FOR EXIT: ");
			choice = scn.nextInt();
			if(choice!=1) {
				System.out.print("\nENTER DESTINATION: ");
				city = scn.next();
				checksLocation = graph.getCityByValue(city);
			}
			else {
				System.out.println("\nYOU HAVE QUIT SUCCESSFULLY!!!");
				break;
			}

		}
		return checksLocation;
	}

	public void prevTrip() {

	}
}