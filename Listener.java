import java.util.*;

class Listener {
	/* 
	 * variable for determine grammartical person
	 * 0 : undefined person. the string doesn't include pronoun
	 * 1 : first-personal (I am...)
	 * 2 : second-personal (You are...)
	 */
	private int personal;

	/*
	 * determine is question or what kind of question
	 * 0 : not a question
	 * 1 : what
	 * 2 : where
	 * 3 : when
	 * 4 : how
	 * 5 : why
	 * 6 : who
	 */
	private int question;
	private boolean isCategory;
	private String noun;
	private String object;
	private List<String> tokens;

	public Listener() {
		clear();
	}
	private void clear() {
		personal = 0;
		question = 0; isCategory = false;
		noun = ""; object = "";
		tokens = null;
	}
	public void listen(String s) {
		Scanner sc = new Scanner(s);		
		tokens = new ArrayList<String>();

		while(sc.hasNext()) tokens.add(sc.next());
	}

	private void checkPerson() {
		for(String s : tokens) {
			if (s.equals("I")) { personal = 1; break; }
			else if (s.matches("\b[Yy]ou\b")) { personal = 2; break; }
			else continue;
		}
	}
	private void checkQuestion() {

	}
}

class Dictionary {
	
}