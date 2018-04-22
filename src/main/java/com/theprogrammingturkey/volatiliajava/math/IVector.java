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
	 * Adds the given x and y amount to the vector and updates this vectors values.
	 * 
	 * @param x
	 *            increment amount
	 * @param y
	 *            increment amount
	 */
	public void addU(Number x, Number y);

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
	 * Subtracts the given x and y amount to the vector and updates this vectors values.
	 * 
	 * @param x
	 *            decrement amount
	 * @param y
	 *            decrement amount
	 */
	public void subU(Number x, Number y);

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
	 * Adds the components of the passed vector to the current vector and updates this vectors
	 * values.
	 * 
	 * @param vector
	 *            to add the components of to the current vector
	 */
	public void addVectorU(IVector vec);

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
	 * Subtracts the components of the passed vector to the current vector and updates this vectors
	 * values.
	 * 
	 * @param vector
	 *            to subtract the components of to the current vector
	 */
	public void subVectorU(IVector vec);

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
	 * Shifts the given vector in the passed direction by the given amount.
	 * 
	 * @param direction
	 *            to shift the vector in
	 * @param amount
	 *            to shift the vector by
	 */
	public void shiftInDirectionU(Direction dir, Number amount);

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

	/**
	 * Sets the x component of this vector.
	 */
	public void setX(Number x);

	/**
	 * Sets the y component of this vector
	 */
	public void setY(Number y);

	/**
	 * Sets the x and y components of this vector.
	 */
	public void setXY(Number x, Number Y);

	/**
	 * 
	 * @return the String representation of the Vector
	 */
	@Override
	public String toString();

	/**
	 * Tests if this vector is equal to the passed vector. Can be any type of IVector, but the
	 * vector coords will not be converted to this vectors data type and compared.
	 * 
	 * @param vector
	 *            to compare
	 * @return If the vectors are equal in both coords.
	 */
	public boolean equals(IVector vector);
}
