package OOP2025;

//Import required Java and Swing libraries
import java.awt.AWTException;
import java.util.Random;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

//Import the LBUGraphics base class
import uk.ac.leedsbeckett.oop.LBUGraphics;

/**
 * TurtleGraphic2025 class extends LBUGraphics
 * This class adds customized drawing commands, file save/load functionality, 
 * and GUI enhancements for the Turtle Graphics project.
 */
public class TurtleGraphic2025  extends LBUGraphics{
	
	// Fields to store commands and helper lists
	public ArrayList<String> list;
	public int size;
	public ArrayList<String> commandList=new ArrayList<String>(); // stores all successful commands
	public ArrayList<String> arr=new ArrayList<String>(  
			Arrays.asList("turtleMove","reverse","doublewidth","randomcolor","circle","clock","shape","equilateral","penwidth","name","image","save","load","screenshot","triangle","square","pencolor","about","penUp","penDown","left","right","green","red","white","blue","black","reset","clear"));
	
	/**
     * Constructor: Sets up the JFrame window and adds this TurtleGraphics panel
     */
	public TurtleGraphic2025()
	{
		JFrame MainFrame = new JFrame();  // Main application window
		MainFrame.setLayout(new FlowLayout());     
		MainFrame.add(this);               // Add this TurtleGraphic panel        
		MainFrame.setSize(850,450);                
		MainFrame.setVisible(true);   		
	}

	/**
     * Save all previously typed valid commands into a text file
     */
	
	public void saveCommands(ArrayList<String>   commandList) {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Save Command File");
		int userSelection = fileChooser.showSaveDialog(null);
		if (userSelection == JFileChooser.APPROVE_OPTION) {
			File fileToSave = fileChooser.getSelectedFile();
			try {
				Files.write(fileToSave.toPath(), commandList);
				 isSaved = true;

			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "File could not be saved", "Error", JOptionPane.ERROR_MESSAGE);
			}}
	}

	
	  /**
     * Load a set of commands from a text file and execute them
     */
	private boolean isSaved = true; // default to true until the user draws
	
	public void loadCommands() {		

		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Load Command File");
		int userSelection = fileChooser.showOpenDialog(null);
		if (userSelection == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile();
			try {
				Scanner scan = new Scanner(selectedFile);
				while(scan.hasNextLine()) {
					String line = scan.nextLine();
					processCommand(line);
				}
				scan.close();
			} catch (FileNotFoundException e) {
				JOptionPane.showMessageDialog(null, "File could not be loaded", "File load error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	
	/**
     * Save the current screen as an image file
     */

	public void saveImage() {	
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Save Image");
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int userSelection = fileChooser.showSaveDialog(null);
		if (userSelection == JFileChooser.APPROVE_OPTION) {
			String path = fileChooser.getSelectedFile().getAbsolutePath() + "/picture.jpg";
			try {
				Thread.sleep(120);
				Robot r = new Robot();
				Rectangle capture = new Rectangle(0, 0, 900, 900);
				BufferedImage Image = r.createScreenCapture(capture);
				ImageIO.write(Image, "png", new File(path));
				System.out.println("Screenshot saved");
				 isSaved = true;

			} catch (AWTException e) {
				System.err.println("Could not create Robot instance: " + e.getMessage());
			} catch (IOException e) {
				System.err.println("Could not write image to file: " + e.getMessage());
			} catch (InterruptedException e) {
				System.err.println("Thread interrupted while sleeping: " + e.getMessage());
			}
		}
	}

	
	 /**
     * Load and display an external image file into the canvas
     */
	
	public void loadImage() throws IOException {		
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Open Image");
		int userSelection = fileChooser.showOpenDialog(null);
		if (userSelection == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile();
			BufferedImage myPicture = ImageIO.read(selectedFile);
			this.setBufferedImage(myPicture);
		}
	}
	
	 /**
     * Overridden about method - shows version info + your name
     */
	 @Override
	public void about() {		
//		super.about();
//		getGraphicsContext().drawString("Sanskar Paudel",200,100);
		 this.setStroke(12);
			this.turtleMove(100);
			this.right(90);
			this.turtleMove(350);
			this.right(180);
			this.penDown();
			this.turtleMove(60);
			this.left(90);
			this.turtleMove(35);
			this.left(90);
			this.turtleMove(50);
			this.right(90);
			this.turtleMove(35);
			this.right(90);
			this.turtleMove(50);
			this.penUp();
			
			//A
			this.turtleMove(35);
			this.right(100);
			this.turtleMove(100);
			this.left(170);
			this.penDown();
			this.turtleMove(120);
			this.right(130);
			this.turtleMove(130);
			this.right(180);
			this.turtleMove(50);
			this.left(50);
			this.turtleMove(50);
			this.penUp();
			
			//N
			
			this.right(190);
			this.turtleMove(120);
			this.left(110);
			this.penDown();
			this.turtleMove(130);
			this.right(145);
			this.turtleMove(140);
			this.left(145);
			this.turtleMove(140);
			this.penUp();
			
			//S
			
			this.right(90);
			this.turtleMove(30);
			this.right(90);
			this.turtleMove(30);
			this.left(90);
			this.turtleMove(30);
			this.penDown();
			this.turtleMove(50);
			this.right(180);
			this.turtleMove(50);
			this.left(90);
			this.turtleMove(40);
			this.left(90);
			this.turtleMove(50);
			this.right(90);
			this.turtleMove(40);
			this.right(90);
			this.turtleMove(50);
			this.penUp();
			
			//k
			
			this.right(180);
			this.turtleMove(100);
			this.right(90);
			this.turtleMove(15);
			this.right(180);
			this.penDown();
			this.turtleMove(140);
			this.right(180);
			this.turtleMove(70);
			this.left(135);
			this.turtleMove(55);
			this.right(180);
			this.turtleMove(55);
			this.left(90);
			this.turtleMove(55);
			this.penUp();
			
			//A
			
			this.turtleMove(65);
			this.left(125);
			this.penDown();
			this.turtleMove(115);
			this.right(145);
			this.turtleMove(115);
			this.right(180);
			this.turtleMove(40);
			this.left(60);
			this.turtleMove(40);
			this.penUp();
			
			
			//R
			
			this.right(180);
			this.turtleMove(100);
			this.right(90);
			this.turtleMove(65);
			this.right(175);
			this.penDown();
			this.turtleMove(150);
			this.right(90);
			this.turtleMove(50);
			this.right(90);
			this.turtleMove(60);
			this.right(90);
			this.turtleMove(50);
			this.left(135);
			this.turtleMove(120);
			this.penUp();
			this.turtleMove(100);
	}
	 
	 /**
	     * Draw an equilateral triangle with given side length
	     */
	 
	public void EquilateralTriangle(int side) {		
		this.left();
		this.penDown();
		this.turtleMove(side);
		this.left(120);
		this.turtleMove(side);
		this.left(120);
		this.turtleMove(side);
		this.left(120);
	}
	
	  /**
     * Draw any triangle given its three sides
     */
	public void Triangle(int a,int b ,int c) {
		 double angleA = Math.toDegrees(Math.acos((b * b + c * c - a * a) / (2.0 * b * c)));
	     double angleB = Math.toDegrees(Math.acos((a * a + c * c - b * b) / (2.0 * a * c)));
	    double angleC = Math.toDegrees(Math.acos((a * a + b * b - c * c) / (2.0 * a * b)));
	this.right(180);
	this.penDown();
	this.turtleMove(a);
	this.left((int)(180.0- angleC));
	this.turtleMove(b);
	this.left((int)(180.0-angleA));
	this.turtleMove(c);
	this.left((int)(180.0-angleB));
	
	
	
	}
	
	 /**
     * Drawn own name using turtle drawing turtleMovements
     */
	public void myName() {
		//s
		this.setStroke(12);
		this.turtleMove(100);
		this.right(90);
		this.turtleMove(350);
		this.right(180);
		this.penDown();
		this.turtleMove(60);
		this.left(90);
		this.turtleMove(35);
		this.left(90);
		this.turtleMove(50);
		this.right(90);
		this.turtleMove(35);
		this.right(90);
		this.turtleMove(50);
		this.penUp();
		
		//A
		this.turtleMove(35);
		this.right(100);
		this.turtleMove(100);
		this.left(170);
		this.penDown();
		this.turtleMove(120);
		this.right(130);
		this.turtleMove(130);
		this.right(180);
		this.turtleMove(50);
		this.left(50);
		this.turtleMove(50);
		this.penUp();
		
		//N
		
		this.right(190);
		this.turtleMove(120);
		this.left(110);
		this.penDown();
		this.turtleMove(130);
		this.right(145);
		this.turtleMove(140);
		this.left(145);
		this.turtleMove(140);
		this.penUp();
		
		//S
		
		this.right(90);
		this.turtleMove(30);
		this.right(90);
		this.turtleMove(30);
		this.left(90);
		this.turtleMove(30);
		this.penDown();
		this.turtleMove(50);
		this.right(180);
		this.turtleMove(50);
		this.left(90);
		this.turtleMove(40);
		this.left(90);
		this.turtleMove(50);
		this.right(90);
		this.turtleMove(40);
		this.right(90);
		this.turtleMove(50);
		this.penUp();
		
		//k
		
		this.right(180);
		this.turtleMove(100);
		this.right(90);
		this.turtleMove(15);
		this.right(180);
		this.penDown();
		this.turtleMove(140);
		this.right(180);
		this.turtleMove(70);
		this.left(135);
		this.turtleMove(55);
		this.right(180);
		this.turtleMove(55);
		this.left(90);
		this.turtleMove(55);
		this.penUp();
		
		//A
		
		this.turtleMove(65);
		this.left(125);
		this.penDown();
		this.turtleMove(115);
		this.right(145);
		this.turtleMove(115);
		this.right(180);
		this.turtleMove(40);
		this.left(60);
		this.turtleMove(40);
		this.penUp();
		
		
		//R
		
		this.right(180);
		this.turtleMove(100);
		this.right(90);
		this.turtleMove(65);
		this.right(175);
		this.penDown();
		this.turtleMove(150);
		this.right(90);
		this.turtleMove(50);
		this.right(90);
		this.turtleMove(60);
		this.right(90);
		this.turtleMove(50);
		this.left(135);
		this.turtleMove(120);
		this.penUp();
		this.turtleMove(100);
	}		
	
	/**
     * Draw a square with the turtle, keeping original orientation
     */
	
	public void square(int side) {
		this.penDown();
		this.turtleMove(side);
		this.left(90);
		this.turtleMove(side);
		this.left(90);
		this.turtleMove(side);
		this.left(90);
		
		this.turtleMove(side);
		this.left(90);



	}
	
	 /**
     * Draw a full circle shape
     */
public void Circle() {
	this.penDown();
	this.circle(150);
	this.penUp();
}

	/**
 	* Draw a custom pattern made of squares and triangles
 	*/
//	public void newShape() {
//		this.penwidth(3);
//	    this.square(100);
//	    setPenColour(Color.white);
//	    this.EquilateralTriangle(100);
//	    this.left(90);
//	    this.right(180);
//	    setPenColour(Color.red);
//	    this.square(100);
//	    setPenColour(Color.cyan);
//	    this.EquilateralTriangle(100);
//	    this.right(90);
//	    setPenColour(Color.white);
//	    this.square(100);
//	    setPenColour(Color.yellow);
//	    this.EquilateralTriangle(100);
//	    this.right(90);
//	    setPenColour(Color.green);
//	    this.square(100);
//	    setPenColour(Color.cyan);
//	    this.EquilateralTriangle(100);
//	    setPenColour(Color.red);
//	    this.penwidth(7);
//	    this.circle(150);
//	}
//	
public void newShape() {
    reset();         // Automatically centers turtle and resets direction
    clear();         // Clear canvas
    penUp();       // Pen up

    // Draw outer red circle
    setPenColour(Color.RED);
    penwidth(5);
    penDown();
    circle(150);
    penUp();

    // 6 symmetric triangles around center
    setStroke(2);
    setPenColour(Color.CYAN);
    for (int i = 0; i < 6; i++) {
        penDown();
        EquilateralTriangle(80);
        penUp();
        right(60);
    }

    // Inner yellow hexagon
    penDown();
    
    setPenColour(Color.YELLOW);
    for (int i = 0; i < 6; i++) {
        turtleMove(110);
        right(60);
    }
    penUp();
    reset();
    // Center dot
    setPenColour(Color.MAGENTA);
    penwidth(4);
    penDown();
    circle(8);
    penUp();
    turtleMove(200);
}

	/**
     * Draw a simple clock face using circles and radial markers
     */
 public void clock() {
	 this.penDown();
	 this.penwidth(3);
	 setPenColour(Color.white);
	 this.circle(150);
	 this.penwidth(5);
	 this.circle(5);
	 this.left(180);
	 this.penUp();
	 this.turtleMove(160);
	 this.left(180);
	 this.penDown();
	 this.penwidth(3);
	 setPenColour(Color.GREEN);
	 this.turtleMove(20);
	 this.penUp();
	 this.turtleMove(120);
	 this.left(90);
	 this.turtleMove(160);
	 this.left(180);
	 this.penDown();
	 this.turtleMove(20);
	 this.penUp();
	 this.turtleMove(140);
	 this.left(90);
	 this.turtleMove(170);
	 this.left(180);
	 this.penDown();
	 this.turtleMove(20);
	 this.penUp();
	 this.turtleMove(140);
	 this.left(90);
	 this.turtleMove(150);
	 this.left(180);
	 this.penDown();
	 this.turtleMove(20);
	 this.penUp();
	 this.turtleMove(140);
	 this.left(60);
	 this.turtleMove(150);
	 this.left(180);
	 this.penDown();
	 this.turtleMove(20);
	 this.penUp();
	 this.turtleMove(150);	
	 this.left(160);
	 this.turtleMove(165);
	 this.left(180);
	 this.penDown();
	 this.turtleMove(20);
	 this.penUp();
	 this.turtleMove(140);
	 this.left(120);
	 this.turtleMove(165);
	 this.left(180);
	 this.penDown();
	 this.turtleMove(20);
	 this.penUp();
	 this.turtleMove(140);
	 this.left(140);
	 this.turtleMove(160);
	 this.left(180);
	 this.penDown();
	 this.turtleMove(20);
	 this.penUp();
	 this.turtleMove(140);
	 this.left(110);
	 this.turtleMove(160);
	 this.left(180);
	 this.penDown();
	 this.turtleMove(20);
	 this.penUp();
	 this.turtleMove(140);
	 this.left(150);
	 this.turtleMove(160);
	 this.left(180);
	 this.penDown();
	 this.turtleMove(20);
	 this.penUp();
	 this.turtleMove(140);
     this.left(120);
this.penUp();
this.turtleMove(150);
this.left(180);
this.penDown();
this.turtleMove(20);
this.penUp();
this.turtleMove(140);
this.left(160);
this.penUp();
this.turtleMove(160);
this.left(180);
this.penDown();
this.turtleMove(20);
this.penUp();
this.turtleMove(140);
this.left(120);
this.penwidth(9);
this.penDown();
setPenColour(Color.blue);
this.turtleMove(70);
this.penUp();
this.right(50);
this.turtleMove(100);
this.right(160);
this.turtleMove(160);
this.left(60);
this.penDown();
setPenColour(Color.green);
this.turtleMove(120);
this.penUp();
this.left(100);
this.turtleMove(200);

 }
 
 public void penUp() {
	    drawOff();
	}

	public void penDown() {
	    drawOn();
	}

 
 public void turtleMove(int distance) {
	    forward(distance);  // Call the inherited forward method
	}

	
 /**
  * Set the pen width (stroke thickness)
  */	
	
	public void	penwidth(int width) {
     this.setStroke(width);
	}

	 /**
     * Set the pen color using RGB values
     */
	public void pencolour(int red,int green,int blue) {		
		this.setPenColour(new Color(red,green,blue));
	}
	
	/**
     * Split a text command into parts and evaluate it
     */
	public void processCommand(String command)   
	
	{


		list=new ArrayList<String>();
		String parts[]=command.split(" ");

		for (int i=0;i<parts.length;i++) 
		{
			list.add(parts[i]);
		}
		size=list.size();
		evaluate(command);
	}
	

	/**
     * Execute a parsed user command (core command logic here)
     */
	public void evaluate(String val) {		

		try {

			if(arr.contains(list.get(0)))
			{

				switch(list.get(0)) 
				{
				case "turtleMove":
				    if (size == 1) {
				        // Only "turtleMove" was typed, no distance provided
				        JOptionPane.showMessageDialog(null, "Missing distance parameter for 'turtleMove'", "Missing Parameter", JOptionPane.WARNING_MESSAGE);
				        break;
				    } else {
				        try {
				            int distance = Integer.parseInt(list.get(1));
				            if (distance > 0) {
				                turtleMove(distance);
				                System.out.println("Turtle moved " + distance + " units.");
				                commandList.add(val);
				                isSaved = false;
				            } else {
				                JOptionPane.showMessageDialog(null, "Distance must be a positive number", "Invalid Parameter", JOptionPane.ERROR_MESSAGE);
				            }
				        } catch (NumberFormatException e) {
				            JOptionPane.showMessageDialog(null, "Parameter must be a number", "Invalid Input", JOptionPane.ERROR_MESSAGE);
				        }
				        break;
				    }

			





				case "right":
					if(size==1) {
						right(90);
						commandList.add(val);
					}



					else
					{
						if(Integer.parseInt(list.get(1))>0) {
							right(Integer.parseInt(list.get(1)));
							System.out.println("Turtle turned "+list.get(1)+" right !....");
							commandList.add(val);
						}
						else 
						{
							JOptionPane.showMessageDialog(null, "You entered negative parameter","Invalid parameter",JOptionPane.ERROR_MESSAGE);
						}
					}


					break;

				case "left":
					if(size==1) 
					{
						left(90);	
						commandList.add(val);

					}
					else 
					{
						if(Integer.parseInt(list.get(1))>0) 
						{
							left(Integer.parseInt(list.get(1)));
							System.out.println("Turtle turned "+list.get(1)+" left !....");
							commandList.add(val);
						}
						else 
						{
							JOptionPane.showMessageDialog(null, "You entered negative parameter","Invalid parameter",JOptionPane.ERROR_MESSAGE);
						}
					}
					break;

				case "reverse":
					if(size==1) 
					{
						turtleMove(-90);
						commandList.add(val);

					}
					else 
					{
						if(Integer.parseInt(list.get(1))>0) {
							turtleMove(-Integer.parseInt(list.get(1)));
							System.out.println("Turtle turtleMoved "+list.get(1)+" backward !....");
							commandList.add(val);
						}
						else 
						{
							JOptionPane.showMessageDialog(null, "You entered negative parameter","Invalid parameter",JOptionPane.ERROR_MESSAGE);

						}

					}
					break;

				case "penUp":
					penUp();
					commandList.add(val);
					System.out.println("Pen is up now!!....");
					break;

				case "penDown":
					penDown();
					commandList.add(val);
					System.out.println("Pen is down now!!....");
					break;

				case "black":
					setPenColour(Color.black);
					penDown();
					commandList.add(val);
					System.out.println("Turtle trail is now set to black!....");
					break;
					
				case "blue":
					setPenColour(Color.BLUE);
					penDown();
					commandList.add(val);
					System.out.println("Turtle trail is now set to black!....");
					break;

				case "green":
					setPenColour(Color.green);
					penDown();
					commandList.add(val);
					System.out.println("Turtle trail is now set to green!....");
					break;

				case "red":
					setPenColour(Color.red);
					penDown();
					commandList.add(val);
					System.out.println("Turtle trail is now set to red!....");
					break;

				case "white":
					setPenColour(Color.white);
					penDown();
					commandList.add(val);
					System.out.println("Turtle trail is now set to white!....");
					break;
				case "clear":
				    if (!isSaved) {
				        int confirm = JOptionPane.showConfirmDialog(null, "You haven't saved your work. Do you want to continue?", "Unsaved Changes", JOptionPane.YES_NO_OPTION);
				        if (confirm != JOptionPane.YES_OPTION) break;
				    }
				    clear();
				    isSaved = false;
				    System.out.println("Trails have been cleared!....");
				    commandList.add(val);
				    break;
				case "reset":
					reset();
					System.out.println("Turtle in orginal position");
					break;
				case "about":
					about();
					commandList.add(val);
					break;
				case "equilateral":
					if(size==1) {
						JOptionPane.showMessageDialog(null, "Please entered  parameter","No parameter",JOptionPane.ERROR_MESSAGE);
					}
					else if (Integer.parseInt(list.get(1))>0) {
						EquilateralTriangle(Integer.parseInt(list.get(1)));
						commandList.add(val);}
					else{
						JOptionPane.showMessageDialog(null, "You entered negative parameter","Invalid parameter",JOptionPane.ERROR_MESSAGE);}	
					break;

				case "pencolor":
					if(size==1 || list.size()==2 || list.size()==3) {
						JOptionPane.showMessageDialog(null, "Please entered  parameter","No parameter",JOptionPane.ERROR_MESSAGE);
					}
					else if(Integer.parseInt(list.get(1)) >= 0)
					{
						pencolour(Integer.parseInt(list.get(1)),Integer.parseInt(list.get(2)),Integer.parseInt(list.get(3)));
						commandList.add(val);}
					else{
						JOptionPane.showMessageDialog(null, "You entered negative parameter","Invalid parameter",JOptionPane.ERROR_MESSAGE);}	
					break;

				case "square":
					if(size==1) {
						JOptionPane.showMessageDialog(null, "Please enter  parameter","No parameter",JOptionPane.ERROR_MESSAGE);
					}
					else if (Integer.parseInt(list.get(1))>0) {
						square(Integer.parseInt(list.get(1)));
						commandList.add(val);}
					else{
						JOptionPane.showMessageDialog(null, "You entered negative parameter","Invalid parameter",JOptionPane.ERROR_MESSAGE);}	

					break;
				case "penwidth":
					if(size==1) {
						JOptionPane.showMessageDialog(null, "Please enter  parameter","No parameter",JOptionPane.ERROR_MESSAGE);
					}
					else if (Integer.parseInt(list.get(1))>0) {
						setStroke(Integer.parseInt(list.get(1)));
						System.out.println("Turtle penwidth incresed by "+list.get(1));
						commandList.add(val);}
					else{
						JOptionPane.showMessageDialog(null, "You entered negative parameter","Invalid parameter",JOptionPane.ERROR_MESSAGE);}	

					break;
					
				case "triangle":
					if(size==1 || list.size()==3||list.size()==2) {
						JOptionPane.showMessageDialog(null, "Please entered  parameter","No parameter",JOptionPane.ERROR_MESSAGE);
					}
					else if (Integer.parseInt(list.get(1))>0){
						int SideA=Integer.parseInt(list.get(1));
						int SideB=Integer.parseInt(list.get(2));
						int SideC=Integer.parseInt(list.get(3));
						Triangle(SideA,SideB,SideC);
					}
					
					else{
						JOptionPane.showMessageDialog(null, "You entered negative parameter","Invalid parameter",JOptionPane.ERROR_MESSAGE);}	
					break;
					
				case "randomcolor":
				    Random rand = new Random();
				    int r = rand.nextInt(256); // random number 0–255
				    int g = rand.nextInt(256);
				    int b = rand.nextInt(256);
				    setPenColour(new Color(r, g, b));
				    penDown();
				    commandList.add(val);
				    System.out.println("Random pen color set: R=" + r + ", G=" + g + ", B=" + b);
				    break;
				    
				case "doublewidth":
				    int newWidth = (int)(getStroke() * 2);
				    setStroke(newWidth);
				    commandList.add(val);
				    System.out.println("Pen width doubled to: " + newWidth);
				    break;



				case "save":
					saveCommands(commandList);
					
					JOptionPane.showMessageDialog(null, "Command saved successfully","Image saved",JOptionPane.PLAIN_MESSAGE);
					break;

				case "load":
					
					
					loadCommands();
					JOptionPane.showMessageDialog(null, "Command saved successfully","Image saved",JOptionPane.PLAIN_MESSAGE);
					commandList.add(val);
					

					break;
				case "screenshot":
				
					saveImage();
					commandList.add(val);
					

					break;
				case "image":
					try
					{
						loadImage();
						commandList.add(val);
						
					}
					catch (IOException e)
					{
						e.printStackTrace();
					}
				

					break;
				case "name":
					
					myName();
				break;
				case "circle":
					Circle();
					commandList.add(val);
				break;
				case "shape":
					newShape();
				commandList.add(val);
				break;
				case "clock":
					clock();
				commandList.add(val);
				break;
				
				

				}}
			



			else{
				JOptionPane.showMessageDialog(null, "You entered invalid command","Invalid Command try again",JOptionPane.ERROR_MESSAGE);
			}
		}







		catch(NumberFormatException nfe)
		{
			JOptionPane.showMessageDialog(null, "You entered string value in parameter","parameter error",JOptionPane.ERROR_MESSAGE);

		}
	}

	/**
     * Main method to launch the TurtleGraphics2025 application
     */

public static void main(String[] args) {
	new TurtleGraphic2025();
}}


