package cs1302.p2;

import cs1302.effects.Artsy;

import javax.swing.JPanel;
import javax.swing.JLabel;

/**
 * This is the main panel for this application. Components
 * and sub-panels should be added to this panel.
 */
public class MainPanel extends JPanel {

    private JLabel label;

    /** 
     * Creates a new <code>MainPanel</code> object. Feel free
     * to change the parameters to this constructor if needed. 
     * However, if you do change the parameters, you will need
     * to update the <code>Driver</code> class where an instance
     * of this class is created.
     */
    public MainPanel(Artsy artsy) {
        super();                      // call the parent constructor
        label = new JLabel("Artsy!"); // initialize the label
        add(label);                   // add the label to the panel
    } // MainPanel

} // MainPanel
