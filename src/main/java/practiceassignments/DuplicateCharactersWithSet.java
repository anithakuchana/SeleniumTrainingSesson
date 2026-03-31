package practiceassignments;

import java.util.HashSet;
import java.util.Set;

public class DuplicateCharactersWithSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "Automation Testing";

		Set<Character> set = new HashSet<>();
		Set<Character> duplicates = new HashSet<>();

		for (char c : str.toLowerCase().toCharArray()) {

			if (!set.add(c)) {
				duplicates.add(c);
			}
		}

		System.out.println("Duplicate Charcaters :" + duplicates);

	}

}
