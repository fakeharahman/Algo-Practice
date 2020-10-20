/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(final String[] args) {
		// code
		final Scanner input = new Scanner(System.in);
		int[] arr = { 0, 7, -1, 4, -1, -1, 2, 5 };
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != i && arr[i] != -1) {
				while (arr[i] != -1 && arr[i] != i) {
					// System.out.println("arri=" + arr[i] + " arriarri=" + arr[arr[i]]);
					int temp = arr[arr[i]];
					arr[arr[i]] = arr[i];
					arr[i] = temp;
					// int temp=arr[i];
					// arr[i]=arr[arr[i]];
					// arr[arr[i]]=temp;
				}
			}
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		input.close();

	}
}