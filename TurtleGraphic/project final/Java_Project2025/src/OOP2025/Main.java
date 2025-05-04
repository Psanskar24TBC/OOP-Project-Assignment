package OOP2025;

//Import necessary Java Swing and LBUGraphics classes
import java.awt.FlowLayout;
import javax.swing.JFrame;
import uk.ac.leedsbeckett.oop.LBUGraphics;

/**
 * Main class for launching a basic LBUGraphics window.
 * This class extends LBUGraphics but does not add new functionality.
 * It simply displays the basic turtle panel and shows version information.
 */
public class Main extends LBUGraphics {

	 /**
     * Constructor: Sets up the JFrame window and adds this panel (turtle canvas)
     */
	public Main()
	// Create a frame to display the turtle graphics panel
	{
		JFrame MainFrame = new JFrame();            
		MainFrame.setLayout(new FlowLayout());  // Set a simple layout manager   
		MainFrame.add(this);                    // Add this panel (inherits from LBUGraphics) to the frame
		MainFrame.setSize(850,450);             // Set frame size  
		MainFrame.setVisible(true);   			// Make frame visible

		about();	// Call about() method (inherited from LBUGraphics) to show version info
	}
	
	  /**
     * Main method: Entry point of the program
     */
	public static void main(String[] args) {
		new Main(); // Create an instance of Main to start the program
	}
	
	 /**
     * Overridden processCommand method (required because we extend LBUGraphics).
     * 
     * Currently, no custom command processing is implemented here.
     * This method must exist, but is left empty as placeholder.
     */
	@Override
	public void processCommand(String arg0) {
		
		// No command processing done in this class
		
		
	}




}


