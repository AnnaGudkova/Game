import static org.junit.Assert.*;

import org.junit.Test;


public class MyWoodLoaderTest {

	@Test
	public void testLoad() {
		char[][] wood;
		MyWood W=new MyWood(wood); //экземпляр класса Wood
		Point k=new Point(1,1);
		W.createWoodman("A", k);
		assertTrue(W.move("A",Direction.Down) == Action.Fail);
		}
}
