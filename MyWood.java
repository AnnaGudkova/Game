import java.util.HashMap;
import java.util.Map;


public class MyWood implements Wood {
	private static String m_name;
	private static Point m_start;
	MyWoodman m_woodman;
	Map <String,MyWoodman> m_woodmanList=new HashMap<String,MyWoodman>();
	private char [][] m_wood;
	
	public MyWood(char[][] wood) {
		m_wood=wood;
	}

	public void createWoodman(String name, Point start) {
		m_name = name;
		m_start=start;
		m_woodman=new MyWoodman(m_name,m_start);
		m_woodmanList.put(m_name,m_woodman);		
	}

	public Action move(String name, Direction direction) {
		Action result=null;
		MyWoodman nn=m_woodmanList.get(m_name);
		if (name!=nn.GetName()) {
			result=Action.WoodmanNotFound;
		} else {
			if(m_woodman.GetLifeCount()>-1) {
				if (direction==Direction.Up) {
					Point n=new Point(m_start.getX()-1,m_start.getY());
					if (m_wood[m_start.getX()-1][m_start.getY()]=='K') {
						m_woodman.Kill();
						result=Action.Dead;
					}
					if (m_wood[m_start.getX()-1][m_start.getY()]=='1') {
						result=Action.Fail;
					}
					if (m_wood[m_start.getX()-1][m_start.getY()]=='0') {
						result=Action.Ok;
						m_woodman.SetLocation(n); 
					}
					if (m_wood[m_start.getX()-1][m_start.getY()]=='L') {
						m_woodman.AddLife();
						result=Action.Life;
						m_woodman.SetLocation(n); 
					}
				}

				if (direction==Direction.Down) {
					Point n=new Point(m_start.getX()+1,m_start.getY());
					if (m_wood[m_start.getX()+1][m_start.getY()]=='K') {
						m_woodman.Kill();
						result=Action.Dead;
					}
					if (m_wood[m_start.getX()+1][m_start.getY()]=='1') { 
						result=Action.Fail;
					}
					if (m_wood[m_start.getX()+1][m_start.getY()]=='0') {
						result=Action.Ok;
						m_woodman.SetLocation(n); 
					}
					if (m_wood[m_start.getX()+1][m_start.getY()]=='L') {
						m_woodman.AddLife();
						result=Action.Life;
					}
				}

				if (direction==Direction.Left) {
					Point n=new Point(m_start.getX(),m_start.getY()-1);
					if (m_wood[m_start.getX()][m_start.getY()-1]=='K') {
						m_woodman.Kill();
						result=Action.Dead;

					}
					if (m_wood[m_start.getX()][m_start.getY()-1]=='1') {
						result=Action.Fail;
					}
					if (m_wood[m_start.getX()][m_start.getY()-1]=='0') {
						m_woodman.SetLocation(n); 
						result=Action.Ok;
					}
					if (m_wood[m_start.getX()][m_start.getY()-1]=='L') {
						m_woodman.AddLife();
						result=Action.Life;
						m_woodman.SetLocation(n); 
					}
				}

				if (direction==Direction.Right) {
					Point n=new Point(m_start.getX(),m_start.getY()+1);
					if (m_wood[m_start.getX()][m_start.getY()+1]=='K') {
						m_woodman.Kill();
						result=Action.Dead;

					}
					if (m_wood[m_start.getX()][m_start.getY()+1]=='1') {
						result=Action.Fail;
					}
					if (m_wood[m_start.getX()][m_start.getY()+1]=='0') {
						m_woodman.SetLocation(n); 
						result=Action.Ok;
					}
					if (m_wood[m_start.getX()][m_start.getY()+1]=='L') {
						m_woodman.AddLife();
						result=Action.Life;
						m_woodman.SetLocation(n); 
					}
				} 			
				if (direction==Direction.None) {

					if (m_wood[m_start.getX()][m_start.getY()]=='K') {
						m_woodman.Kill();
						result=Action.Dead;


					}
					if (m_wood[m_start.getX()][m_start.getY()]=='1') {
						result=Action.Fail;
					}
					if (m_wood[m_start.getX()][m_start.getY()]=='0') { 
						result=Action.Ok;
					}
					if (m_wood[m_start.getX()][m_start.getY()]=='L') {
						m_woodman.AddLife();
						result=Action.Life;
						
					}
				}	
			} else
				result=Action.WoodmanNotFound;
		}

		return result;
	}
}
