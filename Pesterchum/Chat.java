
public class Chat {
	static ChatWindow chat = new ChatWindow();
	Chat()
	{
		chat.createAndShowGUI();
	}
	public static boolean getVisible()
	{
		return chat.isVisible();
	}
}
