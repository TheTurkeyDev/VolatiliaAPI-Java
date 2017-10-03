package com.theprogrammingturkey.volatiliajava.math;

import com.theprogrammingturkey.volatiliajava.util.Direction;

public interface IVector
{
	/**
	 * Adds the given x and y amount to the vector and returns the new values as a new vector
	 * object. Original vector object is not changed.
	 * 
	 * @param x
	 *            increment amount
	 * @param y
	 *            increment amount
	 * @return New vector with the passed in amounts added to the original vector.
	 */
	public IVector add(Number x, Number y);

	/**
	 * Subtracts the given x and y amount to the vector and returns the new values as a new vector
	 * object. Original vector object is not changed.
	 * 
	 * @param x
	 *            decrement amount
	 * @param y
	 *            decrement amount
	 * @return New vector with the passed in amounts subtracted from the original vector.
	 */
	public IVector sub(Number x, Number y);

	/**
	 * Adds the components of the passed vector to the current vector and returns the new values as
	 * a new vector object. Original vector object is not changed
	 * 
	 * @param vector
	 *            to add the components of to the current vector
	 * @return New vector with the components of the passed vector added on to it.
	 */
	public IVector addVector(IVector vec);

	/**
	 * Subtracts the components of the passed vector to the current vector and returns the new
	 * values as a new vector object. Original vector object is not changed
	 * 
	 * @param vector
	 *            to subtract the components of from the current vector
	 * @return New vector with the components of the passed vector subtracted from it.
	 */
	public IVector subVector(IVector vec);

	/**
	 * Shifts the given vector in the passed direction by the given amount.
	 * 
	 * @param direction
	 *            to shift the vector in
	 * @param amount
	 *            to shift the vector by
	 * @return A new vector shifted in the direction by the given amount.
	 */
	public IVector shiftInDirection(Direction dir, Number amount);

	/**
	 * Distance from the current vector to the passed vector.
	 * 
	 * @param vec
	 *            to get the distance to
	 * @return double distance.
	 */
	public double distanceTo(IVector vec);

	/**
	 * Gets the x component of this vector.
	 * 
	 * @return the x component
	 */
	public Number getX();

	/**
	 * Gets the y component of this vector
	 * 
	 * @return the y component
	 */
	public Number getY();
}
