import java.util.*;
import java.io.*;

class Listener {
	/* 
	 * variable for determine grammartical person
	 * 0 : undefined person. the string doesn't include pronoun
	 * 1 : first-personal (I am...)
	 * 2 : second-personal (You are...)
	 */
	private int personal;
	public int getPersonal() { return personal; }

	/*
	 * determine is question or what kind of question
	 * 0 : not a question
	 * 1 : what
	 * 2 : where
	 * 3 : when
	 * 4 : how
	 * 5 : why
	 * 6 : who
	 * 7 : which
	 * 8 : grammatical (Do you, are you... ) // how to find it ?
	 */
	private int question;
	public int getQuestion() { return question; }
	private boolean category;
	public boolean isCategory() { return category; }
	private String verb;
	public String getVerb() { return verb; }
	private String object;
	public String getObject() { return object; }
	private List<String> tokens;
	public List<String> getTokens() { return tokens; }

	private List<Word> dictionary;

	public Listener() {
		clear();
		getDictionary();
	}
	private void getDictionary() {
		dictionary = new ArrayList<Word>();
		try {
			Scanner data = new Scanner(new File("./dict.txt"));
			while(data.hasNextLine()) {
				Scanner line = new Scanner(data.nextLine());
				List<String> s = new ArrayList<String>();
				while(line.hasNext()) s.add(line.next());
				if(s.size() > 0) {
					Word word = new Word();
					word.word = s.get(0);
					word.tag = s.get(1);
					word.category = word.tag.equals("noun") ? s.get(2) : null ;
					dictionary.add(word);
				}
			}
		}
		catch (Exception e) {
			System.err.println(e);
		}
	}
	private void clear() {
		personal = 0;
		question = 0; category = false;
		verb = ""; object = "";
		tokens = null;
	}
	public boolean listen(String s) {
		if(s.contains("leaving")) return false;

		Scanner sc = new Scanner(s);	
		tokens = new ArrayList<String>();

		while(sc.hasNext()) tokens.add(sc.next());

		for(String str : tokens) System.out.println(str);

		checkPerson();
		checkWord();

		return true;
	}

	private void checkPerson() {
		for(String s : tokens) {
			if (s.equals("I")) { personal = 1; break; }
			else if (s.matches("^[Yy]ou$")) {
				// System.out.println("second-person");
				personal = 2; break;
			}
			else continue;
		}
	}
	private void checkQuestion() {

	}
	private void checkWord() {
		for(String s : tokens) {
			for(Word w : dictionary) {
				if(s.matches(w.word + "\\.?")) {
					System.out.println(w.word);
					if(w.tag.equals("verb")) { verb = w.word; }
					else if(w.tag.equals("noun")) {
						object = w.word;
						category = w.isCategory();
					}	
				}
			}
		}
	}
}

class Word {
	String word;
	String tag;
	String category;
	boolean isCategory() { return category.equals("category"); }	
}