

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
/*		int[] arr = {1,1,1,2,3,3,3};
		int[] out = removeDuplicates(arr);
		for(int i: out){
			//System.out.print(" " + i);
		}
		System.out.println();
		int i = 4;
		int j = 5;
		
		System.out.println(++i + ++j);
		System.out.println(i+"        " + j);
		
		String str = "Sachin :100,23,120,34,98";
		String[] temp = null;
		if(str.contains("Sachin")){
			temp = str.split(":");
		}
		
		System.out.println(temp.length);
		
		System.out.println("Temp--- 0 : " + temp[0]);
		System.out.println("Temp--- 1 : " + temp[1]);
		
		String[] temp1 = temp[1].split(",");
		int count = 0;
		for(String s : temp1){
			count = count + Integer.parseInt(s);
		}
		System.out.println("Total count = " + count);
		
		System.out.println("*******************************************");
		
		//Two separate object
		Integer x = new Integer(10);
		Integer y = new Integer(10);
		System.out.println(x == y);
		
		String userName = null;
		Console console = System.console();
		userName = console.readLine("Enter your name");
		System.out.println(userName);
		
		Scanner in;
		in = new Scanner(System.in);
		
		userName = in.nextLine();
		System.out.println(userName);
		
		int input = Integer.parseInt(userName);
		System.out.println(input + 20);*/
		
		
		
		System.out.println("*******************longestCommonSubsequene**************************");
		//System.out.println(longestCommonSubsequene(new StringBuilder("AGGTAB"),new StringBuilder("GXTXAYB")));
		
		//longestCommonSubsequene("AGGTAB","GXTXAYB");
		
		 maxIncreaseSubsequence();

	
	}
	
	
	public static int[] removeDuplicates(int[] input){
		int j = 0;
		int i = 1;
		
		if(input.length < 2){
			return input;
		}
		while(i < input.length){
			if(input[i] == input[j]){
				i++;
			}else{
				input[++j] = input[i++];
			}
		}
		
		int[] output = new int[j+1];
		for(int k = 0; k < output.length; k++){
			output[k] = input[k];
		}
		return output;
	}





/*public static int longestCommonSubsequene(StringBuilder input1,StringBuilder input2){
	int len1 = input1.length();
	int len2 = input2.length();
	
	if(len1 == 0 || len2 == 0){
		return 0;
	}
	String str1 = input1.toString();
	String str2 = input2.toString();
	char[] temp1 = str1.toCharArray();
	char[] temp2 = str2.toCharArray();
	
	
	
	if(temp1[0] == temp1[0]){
		return 1 + longestCommonSubsequene(new StringBuilder().append(temp1,1,len1 - 1),new StringBuilder().append(temp2,1,len2 - 1));
	}else{
		return Math.max(longestCommonSubsequene(new StringBuilder().append(temp1,1,len1 - 1),new StringBuilder().append(temp1,0,len2 - 1)),longestCommonSubsequene(new StringBuilder().append(temp1,0,len1 - 1),new StringBuilder().append(temp1,1,len2 - 1)));
	}
}*/

/*public static void longestCommonSubsequene(String str1,String str2){
	int len1 = str1.length();
	int len2 = str2.length();
	
	int[][] arr = new int[len1][len2];
	
	for(int i = 0 ; i <= len1; i ++){
		arr[i][len2] = 0;
	}
	for(int j = 0; j <= len2; j++){
		arr[len1][j] = 0;
	}
	
	for(int i = 0; i < len1;i++){
		for(int j = 0; j < len2; j++){
			if(str1.charAt(i) == str2.charAt(j)){
				arr[i][j] = 1 + arr[i-1][j-1];
			}else{
				arr[i][j] = Math.max(arr[i-1][j],arr[i][j-1]);
			}
		}
	}
	for(int i = 0 ; i < len1; i++){
		for(int j = 0; j < len2; j++){
			System.out.println(" " + arr[i][j]);
		}
	}
}*/
	
	


public static void maxIncreaseSubsequence(){
	int[] arr = {4,6,1,3,8,4,6};
	int[] temp = new int[arr.length];
	
	
	for(int i = 0; i < arr.length; i++){
		temp[i] = 0;
	}
	temp[0] = arr[0];
	for(int i = 1; i < arr.length; i++){
		int k = i - 1;
		while(k >= 0){
			if(arr[i] > arr[k]){
				int tmp = temp[k] + arr[i];
				if(tmp > temp[i]){
					temp[i] = tmp;
				}
			}
			k--;
		}
		if(arr[i] > temp[i]){
			temp[i] = arr[i];
		}
	}
	for(int i = 0; i < arr.length; i++){
		System.out.print("	"	+ arr[i]);
	}
	System.out.println();
	for(int i = 0; i < arr.length; i++){
		System.out.print("	"	+ temp[i]);
	}
	
}
}
