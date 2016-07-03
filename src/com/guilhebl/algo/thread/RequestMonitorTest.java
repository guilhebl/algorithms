package com.guilhebl.algo.thread;

import java.util.Date;

public class RequestMonitorTest {

	public static void main(String[] args) {
		// Lambda Runnable
		AmazonRunnable task1 = new AmazonRunnable("thread 1");
		 
		// start the thread
		Thread t1 = new Thread(task1);

		// Lambda Runnable
		AmazonRunnable task2 = new AmazonRunnable("thread 2");
		 
		// start the thread
		Thread t2 = new Thread(task2);

		// Lambda Runnable
		AmazonRunnable task3 = new AmazonRunnable("thread 3");
		
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

class AmazonRunnable implements Runnable {
	
	String name;
	
	public AmazonRunnable(String name) {
		super();
		this.name = name;
	}

	@Override
	public void run() {
		int maxCalls = 10;
		
		for(int i = 0; i < maxCalls; i++) {
			callAmazon();			
		}

		System.out.println(name + " ***** Exiting! ***** ");
	}
	
	public void callAmazon() {
		int tries = 1;				
		int maxTries = 10;
		int threadSleepMilis = 400;
		boolean proceed = AmazonRequestMonitor.getInstance().isRequestPossibleUnitedStates();
		while (!proceed && tries < maxTries) {						
			System.out.println(name + " -> tentative to call Amazon AWS Product Advertising API blocked - wait for next period of " + threadSleepMilis + " miliseconds.");													
			AmazonRequestMonitor.getInstance().threadSleepMilis(threadSleepMilis);
			tries++;
			proceed = AmazonRequestMonitor.getInstance().isRequestPossibleUnitedStates();
		}
		
		if (tries >= maxTries) {
			System.out.println(name + " -> tentative to call Amazon AWS Product Advertising API failed - max tries limit reached!");
		}
		
		System.out.println(name + " -> called Amazon");
	}

}

class AmazonRequestMonitor {

	private long lastCall;
	private Integer waitIntervalMilis;
	
	private static AmazonRequestMonitor instance;
	
	private AmazonRequestMonitor() {		
		waitIntervalMilis = 950;
		lastCall = new Date().getTime();
	}
	
	public static AmazonRequestMonitor getInstance() {
		if (instance == null) 
		{
			instance = new AmazonRequestMonitor();
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
	public synchronized boolean isRequestPossibleUnitedStates() {
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
