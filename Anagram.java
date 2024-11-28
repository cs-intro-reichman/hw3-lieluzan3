import java.util.Random;


public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		
		System.out.println(preProcess("What? No way!!!"));
		
		
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		
		String str = "1234567";
		Boolean pass = true;

		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	public static boolean isAnagram(String str1, String str2) {
		// מנקים את המחרוזות
		String cleanStr1 = preProcess(str1);
		String cleanStr2 = preProcess(str2);
	
		if (cleanStr1.length() != cleanStr2.length()) {
			return false;
		}
	
		int[] charCounts = new int[26]; 
	
		for (char c : cleanStr1.toCharArray()) {
			charCounts[c - 'a']++;
		}
	
		for (char c : cleanStr2.toCharArray()) {
			charCounts[c - 'a']--;
			if (charCounts[c - 'a'] < 0) {
				return false; 
			}
		}
	
		
		return true;
	}
	
	public static String preProcess(String str) {
		if (str == null) {
			return "";
		}
		
		return str.replaceAll("[^a-zA-Z ]", "").toLowerCase();
	}
	
	public static String randomAnagram(String str) {
		
    String cleanStr = preProcess(str);
    char[] arr = cleanStr.toCharArray();
    Random random = new Random();
    
    
    for (int i = arr.length - 1; i > 0; i--) {
        int j = random.nextInt(i + 1);
        // החלפת מקומות
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    return new String(arr);
}

	}

