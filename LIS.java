import java.util.Arrays;



/*
  create a temporay array of same size.
  Intialize them to 1, because if the size of the array is 1 then the longest subsequence will be 1
  start i from 1 and from 0 to i
  if(value at j is less than i)
   assign the max(temp[i],temp[j] + 1)
*/

public class LIS {

	public static void main(String[] args) {
		int[] input = {3,4,-1,0,6,2,3};
		System.out.println("The longeest increasing subsequence lenght is " + lis(input));
	}
	
	public static int lis(int[] input){
		int[] temp = new int[input.length];
		for(int i = 0; i < input.length; i++){
			temp[i] = 1;
		}
		for(int i = 1; i < temp.length;i++){
			for(int j = 0; j < i; j++){
				if(input[j] < input[i]){
					temp[i] = Math.max(temp[i], temp[j] + 1);
				}
			}
		}
		Arrays.sort(temp);
		return temp[temp.length - 1];
	}

}
