package com.theprogrammingturkey.volatiliajava.math;

public interface IVector
{
	public IVector add(Number x, Number y);

	public IVector sub(Number x, Number y);

	public IVector addVector(IVector vec);

	public IVector subVector(IVector vec);

	public double distanceTo(IVector vec);

	public Number getX();

	public Number getY();
}
