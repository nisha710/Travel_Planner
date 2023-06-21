package Travel;

import java.util.LinkedList;

public class GraphTraversal {
public static void depthFirstTraversal(City start,LinkedList<City> visitedCities) {
	System.out.println(start.getCity());
	for(Routes e:start.getRoutes()) {
		City neighbour=e.getEnd();
		if(!visitedCities.contains(neighbour)) {
			visitedCities.add(neighbour);
			GraphTraversal.depthFirstTraversal(neighbour, visitedCities);
		}
	}
}

public static void main(String args[]) {
	TestGraph test=new TestGraph();
	City startingCity=test.getStartingCiy();
	LinkedList<City> visitedCities=new LinkedList<City>();
	visitedCities.add(startingCity);
	GraphTraversal.depthFirstTraversal(startingCity,visitedCities);
}
}
