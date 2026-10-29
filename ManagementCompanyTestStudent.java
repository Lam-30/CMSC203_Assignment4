import static org.junit.Assert.*;
import org.junit.Test;

public class ManagementCompanyTestStudent 
{
	@Test
	public void testDefaultConstructor()
	{
		ManagementCompany mc = new ManagementCompany();
		
		assertEquals("", mc.getName());
		assertEquals("", mc.getTaxID());
		assertEquals(0.0, mc.getMgmFeePer(), 0.001);
		assertEquals(0, mc.getPropertiesCount());
		assertEquals("0,0,10,10", mc.getPlot().toString());
	}
	
	@Test
	public void testParameterizedConstructor()
	{
		ManagementCompany mc = new ManagementCompany("Company", "123", 10.0);
		
		assertEquals("Company", mc.getName());
		assertEquals("123", mc.getTaxID());
		assertEquals(10.0, mc.getMgmFeePer(), 0.001);
	}
	
	@Test
	public void testConstructorWithPlot()
	{
		ManagementCompany mc = new ManagementCompany("Company", "123", 10.0, 1, 2, 20, 30);
		
		assertEquals("1,2,20,30", mc.getPlot().toString());
	}
	
	@Test
	public void testAddProperty()
	{
		ManagementCompany mc = new ManagementCompany("Company", "123", 10.0);
		
		int index = mc.addProperty("House", "Rockville", 1000.0, "Alex", 1,1,2,2);
		assertEquals(0, index);
		assertEquals(1, mc.getPropertiesCount());
		assertEquals(1000.0, mc.getTotalRent(), 0.001);
	}
	
	@Test
	public void testAddPropertyErrors()
	{
		ManagementCompany mc = new ManagementCompany("Company", "123", 10.0);
		
		assertEquals(-2, mc.addProperty((Property) null));
		
		assertEquals(-3, mc.addProperty("Outside", "City", 1000.0, "Owner",
					9, 9, 2, 2));
		
		mc.addProperty("First", "City", 1000.0, "Owner", 1, 1, 4, 4);
		
		assertEquals(-4, mc.addProperty("Overlap", "City", 1200.0, "Owner",
						2, 2, 2, 2));
	}
	
	@Test
	public void testFullArray()
	{
		ManagementCompany mc = new ManagementCompany("Company", "123", 10.0);
		
		for (int i = 0; i < 5; i++)
		{
			int index = mc.addProperty("House" + i, "City", 1000.0, "Owner", 
										i * 2, 0, 1, 1);
			
			assertEquals(i, index);
		}
		assertTrue(mc.isPropertiesFull());
		assertEquals(-1, mc.addProperty("Extra", "City", 1000.0, "Owner",
					0, 2, 1, 1));
	}
	
	@Test
	public void testTotalRentAndHighestRent()
	{
		ManagementCompany mc = new ManagementCompany("Company", "123", 10.0);
		
		mc.addProperty("A", "City", 1000.0, "Owner", 0, 0, 2, 2);
		
		mc.addProperty("B", "City", 2000.0, "Owner", 3, 0, 2, 2);
		
		assertEquals(3000.0, mc.getTotalRent(), 0.001);
		assertEquals("B", mc.getHighestRentProperty().getPropertyName());
	}
	
	@Test
	public void testRemoteLastProperty()
	{
		ManagementCompany mc = new ManagementCompany("Company", "123", 10.0);
		
		mc.addProperty("A", "City", 1000.0, "Owner", 0, 0, 2, 2);
		
		mc.removeLastProperty();
		
		assertEquals(0, mc.getPropertiesCount());
		assertNull(mc.getProperties()[0]);
		
		mc.removeLastProperty();
		assertEquals(0, mc.getPropertiesCount());
	}
	
	@Test
	public void testManagementFeeValidation()
	{
		assertTrue(new ManagementCompany("A", "1", 0.0).isManagementFeeValid());
		
		assertTrue(new ManagementCompany("A", "1", 100.0).isManagementFeeValid());

		assertFalse(new ManagementCompany("A", "1", -1.0).isManagementFeeValid());

		assertFalse(new ManagementCompany("A", "1", 101.0).isManagementFeeValid());
	}
	
	@Test
	public void testCopyConstructor()
	{
		ManagementCompany original = new ManagementCompany("Company", "123", 10.0);
		
		original.addProperty("House", "City", 1000.0, "Owner", 1, 1, 2, 2);
		
		ManagementCompany copy = new ManagementCompany(original);
		
		assertEquals(original.getName(), copy.getName());
		assertEquals(original.getTaxID(), copy.getTaxID());
		assertEquals(original.getTotalRent(), copy.getTotalRent(), 0.001);
		assertEquals(1, copy.getPropertiesCount());
		
		assertNotSame(original.getProperties()[0], copy.getProperties()[0]);
	}
	
	@Test public void testToString()
	{
		ManagementCompany mc = new ManagementCompany("Company", "123", 10.0);
		
		mc.addProperty("House", "City", 1000.0, "Owner", 1, 1, 2, 2);
		
		String output = mc.toString();
		
		assertTrue(output.contains("List of the properties for Company, taxID: 123"));
		assertTrue(output.contains("House,City,Owner,1000.0"));
		assertTrue(output.contains("total management Fee: 100.00"));
	}
	
	@Test
	public void testAddPropertyDefaultPlot()
	{
		ManagementCompany mc = new ManagementCompany("Company", "123", 10.0);
		
		int index = mc.addProperty("House", "Rockville", 1200.0, "Alex");
		
		assertEquals(0, index);
		assertEquals(1, mc.getPropertiesCount());
		assertEquals(1200.0, mc.getTotalRent(), 0.001);
	}
	
	@Test
	public void testHighestRentWhenEmpty()
	{
		ManagementCompany mc = new ManagementCompany("Company", "123", 10.0);
		
		assertNull(mc.getHighestRentProperty());
	}
	
	@Test
	public void testRemoveLastProperty()
	{
		ManagementCompany mc = new ManagementCompany("Company", "123", 10.0);
		
		mc.addProperty("House1", "City", 1000.0, "Alex", 0, 0, 2, 2);
		
		mc.addProperty("House2", "City", 1000.0, "Alex", 3, 0, 2, 2);
		
		assertEquals(2, mc.getPropertiesCount());
		
		mc.removeLastProperty();
		
		assertEquals(1, mc.getPropertiesCount());
		assertNull(mc.getProperties()[1]);
		assertEquals(1000.0, mc.getTotalRent(), 0.001);
	}
	
	@Test
	public void testGetters()
	{
		ManagementCompany mc = new ManagementCompany("TestCompany", "456", 8.5);
		
		assertEquals("TestCompany", mc.getName());
		assertEquals("456", mc.getTaxID());
		assertEquals(8.5, mc.getMgmFeePer(), 0.001);
		assertEquals("0,0,10,10", mc.getPlot().toString());
		assertNotNull(mc.getProperties());
		assertEquals(0, mc.getPropertiesCount());
	}
}
