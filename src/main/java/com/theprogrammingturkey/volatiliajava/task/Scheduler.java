package com.theprogrammingturkey.volatiliajava.task;

import java.util.ArrayList;
import java.util.List;

public class Scheduler
{
	private static List<Task> syncTasks = new ArrayList<Task>();
	private static List<Task> asyncTasks = new ArrayList<Task>();

	/**
	 * Schedules a synchronous task to be added to the pool. Relies on the implementer to call the
	 * {@link #tickSyncTasks()} method to tick the tasks
	 * 
	 * @param task
	 *            to schedule
	 * @return If the task was successfully scheduled
	 */
	public static boolean scheduleSyncTask(Task task)
	{
		if(task.delayLeft <= 0)
		{
			task.callback();
			return false;
		}
		return syncTasks.add(task);
	}

	/**
	 * Removes a scheduled synchronous task from the pool.
	 * 
	 * @param task
	 *            to remove
	 * @return If the task was successfully removed
	 */
	public static boolean removeSyncTask(Task task)
	{
		task.kill();
		return syncTasks.remove(task);
	}

	/**
	 * * Schedules a asynchronous task to be added to the pool.
	 * 
	 * @param task
	 *            to schedule
	 * @param tickLength
	 *            length of time in milliseconds between ticks
	 * @return If the task was successfully scheduled
	 */
	public static boolean scheduleAsyncTask(final Task task, int tickLength)
	{
		if(task.delayLeft <= 0)
		{
			task.callback();
			return false;
		}

		Thread thread = new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				while(task.isAlive())
				{
					try
					{
						Thread.sleep(tickLength);
					} catch(InterruptedException e)
					{
						e.printStackTrace();
					}
					if(task.tickTask())
					{
						task.callback();
						task.kill();
					}
					else if(task.shouldUpdate())
					{
						task.update();
					}
				}
				System.out.println(task.getName() + " has terminated");
			}
		});
		thread.start();
		return asyncTasks.add(task);
	}

	/**
	 * Removes the asyncTask from the pool and ends the tasks thread.
	 * 
	 * @param task
	 *            to be removed
	 * @return If the task was successfully removed
	 */
	public static boolean removeAsyncTask(Task task)
	{
		task.kill();
		return asyncTasks.remove(task);
	}

	/**
	 * Method used to tick all of the synchronous tasks. Requires the implementer to call this
	 * method to tick the synchronous tasks in the pool. Will also remove all async tasks safely
	 */
	public static void tickSyncTasks()
	{
		System.out.println("Sync: " + syncTasks.size());
		System.out.println("Async: " + asyncTasks.size());
		for(int i = syncTasks.size() - 1; i >= 0; i--)
		{
			Task task = syncTasks.get(i);
			if(!task.isAlive())
			{
				syncTasks.remove(i);
				continue;
			}

			if(task.tickTask())
			{
				task.callback();
				syncTasks.remove(i);
			}
			else if(task.shouldUpdate())
			{
				task.update();
			}
		}

		for(int i = asyncTasks.size() - 1; i >= 0; i--)
			if(!asyncTasks.get(i).isAlive())
				asyncTasks.remove(i);
	}
}