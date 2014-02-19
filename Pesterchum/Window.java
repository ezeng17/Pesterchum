import java.awt.Graphics;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class Window extends JFrame implements MouseListener, ActionListener{
	public final Image TOP_SECTION = new ImageIcon(getClass().getResource("images/TopPart.png")).getImage();
	public final Image MIDDLE_SECTION = new ImageIcon(getClass().getResource("images/MiddlePart.png")).getImage();
	public final Image JADE = new ImageIcon(getClass().getResource("images/Jade.png")).getImage();
	public final Image JADE_INACTIVE = new ImageIcon(getClass().getResource("images/Jade inactive.png")).getImage();
	public final Image JADE_SELECTED = new ImageIcon(getClass().getResource("images/Jade selected.png")).getImage();
	public final Image ROSE = new ImageIcon(getClass().getResource("images/Rose.jpg")).getImage();
	public final Image ROSE_INACTIVE = new ImageIcon(getClass().getResource("images/Rose inactive.png")).getImage();
	public final Image ROSE_SELECTED = new ImageIcon(getClass().getResource("images/Rose selected.jpg")).getImage();
	public final Image BAR = new ImageIcon(getClass().getResource("images/Bar.png")).getImage();
	public final Image PESTER_ACTIVE = new ImageIcon(getClass().getResource("images/Pester button.png")).getImage();
	public final Image PESTER_INACTIVE = new ImageIcon(getClass().getResource("images/Pester button inactive.png")).getImage();
	//all the images needed to set up the first window.
	
	static boolean jadeActive = true;
	boolean jadeAnimate = true;
	boolean jadeSelected = false;
	static boolean roseActive = true;
	boolean roseSelected = false;
	boolean clickable = false;
	boolean keepAnimate = true;
	//a bunch of booleans to change Jade Harley's (gardenGnostic) icon to match your actions
	//for example, a boolean to animate, and one to show whether it is selected
	
	JOptionPane pane = new JOptionPane();
	
	public Window() 
	{
		
//		Timer timer = new Timer(600, this);
//		timer.start();
		//created a timer to animate

		addMouseListener(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setSize(227,258);
		setTitle("PESTERCHUM");        
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
		//setting all the defaults, as well as making it visible
		
		pane.showMessageDialog(null, "Hey, look! There are two people online! Click on an icon to select her, and then click the Pester button to chat!\nBe polite, too. They've both had their fair share of trolls lately.", "Be Polite. Do the Right Thing.", JOptionPane.WARNING_MESSAGE);
	}
	public void paint(Graphics g)
	{
		super.paint(g);
		Graphics2D g2d = (Graphics2D)g;
		g2d.drawImage(TOP_SECTION,0,18,this);
		g2d.drawImage(MIDDLE_SECTION,0,120,this);
		g2d.drawImage(BAR,0,208,this);
		if (jadeActive == false)
		{
			g2d.drawImage(JADE_INACTIVE, 15, 140, this);
			//if Jade is not active, show her icon as inactive (greyed out)
		}
		else if ((jadeSelected == true)&&(roseSelected == false))
		{
			g2d.drawImage(JADE_SELECTED, 15, 140, this);
			g2d.drawImage(PESTER_ACTIVE, 75, 220, this);
			//if you've selected her icon, show her icon as selected, and show the "pester" button as active
		}

		else
		{
			g2d.drawImage(JADE, 15, 140, this);
		}
		
		//these two options are for animation, show her icon blinking

		if ((jadeActive == false) || (jadeSelected== false))
		{
			g2d.drawImage(PESTER_INACTIVE, 75, 220, this);
		}
		if (Chat.getVisible() == false)
		{
			jadeActive = false;
			jadeSelected = false;
			//in theory, if you close the chat window, Jade should leave the chat and be un-selected.
		}
		if (roseActive == false)
		{
			g2d.drawImage(ROSE_INACTIVE, 15, 162, this);
			//if Jade is not active, show her icon as inactive (greyed out)
		}
		else if (roseSelected == true)
		{
			g2d.drawImage(ROSE_SELECTED, 15, 162, this);
			g2d.drawImage(PESTER_ACTIVE, 75, 220, this);
			//if you've selected her icon, show her icon as selected, and show the "pester" button as active
		}
		else
		{
			g2d.drawImage(ROSE, 15, 162, this);
		}
	}



	public void mouseClicked(MouseEvent e) {
		if ((e.getX() >= 10) && (e.getX() <= 220) && (e.getY() >= 139) && (e.getY() <= 161)) {
			if (roseSelected == true)
			{
				roseSelected = false;
				jadeSelected = !jadeSelected;
				repaint();
			}
			else if (roseSelected == false)
			{
				jadeSelected = !jadeSelected;
				repaint();
			}
			
			//if you click on Jade's icon, show her as selected or not selected, depending on whether she's already selected or not
		}
		if ((e.getX() >= 10) && (e.getX() <= 220) && (e.getY() >= 161) && (e.getY() <= 183)) {
			if (jadeSelected == true)
			{
				jadeSelected = false;
				roseSelected = !roseSelected;
				repaint();
			}
			else if (jadeSelected == false)
			{
				roseSelected = !roseSelected;
				repaint();
			}
			//if you click on Rose's icon, show her as selected or not selected, depending on whether she's already selected or not
		}
		//also, only select one at a time!
		if ((e.getX() >= 75) && (e.getX() <= 146) && (e.getY() >= 220) && (e.getY() <= 242) && (jadeSelected == true)) {
			Chat chat = new Chat();
			//if you choose to pester Jade, open a new Chat Window
		}
		else if ((e.getX() >= 75) && (e.getX() <= 146) && (e.getY() >= 220) && (e.getY() <= 242) && (roseSelected == true)) {
			ChatRose chatRose = new ChatRose();
			//if you choose to pester Jade, open a new Chat Window

		}

	}
	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {

	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void actionPerformed(ActionEvent e) {
		repaint();
		//keep animating
	}

}


