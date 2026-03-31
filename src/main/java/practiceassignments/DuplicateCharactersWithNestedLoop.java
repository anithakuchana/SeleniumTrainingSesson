package practiceassignments;

public class DuplicateCharactersWithNestedLoop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "Automation";

		for (int i = 0; i < str.length(); i++) {
			for (int j = i + 1; j < str.length(); j++) {
				if (str.toLowerCase().charAt(i) == str.toLowerCase().charAt(j)) {
					System.out.println("Duplicate characters: " + str.charAt(i));
					break;
				}
			}
		}

	}

}
