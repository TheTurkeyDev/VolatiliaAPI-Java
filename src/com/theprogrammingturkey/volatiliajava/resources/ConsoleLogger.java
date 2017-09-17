package com.theprogrammingturkey.volatiliajava.resources;

import java.util.Arrays;
import java.util.List;

public class ConsoleLogger
{
	private static List<IConsoleOutput> outputRecievers = Arrays.asList(new BaseConsoleOutput());

	public static void log(Level level, String message)
	{
		for(IConsoleOutput reciever : outputRecievers)
			reciever.output(level, message);
	}

	public static void addOutputReciever(IConsoleOutput reciever)
	{
		outputRecievers.add(reciever);
	}

	public enum Level
	{
		NONE(""), INFO("Info"), IMPORTANT("IMPORTANT"), ALERT("Alert"), WARNING("Warning"), DEBUG("DeBug"), ERROR("ERROR");

		private String display;

		Level(String display)
		{
			this.display = display;
		}

		public String getDisplay()
		{
			return this.display;
		}
	}

	public interface IConsoleOutput
	{
		public void output(Level level, String message);
	}

	public static class BaseConsoleOutput implements IConsoleOutput
	{
		public static boolean debug = false;

		@Override
		public void output(Level level, String message)
		{
			if(level != Level.DEBUG || debug)
				System.out.println("[" + level.getDisplay() + "]: " + message);
		}

		public static void debug(boolean enabled)
		{
			debug = enabled;
		}
	}
}
