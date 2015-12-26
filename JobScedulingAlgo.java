
/*
 Sort the list as per the descending order  of profit.
 Take the first task
 check if the any of the remaining tasks can be accomodated in the list
 (if the task - 1 cell is empty then add and make the cell as occupied. Similarly if the cell from 0 to that cell is empty we can
 add the task other wise skip it)
 
 
 Referecne.
 https://www.youtube.com/watch?v=yHsDLU3ZqNM

*/


package com.sujeet.algo.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class JobScedulingAlgo {

	public static void main(String[] args) {
		ArrayList<Job> jobList = new ArrayList<Job>();
		
		Job j1 = new Job('a',2,100);
		Job j2 = new Job('b',1,19);
		Job j3 = new Job('c',2,27);
		Job j4 = new Job('d',1,25);
		Job j5 = new Job('e',3,15);
		
		jobList.add(j1);
		jobList.add(j2);
		jobList.add(j3);
		jobList.add(j4);
		jobList.add(j5);
		
		Collections.sort(jobList, new MyComparator());
		

		
		
		ArrayList<Integer> timeList = new ArrayList<Integer>();
		for(Job j: jobList){
			timeList.add(j.getTime());
			System.out.println(j.toString());
		}
		
		int max = Collections.max(timeList);
		boolean[] arr = new boolean[max];
		for(int i = 0;i < max;i++){
			arr[i] = false;
		}
		ArrayList<Job> outputList = new ArrayList<Job>();
		
		for(Job j : jobList){
			Integer time = j.getTime();
			if(arr[time - 1] == false){
				arr[time -1 ] = true;
				outputList.add(j);
			}else{
				for(int k = 0 ; k < time; k++){
					if(arr[k] == false){
						arr[k] = true;
						outputList.add(j);
					}
				}
			}
		}
		
		System.out.println("********************************");
		
		for(Job j : outputList){
			System.out.println(j.toString());
		}
	}

}

class Job{

	@SuppressWarnings("unused")
	private char name;
	@SuppressWarnings("unused")
	private int time;
	private int profit;
	
	public Job(char name, int time, int profit) {
		this.name = name;
		this.time = time;
		this.profit = profit;
	}

	public char getName() {
		return name;
	}

	public int getTime() {
		return time;
	}

	public int getProfit() {
		return profit;
	}

	@Override
	public String toString() {
		return "Job [name=" + name + ", time=" + time + ", profit=" + profit
				+ "]";
	}
	
}

class MyComparator implements Comparator<Job>{

	@Override
	public int compare(Job o1, Job o2) {
		Integer i1 = o1.getProfit();
		Integer i2 = o2.getProfit();
		
		return (-(i1 - i2));
	}
	
}
