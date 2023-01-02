import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RecipeGUI extends JFrame{
    JButton button;
    JLabel label;
    RecipeGUI(){
        /*ImageIcon image = new ImageIcon("temp_image.jpg"); // Create an image icon

        JLabel label = new JLabel(); // Create a label
        label.setText("Recipe GUI"); // Set the text of the label
        label.setIcon(image); // Set the image of the label
        label.setHorizontalTextPosition(JLabel.CENTER); // Set the horizontal alignment of the text
        label.setVerticalTextPosition(JLabel.TOP); // Set the vertical alignment of the text
        label.setForeground(Color.white); // Set the text color
        label.setFont(new Font("Arial", Font.ITALIC, 25)); // Set the font of the text
        label.setIconTextGap(-25); // Set the gap between the text and the image
        label.setVerticalAlignment(JLabel.CENTER); // Set the vertical alignment of the label
        label.setHorizontalAlignment(JLabel.CENTER); // Set the horizontal alignment of the label
        label.setBounds(0, 0, 250, 250); // Set the bounds of the label


        JPanel redPanel = new JPanel(); // Create a panel
        redPanel.setBackground(Color.red); // Set the background color of the panel
        redPanel.setBounds(0, 0, 250, 250); // Set the bounds of the panel

        JPanel bluePanel = new JPanel(); // Create a panel
        bluePanel.setBackground(Color.blue); // Set the background color of the panel
        bluePanel.setBounds(250, 0, 250, 250); // Set the bounds of the panel

        JPanel greenPanel = new JPanel(); // Create a panel
        greenPanel.setBackground(Color.green); // Set the background color of the panel
        greenPanel.setBounds(0, 250, 500, 250); // Set the bounds of the panel
        */

        label = new JLabel(); // Create a label
        label.setText("Recipe GUI"); // Set the text of the label
        label.setForeground(Color.white); // Set the text color
        label.setFont(new Font("Arial", Font.ITALIC, 25)); // Set the font of the text
        label.setBounds(0, 0, 250, 250); // Set the bounds of the label
        label.setVisible(false); // Set the visibility of the label

        button = new JButton("Click me"); // Create a button
        button.setBounds(200, 100, 100, 50); // Set the bounds of the button
        button.addActionListener(e -> label.setVisible(true)); // Add an action listener to the button
        button.setFocusable(false); // Set the focusable of the button aka delete annoying border
        button.setFont(new Font("Arial", Font.BOLD, 15)); // Set the font of the button
        button.setHorizontalAlignment(JButton.CENTER); // Set the horizontal alignment of the text
        button.setVerticalAlignment(JButton.CENTER); // Set the vertical alignment of the text
        button.setBackground(Color.white); // Set the background color of the button
        button.setBorder(BorderFactory.createEmptyBorder()); // Set the border of the button

        this.setLayout(null); // Set the layout of the frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //close program when frame is closed
        this.setSize(500, 500); //set size of frame x,y dimensions
        this.setTitle("Recipe GUI"); //set title of frame
        this.setVisible(true); //make frame visible
        this.add(button); // Add the button to the frame
        this.add(label); // Add the label to the frame



//        this.add(redPanel); //add panel to frame
//        this.add(bluePanel); //add panel to frame
//        this.add(greenPanel); //add panel to frame
//        redPanel.add(label); //add label to panel


        ImageIcon logo = new ImageIcon("logo.png"); //create logo icon
        this.setIconImage(logo.getImage()); //change icon of frame
        this.getContentPane().setBackground(new Color(128, 166, 254)); //change color of background
    }


}

