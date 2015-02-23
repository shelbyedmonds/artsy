package cs1302.p2;

import cs1302.effects.Artsy;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.SwingUtilities;

/**
 * This is the driver for this application. It ensures that GUI components
 * are created in the Event Dispatch Thread.
 */
public class Driver {

    /**
     * Creates the frame for this application and sets up the main panel.
     */
    public static void createAndShowGUI() {

        // Create the frame
    	JFrame frame = new JFrame("Artsy!");
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // The single MyArtsy object that you are allowed to pass around
        Artsy artsy = new MyArtsy();

        // Create the main panel and add it to the frame
        JPanel mainPanel = new MainPanel(artsy);
        frame.add(mainPanel);

    	// show the window.
        frame.pack();
        frame.setVisible(true);
		
    } // createAndShowGUI

    /**
     * The entry point into the program. 
     *
     * @param args  command line arguments
     */
    public static void main(String[] args) {
        // Schedule a job for the event dispatch thread:
        // creating and showing this application's GUI.
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    } // main

} // Driver
