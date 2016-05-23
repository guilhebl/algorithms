package com.guilhebl.algo.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * There are n number of conference rooms available in a company for the 
 * meeting. You need to book a meeting for a particular time slot. 
 * Write an algorithm to determine the number of conference rooms available for the meeting with given start time and end time. 
 * Hint: any conference room with non- overlapping meeting will be selected.
 * 
 * 
 * Solution:
 * 1. transform day length in int minutes. 1 day = 24 * 60 = 1440 min - Intervals from 0 to 1440. e.g - Interval from 1PM to 1:30PM would be 
 * 1 PM = 13 * 60 = 780, 1:30 PM = 13 * 60 + 30 = 810
 * 3PM to 4PM = start : 15 * 60 - end : 16 * 60 = 900 - 960
 * 
 *   calculate for each room, any available interval such that:
 *   
 *   src.start <= target.start && src.end >= target.end
 *   
 *   return first found
 *
 */
public class CountAvailableIntervals {

	public static void main(String[] args) {		
		// Room 1 - 8AM - 9AM, 10:30AM - 11AM, 4PM - 5 PM
		ConfRoom rc1 = new ConfRoom();
		Interval rc1i1 = new Interval(480, 540);
		Interval rc1i2 = new Interval(630, 660);
		Interval rc1i3 = new Interval(960, 1020);
		rc1.addInterval(rc1i1);
		rc1.addInterval(rc1i2);
		rc1.addInterval(rc1i3);
		
		// Room 2 - 10AM - 12PM, 2:30PM - 4PM
		ConfRoom rc2 = new ConfRoom();		
		Interval rc2i1 = new Interval(600, 720);
		Interval rc2i2 = new Interval(870, 960);
		rc2.addInterval(rc2i1);
		rc2.addInterval(rc2i2);

		// Room 3 - 7AM - 8:30AM, 5PM - 6PM
		ConfRoom rc3 = new ConfRoom();		
		Interval rc3i1 = new Interval(420, 510);
		Interval rc3i2 = new Interval(1020, 1080);
		rc3.addInterval(rc3i1);
		rc3.addInterval(rc3i2);
		
		List<ConfRoom> cfs = new ArrayList<>();
		cfs.add(rc1);
		cfs.add(rc2);
		cfs.add(rc3);

		// check for any available room for 8 AM - 9AM
		System.out.println(isAvailableRooms(cfs, new Interval(480, 540)));

		// check for any available room for 3:30 PM - 5PM
		System.out.println(isAvailableRooms(cfs, new Interval(930, 1020)));

		// count available rooms from 10:30AM - 11AM
		System.out.println(countAvailableRooms(cfs, new Interval(630, 660)));

		System.out.println("**********************************************");
	}
	
	public static boolean isRoomAvailable(ConfRoom cf, Interval interval) {		
		List<Interval> itvs = cf.intervals;
		for (Interval interval2 : itvs) {
			if (isIntervalAvailable(interval2, interval)) {
				return true;
			}
		}
				
		return false;
	}

	// does target fit in src
	public static boolean isIntervalAvailable(Interval src, Interval target) {
		return (src.start <= target.start && src.end >= target.end);		
	}

	public static boolean isAvailableRooms(List<ConfRoom> cf, Interval interval) {
		for (ConfRoom confRoom : cf) {
			if (isRoomAvailable(confRoom, interval)) {
				return true;
			}
		}						
		return false;
	}

	public static int countAvailableRooms(List<ConfRoom> cf, Interval interval) {
		int roomsAvailable = 0;
		for (ConfRoom confRoom : cf) {
			if (isRoomAvailable(confRoom, interval)) {
				roomsAvailable++;
			}
		}
		return roomsAvailable;
	}
	
}

class ConfRoom {
	List<Interval> intervals;
	public ConfRoom() {
		intervals = new ArrayList<>();
	}	
	public void addInterval(Interval it) {
		if (intervals != null) {
			intervals.add(it);	
		}	
	}
}

class Interval {
	int start;
	int end;
	public Interval(int start, int end) {	
		this.start = start;
		this.end = end;
	}		
}
