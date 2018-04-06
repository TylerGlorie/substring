//written by Tyler Glorie

package substring;

import java.util.Arrays;
import java.util.Scanner;

public class Substring {
	public static int numStrings;
	
	public static void main(String[] args) {
		 Scanner stdin = new Scanner(System.in);
		 
		 //read number of sets of strings
		 numStrings = Integer.parseInt(stdin.nextLine());
		 
		 //print the output of count for each set of strings
		 for(int i = 0; i < numStrings; i++ ) {
			 
			 //read in two string from the standard input
			 String a = stdin.nextLine();
			 String b = stdin.nextLine();
			 
			 //print the result of count()
			 System.out.println(count(a,b));
		 }
		 stdin.close();
	}
	//solve problem using Dynamic Programming techniques
	public static long count(String a, String b) {
		
		int n = a.length();
		int m = b.length();
		
		//create lookup table and fill with 0
		long[][] lookup = new long[n + 1][m + 1];
		for(long[] row: lookup) Arrays.fill(row, 0);
		
		//if the second string is empty
		for(int i = 0; i <= n; i++) {
			lookup[i][0] = 1;
		}
		
		//fill lookup table from the bottom up
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= m; j++) {
				
				//if two chars are the same 
				// check if last chars of each string are in solution
				if( a.charAt(i-1) == b.charAt(j - 1)) {
					lookup[i][j] = lookup[i - 1][j - 1] + lookup[i - 1][j];
				}else {
					// otherwise ignore the last character of the main string
					lookup[i][j] = lookup[i - 1][j];
				}
				
			}
		}
		return lookup[n][m];
		
	}
}
