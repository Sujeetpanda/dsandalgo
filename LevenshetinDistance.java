
public class LevenshetinDistance {

	public static void main(String[] args) {
		String source = "abcdef";
		String dest = "azced";
		
		int[][] arr = new int[dest.length() + 1][source.length() + 1];
		
		for(int i = 0; i < source.length() + 1;i++) {
			arr[0][i] = i;
		}
		for(int j = 0 ; j < dest.length() + 1; j++) {
			arr[j][0] = j;
		}
		
		for(int i = 1;i < dest.length() + 1; i++) {
			for(int j = 1; j < source.length() + 1;j++) {
				if(dest.charAt(i - 1) == source.charAt(j - 1)) {
					arr[i][j] = arr[i - 1][j-1];
				}else {
					int a = arr[i][j -1];
					int b = arr[i - 1][j];
					int c = arr[i - 1][j-1];
					System.out.println(a+" " + b + " " + c);
					int mn = (a<b)?((a<c)?a:c):((b<c)?b:c);
					 arr[i][j] = mn + 1;
				}
			}
		}
		
		for(int i = 0; i < dest.length() + 1;i++) {
			for(int j = 0; j < source.length() + 1; j++) {
				System.out.print(" " + arr[i][j]);
			}
			System.out.println();
		}
		
		
	}

}
