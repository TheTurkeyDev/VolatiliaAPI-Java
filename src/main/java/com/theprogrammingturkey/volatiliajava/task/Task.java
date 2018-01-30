package com.theprogrammingturkey.volatiliajava.task;

public abstract class Task
{
	public String name;
	public int delayLeft;
	private boolean forever = false;

	public int updateTick;

	/**
	 * Creates a task that runs for a given amount of time then calls its callback function.
	 * 
	 * @param name
	 *            of the task. Not really used for anything yet.
	 * @param delay
	 *            in ticks the task runs for before calling its callback function.
	 */
	public Task(String name, int delay)
	{
		this(name, delay, -1);
	}

	/**
	 * Creates a task that runs for a given amount of time then calls its callback function, but
	 * also calls an update function every specified interval.
	 * 
	 * @param name
	 *            of the task. Not really used for anything yet.
	 * @param delay
	 *            in ticks the task runs for before calling its callback function. Set to -1 to run
	 *            forever and never call the callback function.
	 * @param updateTick
	 *            interval in ticks that the task should call its update function.
	 */
	public Task(String name, int delay, int updateTick)
	{
		this.name = name;
		this.delayLeft = delay;
		if(delay == -1)
			forever = true;
		this.updateTick = updateTick;
	}

	/**
	 * Returns whether or not this task should call its update method based upon how many ticks this
	 * task has left.
	 * 
	 * @return If the task should update
	 */
	public boolean shouldUpdate()
	{
		return this.updateTick != -1 && (delayLeft % updateTick) == 0;
	}

	/**
	 * Callback method when the task completes by reaching 0 on it's ticks left.
	 */
	public abstract void callback();

	/**
	 * Ticks the given task. Not sure what else you want from me...
	 * 
	 * @return if the task is now complete
	 */
	public boolean tickTask()
	{
		this.delayLeft--;
		return this.delayLeft <= 0 && !forever;
	}

	/**
	 * Method called when the task reaches an update point based upon the given values.
	 */
	public void update()
	{

	}
}