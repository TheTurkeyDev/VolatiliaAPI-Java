package com.theprogrammingturkey.volatiliajava.math;

import com.theprogrammingturkey.volatiliajava.util.Direction;

public class Vector2F implements IVector
{
	private float x;
	private float y;

	public Vector2F()
	{
		this.x = 0;
		this.y = 0;
	}

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
	public void addU(Number x, Number y)
	{
		this.x += x.floatValue();
		this.y += y.floatValue();
	}

	@Override
	public Vector2F sub(Number x, Number y)
	{
		return new Vector2F(this.x - x.floatValue(), this.y - y.floatValue());
	}

	@Override
	public void subU(Number x, Number y)
	{
		this.x -= x.floatValue();
		this.y -= y.floatValue();
	}

	@Override
	public Vector2F addVector(IVector vec)
	{
		return new Vector2F(this.x + vec.getX().floatValue(), this.y + vec.getY().floatValue());
	}

	@Override
	public void addVectorU(IVector vec)
	{
		this.x += vec.getX().floatValue();
		this.y += vec.getY().floatValue();
	}

	@Override
	public Vector2F subVector(IVector vec)
	{
		return new Vector2F(this.x - vec.getX().floatValue(), this.y - vec.getY().floatValue());
	}

	@Override
	public void subVectorU(IVector vec)
	{
		this.x -= vec.getX().floatValue();
		this.y -= vec.getY().floatValue();

	}

	@Override
	public Vector2F shiftInDirection(Direction dir, Number amount)
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
	public void shiftInDirectionU(Direction dir, Number amount)
	{
		switch(dir)
		{
			case DOWN:
				this.subU(0, amount);
			case LEFT:
				this.subU(amount, 0);
			case RIGHT:
				this.addU(amount, 0);
			case UP:
				this.addU(0, amount);
			default:
				this.addU(0, 0);
		}
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
