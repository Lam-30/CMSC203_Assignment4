import static org.junit.Assert.*;
import org.junit.Test;

public class PropertyTestStudent 
{
	@Test
	public void testDefaultConstructor()
	{
		Property p = new Property();
		assertEquals("", p.getPropertyName());
		assertEquals("", p.getCity());
		assertEquals(0.0, p.getRentAmount(), 0.001);
		assertEquals("", p.getOwner());
		assertNotNull(p.getPlot());
	}
	
	@Test
	public void testParameterizedConstructor()
	{
		Property p = new Property("Lake House", "Rockville", 1500.0, "Alex");
		
		assertEquals("Lake House", p.getPropertyName());
		assertEquals("Rockville", p.getCity());
		assertEquals(1500.0, p.getRentAmount(), 0.001);
		assertEquals("Alex", p.getOwner());
	}
	
	@Test
	public void testConstructorWithPlot()
	{
		Property p = new Property("Lake House", "Rockville", 1500.0, "Alex", 1,2,3,4);
		
		assertEquals("1,2,3,4", p.getPlot().toString());
	}
	
	@Test
	public void testCopyConstructor()
	{
		Property original = new Property("Lake House", "Rockville", 1500.0, "Alex", 1,2,3,4);
		
		Property copy = new Property(original);
		
		assertEquals(original.toString(), copy.toString());
		assertEquals(original.getPlot().toString(), copy.getPlot().toString());
		assertNotSame(original, copy);
		assertNotSame(original.getPlot(), copy.getPlot());
		
	}
	
	@Test
	public void testSetters()
	{
		Property p = new Property();
		p.setPropertyName("New House");
		p.setCity("Silver Spring");
		p.setRentAmount(2000.0);
		p.setOwner("Jordan");
		p.setPlot(new Plot(1,1,2,2));
		
		assertEquals("New House", p.getPropertyName());
		assertEquals("Silver Spring", p.getCity());
		assertEquals(2000.0, p.getRentAmount(), 0.001);
		assertEquals("Jordan", p.getOwner());
		assertEquals("1,1,2,2", p.getPlot().toString());
	}
	
	@Test
	public void testToString()
	{
		Property p = new Property("Lake House", "Rockville", 1500.0, "Alex");
		
		assertEquals("Lake House,Rockville,Alex,1500.0", p.toString());
	}
}
