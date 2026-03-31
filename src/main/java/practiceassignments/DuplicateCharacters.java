package practiceassignments;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DuplicateCharacters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		findDuplicates("Automation");
		System.out.println();
		findDuplicates("Anitha");

		System.out.println("\n-------using set method-----------\n0");

		Set<Character> s = findDuplicates2("Hello World");
		System.out.println(s);

	}

	public static void findDuplicates(String str) {
		Map<Character, Integer> charCount = new HashMap<>();

		// count for frequency

		for (char c : str.toLowerCase().toCharArray()) {
			charCount.put(c, charCount.getOrDefault(c, 0) + 1);

		}

		// print characters with count > 1

		System.out.println("Duplicate characters in \" " + str + "\":");

		for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
			if (entry.getValue() > 1) {
				System.out.println(" ' " + entry.getKey() + " ' -> " + entry.getValue());
			}
		}

	}

	public static Set<Character> findDuplicates2(String str) {
		Set<Character> seen = new HashSet<>();
		Set<Character> duplicates = new HashSet<>();

		for (char c : str.toCharArray()) {
			if (!seen.add(c)) // add() returns false if already present
				duplicates.add(c);
		}
		return duplicates; // e.g. [r, g, m]
	}

}
