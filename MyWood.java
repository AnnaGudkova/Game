import java.util.HashMap;
import java.util.Map;

public class MyWood implements Wood {
	Map <String,MyWoodman> m_woodmanList=new HashMap<String,MyWoodman>();
	private char [][] m_wood;

	public MyWood(char[][] wood) {
		m_wood=wood;
	}

	public void createWoodman(String name, Point start) {
		MyWoodman m_woodman=new MyWoodman(name,start);
		m_woodmanList.put(name,m_woodman);		
	}

	public Action move(String name, Direction direction) {
		Action result=null;
		String new_name;
		new_name=(m_woodmanList.get(name)).GetName();
		if (name!=new_name) {
			result=Action.WoodmanNotFound;
		} else {
			if(m_woodmanList.get(name).GetLifeCount()>-1) {
				if (direction==Direction.Up) {
					Point n=m_woodmanList.get(name).GetLocation();
					if (m_wood[m_woodmanList.get(name).GetLocation().getX()-1][m_woodmanList.get(name).GetLocation().getY()]=='K') {
						m_woodmanList.get(name).Kill();
						result=Action.Dead;
					}
					if (m_wood[m_woodmanList.get(name).GetLocation().getX()-1][m_woodmanList.get(name).GetLocation().getY()]=='1') {
						result=Action.Fail;
					}
					if (m_wood[m_woodmanList.get(name).GetLocation().getX()-1][m_woodmanList.get(name).GetLocation().getY()]=='0') {
						result=Action.Ok;
						m_woodmanList.get(name).SetLocation(n); 
					}
					if (m_wood[m_woodmanList.get(name).GetLocation().getX()-1][m_woodmanList.get(name).GetLocation().getY()]=='L') {
						m_woodmanList.get(name).AddLife();
						result=Action.Life;
						m_woodmanList.get(name).SetLocation(n); 
					}
				}

				if (direction==Direction.Down) {
					Point n=new Point(m_woodmanList.get(name).GetLocation().getX()+1,m_woodmanList.get(name).GetLocation().getY());
					if (m_wood[m_woodmanList.get(name).GetLocation().getX()+1][m_woodmanList.get(name).GetLocation().getY()]=='K') {
						m_woodmanList.get(name).Kill();
						result=Action.Dead;
					}
					if (m_wood[m_woodmanList.get(name).GetLocation().getX()+1][m_woodmanList.get(name).GetLocation().getY()]=='1') { 
						result=Action.Fail;
					}
					if (m_wood[m_woodmanList.get(name).GetLocation().getX()+1][m_woodmanList.get(name).GetLocation().getY()]=='0') {
						result=Action.Ok;
						m_woodmanList.get(name).SetLocation(n); 
					}
					if (m_wood[m_woodmanList.get(name).GetLocation().getX()+1][m_woodmanList.get(name).GetLocation().getY()]=='L') {
						m_woodmanList.get(name).AddLife();
						result=Action.Life;
					}
				}

				if (direction==Direction.Left) {
					Point n=new Point(m_woodmanList.get(name).GetLocation().getX(),m_woodmanList.get(name).GetLocation().getY()-1);
					if (m_wood[m_woodmanList.get(name).GetLocation().getX()][m_woodmanList.get(name).GetLocation().getY()-1]=='K') {
						m_woodmanList.get(name).Kill();
						result=Action.Dead;
					}
					if (m_wood[m_woodmanList.get(name).GetLocation().getX()][m_woodmanList.get(name).GetLocation().getY()-1]=='1') {
						result=Action.Fail;
					}
					if (m_wood[m_woodmanList.get(name).GetLocation().getX()][m_woodmanList.get(name).GetLocation().getY()-1]=='0') {
						m_woodmanList.get(name).SetLocation(n); 
						result=Action.Ok;
					}
					if (m_wood[m_woodmanList.get(name).GetLocation().getX()][m_woodmanList.get(name).GetLocation().getY()-1]=='L') {
						m_woodmanList.get(name).AddLife();
						result=Action.Life;
						m_woodmanList.get(name).SetLocation(n); 
					}
				}

				if (direction==Direction.Right) {
					Point n=new Point(m_woodmanList.get(name).GetLocation().getX(),m_woodmanList.get(name).GetLocation().getY()+1);
					if (m_wood[m_woodmanList.get(name).GetLocation().getX()][m_woodmanList.get(name).GetLocation().getY()+1]=='K') {
						m_woodmanList.get(name).Kill();
						result=Action.Dead;
					}
					if (m_wood[m_woodmanList.get(name).GetLocation().getX()][m_woodmanList.get(name).GetLocation().getY()+1]=='1') {
						result=Action.Fail;
					}
					if (m_wood[m_woodmanList.get(name).GetLocation().getX()][m_woodmanList.get(name).GetLocation().getY()+1]=='0') {
						m_woodmanList.get(name).SetLocation(n); 
						result=Action.Ok;
					}
					if (m_wood[m_woodmanList.get(name).GetLocation().getX()][m_woodmanList.get(name).GetLocation().getY()+1]=='L') {
						m_woodmanList.get(name).AddLife();
						result=Action.Life;
						m_woodmanList.get(name).SetLocation(n); 
					}
				} 			
				if (direction==Direction.None) {

					if (m_wood[m_woodmanList.get(name).GetLocation().getX()][m_woodmanList.get(name).GetLocation().getY()]=='K') {
						m_woodmanList.get(name).Kill();
						result=Action.Dead;
					}
					if (m_wood[m_woodmanList.get(name).GetLocation().getX()][m_woodmanList.get(name).GetLocation().getY()]=='1') {
						result=Action.Fail;
					}
					if (m_wood[m_woodmanList.get(name).GetLocation().getX()][m_woodmanList.get(name).GetLocation().getY()]=='0') { 
						result=Action.Ok;
					}
					if (m_wood[m_woodmanList.get(name).GetLocation().getX()][m_woodmanList.get(name).GetLocation().getY()]=='L') {
						m_woodmanList.get(name).AddLife();
						result=Action.Life;
					}
				}	
			} else
				result=Action.WoodmanNotFound;
		}
		return result;
	}
}
