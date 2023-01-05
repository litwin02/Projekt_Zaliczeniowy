import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RecipeGUI extends JFrame{
    RecipeGUI(){
        /*
        JPanel redPanel = new JPanel(); // Create a panel
        redPanel.setBackground(Color.red); // Set the background color of the panel
        redPanel.setBounds(0, 0, 250, 250); // Set the bounds of the panel
        */

        JPanel mainTextPanel = new JPanel();
        mainTextPanel.setBackground(new Color(0xFB8604));
        mainTextPanel.setBounds(0, 40, 1000, 100);


        JLabel mainTitle = new JLabel(); // Create a label
        mainTitle.setText("RecipeIT"); // Set the text of the label
        mainTitle.setForeground(Color.white); // Set the text color
        mainTitle.setVerticalAlignment(JLabel.CENTER); // Set the vertical alignment of the label
        mainTitle.setHorizontalAlignment(JLabel.CENTER); // Set the horizontal alignment of the label
        mainTitle.setFont(new Font("Helvetica", Font.BOLD,45)); // Set the font of the text
        mainTitle.setForeground(new Color(0xFEEEDC)); // Set the text color
        mainTitle.setBounds(0, 0, 500, 500); // Set the bounds of the label


        this.setLayout(null); // Set the layout of the frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //close program when frame is closed
        this.setSize(1000, 800); //set size of frame x,y dimensions
        this.setTitle("RecipeIT"); //set title of frame
        this.setVisible(true); //make frame visible
        this.add(mainTextPanel); //add panel to frame
        mainTextPanel.add(mainTitle); //add label to panel


        ImageIcon logo = new ImageIcon("logo.png"); //create logo icon
        this.setIconImage(logo.getImage()); //change icon of frame
        this.getContentPane().setBackground(new Color(0xFB8604)); //change color of background
    }


}

