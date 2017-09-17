package com.theprogrammingturkey.volatiliajava.resources;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

import com.theprogrammingturkey.volatiliajava.resources.ConsoleLogger.Level;

public class FileHelper
{
	public static String loadFile(String location)
	{
		return loadFile(new File(location));
	}

	public static String loadFile(File file)
	{
		FileReader isr = null;
		try
		{
			isr = new FileReader(file);
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

	public void writeToFile(File file, String output)
	{
		try
		{
			FileOutputStream outputStream = new FileOutputStream(file);
			OutputStreamWriter writer = new OutputStreamWriter(outputStream);
			writer.append(output);
			writer.close();
			outputStream.close();
		} catch(Exception e)
		{
			ConsoleLogger.log(Level.ERROR, "Failed to write to the file \"" + file.getName() + "\"!");
			ConsoleLogger.log(Level.ERROR, e.getMessage());
			e.printStackTrace();
		}
	}
}
