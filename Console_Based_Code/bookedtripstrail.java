package Travel;

public class bookedtripstrail {
	void a() {
		User u=new User();
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Graph g=new Graph(true,true,true,true,true,true,true);
g.addcityy();
User u=new User();
Dijikstra dj=new Dijikstra();
//String startLocation;
//String destination;
u.c();
System.out.println(u.aa);
System.out.println(u.check_sLocation);

dj.shortestPathBetween(g, u.aa,u.bb);



	}

}
