package com.theprogrammingturkey.volatiliajava.math;

public class MathHelper
{
	/**
	 * Clamps the passed number to be within the passed bounds
	 * 
	 * @param lower
	 *            bound of the range
	 * @param upper
	 *            bound of the range
	 * @param number
	 *            to clamp within the range
	 * @return the number if it lies within the bounds or the upper/ lower bound if the number is
	 *         outside of the passed limits
	 */
	public static int clamp(int lower, int upper, int number)
	{
		if(number < lower)
			return lower;
		if(number > upper)
			return upper;
		return number;
	}

	/**
	 * Clamps the passed number to be within the passed bounds
	 * 
	 * @param lower
	 *            bound of the range
	 * @param upper
	 *            bound of the range
	 * @param number
	 *            to clamp within the range
	 * @return the number if it lies within the bounds or the upper/ lower bound if the number is
	 *         outside of the passed limits
	 */
	public static float clamp(float lower, float upper, float number)
	{
		if(number < lower)
			return lower;
		if(number > upper)
			return upper;
		return number;
	}
}
