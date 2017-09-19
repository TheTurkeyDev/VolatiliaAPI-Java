package com.theprogrammingturkey.volatiliajava.math;

public class MathHelper
{
	public static int clamp(int lower, int upper, int number)
	{
		if(number < lower)
			return lower;
		if(number > upper)
			return upper;
		return number;
	}

	public static float clamp(float lower, float upper, float number)
	{
		if(number < lower)
			return lower;
		if(number > upper)
			return upper;
		return number;
	}
}
