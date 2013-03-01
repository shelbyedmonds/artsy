package cs1302.p2;

import cs1302.effects.Artsy;

import javax.swing.JFrame;
import javax.swing.UIManager;

public class Driver {
	
    public static void createAndShowGUI() {
		
    	JFrame frame = new JFrame("Artsy!");
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // The single MyArtsy object that you are allowed to pass around
        Artsy artsy = new MyArtsy();

        // YOUR GUI CODE CAN START HERE
        // I recommend that the constructor to your main panel object take in
        // an Artsy object so that your action listeners, etc. can use it.

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
