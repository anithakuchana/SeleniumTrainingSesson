package practiceassignments;

import java.util.Arrays;

public class TwoStringAnagrams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s1 = "silent";
		String s2 = "listen";

		char[] a = s1.toCharArray();
		char[] b = s2.toCharArray();

		Arrays.sort(a);
		Arrays.sort(b);

		System.out.println(Arrays.equals(a, b));

	}

}
