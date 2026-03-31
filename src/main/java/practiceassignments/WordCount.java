package practiceassignments;

import java.util.HashMap;
import java.util.Map;

public class WordCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "java selenium Java test selenium Automation";

		String[] words = str.toLowerCase().split(" ");

		Map<String, Integer> map = new HashMap<>();

		for (String s : words) {
			map.put(s, map.getOrDefault(s, 0) + 1);
		}

		System.out.println(map);

	}

}
