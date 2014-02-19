import java.util.StringTokenizer;
import javax.swing.JOptionPane;

public class GenerateRepliesJade {
	String name = "";
	String pet = "";
	int numberOfLines = 1;
	JOptionPane pane = new JOptionPane();

	public void GenerateReplesJade()
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
		if (numberOfLines <=6)
		{
			return setThings(entered);
		}
		else if (numberOfLines <12)
		{
			return nextReply(entered);
		}
		else if (numberOfLines<=23)
		{
			return nextNextReply(entered);
		}
		else if (numberOfLines == 24)
		{
			return lastReply();
		}
		else if (numberOfLines >= 50)
		{
			return otherBranch(entered);
		}
		else
		{
			return "";
		}
	}
	/**
	 * 
	 * @return		The first thing Jade says to you
	 */
	public String begin()
	{
		return "GG: hello!\nGG: whats your name??\n";
	}
	/**
	 * Begin the conversation with Jade getting the user's name. Hopefully before she gets frustrated.
	 * @param enteredLine		The line the user entered
	 * @return					The line Jade replies with
	 */
	public String setThings(String enteredLine)
	{
		String word = "";
		StringTokenizer token = new StringTokenizer(enteredLine);
		if ((enteredLine.contains("yes"))||(enteredLine.contains("yeah"))||(enteredLine.contains("yup")))
		{
			numberOfLines = 7;
			return "GG: great!!\nGG: thats what ill call you then\n";
			//this should fire after Jade gets your potential name and tries to confirm it, and the user says yes
		}
		else if ((enteredLine.contains("no "))||(enteredLine.contains(" no"))||(enteredLine.equals("no")))
		{
			return "GG: well then what IS your name???\n";
			//this should fire after Jade gets your potential name and tries to confirm it, and the user says no
		}
		else if ((enteredLine.contains("hello"))||(enteredLine.contains("hi")))
		{
			return "GG: hi!\n";
			//if the user greets Jade, don't let her get confused and think "hello" is the user's name
		}
		else if (numberOfLines == 6)
		{
			name = "farmstink";
			return "GG: okay this is getting silly!!\nGG: ill just call you " + name + " then.\n";
			//after too many tries, Jade gets frustrated and calls you farmstink.
		}

		else if (numberOfLines < 6)
		{
			while (token.countTokens() > 0)
			{
				word = token.nextToken();

				if (word.length() > 4)
				{
					numberOfLines++;
					name = word;					
					return "GG: " + name + "? thats a really weird name!! :)\nGG: ...\nGG: that is your name right?\n";
				}

			}
			numberOfLines++;
			return "GG: huh???\nGG: i dont think i understand\n";
		}
		else
		{
			return "GG: huh???\nGG: i dont think i understand\n";
		}
		//before Jade gets frustrated, analyze the entered line for any word longer than 5 characters
		//Jade will take the name, and try to confirm it with the user
		//otherwise, if the line doesn't contain any words longer than 5 characters, Jade will get confused.
		//Good luck to those with short names.

	}
	/**
	 * Go to the next stage of replies. Jade will ask you what's up.
	 * @param entered		The entered line
	 * @return				What Jade replies with
	 */
	public String nextReply(String entered)
	{
		if (numberOfLines == 7)
		{
			numberOfLines++;
			return "GG: so......\nGG: whats up!! hehehe\n";
			//where this should begin.
		}
		else if (entered.contains("you?"))
		{
			numberOfLines++;
			return "GG: oh, nothing much!!\n";
			//if the user asks "What about you?" or something along those lines
		}
		else if (entered.contains("?"))
		{
			numberOfLines++;
			return "GG: yup!!!\nGG: i think???\n";
			//if the user asks a question, Jade will stay optimistic.
		}
		else if (numberOfLines == 9)
		{
			numberOfLines++;
			return "GG: mhm\n";
			//after a bit, let Jade sound interested
		}
		else
		{
			numberOfLines++;
			return "";
		}
	}
	/**
	 * Go to the next stage of conversation. Jade discusses disappearing pumpkins and explosions and basically
	 * disregards whatever the user says.
	 * @param entered		The entered line
	 * @return				What Jade replies with
	 */
	public String nextNextReply(String entered)
	{
		if (numberOfLines == 12)
		{
			numberOfLines++;
			return "GG: that sounds really interesting!\nGG: not much is happening here....\nGG: my pumpkins keep disappearing!\nGG: i wonder what keeps happening to them\n";
			//the disappearing pumpkin!
		}
		else if (numberOfLines == 14)
		{
			numberOfLines++;
			return "GG: whoa what was that????\n";
			//she gets suspicious
		}
		else if (numberOfLines == 15)
		{
			numberOfLines++;
			return "GG: there was a loud noise outside my house!\nGG: it sounded like an explosion!!!!\nGG: ill be back soon\nGG: meanwhile, why dont you tell me about your family? :)\nGG: ill read it when i come back\n";
			//something to keep the user busy and patient?
		}
		else if (numberOfLines == 20)
		{
			numberOfLines++;
			return "GG: okay im back now :)\nGG: it was just my dog, bec!!\nGG: he gets pretty naughty sometimes\n";
			//nothing much
			//just an explosion
		}
		else if (numberOfLines == 22)
		{
			numberOfLines++;
			return "GG: oh!\nGG: do you have any pets?\n";
		}
		else if ((numberOfLines == 23)&&(entered.contains("no")))
		{
			numberOfLines++;
			return "GG: oh\nGG: well thats okay too! but pets are really fun!!\n";
		}
		else if ((numberOfLines == 23)&&((entered.contains("yes"))||(entered.contains("yeah"))||(entered.contains("yup"))))
		{
			numberOfLines = 50;
			return otherBranch(entered);
		}
		else if (numberOfLines == 23)
		{
			numberOfLines++;
			return "GG: huh???\nGG: well whatever :\\\n";
		}
		else
		{
			numberOfLines++;
			return "";
		}
	}
	/**
	 * A little alternate conversation depending on whether you have 
	 * @param entered		Your entered line
	 * @return				What Jade replies with
	 */
	public String otherBranch(String entered)
	{
		if (numberOfLines == 50)
		{
			numberOfLines++;
			return "GG: oh my gosh!!!\nGG: what kind of pet do you have????\n";
		}
		else if (numberOfLines == 51)
		{
			numberOfLines++;
			if (entered.contains("dog"))
			{
				pet = "dog";
				return "GG: omigosh!!!!!\nGG: i have a dog too!! :)\n";
			}
			else if (entered.contains("cat"))
			{
				pet = "cat";
				return "GG: omigosh!!!!!\nGG: cats are so cute!! :)\n";
			}
			else if (entered.contains("fish"))
			{
				pet = "fish";
				return "GG: omigosh!!!!!\nGG: fish are so beautiful!! :)\n";
			}
			else if (entered.contains("bird"))
			{
				pet = "bird";
				return "GG: omigosh!!!!!\nGG: birds are so wonderful!! :)\n";
			}
			else
			{
				pet = "pet";
				return "GG: huh\nGG: im not sure if ive ever heard of that pet before?\n";
			}
		}
		else
		{
			numberOfLines = 24;
			return lastReply();
		}
	}
	/**
	 * The end of the conversation
	 * @return		The last reply, and after that just return nothing
	 */
	public String lastReply()
	{
		if (numberOfLines == 24)
		{
			numberOfLines++;
			if (pet.equals(""))
			{
				return "GG: well i have to go now!!!!\nGG: it was really nice to meet you, " + name + "!! ;)\nGG: bye!!!!!!!\n";
				//Look, she remembers your name!!
			}
			else
			{
				return "GG: well i have to go now!!!!\nGG: it was really nice to meet you, " + name + "!! ;)\nGG: hopefully sometime i can come and meet your " + pet + "!!\nGG: bye!!!!!!!\n";
			}
		}
		else
		{
			numberOfLines++;
			return "";
		}
	}
}

