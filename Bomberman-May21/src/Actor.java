// Project Bomberman

public class Actor
{
	private int myRow, myColumn;
	
	public Actor()
	{
		myRow = 0;
		myColumn = 0;
	}
	
	public Actor(int row, int column)
	{
		myRow = row;
		myColumn = column;
	}
	
	public int getRow()
	{
		return myRow;
	}
	
	public int getColumn()
	{
		return myColumn;
	}
	
	public void setRow(int row)
	{
		myRow = row;
	}
	
	public void setColumn(int column)
	{
		myColumn = column;
	}
	
	public int getPower()
	{
		return 1;
	}
	
	public int getPlayer()
	{
		return 1;
	}
}
