import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class ChatWindow extends JPanel implements ActionListener {

	JTextField enterText = new JTextField(10);
	//Creating a TextField where you can enter text

	JTextPane chatWindow = new JTextPane();
	//Creating a TextPane, where text is displayed with styles!

	StyledDocument doc = chatWindow.getStyledDocument();
	//creating a StyledDocument to enable styles in the chat window

	Style style = chatWindow.addStyle("I'm a Style", null);
	Style leavingStyle = chatWindow.addStyle("I'm another Style", null);
	//creating two styles for text to appear in

	GenerateRepliesJade reply = new GenerateRepliesJade();
	public ChatWindow()
	{

		super(new GridBagLayout());

		StyleConstants.setForeground(style, new Color(Integer.parseInt( "4ac925",16)));
		StyleConstants.setForeground(leavingStyle, new Color(Integer.parseInt( "999999",16)));
		StyleConstants.setFontSize(leavingStyle, 10);
		StyleConstants.setFontFamily(style, "Courier");
		//setting font, size, color for the styles

		chatWindow.setPreferredSize(new Dimension(250,1200));
		enterText.setPreferredSize(new Dimension(250, 40));
		enterText.addActionListener(this);
		JScrollPane scrollPane = new JScrollPane(chatWindow); 
		scrollPane.setVerticalScrollBarPolicy(
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setPreferredSize(new Dimension(250,500));
		//creating a new ScrollPane so you can scroll through the chat transcript
		
		chatWindow.setEditable(false);
		GridBagConstraints c = new GridBagConstraints();
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.fill = GridBagConstraints.BOTH;
		add(scrollPane, c);
		add(enterText, c);
		setVisible(true);
		
		try
		{
			doc.insertString(0, reply.begin(), style);

		}
		catch(Exception e) {}

	}
	/**
	 * Create and show the window
	 */
	public void createAndShowGUI() {
		
		
		JFrame frame = new JFrame("Chatting With gardenGnostic");
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.add(new ChatWindow());
		//Add contents to the window.
		
		frame.pack();
		frame.setVisible(true);
		frame.setResizable(false);
	}
	public void actionPerformed(ActionEvent evt) {
		String text = enterText.getText();
		if (text.equals(""))
		{
			return;
		}
		try
		{
			doc = chatWindow.getStyledDocument();
			doc.insertString(doc.getLength(), text, null);
			doc.insertString(doc.getLength(), "\n", null);
			//everytime you type, enter it into the chat window at the end

		}
		catch(Exception e) {}
		enterText.selectAll();
		enterText.setCaretPosition(enterText.getDocument().getLength());
		enterText.setText("");
		//add the text you entered to the styled document, and reset it to empty

		String stuff = reply.answer(text);
		//generate the reply
		if (!stuff.equals(""))
		{
			try

			{
				
				doc.insertString(doc.getLength(), stuff, style);
				//pause to make the reply somewhat realistic, and add the reply to the document
			}
			catch(Exception e) 
			{}
			if (stuff.contains("bye!!!!!!!"))
			{
				try {

					doc.insertString(doc.getLength(), "gardenGnostic has left the chat\n", leavingStyle);
					Window.jadeActive = false;
				} 
				catch (BadLocationException e) 
				{}
				//if Jade is leaving, say GG has left the chat, and make her icon inactive
			}


		}
		chatWindow.setCaretPosition(chatWindow.getDocument().getLength());
		return;
		//every time text happens, make the chat window scroll all the way down

	}



}
