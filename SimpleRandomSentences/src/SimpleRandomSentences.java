/**
 * The class has the sentence() method, which arbitrary makes a sentence randomly.
 *
 */
public class SimpleRandomSentences { // begin of class

	//Array for conjunctions
	static String[] conjunction = new String[]{"and ", "or ", "but ", "because "};

	//Array for names
	static String[] proper_noun = new String[]{"Fred ", "Jane ", "Richard Nixon ",
	"Miss America "};

	//Array for nouns
	static String[] common_noun = new String[]{"man ", "fish ", "elephant ",
	"unicorn "};

	//Array for determiner
	static String[] determiner = new String[]{"a ", "the ", "every ", "some "};

	//Array for adjectives
	static String[] adjective = new String[]{"big ", "big ", "pretty ", "bald "};

	//Array for intransitive verbs
	static String[] intransitive_verb = new String[]{"runs ", "jumps ", "talks ",
	"sleeps "};

	//Array for transitive_verb
	static String[] transitive_verb = new String[]{"loves ", "hates ", "sees ",
			"knows ", "looks for ", "finds "};


	/*
	 * the method calls simple_sentence and itself recursively with a base case
	 * that it calls itself just once. 
	 * It calls randomItem for accessing random string items of an array.
	 * 
	 * @return String a complete random sentence.
	 */
	public static String sentence() {
		String s;
		boolean flag = false; // base case for the recursion
		s = simple_sentence();

		if(Math.random() <= .4 && flag == false) { // 50% probability
			s += randomItem(conjunction);
			s += sentence();
			flag = true;
		}
		return s;
	}


	/*
	 * it calls noun_phrase() and verb_phrase() to form a simple sentence.
	 * 
	 * @return String represents a noun phrase and a verb phrase
	 */
	public static String simple_sentence() {
		return noun_phrase() + verb_phrase();
	}


	/*
	 * This method builds a noun phrase randomly according to probability.
	 * It calls randomItem() to choose Items randomly and verb_phrase also.
	 * 
	 * @return String a noun phrase which differs according to probability
	 */
	public static String noun_phrase() {
		String s;

		if((int)(10*Math.random()) >= 5) { // 50% probability
			s = randomItem(proper_noun);
		}

		else {
			s = randomItem(determiner);

			if((int)(10*Math.random()) > 6) { // 30% probability
				s+= randomItem(adjective);
			}

			s+= randomItem(common_noun);

			if((int)(10*Math.random()) < 4) { // 40% probability
				s+=", who ";
				s+= verb_phrase();
			}
		}
		return s;	
	}


	/*
	 * This method makes a random verb phrase according to equal probability.
	 * It calls randomItem() to choose verbs randomly and calls noun_phrase
	 * and calls simple_sentence also.
	 * 
	 * @return String a verb phrase according to the probability.
	 */
	public static String verb_phrase() {
		String s;
		int flag = (int)(100*Math.random()); // flag provides an equal probability

		if(flag < 25) { // 25% probability
			s = randomItem(intransitive_verb);
		}

		else if(flag >= 25 && flag < 50) { // 25% probability
			s = randomItem(transitive_verb);
			s += noun_phrase();
		}

		else if(flag >= 50 && flag < 75) { // 25% probability
			s = " is ";
			s += randomItem(adjective);
		}

		else { // 25% probability
			s = " believes that ";
			s += simple_sentence();
		}

		return s;
	}



	/*
	 * This method takes a String array and returns a random chosen String
	 * of its items.
	 * 
	 * @return String a random chosen Item of an array
	 */
	public static String randomItem(String[] listOfStrings) {
		return listOfStrings[(int)(listOfStrings.length * Math.random())];

	}




	public static void main(String[] args) { // begin of main method

		System.out.println(new SimpleRandomSentences().sentence());

	} // end of main method
} // end of class
