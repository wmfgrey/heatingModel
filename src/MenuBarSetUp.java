
/**
 * 
 * @author will Grey
 * 
 * @version  28/3/2015
 * 
 * This is free and unencumbered software released into the public domain.
 *  For more information, please refer to <http://unlicense.org/>
 */

import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.awt.BorderLayout;
//import java.awt.Point;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.Box;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MenuBarSetUp extends JFrame {

	private static final long serialVersionUID = 1L;

	public MenuBarSetUp(String title) throws HeadlessException {
		super(title);
	}

	protected JMenuBar menuSetUp() {
		  
		   JMenuBar menuBar = new JMenuBar();
		 
		  JMenu fileMenu = new JMenu("File");
		  JMenu helpMenu = new JMenu("Help");
		  
		  menuBar.add(fileMenu);
		  menuBar.add(Box.createHorizontalGlue());
		  menuBar.add(helpMenu);
		  
		  JMenuItem exitMenu = new JMenuItem("Exit");
		   fileMenu.addSeparator();
		  fileMenu.add(exitMenu);
		   
		  JMenuItem help = new JMenuItem("Help");
		  JMenuItem aboutMenu = new JMenuItem("About");	  
		  helpMenu.add(help);
		  helpMenu.add(aboutMenu);
		  
		  exitMenu.addActionListener(new ActionListener(){
		      @Override
		      public void actionPerformed(ActionEvent e) {
		          System.exit(0);
		     }
		  });
		  
	  
		  aboutMenu.addActionListener(new ActionListener(){
		  public void actionPerformed(ActionEvent e) {
			    JFrame gui = new JFrame();
			    aboutSetUp(gui);
	        }
		});
		    
		  help.addActionListener(new ActionListener(){
			  public void actionPerformed(ActionEvent e) {	    		      
		            JTextArea textArea = textAreaSetUp();
		              helpSetUp(textArea);
		        }
			 });
		  
		return menuBar;
	}

	public JTextArea textAreaSetUp() {
		
		JTextArea textArea = new JTextArea(2, 20);
		textArea.setText(HelpFile.text1);
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setOpaque(false);
		textArea.setEditable(false);
		textArea.setFocusable(false);
		return textArea;
		
	}
	
	private void helpSetUp(JTextArea textArea) {
		
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.getVerticalScrollBar().setValue(0);
		scrollPane.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		JFrame frame = new JFrame();
		frame.add(scrollPane);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.setSize(500, 500);
		frame.setVisible(true);
		
	}

	private void aboutSetUp(JFrame gui) {
		
		final JPanel Panel = new JPanel ( new GridLayout(4,2));
		Panel.add(new JLabel(" HOME (HOuse Model of Energy) 2015"));
		Panel.add(new JLabel(" Author: Will Grey"));
		Panel.add(new JLabel(" This is free and unencumbered software released into the public domain."));
        Panel.add(new JLabel(" For more information, please refer to <http://unlicense.org/>"));
		
		gui.add(Panel);
		gui.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		gui.setSize(600, 100);
		gui.setLocation(300, 300);
		gui.setVisible(true);
	
	}
	
}