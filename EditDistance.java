http://www.geeksforgeeks.org/dynamic-programming-set-5-edit-distance/
//Logic
/*
  if(characters match then copy from the diagonal)
  else
    min(diagonal,left,up) + 1
  */
  
  import java.util.ArrayList;
import java.util.Collections;


public class EditDistance {

	public static void main(String[] args) {
		char[] str1 = {'a','b','c','d','e','f'};
		char[] str2 = {'a','z','c','e','d'};
		
		System.out.println("The minimum numbe of changes required " + minimumchange(str1,str2));
	}
	
	public static int minimumchange(char[]str1,char[] str2){
		int[][] temp = new int[str2.length + 1][str1.length + 1];
		
		for(int i = 0;i < str1.length + 1;i++){
			temp[0][i] = i;
		}
		for(int j = 0; j < str2.length + 1;j++){
			temp[j][0] = j;
		}
/*		for(int i = 0; i < str2.length + 1;i++){
			for(int j = 0; j < str1.length + 1;j++){
				System.out.print(" "+temp[i][j]);
			}
			System.out.println();
		}*/
		
		for(int i = 1;i < str2.length + 1; i++){
			for(int j = 1; j < str1.length + 1;j++){
				if(str2[i - 1] == str1[j -1 ]){
					temp[i][j] = temp[i - 1][j - 1];
				}else{
					ArrayList<Integer> tempList = new ArrayList<Integer>();
					tempList.add(temp[i -i][j]);
					tempList.add(temp[i][j -1]);
					tempList.add(temp[i - 1][j - 1]);
					
					Collections.sort(tempList);
					temp[i][j] = tempList.get(0) + 1;
				}
			}
		}
		
				for(int i = 0; i < str2.length + 1;i++){
		for(int j = 0; j < str1.length + 1;j++){
			System.out.print(" "+temp[i][j]);
		}
		System.out.println();
	}
		return temp[str2.length][str1.length];
	}
	

}
