package com.theprogrammingturkey.volatiliajava;

import com.theprogrammingturkey.volatiliajava.task.Scheduler;
import com.theprogrammingturkey.volatiliajava.task.Task;

public class TaskTest
{
	public TaskTest()
	{
		Scheduler.scheduleSyncTask(createTask("Task 1", 1));
		Scheduler.scheduleSyncTask(createTask("Task 2", 3));
		Scheduler.scheduleSyncTask(createUpdateTask("Task 3", 6));
		Scheduler.scheduleSyncTask(createUpdateTask("Task 4", 10));
		Scheduler.scheduleAsyncTask(createTask("Task 5", 2), 1000);
		Scheduler.scheduleAsyncTask(createTask("Task 6", 4), 1000);
		Scheduler.scheduleAsyncTask(createUpdateTask("Task 7", 8), 1000);
		Scheduler.scheduleAsyncTask(createUpdateTask("Task 8", 11), 1000);

		//Simulate Game Loop
		for(int i = 1; i <= 20; i++)
		{
			try
			{
				Thread.sleep(1000);
			} catch(InterruptedException e)
			{
				e.printStackTrace();
			}
			System.out.println(i + " second");
			Scheduler.tickSyncTasks();
		}
	}

	public Task createTask(String name, int delay)
	{
		return new Task(name, delay)
		{
			@Override
			public void callback()
			{
				System.out.println(this.name + " has finished");
			}
		};
	}

	public Task createUpdateTask(String name, int delay)
	{
		return new Task(name, delay, 1)
		{
			@Override
			public void callback()
			{
				System.out.println(this.name + " has finished");
			}

			@Override
			public void update()
			{
				System.out.println(this.name + " has updated");
			}
		};
	}

	public static void main(String[] args)
	{
		new TaskTest();
	}
}
