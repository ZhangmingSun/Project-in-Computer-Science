package edu.utdallas.taskExecutorImpl;

import edu.utdallas.blockingFIFO.BlockingTaskQueue;
import edu.utdallas.taskExecutor.Task;

public class TaskRunner implements Runnable {
	private static BlockingTaskQueue taskQueue = new BlockingTaskQueue();

	public static BlockingTaskQueue getTaskQueue() {
		return taskQueue;
	}

	@Override
	public void run() {
		while (true) {
			Task task = taskQueue.remove();
			task.execute();
		}
	}
}
