package com.theprogrammingturkey.volatiliajava.math;

import com.theprogrammingturkey.volatiliajava.util.Direction;

public class Vector2D implements IVector
{
	private double x, y;

	public Vector2D()
	{
		this.x = 0;
		this.y = 0;
	}

	public Vector2D(double x, double y)
	{
		this.x = x;
		this.y = y;
	}

	@Override
	public Vector2D add(Number x, Number y)
	{
		return new Vector2D(this.x + x.doubleValue(), this.y + y.doubleValue());
	}

	@Override
	public Vector2D sub(Number x, Number y)
	{
		return new Vector2D(this.x - x.doubleValue(), this.y - y.doubleValue());
	}

	@Override
	public Vector2D addVector(IVector vec)
	{
		return new Vector2D(this.x + vec.getX().doubleValue(), this.y + vec.getY().doubleValue());
	}

	@Override
	public Vector2D subVector(IVector vec)
	{
		return new Vector2D(this.x - vec.getX().doubleValue(), this.y - vec.getY().doubleValue());
	}

	@Override
	public Vector2D shiftInDirection(Direction dir, Number amount)
	{
		switch(dir)
		{
			case DOWN:
				return this.sub(0, amount);
			case LEFT:
				return this.sub(amount, 0);
			case RIGHT:
				return this.add(amount, 0);
			case UP:
				return this.add(0, amount);
			default:
				return this.add(0, 0);
		}
	}

	@Override
	public double distanceTo(IVector vec)
	{
		return Math.sqrt(Math.pow((x + vec.getX().doubleValue()), 2) + Math.pow((y + vec.getY().doubleValue()), 2));
	}

	@Override
	public Double getX()
	{
		return x;
	}

	@Override
	public Double getY()
	{
		return y;
	}

	@Override
	public String toString()
	{
		return "(" + this.x + ", " + this.y + ")";
	}

	@Override
	public boolean equals(IVector vector)
	{
		return this.getX().equals(vector.getX()) && this.getY().equals(vector.getY());
	}
}
