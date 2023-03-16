package Travel;

import java.util.LinkedList;
import java.util.Scanner;
public class Graph {
	//data-city,Edges-Routes,vertex-City
	static LinkedList<City> cities;
	boolean isBusDist,isTrainDist,isBusCost,isTrainCost,isBusTime,isTrainTime;//isbusDist
	boolean isDirected;
	
	public Graph(boolean isBusDist,boolean isTrainDist,boolean isBusCost,boolean isTrainCost,boolean isBusTime,boolean isTrainTime
			,boolean isDirected) {
		this.cities=new LinkedList<City>();
		this.isBusDist=isBusDist;
		this.isTrainDist=isTrainDist;
		this.isBusCost=isBusCost;
		this.isTrainCost=isTrainCost;
		this.isBusTime=isBusTime;
		this.isTrainTime=isTrainTime;
		this.isDirected=isDirected;
	}

	public City addCity(String city) {
		City newCity=new City(city);
		this.cities.add(newCity);
		return newCity;
	}

	public void addRoute(City city1,City city2,Integer busDist,Integer trainDist,Integer busCost,
			Integer trainCost,Integer busTime,Integer trainTime) {//provides abstraction 
		//ata purta fakt busdist consider kela in future will add
		if(!this.isBusDist) {//if dist not given consider it as null
			busDist=null;
		}
		city1.addRoutes(city2,busDist,trainDist,busCost,
				trainCost,busTime,trainTime);
		if(!this.isDirected) {
			city2.addRoutes(city1,busDist,trainDist,busCost,
					trainCost,busTime,trainTime);
		}	
	}
	public void removeRoute(City city1,City city2) {
		city1.removeRoutes(city2);
		if(!this.isDirected) {
			city2.removeRoutes(city1);
		}
	}

	public void removeCity(City city) {
		this.cities.remove(city);
	}

	public LinkedList<City> getCities(){
		return this.cities;
	}

	public boolean isBusDist() {
		return this.isBusDist;
	}

	public boolean isTrainDist() {
		return this.isTrainDist;
	}

	//	public boolean isBusCost() {
	//		return this.isBusCost;
	//	}

	public boolean isTrainCost() {
		return this.isTrainCost;
	}

	public boolean isBusTime() {
		return this.isBusTime;
	}

	public boolean isTrainTime() {
		return this.isTrainTime;
	}

	public boolean isDirected() {
		return this.isDirected;
	}


	public City getCityByValue(String value) {//to check whether city 
		//is present or not
		//System.out.println("hi");
		for(City c:this.cities) {
			//System.out.println("hi");
			if(c.getCity().equals(value)) {
				return c;
				
			}
		
		}
		return null;



		
	}

	public void print() {
		int i=0;
		for(City c: this.cities) {
			if(i<1) {
				c.print(isBusDist);
				i++;}//fakt isBusDist sathi lihila in future baki karu
		}
		
	}
	
	
	String Checkpassword(String password) {
		Scanner scan=new Scanner(System.in);
		int exit=0;
		while(!password.equals("sam")){
			System.out.print("\nTO EXIT PRESS 1: ");
			exit=scan.nextInt();
			if(exit==1) {
				System.out.println("YOU HAVE EXIT SUCCESSFULLY!!");
				break;
			}
			else {
				System.out.print("\nPLEASE ENTER VALID PASSWORD: ");
				password = scan.next();
			}
		}

		return password;
	}
	public static void main(String[] args) {
		Graph busNetwork = new Graph(true, true, true, true, true, true, true);
		//when isDirected is false undirected is considered
		//this line might be wrong was like isBusDist:true but was giving error 
		//so wrote like this
		User user=new User();
		City MumbaiStation=busNetwork.addCity("Mumbai");
		City PuneStation=busNetwork.addCity("Pune");
		City DelhiStation=busNetwork.addCity("Delhi");
		City NagpurStation=busNetwork.addCity("Nagpur");
		busNetwork.addRoute(MumbaiStation,PuneStation,300,400,30,40,3,4);
		busNetwork.addRoute(PuneStation,DelhiStation,500,600,30,40,3,4);
		busNetwork.addRoute(DelhiStation,NagpurStation,500,600,30,40,3,4);
		
		
		Scanner scan=new Scanner(System.in);
		int choice=0;
		System.out.println("********************WELCOME TO TRAVEL PLANNER********************"
				+ "\n1.ADMIN LOGIN\n2.USER LOGIN\n");
		System.out.print("ENTER YOUR CHOICE: ");
		choice=scan.nextInt();
		scan.nextLine();
		switch(choice) {
		case 1:
			String password;
			System.out.print("\nPLEASE ENTER PASSWORD: ");
			password = scan.nextLine();
			password=busNetwork.Checkpassword(password);
			busNetwork.print();
			break;//sysout ctr+space
		case 2:
			
			user.userLogin();
			break;
		default:
			System.out.println("PLEASE ENTER VALID CHOICE!!");
		}
		
		//busNetwork.print();
		//System.out.println(City.routes.size());z
	}
}
