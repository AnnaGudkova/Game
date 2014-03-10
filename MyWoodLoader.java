import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class MyWoodLoader implements WoodLoader {

	private char[][] m_wood;
    Wood world;	
    
    public MyWoodLoader(char[][] wood) {
    	m_wood=wood;
    	
	}
	private Wood Wood(char[] m_wood2) {
		return world=Wood(m_wood2);
	}
	public Wood Load(InputStream stream) throws IOException, CodeException {
		File file = new File("world.txt");
		Scanner sc= new Scanner(new InputStreamReader(new FileInputStream(file),"utf8"));
		 try {
			String a=sc.nextLine();
			while (sc.nextLine() != null) {		
				for (int j=0;j<m_wood.length;j++)  
				{
					m_wood[j]=a.toCharArray();
					world=Wood(m_wood[j]);
				}
			}
		} finally	{
			sc.close();	
		}
		return world;
	}
}

