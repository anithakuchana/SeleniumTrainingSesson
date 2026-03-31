package practiceassignments;

public class MaxMInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = { 10, 18, 5, 23, 19, 6, 1 };

		int max = arr[0];
		int min = arr[0];

		for (int num : arr) {
			if (num > max)
				max = num;
			if (num < min)
				min = num;
		}

		System.out.println("Max :" + max);
		System.out.println("Min :" + min);

	}

}
