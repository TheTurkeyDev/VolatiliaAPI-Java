package com.theprogrammingturkey.volatiliajava.math;

import com.theprogrammingturkey.volatiliajava.util.Direction;

public class Vector2L implements IVector
{
	private long x;
	private long y;

	public Vector2L()
	{
		this.x = 0;
		this.y = 0;
	}

	public Vector2L(long x, long y)
	{
		this.x = x;
		this.y = y;
	}

	@Override
	public Vector2L add(Number x, Number y)
	{
		return new Vector2L(this.x + x.longValue(), this.y + y.longValue());
	}

	@Override
	public Vector2L sub(Number x, Number y)
	{
		return new Vector2L(this.x - x.longValue(), this.y - y.longValue());
	}

	@Override
	public Vector2L addVector(IVector vec)
	{
		return new Vector2L(x + vec.getX().longValue(), y + vec.getY().longValue());
	}

	@Override
	public Vector2L subVector(IVector vec)
	{
		return new Vector2L(x - vec.getX().longValue(), y - vec.getY().longValue());
	}

	@Override
	public Vector2L shiftInDirection(Direction dir, Number amount)
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
		return Math.sqrt(Math.pow((x + vec.getX().longValue()), 2) + Math.pow((y + vec.getY().longValue()), 2));
	}

	@Override
	public Long getX()
	{
		return x;
	}

	@Override
	public Long getY()
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
