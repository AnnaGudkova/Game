
public class MyWood implements Wood {
	private static String m_name;
	private static Point m_start;
	MyWoodman m_woodmanList;
	private char [][] m_wood;

	public MyWood(char[][] wood) {
		m_wood=wood;
	}

	public void createWoodman(String name, Point start) {
		m_name = name;
		m_start=start;
		m_woodmanList=new MyWoodman(m_name,m_start);
	}

	public Action move(String name, Direction direction) {
		Action result=null;
		String new_name;
		new_name=m_woodmanList.GetName();
		if (name!=new_name) {
			result=Action.WoodmanNotFound;
		} else {
			if(m_woodmanList.GetLifeCount()>-1){
			if (direction==Direction.Up) {//Point k=m_woodmanList.GetLocation();
				Point n=new Point(m_start.getX()-1,m_start.getY());
				if (m_wood[m_start.getX()-1][m_start.getY()]=='K') {
					m_woodmanList.Kill();
					if(m_woodmanList.GetLifeCount()>-1) result=Action.Dead;
					else
						result=Action.WoodmanNotFound;
				}
				if (m_wood[m_start.getX()-1][m_start.getY()]=='1') {
					m_woodmanList.SetLocation(n); 
					result=Action.Fail;
				}
				if (m_wood[m_start.getX()-1][m_start.getY()]=='0') {
					
					result=Action.Ok;
					m_woodmanList.SetLocation(n); 
				}
				if (m_wood[m_start.getX()-1][m_start.getY()]=='L') {
					m_woodmanList.AddLife();
					result=Action.Life;
				}
			}

			if (direction==Direction.Down) {
				//m_wood[m_start.getX()][m_start.getY()]=m_wood[m_start.getX()+1][m_start.getY()]; 
				Point n=new Point(m_start.getX()+1,m_start.getY());
				if (m_wood[m_start.getX()+1][m_start.getY()]=='K') {
					m_woodmanList.Kill();
					if(m_woodmanList.GetLifeCount()>-1) result=Action.Dead;
					else
						result=Action.WoodmanNotFound;
				}
				if (m_wood[m_start.getX()+1][m_start.getY()]=='1') {
					m_woodmanList.SetLocation(n); 
					result=Action.Fail;
				}
				if (m_wood[m_start.getX()+1][m_start.getY()]=='0') {
					
					result=Action.Ok;
					m_woodmanList.SetLocation(n); 
				}
				if (m_wood[m_start.getX()+1][m_start.getY()]=='L') {
					m_woodmanList.AddLife();
					result=Action.Life;
				}
			}

			if (direction==Direction.Left) {
				Point n=new Point(m_start.getX(),m_start.getY()-1);
				//m_wood[m_start.getX()][m_start.getY()]=m_wood[m_start.getX()][m_start.getY()-1]; 
				if (m_wood[m_start.getX()][m_start.getY()-1]=='K') {
					m_woodmanList.Kill();
					if(m_woodmanList.GetLifeCount()>-1) result=Action.Dead;
					else
						result=Action.WoodmanNotFound;
				}
				if (m_wood[m_start.getX()][m_start.getY()-1]=='1') {
					m_woodmanList.SetLocation(n); 
					result=Action.Fail;
				}
				if (m_wood[m_start.getX()][m_start.getY()-1]=='0') {
					m_woodmanList.SetLocation(n); 
					result=Action.Ok;
				}
				if (m_wood[m_start.getX()][m_start.getY()-1]=='L') {
					m_woodmanList.AddLife();
					result=Action.Life;
				}
			}

			if (direction==Direction.Right) {
				Point n=new Point(m_start.getX(),m_start.getY()+1);
				//m_wood[m_start.getX()][m_start.getY()]=m_wood[m_start.getX()][m_start.getY()+1]; 
				
				if (m_wood[m_start.getX()][m_start.getY()+1]=='K') {
					m_woodmanList.Kill();
					 result=Action.Dead;
					
				}
				if (m_wood[m_start.getX()][m_start.getY()+1]=='1') {
					m_woodmanList.SetLocation(n); 
					result=Action.Fail;
				}
				if (m_wood[m_start.getX()][m_start.getY()+1]=='0') {
					m_woodmanList.SetLocation(n); 
					result=Action.Ok;
				}
				if (m_wood[m_start.getX()][m_start.getY()+1]=='L') {
					m_woodmanList.AddLife();
					result=Action.Life;
				}
			} 			
			if (direction==Direction.None) {

				if (m_wood[m_start.getX()][m_start.getY()]=='K') {
					m_woodmanList.Kill();
					if(m_woodmanList.GetLifeCount()>-1) result=Action.Dead;
					else
						result=Action.WoodmanNotFound;

				}
				if (m_wood[m_start.getX()][m_start.getY()]=='1') {
					result=Action.Fail;
				}
				if (m_wood[m_start.getX()][m_start.getY()]=='0') { 
					result=Action.Ok;
				}
				if (m_wood[m_start.getX()][m_start.getY()]=='L') {
					m_woodmanList.AddLife();
					result=Action.Life;
				}
			}	
		} else
			result=Action.WoodmanNotFound;
		}

		return result;
	}
}
