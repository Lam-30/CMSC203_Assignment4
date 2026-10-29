import static org.junit.Assert.*;
import org.junit.Test;

public class PlotTestStudent 
{
	@Test
	public void testDefaultConstructor()
	{
		Plot p = new Plot();
		assertEquals(0, p.getX());
		assertEquals(0, p.getY());
		assertEquals(1, p.getWidth());
		assertEquals(1, p.getDepth());
	}
	
	@Test
	public void testParameterizedConstructor()
	{
		Plot p = new Plot(2,3,4,5);
		assertEquals(2, p.getX());
		assertEquals(3, p.getY());
		assertEquals(4, p.getWidth());
		assertEquals(5, p.getDepth());
	}
	
	@Test
	public void testCopyConstructor()
	{
		Plot original = new Plot(1,2,3,4);
		Plot copy = new Plot(original);
		assertEquals(original.toString(), copy.toString());
		assertNotSame(original, copy);
	}
	
	@Test
	public void testSetters()
	{
		Plot p = new Plot();
		p.setX(2);
		p.setY(3);
		p.setWidth(4);
		p.setDepth(5);
		
		assertEquals(2, p.getX());
		assertEquals(3, p.getY());
		assertEquals(4, p.getWidth());
		assertEquals(5, p.getDepth());
	}
	
	@Test
	public void testOverlaps()
	{
		Plot p1 = new Plot(0,0,5,5);
		Plot p2 = new Plot(4,4,3,3);
		Plot p3 = new Plot(5,0,2,2);
		
		assertTrue(p1.overlaps(p2));
		assertFalse(p1.overlaps(p3));
	}
	
	@Test
	public void testEncompasses()
	{
		Plot outer = new Plot(0,0,10,10);
		Plot inner = new Plot(2,2,3,3);
		Plot edge = new Plot(0,0,10,10);
		Plot outside = new Plot(9,9,2,2);
		
		assertTrue(outer.encompasses(inner));
		assertTrue(outer.encompasses(edge));
		assertFalse(outer.encompasses(outside));
	}
	
	@Test
	public void testToString()
	{
		Plot p = new Plot(2,3,4,5);
		assertEquals("2,3,4,5", p.toString());
	}
}
