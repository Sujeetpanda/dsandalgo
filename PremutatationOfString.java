package com.sujeet.algo.greedy;

public class PremutatationOfString {

	static char[] inputStr = new String("ABC").toCharArray();
	public static void main(String[] args) {
		permute(inputStr,0,2);

	}
	
	public static void permute(char[] str,int start,int end){
		if(start == end){
			System.out.println(str);
		}else{
			for(int i = start;i <= end;i++){
				swap(start,i);
				permute(str,start+1,end);
				swap(start,i);
			}
		}
	}
	
	public static void swap(int i, int j){
		char temp = inputStr[i];
		inputStr[i] = inputStr[j];
		inputStr[j] = temp;
	}

}
