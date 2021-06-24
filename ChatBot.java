import java.util.*;

public class ChatBot {
	public static void main(String[] args) {
		Listener listener = new Listener();
		Speaker speaker = new Speaker();

		Scanner sc = new Scanner(System.in);

		do speaker.speak(listener); while (listener.listen(sc.nextLine()));
	}
}