package com.guilhebl.algo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * 
 * You are given a function: List getTimeSlots (String friend) Assume getTimeSlots() returns available times for a friend, sorted in order, with no overlap. You want to schedule a meeting among all of your friends, such that all can attend. Implement a function to get the first k common TimeSlots among all your friends:

Example:

user1 1-2pm, 3-4pm, 7-8pm user2 1-2pm, 5-6pm, 7-9pm

first 2 common: 1-2pm, 7-8pm
 *
 */
public class FirstCommonTimeslots {

	public static void main(String[] args) {
		List<List<TimeSlot>> timeslots = new ArrayList<List<TimeSlot>>();
				
		// friend 1
		List<TimeSlot> timeSlotList = new ArrayList<TimeSlot>();
		timeSlotList.add(new TimeSlot(6, 9));
		timeSlotList.add(new TimeSlot(10, 14));
		timeSlotList.add(new TimeSlot(16, 17));
		timeSlotList.add(new TimeSlot(19, 20));
		timeSlotList.add(new TimeSlot(21, 22));
		timeslots.add(timeSlotList);
		
		// friend 2
		timeSlotList = new ArrayList<TimeSlot>();
		timeSlotList.add(new TimeSlot(7, 8));
		timeSlotList.add(new TimeSlot(13, 14));
		timeSlotList.add(new TimeSlot(17, 18));
		timeSlotList.add(new TimeSlot(20, 23));
		timeslots.add(timeSlotList);

		// friend 3
		timeSlotList = new ArrayList<TimeSlot>();
		timeSlotList.add(new TimeSlot(5, 8));
		timeSlotList.add(new TimeSlot(13, 15));
		timeSlotList.add(new TimeSlot(19, 20));
		timeSlotList.add(new TimeSlot(21, 23));
		timeslots.add(timeSlotList);

		// friend 4
		timeSlotList = new ArrayList<TimeSlot>();
		timeSlotList.add(new TimeSlot(6, 8));
		timeSlotList.add(new TimeSlot(13, 16));
		timeSlotList.add(new TimeSlot(19, 20));
		timeSlotList.add(new TimeSlot(21, 22));
		timeslots.add(timeSlotList);

		printFirstNCommonTimeslots(timeslots, 3);
	}

	public static void printFirstNCommonTimeslots(List<List<TimeSlot>> timeslots, int n) {
		if (n <= 0 || timeslots == null || timeslots.isEmpty()) {
			return;			
		}		
		Set<TimeSlot> commonTimeSlots = new HashSet<>();
		
		TimeSlot candidate = null;
		int i = 0;
		int candidatesFound = 0;
		int listsAnalyzed = 0;
		boolean stillCandidate = false;
		boolean candidateFound = false;
		
		// get timeslots from first person and check if it matches with all others
		List<TimeSlot> firstPersonTimeslots = timeslots.get(0);				
		for (TimeSlot timeSlot : firstPersonTimeslots) {
			candidate = timeSlot;
			stillCandidate = true;			
			i = 1;
			while(i < timeslots.size() && stillCandidate) {
				List<TimeSlot> listT = timeslots.get(i);
				
				for (int j = 0; j < listT.size() && !candidateFound; j++) {
					TimeSlot timeSlot2 = listT.get(j);
										
					int initTimeA = candidate.init;
					int endTimeA = candidate.end;
					int initTimeB = timeSlot2.init;										
					int endTimeB = timeSlot2.end;
					
					if (initTimeA == initTimeB || endTimeB == endTimeA ||
							(initTimeA < endTimeB && initTimeA > initTimeB) ||
							(initTimeB < endTimeA && initTimeB > initTimeA)) {

						while (initTimeA != initTimeB) {
							if (initTimeA < initTimeB) {
								initTimeA++;
							} else if (initTimeA > initTimeB) { 
								initTimeB++;
							}
						}

						while (endTimeA != endTimeB) {
							if (endTimeA < endTimeB) {
								endTimeB--;
							} else if (endTimeA > endTimeB) {
								endTimeA--;								
							}						
						}

						candidate = new TimeSlot(initTimeA, endTimeA);
						candidateFound = true;						
					} 																							
				}
				
				if (candidateFound) {
					listsAnalyzed++;
					candidateFound = false;
				} else {
					stillCandidate = false;
					listsAnalyzed = 0;					
				}
				
				i++;
			}
			
			
			if (listsAnalyzed == timeslots.size() - 1) {
				commonTimeSlots.add(candidate);				
				candidatesFound++;
				listsAnalyzed = 0;
				
				if (candidatesFound == n) {
					break;
				}
			}
		}		
				

		if (candidatesFound > 0) {
			Iterator<TimeSlot> timeSlots = commonTimeSlots.iterator();			
			while(timeSlots.hasNext()) {				
				System.out.println(timeSlots.next());
			}			
		}
	}
	
	
}

class TimeSlot {
	int init;
	int end;
	
	public TimeSlot(int init, int end) {
		super();
		this.init = init;
		this.end = end;
	}
	
	@Override
	public String toString() {
		return init + " " + end; 		
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TimeSlot other = (TimeSlot) obj;
		if (end != other.end)
			return false;
		if (init != other.init)
			return false;
		return true;
	}
	
}
