package com.sujeet.algo.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class MeetingSchedulingAlgo {
	static int MAX = 0;
	
	
	public static void main(String[] args) {
		//Create different meeting objects
		Meeting m1 = new Meeting(8,12);
		Meeting m2 = new Meeting(8,10);
		Meeting m3 = new Meeting(9,10);
		Meeting m4 = new Meeting(10,11);
		Meeting m5 = new Meeting(12,1);
		
		
		List<Meeting> meetingList = new ArrayList<Meeting>();
		meetingList.add(m1);
		meetingList.add(m2);
		meetingList.add(m3);
		meetingList.add(m4);
		meetingList.add(m5);
		
		List<Integer> startTimeList = new ArrayList<Integer>();
		List<Integer> endTimeList = new ArrayList<Integer>();
		
		for(Meeting m : meetingList){
			startTimeList.add(m.getStartTime());
			endTimeList.add(m.getEndTime());
		}
		
		//Take all the timing and sort it
		Set<Integer> timeSet = new TreeSet<Integer>();
		timeSet.addAll(startTimeList);
		timeSet.addAll(endTimeList);
		
		for(Integer i : timeSet){
			System.out.println("The unique times are " + i);
		}
		
		
		for(Integer i : timeSet){
			int startFeq = Collections.frequency(startTimeList, i);
			int endFeq = Collections.frequency(endTimeList, i);
			int temp = MAX;
			//temp will be calculated with total number of meeting rooms needed at a particular time
			temp = temp + startFeq - endFeq;
			if(temp > MAX){
				MAX = temp;
			}
		}
		
		System.out.println("The number of room required is :" + MAX);

	}

}

//Meeting class with startTime and endTime
class Meeting{
	int startTime;
	int endTime;
	public Meeting(int startTime, int endTime) {
		super();
		this.startTime = startTime;
		this.endTime = endTime;
	}
	public int getStartTime() {
		return startTime;
	}
	public int getEndTime() {
		return endTime;
	}
	
	
	
}
