import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	
	public static boolean isAnagram(String str1, String str2) {
  //מקבל את מחרוזות ומעדכן אותם במשתנה בפעולה
    str1 = preProcess(str1);
    str2 = preProcess(str2);
    
    
    if (str1.length() != str2.length()) {
        return false;
    }
    
    // מיון האותיות בשני המחרוזות והשוואה ביניהם
    char[] arr1 = str1.toCharArray();
    char[] arr2 = str2.toCharArray();

    Arrays.sort(arr1);
    Arrays.sort(arr2);
    
    return Arrays.equals(arr1, arr2);		
	}
	   
	
	public static String preProcess(String str) {
		str = str.replaceAll("\\s", ""); 
		str = str.replaceAll("[^a-zA-Z]", "");
		str = str.toLowerCase();         
		return str;
	
	} 
	   
	
	public static String randomAnagram(String str) {
		str = preProcess(str);  // נשתמש ב-preProcess כדי לנקות את המילה
    
    // המרת המילה למערך תוויים
    List<Character> characters = new ArrayList<>();
    for (char c : str.toCharArray()) {
        characters.add(c);
    }
    
    // ערבוב אקראי של התוויים
    Collections.shuffle(characters);
    
    // בניית המילה מחדש מהתוויים המעורבבים
    StringBuilder sb = new StringBuilder();
    for (char c : characters) {
        sb.append(c);
    }
    
    return sb.toString();
		
	}
}
