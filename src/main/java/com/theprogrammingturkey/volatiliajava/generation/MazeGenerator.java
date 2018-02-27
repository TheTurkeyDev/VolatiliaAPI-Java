package com.theprogrammingturkey.volatiliajava.generation;

import java.util.ArrayList;
import java.util.Random;

import com.theprogrammingturkey.volatiliajava.math.Vector2I;
import com.theprogrammingturkey.volatiliajava.util.Direction;

public class MazeGenerator
{
	private int xSize;
	private int ySize;
	private int width;
	private int height;
	private int xWallScale, yWallScale;
	private int[][] map;
	private ArrayList<Vector2I> walls = new ArrayList<Vector2I>();
	private Random r = new Random();

	private int currentX = 1;
	private int currentY = 1;

	private int nonWall = 0;
	private int wall = 1;

	private boolean generated = false;

	/**
	 * creates a maze with the given parameters
	 * 
	 * @param multiple
	 *            solutions
	 * @param x
	 *            maze Size
	 * @param y
	 *            maze size
	 * @param x
	 *            wall size
	 * @param y
	 *            wall size
	 */
	public void generate(boolean multiple, int x1, int y1, int x2, int y2)
	{
		xSize = x1;
		ySize = y1;
		xWallScale = x2;
		yWallScale = y2;
		map = new int[xSize][ySize];
		for(int y = 0; y < ySize; y++)
		{
			for(int x = 0; x < xSize; x++)
			{
				map[x][y] = wall;
			}
		}

		map[1][1] = nonWall;
		currentX = 1;
		currentY = 1;
		Vector2I current = new Vector2I(currentX, currentY);

		for(Direction dir : Direction.values())
		{
			Vector2I dirVec = current.shiftInDirection(dir, 1);
			Vector2I dirVec2 = dirVec.shiftInDirection(dir, 1);
			if(isLocInMaze(dirVec) && (map[dirVec.getX()][dirVec.getY()] == wall))
			{
				if(multiple)
					walls.add(dirVec);
				else if((map[dirVec2.getX()][dirVec2.getY()] == wall))
					walls.add(dirVec);
			}
		}

		while(walls.size() > 0)
		{
			int randomLoc = r.nextInt(walls.size());
			currentX = (int) (walls.get(randomLoc)).getX();
			currentY = (int) (walls.get(randomLoc)).getY();
			current = new Vector2I(currentX, currentY);

			if(!checkwalls(current))
			{
				map[currentX][currentY] = nonWall;
				walls.remove(randomLoc);
				for(Direction dir : Direction.values())
				{
					Vector2I dirVec = current.shiftInDirection(dir, 1);
					Vector2I dirVec2 = dirVec.shiftInDirection(dir, 1);
					if(isLocInMaze(dirVec2) && (map[dirVec.getX()][dirVec.getY()] == wall))
					{
						if(multiple)
							walls.add(dirVec);
						else if((map[dirVec2.getX()][dirVec2.getY()] == wall))
							walls.add(dirVec);
					}
				}
			}
			else
			{
				walls.remove(randomLoc);
			}
		}
		if(multiple)
		{
			for(int y = 1; y < ySize - 1; y++)
			{
				for(int x = 1; x < xSize - 1; x++)
				{
					if(isWall(x, y) && numWallsAround(new Vector2I(x, y)) == 2)
					{
						map[x][y] = nonWall;
					}
				}
			}
		}
		height = ySize * yWallScale;
		width = xSize * xWallScale;
		generated = true;
	}

	private boolean checkwalls(Vector2I loc)
	{
		Vector2I north = loc.add(0, -1);
		Vector2I east = loc.add(1, 0);
		Vector2I south = loc.add(0, 1);
		Vector2I west = loc.add(-1, 0);

		int yes = 0;
		if((north.getY() >= 0 && map[(int) north.getX()][(int) north.getY()] == nonWall) || north.getY() > ySize)
			yes++;
		if((east.getX() < xSize && map[(int) east.getX()][(int) east.getY()] == nonWall) || east.getX() > xSize)
			yes++;
		if((south.getY() < ySize && map[(int) south.getX()][(int) south.getY()] == nonWall) || south.getY() < 0)
			yes++;
		if((west.getX() >= 0 && map[(int) west.getX()][(int) west.getY()] == nonWall) || west.getX() < 0)
			yes++;
		return yes > 1;
	}

	private int numWallsAround(Vector2I loc)
	{
		Vector2I north = loc.add(0, -1);
		Vector2I east = loc.add(1, 0);
		Vector2I south = loc.add(0, 1);
		Vector2I west = loc.add(-1, 0);

		int yes = 0;
		if(north.getY() >= 0 && map[(int) north.getX()][(int) north.getY()] == nonWall)
			yes++;
		if(east.getX() < xSize && map[(int) east.getX()][(int) east.getY()] == nonWall)
			yes++;
		if(south.getY() < ySize && map[(int) south.getX()][(int) south.getY()] == nonWall)
			yes++;
		if(west.getX() >= 0 && map[(int) west.getX()][(int) west.getY()] == nonWall)
			yes++;
		return yes;
	}

	/**
	 * returns if the maze has been generated
	 * 
	 * @return is generated
	 */
	public boolean isGenrated()
	{
		return generated;
	}

	/**
	 * returns whether or not there is a wall in contact with the give location and size
	 * 
	 * @param x
	 *            location
	 * @param y
	 *            lovation
	 * @param size
	 *            of the object (only square)
	 * @return if there is a wall
	 */
	public boolean isWall(float x, float y, float size)
	{
		int x1 = (int) ((x - size) / xWallScale);
		int x2 = (int) ((x + size) / xWallScale);
		int y1 = (int) ((y - size) / yWallScale);
		int y2 = (int) ((y + size) / yWallScale);

		if(map[x1][y1] == wall)
		{
			return true;
		}
		if(map[x1][y2] == wall)
		{
			return true;
		}
		if(map[x2][y1] == wall)
		{
			return true;
		}
		if(map[x2][y2] == wall)
		{
			return true;
		}
		return false;
	}

	/**
	 * returns if there is a wall at the given location
	 * 
	 * @param x
	 *            location
	 * @param y
	 *            location
	 * @return if there is a wall
	 */
	public boolean isWall(int x, int y)
	{
		if(map[x][y] == wall)
		{
			return true;
		}
		return false;
	}

	/**
	 * gets a random location that doesnt have a wall
	 * 
	 * @return open location
	 */
	public Vector2I getFreeLoc()
	{
		int x = r.nextInt(xSize);
		int y = r.nextInt(ySize);
		boolean valid = false;
		while(!valid)
		{
			if(map[x][y] == nonWall)
			{
				valid = true;
			}
			else
			{
				x = r.nextInt(xSize);
				y = r.nextInt(ySize);
			}
		}
		return new Vector2I(x, y);
	}

	/**
	 * Returns whether or not the given location is in the bounds of the maze.
	 * 
	 * Bounds of the maze do not include boarder.
	 * 
	 * True if 0<x<width and 0<y<height
	 * 
	 * False otherwise
	 * 
	 * @param loc
	 *            location to test
	 * @return if the location is in the bounds of the maze
	 */
	public boolean isLocInMaze(Vector2I loc)
	{
		return loc.getX() > 0 && loc.getX() < xSize && loc.getY() > 0 && loc.getY() < ySize;
	}

	/**
	 * gets the width of the maze
	 * 
	 * @return width
	 */
	public int getWidth()
	{
		return width;
	}

	/**
	 * gets the height of the maze
	 * 
	 * @return height
	 */
	public int getHeight()
	{
		return height;
	}

	/**
	 * returns the size of the walls x direction
	 * 
	 * @return x Wall size
	 */
	public int getxWallScale()
	{
		return xWallScale;
	}

	/**
	 * returns the size of the walls y direction
	 * 
	 * @return y Wall size
	 */
	public int getyWallScale()
	{
		return yWallScale;
	}

	/**
	 * gets the full width of the maze
	 * 
	 * @return x Size
	 */
	public int getXSize()
	{
		return xSize;
	}

	/**
	 * gets the full height of the maze
	 * 
	 * @return x Size
	 */
	public int getYSize()
	{
		return ySize;
	}

	/**
	 * returns the maze array
	 * 
	 * @return maze array
	 */
	public int[][] getMazeMap()
	{
		return map;
	}
}