import java.util.StringTokenizer;
import javax.swing.JOptionPane;

public class GenerateRepliesRose {
	String name = "";
	String pet = "";
	int numberOfLines = 1;
	JOptionPane pane = new JOptionPane();

	public void GenerateReplesRose()
	{
		numberOfLines = 1;

	}
	/**
	 * Basically, direct the program to the right method depending on where the user is in the conversation
	 * @param entered		The String the user entered
	 * @return				The String that will be printed into the chatwindow
	 */
	public String answer(String entered)
	{
		entered = entered.toLowerCase();
		System.out.println(numberOfLines);
		if (numberOfLines <=5)
		{
			return begin(entered);
		}
		else if (numberOfLines <11)
		{
			return setThings(entered);
		}
		else if (numberOfLines >=11)
		{
			return lastReply();
		}
		else
		{
			return "";
		}
	}
	/**
	 * The very beginning of the conversation. Rose is a little snarky and impatient.
	 * @param enteredLine	Your entered line
	 * @return				What Rose replies
	 */
	public String begin(String enteredLine)
	{
		if (numberOfLines == 1)
		{
			numberOfLines++;
			return "TT: Excuse me. I am somewhat preoccupied at the moment. I would prefer not to be distracted. Or, if you prefer, \"distacted\".\nTT: Although, I can make an exception, if you promise to be good.\n";
		}
		else if (numberOfLines == 2)
		{
			numberOfLines++;
			return "TT: Do you promise to be good?\n";
		}
		else if ((numberOfLines == 3)&&((enteredLine.contains("yes"))||(enteredLine.contains("yeah"))||(enteredLine.contains("yup"))))
		{
			numberOfLines = 6;
			return "TT: Wonderful.\nTT: I believe I should introduce myself. I am Rose Lalonde, grimdark magician, enthusiast of the bestially strange and fictitious.\n";
			//this should fire after Jade gets your potential name and tries to confirm it, and the user says yes
		}
		else if ((numberOfLines == 3)&&((enteredLine.contains("no "))||(enteredLine.contains(" no"))||(enteredLine.equals("no"))))
		{
			numberOfLines = 11;
			return "TT: Well, then we'll have a small problem, won't we? TT: I'm afraid I must leave then. Pardon me.\n";
			//this should fire after Jade gets your potential name and tries to confirm it, and the user says no
		}
		else if (numberOfLines < 5)
		{
			numberOfLines++;
			return "TT: Pardon?\nTT: I'm a little too busy to try and parse your unintelligible comments.\nTT: A simple affirmative or dissentient will do.\nTT: In other words : a simple \"yes\" or \"no\", please.\n";
		}
		else if (numberOfLines == 5)
		{
			numberOfLines = 11;
			return "TT: Well, that was certainly a wonderful waste of time.\nTT: Now, if you don't mind, I'd like to take a small respite from your mockery.\nTT: This may come as a surprise to you, but -\nTT: I'm busy.\nTT: Pardon me.\n";
		}
		else
		{
			return "TT: Pardon?\nTT: I'm a little too busy to try and parse your unintelligible comments.\n";
		}

	}
	public String setThings(String enteredLine)
	{
		String word = "";
		StringTokenizer token = new StringTokenizer(enteredLine);
		if (numberOfLines == 6)
		{
			numberOfLines++;
			return "TT: I believe the proper response to an introduction is to reciprocate. \nTT: Apologies if I missed it.\nTT: What are you called?\n";
		}
		else if ((enteredLine.contains("yes"))||(enteredLine.contains("yeah"))||(enteredLine.contains("yup")))
		{
			numberOfLines = 11;
			return "TT: Wonderful. Now that I have your name, I can commence with the eldritch magickks.\nTT: I am being sarcastic, of course.\n";
		}
		else if ((enteredLine.contains("no "))||(enteredLine.contains(" no"))||(enteredLine.equals("no")))
		{
			numberOfLines = 11;
			return "TT: Well, that was certainly a wonderful waste of time.\nTT: Now, if you don't mind, I'd like to take a small respite from your mockery.\nTT: This may come as a surprise to you, but -\nTT: I'm busy.\nTT: Pardon me.\n";
		}
		else if (numberOfLines == 10)
		{
			numberOfLines = 11;
			return "TT: Well, that was certainly a wonderful waste of time.\nTT: Now, if you don't mind, I'd like to take a small respite from your mockery.\nTT: This may come as a surprise to you, but -\nTT: I'm busy.\nTT: Pardon me.\n";
		}

		else if (numberOfLines < 10)
		{
			while (token.countTokens() > 0)
			{
				word = token.nextToken();

				if (word.length() > 4)
				{
					numberOfLines++;
					char[] stringArray = word.toCharArray();
					stringArray[0] = Character.toUpperCase(stringArray[0]);
					word = new String(stringArray);	
					name = word;
					return "TT: " + name + "? Lovely.\nTT: Unless you're trying to fool me. I must apologize, but I've been confronted by a great many of trolls recently, so I must confirm that " + name + " is your real name, and not just another attempt to troll.\nTT: Again, a yes or no will do.\n";
				}

			}
			numberOfLines++;
			return "TT: Pardon?\n";
		}
		else
		{
			return "TT: Pardon?\n";
		}
	}


	/**
	 * The end of the conversation
	 * @return		The last reply, and after that just return nothing
	 */
	public String lastReply()
	{
		if (numberOfLines == 11)
		{
			return "TT: I'm afraid I really must leave now. Adieu, or as the French intend, \"until God\".\n";
		}
		else
		{
			return "";
		}

	}
}

