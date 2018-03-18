package piotrkrzyminski;

import java.util.List;

public class App {
	
	public static void main(String[] args) {
		String text = "AACBBAACCACBCCBABBBBABACAABAAACABCABBCBAAAAAAACCAAACBBAACABCBCCABCBCCBCBCAABACAC";
		String pattern = "AACBB";
		
		List<Integer> indexes1 = SearchingAlgorithms.naiveSearch(text, pattern);
		List<Integer> indexes2 = SearchingAlgorithms.naiveSearch(text, pattern);
		
		for(Integer index : indexes1)
			System.out.print(index + " ");
		
		System.out.println();
		
		for(Integer index : indexes2)
			System.out.print(index + " ");
	}
	
}