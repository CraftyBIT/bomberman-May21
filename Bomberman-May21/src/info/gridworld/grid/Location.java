/* 
 * AP(r) Computer Science GridWorld Case Study:
 * Copyright(c) 2002-2006 College Entrance Examination Board 
 * (http://www.collegeboard.com).
 *
 * This code is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * @author Alyce Brady
 * @author Chris Nevison
 * @author APCS Development Committee
 * @author Cay Horstmann
 */

package info.gridworld.grid;

/**
 * A <code>Location</code> object represents the row and column of a location
 * in a two-dimensional grid. <br />
 * The API of this class is testable on the AP CS A and AB exams.
 */
public class Location implements Comparable
{
    private int row; // row location in grid
    private int col; // column location in grid

    /**
     * The turn angle for turning 90 degrees to the left.
     */


    /**
     * Constructs a location with given row and column coordinates.
     * @param r the row
     * @param c the column
     */
    public Location(int r, int c)
    {
        row = r;
        col = c;
    }

    /**
     * Gets the row coordinate.
     * @return the row of this location
     */
    public int getRow()
    {
        return row;
    }

    /**
     * Gets the column coordinate.
     * @return the column of this location
     */
    public int getCol()
    {
        return col;
    }
    
    public void setLocation(int r, int c){
    	row = r;
    	col = c;
    }

    /**
     * Gets the adjacent location in any one of the eight compass directions.
     * @param direction the direction in which to find a neighbor location
     * @return the adjacent location in the direction that is closest to
     * <tt>direction</tt>
     */
  
    /**
     * Generates a hash code.
     * @return a hash code for this location
     */
    public int hashCode()
    {
        return getRow() * 3737 + getCol();
    }

    /**
     * Compares this location to <code>other</code> for ordering. Returns a
     * negative integer, zero, or a positive integer as this location is less
     * than, equal to, or greater than <code>other</code>. Locations are
     * ordered in row-major order. <br />
     * (Precondition: <code>other</code> is a <code>Location</code> object.)
     * @param other the other location to test
     * @return a negative integer if this location is less than
     * <code>other</code>, zero if the two locations are equal, or a positive
     * integer if this location is greater than <code>other</code>
     */
  

    /**
     * Creates a string that describes this location.
     * @return a string with the row and column of this location, in the format
     * (row, col)
     */
    public String toString()
    {
        return "(" + getRow() + ", " + getCol() + ")";
    }

	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
}