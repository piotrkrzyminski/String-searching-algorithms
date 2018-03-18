package piotrkrzyminski;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchingAlgorithms {
	
	public static List<Integer> naiveSearch(String text, String pattern) {
		List<Integer> indexes = new ArrayList<>();
		
		int textLength = text.length();
		int patternLength = pattern.length();
		
		for(int i = 0; i <= textLength - patternLength; i++) {
			if(matchesAt(text, pattern, i))
				indexes.add(Integer.valueOf(i));
		}
		
		return indexes;
	}
	
	public static List<Integer> sundaySearch(String text, String pattern) {
		List<Integer> indexes = new ArrayList<>();
		
		int textLength = text.length();
		int patternLength = pattern.length();
		
		int[] lastp = new int[256];
		Arrays.fill(lastp, -1);
		
		for(int i = 0; i < patternLength; i++)
			lastp[pattern.charAt(i)] = i;
		
		int p = 0; 
		while(p <= textLength - patternLength) {
			if(matchesAt(text, pattern, p))
				indexes.add(p);
			
			p = p + patternLength;
			
			if(p >= textLength)
				break;
			
			p -= lastp[text.charAt(p)];
		}
		
		return indexes;
	}
	
	private static boolean matchesAt(String text, String pattern, int index) {
		int patternLength = pattern.length();
		int p = 0;

		for(int i = index; i < index + patternLength; i++) {
			if(text.charAt(i) != pattern.charAt(p))
				return false;
			
			p++;
		}
		
		return true;
	}
}
