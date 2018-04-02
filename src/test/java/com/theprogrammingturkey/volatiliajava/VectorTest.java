package com.theprogrammingturkey.volatiliajava;

import com.theprogrammingturkey.volatiliajava.math.Vector2F;
import com.theprogrammingturkey.volatiliajava.math.Vector2I;

public class VectorTest
{
	public VectorTest()
	{
		Vector2I vec1 = new Vector2I(1, 2);
		Vector2F vec2 = new Vector2F(1.5f, 2.33f);
		Vector2F vec3 = new Vector2F(1.5f, 2.33f);
		System.out.println("(1,2) == (1.5, 2.33): " + vec1.equals(vec2));
		System.out.println("(1.5,2.33) == (1.5, 2.33): " + vec2.equals(vec3));
	}

	public static void main(String[] args)
	{
		new VectorTest();
	}
}
