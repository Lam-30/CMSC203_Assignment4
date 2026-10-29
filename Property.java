/**
 * Represents a rental property, including its name, city, rent,
 * owner, and plot location.
 * 
 * @author Luis Aguero
 * @version 10/29/2026
 */
public class Property
{
	private String propertyName;
	private String city;
	private double rentAmount;
	private String owner;
	private Plot plot;
	
	//Default constructor
	public Property()
	{
		propertyName = "";
		city = "";
		rentAmount = 0.0;
		owner = "";
		plot = new Plot();
	}
	
	//Constructor without plot coordinates
	public Property(String propertyName, String city,
					double rentAmount, String owner)
	{
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
		plot = new Plot();
	}
	
	//Constructor with plot coordinates
	public Property(String propertyName, String city,
					double rentAmount, String owner,
					int x, int y, int width, int depth)
	{
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
		plot = new Plot(x, y, width, depth);
	}
	
	// Copy constructor
	
	public Property(Property otherProperty)
	{
		this.propertyName = otherProperty.propertyName;
		this.city = otherProperty.city;
		this.rentAmount = otherProperty.rentAmount;
		this.owner = otherProperty.owner;
		this.plot = new Plot(otherProperty.plot);
	}
	
	// Getters
	
	public String getPropertyName()
	{
		return propertyName;
	}
	
	public String getCity()
	{
		return city;
	}
	
	public double getRentAmount()
	{
		return rentAmount;
	}
	
	public String getOwner()
	{
		return owner;
	}
	
	public Plot getPlot()
	{
		return plot;
	}
	
	// Setters
	
	public void setPropertyName(String propertyName)
	{
		this.propertyName = propertyName;
	}
	
	public void setCity(String city)
	{
		this.city = city;
	}
	
	public void setRentAmount(double rentAmount)
	{
		this.rentAmount = rentAmount;
	}
	
	public void setOwner(String owner)
	{
		this.owner = owner;
	}
	
	public void setPlot(Plot plot)
	{
		this.plot = plot;
	}
	
	@Override
	public String toString()
	{
		return propertyName + "," + city + "," + owner + "," + rentAmount;
	}
}
