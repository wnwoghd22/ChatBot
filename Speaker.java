import java.util.*;

class Speaker {
	public void speak(Listener l) {
		 if(l.getTokens() == null || l.getTokens().size() < 1) {	//at first or no arguments
			switch((int)(Math.random() * 3)) {
			case 0 : 
				System.out.println("What can I help you?");
				break;
			case 1 : 
				System.out.println("How may I help you?");
				break;
			case 2 : 
				System.out.println("Is there anything you find?");
				break;
			default : // out of range : never selected
				System.out.println("Hello, world!");
				break;
			}
		} else { // several words are spoken
			if(l.getObject().equals("")) { // no keywords found
				switch((int)(Math.random() * 3)) {
				case 0 : 
					System.out.println("I wouldn\'t fully understand what you say.");
					break;
				case 1 : 
					System.out.println("Pardon me?");
					break;
				case 2 : 
					System.out.println("What did you say?");
					break;
				default : break;
				}
			} else { // keyowrd found
				if(l.isCategory()) { // customer wants something, but not specific
					switch(l.getPersonal()) {
					case 0 : // no personal phrase
						System.out.println("What kind of " + l.getObject() + " are you looking for?");
						break;
					case 1 : // I ~
						if(l.getVerb().equals("")) { //no verb
							System.out.println("Which " + l.getObject() + " are you looking for?");
						}
						else if(l.getVerb().equals("am")) { // I am ~
							System.out.println("What kind of " + l.getObject() + " are you looking for?");
						} else { // I inf.~
							switch((int)(Math.random() * 2)) {
							case 0 : 
								System.out.println("What kind of " + l.getObject() + " do you " + l.getVerb() + "?");
								break;
							case 1 : 
								System.out.println("Which " + l.getObject() + " do you " + l.getVerb() + "?");
								break;
							default : break;
							}
						}
						break;
					case 2 : // you ~
						if(l.getVerb().equals("")) { //no verb
							System.out.println("Hmm, that\'s interestring.");
						}
						else if(l.getVerb().equals("are")) { // You are ~
							switch((int)(Math.random() * 2)) {
							case 0 : 
								System.out.println("Yes, I am.");
								break;
							case 1 :
								System.out.println("No , I am not.");
								break;
							default : break; 
							}
						} else { // You inf.~
							System.out.println("I " + l.getVerb() + " " + l.getObject() + ".");	
						}
						break;
					default : break;
					}
				} else { // Customer wants specific item
					if(l.getAttribute().equals("")) { 
						switch((int)(Math.random() * 4)) {
							case 0 : 
								System.out.println("What color of " + l.getObject() + " do you want?");
								break;
							case 1 :
								System.out.println("How many " + l.getObject() + " do you want?");
								break;
							case 2 :
								System.out.println("Which size of " + l.getObject() + " do you find?");
								break;
							default : 
								System.out.println("Already sold out. Sorry.");
								break; 
						}
					} else {
						switch((int)(Math.random() * 4)) {
							case 0 : 
								System.out.println("Good choice.");
								break;
							case 1 :
								System.out.println((int)(Math.random() * 100) + " dollars, please.");
								break;
							case 2 :
								System.out.println("We don't have such item.");
								break;
							default : 
								System.out.println("Already sold out. Sorry.");
								break; 
						}
					}
				}
			}
		}
	}
}