
public class MyWoodman implements Woodman {

	private int m_life_count;
	private static Point m_start;
	private Point m_location;
	private static String m_name;

	public MyWoodman(String name, Point start) {
		m_life_count=3;
		m_start=m_location=start;
		m_name=name;
	}

	public int GetLifeCount() {
		return m_life_count;
	}


	public String GetName() {
		return m_name;
	}


	public boolean Kill() {
		m_life_count=m_life_count-1;
		if (m_life_count>-1)
			return true;
		else
			return false;
	}


	public void AddLife() {
		m_life_count=m_life_count+1;
	}

	//�������������� ��������� �� ������� ����.
	public Point GetLocation() {
		return m_location;
	}

	//���������� ����� �������������� ��������� �� ������� ����.
	public void SetLocation(Point location) {
		m_location=location;
	}

	//����������� ������ � ��������� �����
	public void MoveToStart() {
		m_location=m_start;
	}

}
