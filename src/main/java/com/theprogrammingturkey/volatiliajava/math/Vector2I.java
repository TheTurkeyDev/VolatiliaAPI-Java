package com.theprogrammingturkey.volatiliajava.math;

public class Vector2I implements IVector
{
	private int x;
	private int y;

	public Vector2I(int x, int y)
	{
		this.x = x;
		this.y = y;
	}

	@Override
	public Vector2I add(Number x, Number y)
	{
		return new Vector2I(this.x + x.intValue(), this.y + y.intValue());
	}

	@Override
	public Vector2I sub(Number x, Number y)
	{
		return new Vector2I(this.x - x.intValue(), this.y - y.intValue());
	}

	@Override
	public Vector2I addVector(IVector vec)
	{
		return new Vector2I(x + vec.getX().intValue(), y + vec.getY().intValue());
	}

	@Override
	public Vector2I subVector(IVector vec)
	{
		return new Vector2I(x - vec.getX().intValue(), y - vec.getY().intValue());
	}

	@Override
	public double distanceTo(IVector vec)
	{
		return Math.sqrt(Math.pow((x + vec.getX().intValue()), 2) + Math.pow((y + vec.getY().intValue()), 2));
	}

	@Override
	public Integer getX()
	{
		return x;
	}

	@Override
	public Integer getY()
	{
		return y;
	}
}
