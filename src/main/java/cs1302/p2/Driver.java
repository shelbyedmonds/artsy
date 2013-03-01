package cs1302.p2;

import javax.swing.JFrame;
import javax.swing.UIManager;

public class Driver {
	
    public static void createAndShowGUI() {
		
    	JFrame frame = new JFrame("Artsy!");
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	// YOU CAN START YOUR GUI HERE

    	// show the window.
        frame.pack();
        frame.setVisible(true);
		
    } // createAndShowGUI
	
    public static void main(String[] args) {
		
	// Schedule a job for the event dispatch thread:
        // creating and showing this application's GUI.
	javax.swing.SwingUtilities.invokeLater(new Runnable() {
		public void run() {
		    createAndShowGUI();
		} // run
	    });
		
    } // main

} // Driver
