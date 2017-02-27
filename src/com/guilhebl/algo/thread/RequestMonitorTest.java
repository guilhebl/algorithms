package com.guilhebl.algo.thread;

import java.util.Date;

/**
 * Tests a request monitor for mult-thread env.
 * 
 * the monitor will only enable 1 request to be done per thread for every X miliseconds
 *
 */
public class RequestMonitorTest {

	public static void main(String[] args) {
		// Lambda Runnable
		ThreadRequestRunnable task1 = new ThreadRequestRunnable("thread 1");
		 
		// start the thread
		Thread t1 = new Thread(task1);

		// Lambda Runnable
		ThreadRequestRunnable task2 = new ThreadRequestRunnable("thread 2");
		 
		// start the thread
		Thread t2 = new Thread(task2);

		// Lambda Runnable
		ThreadRequestRunnable task3 = new ThreadRequestRunnable("thread 3");
		
		// start the thread
		Thread t3 = new Thread(task3);
		
		t1.start();
		t2.start();
		t3.start();
		
		try {
			t1.join();
			t2.join();
			t3.join();
			
		} catch(InterruptedException e) {
			System.out.println("Main thread got interrupted");
		}
		
		System.out.println("Main Thread Exiting!");
	}
}

class ThreadRequestRunnable implements Runnable {
	
	String name;
	
	public ThreadRequestRunnable(String name) {
		super();
		this.name = name;
	}

	@Override
	public void run() {
		int maxCalls = 10;
		
		for(int i = 0; i < maxCalls; i++) {
			callWebservice();			
		}

		System.out.println(name + " ***** Exiting! ***** ");
	}
	
	public void callWebservice() {
		int tries = 1;				
		int maxTries = 10;
		int threadSleepMilis = 400;
		boolean proceed = RequestMonitor.getInstance().isRequestPossible();
		while (!proceed && tries < maxTries) {						
			System.out.println(name + " -> tentative to call WEBSERVICE blocked - wait for next period of " + threadSleepMilis + " miliseconds.");													
			RequestMonitor.getInstance().threadSleepMilis(threadSleepMilis);
			tries++;
			proceed = RequestMonitor.getInstance().isRequestPossible();
		}
		
		if (tries >= maxTries) {
			System.out.println(name + " -> FAILED to call WEBSERVICE - max tries limit reached!");
			return;
		}
		
		System.out.println(name + " -> called WEBSERVICE");
	}

}

class RequestMonitor {

	private long lastCall;
	private Integer waitIntervalMilis;
	
	private static RequestMonitor instance;
	
	private RequestMonitor() {		
		waitIntervalMilis = 950; // wait almost 1 second - 950 mls
		lastCall = new Date().getTime();
	}
	
	public static RequestMonitor getInstance() {
		if (instance == null) 
		{
			instance = new RequestMonitor();
		}
		return instance;
	}


	/**
	 * Checks if waitIntervalMilis has passed since last Call.
	 * 
	 * Difference in miliseconds (1*1000) = 1 second
	 * 
	 * @return
	 */
	public synchronized boolean isRequestPossible() {
		long now = new Date().getTime();
		if (now - lastCall >= waitIntervalMilis) {
			lastCall = now;
			return true;
		}
		return false;
	}

	public void threadSleepMilis(int milis) {
		try {
			Thread.sleep(milis);	
		} catch(InterruptedException e) {
			// do nothing
		}
	}
}
