package com.theprogrammingturkey.volatiliajava.math;

public class Vector2F implements IVector
{
	private float x;
	private float y;

	public Vector2F(float x, float y)
	{
		this.x = x;
		this.y = y;
	}

	@Override
	public Vector2F add(Number x, Number y)
	{
		return new Vector2F(this.x + x.floatValue(), this.y + y.floatValue());
	}

	@Override
	public Vector2F sub(Number x, Number y)
	{
		return new Vector2F(this.x - x.floatValue(), this.y - y.floatValue());
	}

	@Override
	public Vector2F addVector(IVector vec)
	{
		return new Vector2F(this.x + vec.getX().floatValue(), this.y + vec.getY().floatValue());
	}

	@Override
	public Vector2F subVector(IVector vec)
	{
		return new Vector2F(this.x - vec.getX().floatValue(), this.y - vec.getY().floatValue());
	}

	@Override
	public double distanceTo(IVector vec)
	{
		return Math.sqrt(Math.pow((x + vec.getX().floatValue()), 2) + Math.pow((y + vec.getY().floatValue()), 2));
	}

	@Override
	public Float getX()
	{
		return x;
	}

	@Override
	public Float getY()
	{
		return y;
	}

}
