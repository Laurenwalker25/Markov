import java.util.Arrays;

/**
 * A WordGram object represents an immutable
 * sequence of words.
 * For use in Compsci 201, Duke University, Fall 2022
 * Add yourself as an author when you make edits
 * @author Brandon Fain
 * @author Lauren Walker
 */

public class WordGram {
	private String[] myWords; 	// Stores WordGram words
	private String myToString;	// Stores space separated words as one string
	private int myHash;			// Stores hash value of WordGram

	
	/**
	 * Constructor should generate a WordGram with size words
	 * beginning at the start index value of source array.
	 * Each element of source array should be a single word.
	 * @param source Source array, each element should be a single word
	 * @param start Index of first word for WordGram object
	 * @param size Number of elements in WordGram object
	 */
	public WordGram(String[] source, int start, int size) {
		// TODO correctly implement constructor
		//myWords = new String[]{source[start]};
		myWords = new String[size];
		for (int i = start, j = 0; i < start + size; i++, j++) {
			myWords[j] = source[i];
		}
		myToString = "";
		myHash = 0;
	}


	/**
	 * Return the word at a given index of WordGram
	 * @param index of word
	 * @return String/word at index position in WordGram
	 * @throws IndexOutOfBoundsException if index < 0 or index >= length()
	 */
	public String wordAt(int index) {
		// TODO correctly implement wordAt
		return this.myWords[index];
	}


	/**
	 * Returns number of words in this WordGram
	 * @return order of wordgram, number of words
	 */
	public int length() {
		// TODO correctly implement length 
		return this.myWords.length;
	}


	/** 
	 * Returns true if o is also a wordgram with the
	 * same words, otherwise returns false 
	*/
	@Override
	public boolean equals(Object o) {
		if (! (o instanceof WordGram) || o == null){
			return false;
		}
		WordGram other = (WordGram) o;
		// TODO complete correct implementation of equals (above is correct)
		String[] words1 = other.myWords;
		String[] words2 = this.myWords;
		if (Arrays.equals(words1, words2)) {
			return true;
		} 
		return false;
	}


	/**
	 * Returns a hashCode for WordGram object equal to 
	 * the hashCode of the space separated words stored in 
	 * the WordGram.
	 */
	@Override
	public int hashCode() {
		// TODO correctly implement hashCode
		if (! (myHash == 0)) {
			return myHash;
		} else {
			String str = String.join(" ", myWords);
			myHash = str.hashCode();
		}
		return myHash;
	}


	/**
	 * Return a new WordGram of the same length as this WordGram 
	 * consisting of words 1 through length-1 of this WordGram
	 * followed by last. Does NOT mutate this WordGram.
	 * @param last added as last string of returned WordGram
	 * Should be a single word
	 * @return new WordGram
	 */
	public WordGram shiftAdd(String last) {
		// TODO correctly implement shiftAdd
		String [] myWords2 = new String[myWords.length];
		for (int i = 0, j = 1; i < myWords.length-1; i++, j++) {
			myWords2[i] = myWords[j];
		}
		myWords2[myWords.length-1] = last;

		WordGram a = new WordGram(myWords2, 0, myWords2.length);
		return a;
	}


	/**
	 * Returns space separated words stored in the WordGram
	 * as a single String.
	 */
	@Override
	public String toString() {
		// TODO correctly implement toString
		if(myToString.equals("")) {
			myToString = String.join(" ", myWords);

		}
		return myToString;
	}
}
