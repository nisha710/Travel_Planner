package Travel;

public class TestGraph {
	private Graph testGraph;
	
	public TestGraph() {
		this.testGraph=new Graph(false,true,true,true,true,true,true);
		City startnode=testGraph.addCity("c0.0.0");//city:"v0.0.0"
		City c1=this.testGraph.addCity("c1.0.0");
		City c2=this.testGraph.addCity("c2.0.0");
		
		City c11=testGraph.addCity("c1.1.0");
		City c12=testGraph.addCity("c1.2.0");
		City c21=testGraph.addCity("c2.1.0");
		
		City c111=testGraph.addCity("c1.1.1");
		City c112=testGraph.addCity("c1.1.2");
		City c121=testGraph.addCity("c1.2.1");
		City c211=testGraph.addCity("c2.1.1");
		
		this.testGraph.addRoutes(startnode,c1,null,null,null,null,null,null);//weight:null
		this.testGraph.addRoutes(startnode,c2,null,null,null,null,null,null);//weight:null
		this.testGraph.addRoutes(c1,c11,null,null,null,null,null,null);//weight:null
		this.testGraph.addRoutes(c1,c12,null,null,null,null,null,null);//weight:null
		this.testGraph.addRoutes(c2,c21,null,null,null,null,null,null);//weight:null
		this.testGraph.addRoutes(c11,c111,null,null,null,null,null,null);//weight:null
		this.testGraph.addRoutes(c11,c112,null,null,null,null,null,null);//weight:null
		this.testGraph.addRoutes(c12,c121,null,null,null,null,null,null);//weight:null
		this.testGraph.addRoutes(c21,c211,null,null,null,null,null,null);//weight:null
		
		//create a cycle
		testGraph.addRoutes(c211, c2, null, null, null, null, null, null);
	}
	public City getStartingCiy() {
		return testGraph.getCities().get(0);//index:0
	}
}
