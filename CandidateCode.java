package com.sujeet.algo.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

//Java program to print all combination of size r in an array of size n

class CandidateCode {
	static int count = 0;
	static int sum = 0;
	
	static ArrayList<UtilityClass> utilityOutput = new ArrayList<UtilityClass>();

	/* arr[] ---> Input Array
	data[] ---> Temporary array to store current combination
	start & end ---> Staring and Ending indexes in arr[]
	index ---> Current index in data[]
	r ---> Size of a combination to be printed */
	static void combinationUtil(Candidate arr[], Candidate data[], int start,
								int end, int index, int r)
	{
		// Current combination is ready to be printed, print it
		if (index == r)
		{
			ArrayList<Candidate> candidataList = new ArrayList<Candidate>();
			for (int j=0; j<r; j++){
				//System.out.print(data[j].toString());
				sum = sum + data[j].getMark();
				candidataList.add(data[j]);
			}
			UtilityClass temp = new UtilityClass(candidataList,sum);
			utilityOutput.add(temp);
			sum = 0;
			System.out.println("");
			count++;
			return;
		}

		// replace index with all possible elements. The condition
		// "end-i+1 >= r-index" makes sure that including one element
		// at index will make a combination with remaining elements
		// at remaining positions
		for (int i=start; i<=end && end-i+1 >= r-index; i++)
		{
			data[index] = arr[i];
			combinationUtil(arr, data, i+1, end, index+1, r);
		}
	}

	// The main function that prints all combinations of size r
	// in arr[] of size n. This function mainly uses combinationUtil()
	static void printCombination(Candidate arr[], int n, int r)
	{
		// A temporary array to store all combination one by one
		Candidate data[]=new Candidate[r];

		// Print all combination using temprary array 'data[]'
		combinationUtil(arr, data, 0, n-1, 0, r);
	}

	/*Driver function to check for above function*/
	public static void main (String[] args) {
		Candidate[] canditates = new Candidate[10];
		canditates[0] = new Candidate("C1",2);
		canditates[1] = new Candidate("C2",5);
		canditates[2] = new Candidate("C3",1);
		canditates[3] = new Candidate("C4",2);
		canditates[4] = new Candidate("C5",4);
		canditates[5] = new Candidate("C6",1);
		canditates[6] = new Candidate("C7",6);
		canditates[7] = new Candidate("C8",5);
		canditates[8] = new Candidate("C9",2);
		canditates[9] = new Candidate("C10",2);
		

		int r = 6;
		int n = canditates.length;
		printCombination(canditates, n, r);
		//System.out.println("Sujeet********************************" + count);
		Collections.sort(utilityOutput, new MyComparatorUtility());
		for(int i = 0 ; i < 6; i++){
			System.out.println(utilityOutput.get(i).toString());
		}
		
	}
}

class Candidate{
	String name;
	int mark;
	public Candidate(String name, int mark) {
		super();
		this.name = name;
		this.mark = mark;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMark() {
		return mark;
	}
	public void setMark(int mark) {
		this.mark = mark;
	}
	@Override
	public String toString() {
		return "Candidate [name=" + name + ", mark=" + mark + "]";
	}
	
	
}

class UtilityClass{
	private ArrayList<Candidate> candidateList;
	private int total;
	public UtilityClass(ArrayList<Candidate> candidateList, int total) {
		this.candidateList = candidateList;
		this.total = total;
	}
	public ArrayList<Candidate> getCandidateList() {
		return candidateList;
	}
	public void setCandidateList(ArrayList<Candidate> candidateList) {
		this.candidateList = candidateList;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	@Override
	public String toString() {
		return "UtilityClass [candidateList=" + candidateList + ", total="
				+ total + "]";
	}
	
	
	
	
}

class MyComparatorUtility implements Comparator<UtilityClass>{

	@Override
	public int compare(UtilityClass o1, UtilityClass o2) {
		return -(o1.getTotal() - o2.getTotal());
	}
}

