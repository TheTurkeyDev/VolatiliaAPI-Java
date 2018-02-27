package com.theprogrammingturkey.volatiliajava;

import com.theprogrammingturkey.volatiliajava.generation.MazeGenerator;

public class MazeTest
{

	public static void main(String[] args)
	{
		MazeGenerator maze = new MazeGenerator();
		maze.generate(false, 40, 40, 1, 1);
		for(int y = 0; y < maze.getYSize(); y++)
		{
			for(int x = 0; x < maze.getXSize(); x++)
			{
				System.out.print(maze.isWall(x, y) ? "X" : "O");
			}
			System.out.println();
		}
	}

}
