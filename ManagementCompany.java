/**
 * Represents a management company that manages rental properties.
 * Stores company information, manages property plots, calculates
 * total rent, and calculates management fees.
 * 
 * @author Luis Aguero
 * @version 10/29/2026
 */

public class ManagementCompany 
{
	public static final int MAX_PROPERTY = 5;
	public static final int MGMT_WIDTH = 10;
	public static final int MGMT_DEPTH = 10;
	
	private String name;
	private String taxID;
	private double mgmFee;
	private Property[] properties;
	private Plot plot;
	private int numberOfProperties;
	
	//Default constructor
	public ManagementCompany()
	{
		name = "";
		taxID = "";
		mgmFee = 0.0;
		plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
		properties = new Property[MAX_PROPERTY];
		numberOfProperties = 0;
	}
	
	//Constructor with name, tax ID, and fee
	public ManagementCompany(String name, String taxID, double mgmFee)
	{
		this();
		this.name = name;
		this.taxID = taxID;
		this.mgmFee = mgmFee;
	}
	
	//Constructor with a custom management plot
	public ManagementCompany(String name, String taxID,
							double mgmFee, int x, int y,
							int width, int depth)
	{
		this(name, taxID, mgmFee);
		plot = new Plot(x, y, width, depth);
	}
	
	//Copy constructor
	public ManagementCompany(ManagementCompany otherCompany)
	{
		this(otherCompany.name, otherCompany.taxID, otherCompany.mgmFee);
		
		plot = new Plot(otherCompany.plot);
		
		for(int i = 0; i < otherCompany.numberOfProperties; i++)
		{
			properties[i] = new Property(otherCompany.properties[i]);
			numberOfProperties++;
		}
	}
	
	//Getters
	public String getName()
	{
		return name;
	}
	
	public String getTaxID()
	{
		return taxID;
	}
	
	public double getMgmFeePer()
	{
		return mgmFee;
	}
	
	public Plot getPlot()
	{
		return plot;
	}
	
	public Property[] getProperties()
	{
		return properties;
	}
	
	//Setters
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setTaxID(String taxID)
	{
		this.taxID = taxID;
	}
	
	public void setMgmFeePer(double mgmFee)
	{
		this.mgmFee = mgmFee;
	}
	
	public void setPlot(Plot plot)
	{
		this.plot = plot;
	}
	
	//Adds a property object to the company
	public int addProperty(Property property)
	{
		
		if (isPropertiesFull())
		{
			return -1;
		}
		
		if(property == null)
		{
			return -2;
		}
		
		if(!plot.encompasses(property.getPlot()))
		{
			return -3;
		}
		
		for (int i = 0; i < numberOfProperties; i++)
		{
			if (property.getPlot().overlaps(properties[i].getPlot()))
			{
				return -4;
			}
		}
		
		int index = numberOfProperties;
		properties[index] = new Property(property);
		numberOfProperties++;
		
		return index;
	}
	
	//Adds a property using its default plot
	public int addProperty(String name, String city,
							double rent, String owner)
	{
		Property property = new Property(name, city, rent, owner);
		
		return addProperty(property);
	}
	
	//Adds a property with specified plot coordinates
	public int addProperty(String name, String city,
							double rent, String owner,
							int x, int y, int width, int depth)
	{
		Property property = new Property(name, city, rent, owner, x, y, width, depth);
		
		return addProperty(property);
	}
	
	//Removes the last property
	public void removeLastProperty()
	{
		if (numberOfProperties > 0)
		{
			properties[numberOfProperties - 1] = null;
			numberOfProperties--;
		}
	}
	
	//Checks whether the array is full
	public boolean isPropertiesFull()
	{
		return numberOfProperties == MAX_PROPERTY;
	}
	
	//Returns the number of properties
	public int getPropertiesCount()
	{
		return numberOfProperties;
	}
	
	//Calculates total rental income
	public double getTotalRent()
	{
		double totalRent = 0.0;
		
		for (int i = 0; i < numberOfProperties; i++)
		{
			totalRent += properties[i].getRentAmount();
		}
		
		return totalRent;
	}
	
	//Finds the index of the highest-rent property
	private int maxRentPropertyIndex()
	{
		if (numberOfProperties == 0)
		{
			return -1;
		}
		
		int maxIndex = 0;
		
		for (int i = 1; i < numberOfProperties; i++)
		{
			if (properties[i].getRentAmount() > properties[maxIndex].getRentAmount())
			{
				maxIndex = i;
			}
		}
		
		return maxIndex;
	}
	
	//Returns the property with the highest rent
	public Property getHighestRentProperty()
	{
		int index = maxRentPropertyIndex();
		
		if (index == -1)
		{
			return null;
		}
		
		return properties[index];
	}
	
	//Checks whether the management fee is valid
	public boolean isManagementFeeValid()
	{
		return mgmFee >= 0 && mgmFee <= 100;
	}
	
	//Returns company and property information
	@Override
	public String toString()
	{
		StringBuilder result = new StringBuilder();
		
		result.append("List of the properties for ").append(name).append(", taxID: ").append(taxID).append("\n");
		
		result.append("______________________________________________________________").append("\n");
		
		for(int i = 0; i < numberOfProperties; i++)
		{
			result.append(properties[i].toString()).append("\n");
		}
		
		result.append("_______________________________________________________________").append("\n");
		
		double totalManagementFee = getTotalRent() * mgmFee / 100.0;
		
		result.append("total management Fee: ").append(String.format("%.2f", totalManagementFee));
		
		return result.toString();
		
	}
}
