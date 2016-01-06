http://www.geeksforgeeks.org/dynamic-programming-set-4-longest-common-subsequence/

//Logic
/*
  if(characters match)
    diagonal + 1
  else
    max(left,top)
    */
    
public class LCS {

	public static void main(String[] args) {
		char[] str1 = {'a','b','c','d','a','f'};
		char[] str2 = {'a','c','b','c','f'};
		
		System.out.println("The longest LCS is " + longestCommonSubstring(str1,str2));
	}
	public static int longestCommonSubstring(char[] str1,char[] str2){
		int[][] temp = new int[str2.length + 1][str1.length + 1];
		
		for(int i = 0; i < str1.length;i++){
			temp[0][i] = 0;
		}
		for(int j = 0; j < str2.length;j++){
			temp[j][0] = 0;
		}

		for(int i = 0 ; i < str2.length;i++){
			for(int j = 0; j < str1.length;j++){
				if(str2[i] == str1[j]){
					temp[i + 1][j + 1] = temp[i][j] + 1;
				}else{
					temp[i + 1][j + 1] = Math.max(temp[i][j + 1], temp[i + 1][j]);
				}
			}
		}
		for(int i = 0; i < str2.length + 1; i++){
			for(int j = 0; j < str1.length + 1; j++){
				System.out.print(" " + temp[i][j]);
			}
			System.out.println();
		}
		return temp[str2.length][str1.length];
	}

}
