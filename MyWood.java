
public class MyWood implements Wood {
	private static String m_name;
	private static Point m_start;
	Woodman m_woodmanList;
	private char [][] m_wood;

	public MyWood(char[][] wood) {
		m_wood=wood;
	}

	public void createWoodman(String name, Point start) {
		m_name = name;
		m_start=start;
	}

	public Action move(String name, Direction direction) {
		Action result=null;
		if (name!=m_name) {
			result=Action.WoodmanNotFound;
		} else {
			if (direction==Direction.Up) {
				m_wood[m_start.getX()][m_start.getY()]=m_wood[m_start.getX()-1][m_start.getY()]; 
				if (m_wood[m_start.getX()-1][m_start.getY()]=='K') {
					result=Action.Dead;
				}
				if (m_wood[m_start.getX()-1][m_start.getY()]=='1') {
					result=Action.Fail;
				}
				if (m_wood[m_start.getX()-1][m_start.getY()]=='0') {
					result=Action.Ok;
				}
				if (m_wood[m_start.getX()-1][m_start.getY()]=='L') {
					result=Action.Life;
				}
			}

			if (direction==Direction.Down) {
				m_wood[m_start.getX()][m_start.getY()]=m_wood[m_start.getX()+1][m_start.getY()]; 
				if (m_wood[m_start.getX()+1][m_start.getY()]=='K') {
					result=Action.Dead;
				}
				if (m_wood[m_start.getX()+1][m_start.getY()]=='1') {
					result=Action.Fail;
				}
				if (m_wood[m_start.getX()+1][m_start.getY()]=='0') {
					result=Action.Ok;
				}
				if (m_wood[m_start.getX()+1][m_start.getY()]=='L') {
					result=Action.Life;
				}
			}

			if (direction==Direction.Left) {
				m_wood[m_start.getX()][m_start.getY()]=m_wood[m_start.getX()][m_start.getY()-1]; 
				if (m_wood[m_start.getX()][m_start.getY()-1]=='K') {
					result=Action.Dead;
				}
				if (m_wood[m_start.getX()][m_start.getY()-1]=='1') {
					result=Action.Fail;
				}
				if (m_wood[m_start.getX()][m_start.getY()-1]=='0') {
					result=Action.Ok;
				}
				if (m_wood[m_start.getX()][m_start.getY()-1]=='L') {
					result=Action.Life;
				}
			}

			if (direction==Direction.Right) {
				m_wood[m_start.getX()][m_start.getY()]=m_wood[m_start.getX()][m_start.getY()+1]; 
				if (m_wood[m_start.getX()][m_start.getY()+1]=='K') {
					result=Action.Dead;
				}
				if (m_wood[m_start.getX()][m_start.getY()+1]=='1') {
					result=Action.Fail;
				}
				if (m_wood[m_start.getX()][m_start.getY()+1]=='0') {
					result=Action.Ok;
				}
				if (m_wood[m_start.getX()][m_start.getY()+1]=='L') {
					result=Action.Life;
				}
			}
			if (direction==Direction.None) {

				if (m_wood[m_start.getX()][m_start.getY()]=='K') {
					result=Action.Dead;
				}
				if (m_wood[m_start.getX()][m_start.getY()]=='1') {
					result=Action.Fail;
				}
				if (m_wood[m_start.getX()][m_start.getY()]=='0') {
					result=Action.Ok;
				}
				if (m_wood[m_start.getX()][m_start.getY()]=='L') {
					result=Action.Life;
				}
			}	
		}
		if (result==Action.Dead)
			if (result==Action.Dead)
				if (result==Action.Dead) 
					result=Action.WoodmanNotFound;
		
		return result;
	}
}
