import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Main implements Runnable, ActionListener{

  // Class Variables
  JPanel mainPanel; 

  JLabel guessLabel;
  JLabel responseLabel; 

  JTextField numberInput;

  JButton submitButton;
  JButton newNumberButton;
  


  // Method to assemble our GUI
  public void run(){
    // Creats a JFrame that is 800 pixels by 600 pixels, and closes when you click on the X
    JFrame frame = new JFrame("Title");
    // Makes the X button close the program
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // makes the windows 800 pixel wide by 600 pixels tall
    frame.setSize(800,600);
    // shows the window
    frame.setVisible(true);

  

    // initialize the main JPanel
    mainPanel = new JPanel();
    // disable any layout helpers
    mainPanel.setLayout(null);

    //initialize the labels
    guessLabel = new JLabel("Guess the number between 0 and 100:");
    responseLabel = new JLabel();
    // set the location and setSize
    guessLabel.setBounds(100, 50, 300, 20);
    responseLabel.setBounds(100, 180, 300, 20);
    // add the JLabels to the main panel
    mainPanel.add(guessLabel);
    mainPanel.add(responseLabel);

    // initialize the text area
    numberInput = new JTextField();
    // set the location and size
    numberInput.setBounds(100, 90, 300, 20);
    // add the text area to the main panel
    mainPanel.add(numberInput);

    // initialize the JButtons
    submitButton = new JButton("Submit");
    newNumberButton = new JButton("New Number");
    // set the location and size
    submitButton.setBounds(100, 130, 95, 30);
    newNumberButton.setBounds(205, 130, 195, 30);
    // add an action listener to the buttons
    submitButton.addActionListener(this);
    newNumberButton.addActionListener(this);
    // set the action command on the buttons
    submitButton.setActionCommand("Submit");
    newNumberButton.setActionCommand("New Number");
    // add the JButtons to the main panel
    mainPanel.add(submitButton);
    mainPanel.add(newNumberButton);

    // add the main panel to the window
    frame.add(mainPanel);
  }

  // method called when a button is pressed
  public void actionPerformed(ActionEvent e){
    // get the command from the action
    String command = e.getActionCommand();

    // creating the random generator
    Random rand = new Random();

    // create a random number
    int randomNumber = rand.nextInt(100);

    if(command.equals("Submit")){
      // get the text from the text box
      String numberText = numberInput.getText();

      // change the string into an integer
      int numberInteger = Integer.parseInt(numberText);
      
      if(numberInteger > randomNumber){
        // print out result 
        responseLabel.setText("Your guess of " + numberInteger + " is too high!");
      }else if(numberInteger < randomNumber){
        // print out result 
        responseLabel.setText("Your guess of " + numberInteger + " is too low!");
      }else if( numberInteger == randomNumber){
        // print out result 
        responseLabel.setText("Your guess of " + numberInteger + " is correct!");
      }
    }
  }

  // Main method to start our program
  public static void main(String[] args){
    // Creates an instance of our program
    Main gui = new Main();
    // Lets the computer know to start it in the event thread
    SwingUtilities.invokeLater(gui);
  }
}
