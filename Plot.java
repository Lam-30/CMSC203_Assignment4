/**
 * Represents a rectangular plot with an x-coordinate, y-coordinate, 
 * width, and depth. Provides methods to check whether plots overlap
 * or whether one plot encompasses another.
 * 
 * @author Luis Aguero
 * @version 10/29/2026
 */

public class Plot 
{
	private int x;
	private int y;
	private int width;
	private int depth;
	
	//Default constructor
	public Plot()
	{
		x = 0;
		y = 0;
		width = 1;
		depth = 1;
	}
	
	//Parameterized constructor
	public Plot(int x, int y, int width, int depth)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.depth = depth;
	}
	
	//Copy constructor
	public Plot(Plot otherPlot)
	{
		this(otherPlot.x, otherPlot.y, otherPlot.width, otherPlot.depth);
	}
	
	//Getters
	public int getX() 
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	public int getWidth()
	{
		return width;
	}
	
	public int getDepth()
	{
		return depth;
	}
	
	//Setters
	public void setX(int x)
	{
		this.x = x;
	}
	
	public void setY(int y)
	{
		this.y = y;
	}
	
	public void setWidth(int width)
	{
		this.width = width;
	}
	
	public void setDepth(int depth)
	{
		this.depth = depth;
	}
	
	//Returns true if the plots overlap.
	//Sharing an edge does not count as overlapping.
	
	public boolean overlaps(Plot plot)
	{
		if (plot == null)
		{
			return false;
		}
		
		int right = x + width;
		int bottom = y + depth;
		int otherRight = plot.x + plot.width;
		int otherBottom = plot.y + plot.depth;
		
		if (right <= plot.x || otherRight <= x)
		{
			return false;
		}
		
		if (bottom <= plot.y || otherBottom <= y)
		{
			return false;
		}
		
		return true;
	}
	
	// Returns true if this plot completely contains
	// the specified plot, including its edges.
	
	public boolean encompasses(Plot plot)
	{
		if (plot == null)
		{
			return false;
		}
		return plot.x >= x
				&& plot.y >= y
				&& plot.x + plot.width <= x + width
				&& plot.y + plot.depth <= y + depth;
	}
	
	@Override
	public String toString()
	{
		return x + "," + y + "," + width + "," + depth;
	}
	
}
