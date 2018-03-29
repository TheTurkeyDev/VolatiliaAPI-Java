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
	public static double clamp(double lower, double upper, double number)
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
	public static long clamp(long lower, long upper, long number)
	{
		if(number < lower)
			return lower;
		if(number > upper)
			return upper;
		return number;
	}

	/**
	 * Maps an integer value from one range, to a new range.
	 * 
	 * @param currentValue
	 *            value to map to the new range of.
	 * @param oldLow
	 *            lower bound of the range that the value is currently mapped to
	 * @param oldUpper
	 *            upper bound of the range that the value is currently mapped to
	 * @param newLow
	 *            lower bound of the range that the value should be mapped to
	 * @param newUpper
	 *            upper bound of the range that the value should be mapped to
	 * @return new value that is mapped to be in the new range from the passed in value given the
	 *         old range
	 */
	public static int map(int currentValue, int oldLow, int oldUpper, int newLow, int newUpper)
	{
		return (currentValue - oldLow) / (oldUpper - oldLow) * (newUpper - newLow) + newLow;
	}

	/**
	 * Maps an double value from one range, to a new range.
	 * 
	 * @param currentValue
	 *            value to map to the new range of.
	 * @param oldLow
	 *            lower bound of the range that the value is currently mapped to
	 * @param oldUpper
	 *            upper bound of the range that the value is currently mapped to
	 * @param newLow
	 *            lower bound of the range that the value should be mapped to
	 * @param newUpper
	 *            upper bound of the range that the value should be mapped to
	 * @return new value that is mapped to be in the new range from the passed in value given the
	 *         old range
	 */
	public static double map(double currentValue, double oldLow, double oldUpper, double newLow, double newUpper)
	{
		return (currentValue - oldLow) / (oldUpper - oldLow) * (newUpper - newLow) + newLow;
	}

	/**
	 * Maps an float value from one range, to a new range.
	 * 
	 * @param currentValue
	 *            value to map to the new range of.
	 * @param oldLow
	 *            lower bound of the range that the value is currently mapped to
	 * @param oldUpper
	 *            upper bound of the range that the value is currently mapped to
	 * @param newLow
	 *            lower bound of the range that the value should be mapped to
	 * @param newUpper
	 *            upper bound of the range that the value should be mapped to
	 * @return new value that is mapped to be in the new range from the passed in value given the
	 *         old range
	 */
	public static float map(float currentValue, float oldLow, float oldUpper, float newLow, float newUpper)
	{
		return (currentValue - oldLow) / (oldUpper - oldLow) * (newUpper - newLow) + newLow;
	}
	
	/**
	 * Maps an long value from one range, to a new range.
	 * 
	 * @param currentValue
	 *            value to map to the new range of.
	 * @param oldLow
	 *            lower bound of the range that the value is currently mapped to
	 * @param oldUpper
	 *            upper bound of the range that the value is currently mapped to
	 * @param newLow
	 *            lower bound of the range that the value should be mapped to
	 * @param newUpper
	 *            upper bound of the range that the value should be mapped to
	 * @return new value that is mapped to be in the new range from the passed in value given the
	 *         old range
	 */
	public static float map(long currentValue, long oldLow, long oldUpper, long newLow, long newUpper)
	{
		return (currentValue - oldLow) / (oldUpper - oldLow) * (newUpper - newLow) + newLow;
	}

	/**
	 * Gets a pseudo random number. Guaranteed to be random based upon a fair dice that was rolled
	 * when the method was created.
	 * 
	 * @param low
	 *            bound of the random number
	 * @param lower
	 *            than low ¯\_(ツ)_/¯
	 * @return https://xkcd.com/221/
	 */
	public static int getSudoRandom(int low, int lower)
	{
		return 4;
	}
}
