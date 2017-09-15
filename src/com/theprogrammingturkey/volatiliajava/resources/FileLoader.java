package com.theprogrammingturkey.volatiliajava.resources;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.theprogrammingturkey.volatiliajava.resources.ConsoleLogger.Level;

public class FileLoader
{
	public static String loadFile(String location)
	{
		FileReader isr = null;
		try
		{
			isr = new FileReader(new File(location));
		} catch(FileNotFoundException e)
		{
			ConsoleLogger.log(Level.ERROR, "File not found!!");
		}

		StringBuilder builder = new StringBuilder();
		BufferedReader reader = new BufferedReader(isr);
		try
		{
			String line;
			while((line = reader.readLine()) != null)
				builder.append(line);

			reader.close();
		} catch(IOException e)
		{
			ConsoleLogger.log(Level.ERROR, e.getMessage());
		}

		return builder.toString();
	}
}
