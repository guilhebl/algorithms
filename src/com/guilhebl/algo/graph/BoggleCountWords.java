package com.guilhebl.algo.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * http://www.geeksforgeeks.org/boggle-find-possible-words-board-characters/
 *
 */
public class BoggleCountWords {

	public static void main(String[] args) {
		char boggle[][] = { { 'G', 'I', 'Z' }, { 'U', 'E', 'K' }, { 'Q', 'S', 'E' } };
		String dictionary[] = { "GEEKS", "FOR", "QUIZ", "GO" };
		System.out.println("number of matched words: " + countWords(boggle, dictionary));
	}

	public static int countWords(char[][] boggle, String[] dictionary) {
		if (boggle == null || dictionary == null) {
			return 0;
		}

		List<StringOccurence> list = new ArrayList<>();
		for (int i = 0; i < boggle.length; i++) {
			for (int j = 0; j < boggle[0].length; j++) {
				countWords(i, j, new StringBuilder(), boggle, dictionary, list);
			}
		}
		
		int uniqueCount = 0;
		int count = 0;
		Map<String, Integer> strCount = new HashMap<>();
		for (StringOccurence stringOccurence : list) {
			String key = stringOccurence.s;
			if (strCount.containsKey(key)) {
				count = strCount.get(key);
				strCount.put(key, count + 1);
			} else {
				uniqueCount++;
				strCount.put(key, 1);
			}
			
			System.out.println(key);
			
		}
		return uniqueCount;
	}

	// count words starting from root element
	private static void countWords(int i, int j, StringBuilder sb, char[][] boggle, String[] dict,
			List<StringOccurence> list) {
		if (i < 0 || i >= boggle.length || j < 0 || j >= boggle[0].length) {
			return;
		}
		sb.append(boggle[i][j]);
		Boolean[][] visited = new Boolean[boggle.length][boggle[0].length];
		fillArrayFalse(visited);
		visited[i][j] = true;

		PairVals pv = checkWord(sb.toString(), dict, visited, list);

		if (pv.stillHas) {
			/*
			 * ClockWise rotation
			 */
			// up
			pv.wordMatched += countWords(i - 1, j, new StringBuilder(sb), boggle, dict, visited, list);

			// up-right
			fillArrayFalse(visited);
			visited[i][j] = true;
			pv.wordMatched += countWords(i - 1, j + 1, new StringBuilder(sb), boggle, dict, visited, list);

			// right
			fillArrayFalse(visited);
			visited[i][j] = true;
			pv.wordMatched += countWords(i, j + 1, new StringBuilder(sb), boggle, dict, visited, list);

			// right-down
			fillArrayFalse(visited);
			visited[i][j] = true;
			pv.wordMatched += countWords(i + 1, j + 1, new StringBuilder(sb), boggle, dict, visited, list);

			// down
			fillArrayFalse(visited);
			visited[i][j] = true;
			pv.wordMatched += countWords(i + 1, j, new StringBuilder(sb), boggle, dict, visited, list);

			// down-left
			fillArrayFalse(visited);
			visited[i][j] = true;
			pv.wordMatched += countWords(i + 1, j - 1, new StringBuilder(sb), boggle, dict, visited, list);

			// down-left
			fillArrayFalse(visited);
			visited[i][j] = true;
			pv.wordMatched += countWords(i + 1, j - 1, new StringBuilder(sb), boggle, dict, visited, list);

			// left
			fillArrayFalse(visited);
			visited[i][j] = true;
			pv.wordMatched += countWords(i, j - 1, new StringBuilder(sb), boggle, dict, visited, list);

			// left-up
			fillArrayFalse(visited);
			visited[i][j] = true;
			pv.wordMatched += countWords(i - 1, j - 1, new StringBuilder(sb), boggle, dict, visited, list);
		}
	}

	private static void fillArrayFalse(Boolean[][] visited) {
		for (int i = 0; i < visited.length; i++) {
			for (int j = 0; j < visited[0].length; j++) {
				visited[i][j] = Boolean.FALSE;
			}
		}
	}

	private static int countWords(int i, int j, StringBuilder sb, char[][] boggle, String[] dict, Boolean[][] visited,
			List<StringOccurence> list) {
		if (i < 0 || i >= boggle.length || j < 0 || j >= boggle[0].length || visited[i][j]) {
			return 0;
		}
		sb.append(boggle[i][j]);
		visited[i][j] = true;
		PairVals pv = checkWord(sb.toString(), dict, visited, list);

		if (pv.stillHas) {
			Boolean[][] temp = null;

			/*
			 * ClockWise rotation
			 */
			// up
			temp = getNewCopy(visited);
			pv.wordMatched += countWords(i - 1, j, new StringBuilder(sb), boggle, dict, temp, list);

			// up-right
			temp = getNewCopy(visited);
			pv.wordMatched += countWords(i - 1, j + 1, new StringBuilder(sb), boggle, dict, temp, list);

			// right
			temp = getNewCopy(visited);
			pv.wordMatched += countWords(i, j + 1, new StringBuilder(sb), boggle, dict, temp, list);

			// right-down
			temp = getNewCopy(visited);
			pv.wordMatched += countWords(i + 1, j + 1, new StringBuilder(sb), boggle, dict, temp, list);

			// down
			temp = getNewCopy(visited);
			pv.wordMatched += countWords(i + 1, j, new StringBuilder(sb), boggle, dict, temp, list);

			// down-left
			temp = getNewCopy(visited);
			pv.wordMatched += countWords(i + 1, j - 1, new StringBuilder(sb), boggle, dict, temp, list);

			// down-left
			temp = getNewCopy(visited);
			pv.wordMatched += countWords(i + 1, j - 1, new StringBuilder(sb), boggle, dict, temp, list);

			// left
			temp = getNewCopy(visited);
			pv.wordMatched += countWords(i, j - 1, new StringBuilder(sb), boggle, dict, temp, list);

			// left-up
			temp = getNewCopy(visited);
			pv.wordMatched += countWords(i - 1, j - 1, new StringBuilder(sb), boggle, dict, temp, list);
		}
		return pv.wordMatched;
	}

	private static Boolean[][] getNewCopy(Boolean[][] visited) {
		Boolean[][] cp = new Boolean[visited.length][visited[0].length];
		for (int i = 0; i < visited.length; i++) {
			for (int j = 0; j < visited[0].length; j++) {
				cp[i][j] = visited[i][j];
			}
		}

		return cp;
	}

	private static PairVals checkWord(String string, String[] dict, Boolean[][] v, List<StringOccurence> occs) {
		PairVals pv = new PairVals(false, 0);
		for (int i = 0; i < dict.length; i++) {
			// check for Match
			if (string.length() == dict[i].length() && string.equals(dict[i])) {
				StringOccurence so = new StringOccurence(string, v);

				if (!occs.contains(so)) {
					occs.add(so);
					pv.wordMatched++;
				}
			}

			// check if still word for this element
			if (dict[i].indexOf(string) >= 0) {
				pv.stillHas = true;
			}
		}

		return pv;
	}

}

class StringOccurence {
	String s;
	Boolean[][] visited;

	public StringOccurence(String s, Boolean[][] visited) {
		super();
		this.s = s;
		this.visited = visited;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((s == null) ? 0 : s.hashCode());
		result = prime * result + Arrays.deepHashCode(visited);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StringOccurence other = (StringOccurence) obj;
		if (s == null) {
			if (other.s != null)
				return false;
		} else if (!s.equals(other.s))
			return false;
		if (!Arrays.deepEquals(visited, other.visited))
			return false;
		return true;
	}
}

class PairVals {
	boolean stillHas;
	int wordMatched;

	public PairVals(boolean x, int wordMatched) {
		this.stillHas = x;
		this.wordMatched = wordMatched;
	}
}