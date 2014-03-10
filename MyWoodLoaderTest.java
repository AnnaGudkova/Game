import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.junit.Test;

public class MyWoodLoaderTest {

	@Test
	public void testLoad() {
		Wood W =WoodLoader.Load(new FileInputStream("world.txt"));
		//MyWood W=new MyWood(wood); 
		Point k=new Point(1,1);
		W.createWoodman("A", k);
		assertEquals(W.move("A",Direction.Down) , Action.Fail);
		}
}
