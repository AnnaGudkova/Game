import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class MyWoodLoader implements WoodLoader {

	private char[][] m_wood;
	MyWood world=new MyWood(m_wood);	

		public Wood Load(InputStream stream) throws IOException, CodeException {
		int n=0;
		int m=0;
		List<String> list = new LinkedList<String>();
		Scanner sc= new Scanner(new InputStreamReader(stream,"utf8"));
		try {
			n=sc.nextLine().length();
			list.add(sc.toString());
			while(sc.hasNextLine()) { {
				list.add(sc.nextLine());
				m++;
			}
				if(sc.nextLine().length()==n){
					m_wood=new char[n][m];
					for (int i=0;i<m;i++){
						
						m_wood[i]=list.get(i).toCharArray();	
						}
				} else throw new CodeException("Input correct world!");
			}
		} finally	{
			sc.close();	
		}
			return world;
	}
}

