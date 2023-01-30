import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

public class RecipeGUI extends JFrame implements ActionListener {
    private String search;
    private JTextField searchField;
    private JList searchResults;
    private JPanel addRecipePanel;
    private JButton addRecipeButton;
    static ArrayList<Recipe> recipes = new ArrayList<Recipe>();
    static ArrayList<Recipe> filteredRecipes = new ArrayList<Recipe>();
    private boolean ifDirExists = false;
    RecipeGUI(){
        JPanel mainTextPanel = new JPanel();
        mainTextPanel.setBackground(new Color(0xFB8604));
        mainTextPanel.setBounds(0, 40, 1000, 100);

        JPanel searchPanel = new JPanel();
        searchPanel.setBackground(new Color(0xFB8604));
        searchPanel.setBounds(0, 140, 1000, 100);

        JPanel resultsPanel = new JPanel();
        resultsPanel.setBackground(new Color(0xFB8604));
        resultsPanel.setBounds(0, 240, 1000, 700);

        addRecipePanel = new JPanel();
        addRecipePanel.setBackground(new Color(0xFB8604));
        addRecipePanel.setBounds(800, 40, 200, 100);


        //Main Title Label
        JLabel mainTitle = new JLabel(); // Create a label
        mainTitle.setText("RecipeFIT"); // Set the text of the label
        mainTitle.setVerticalTextPosition(JLabel.CENTER); // Set the vertical alignment of the label
        mainTitle.setHorizontalTextPosition(JLabel.CENTER); // Set the horizontal alignment of the label
        mainTitle.setFont(new Font("Helvetica", Font.BOLD,45)); // Set the font of the text
        mainTitle.setForeground(new Color(0xFEEEDC)); // Set the text color

        //Add Recipe Button
        addRecipeButton = new JButton("Add Recipe");
        addRecipeButton.setBackground(new Color(0x342009));
        addRecipeButton.setFocusable(false);
        addRecipeButton.setPreferredSize(new Dimension(120, 70));
        addRecipeButton.setFont(new Font("Helvetica", Font.BOLD,13));
        addRecipeButton.setForeground(new Color(0x342009));
        addRecipeButton.setBackground(new Color(0xFEEEDC));
        ActionListener actionListener = actionEvent -> {
            this.dispose();
            AddRecipePage addRecipePage = new AddRecipePage();
        };
        addRecipeButton.addActionListener(actionListener);

        //Search Field
        searchField = new JTextField("", 20);
        searchField.setForeground(new Color(0xFEEEDC));
        searchField.setBackground(new Color(0x342009));
        searchField.setFont(new Font("Helvetica", Font.BOLD,20));

        //Search Button
        JButton button = new JButton("Search");
        button.setBackground(new Color(0x342009));
        button.setForeground(new Color(0xFEEEDC));
        button.setFont(new Font("Helvetica", Font.BOLD,20));
        button.setBounds(300, 0, 1000, 100);
        button.addActionListener(this);


        //Search Results Listings
        searchResults = new JList();
        searchResults.setVisible(false);
        searchResults.setFont(new Font("Helvetica", Font.BOLD,20));
        searchResults.setBackground(new Color(0x342009));
        searchResults.setForeground(new Color(0xFEEEDC));

        //Open new Recipe Page when a recipe is selected
        ListSelectionListener listSelectionListener = listSelectionEvent -> {
            this.dispose();
            RecipePage recipePage = new RecipePage(recipes.get(searchResults.getSelectedIndex()));
        };
        searchResults.addListSelectionListener(listSelectionListener);


        //window settings
        this.setLayout(null); // Set the layout of the frame
        this.setResizable(false); // Set the frame not to be resizable
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //close program when frame is closed
        this.setSize(1000, 800); //set size of frame x,y dimensions
        this.setTitle("RecipeFIT"); //set title of frame
        this.setVisible(true); //make frame visible
        this.setResizable(false); //set frame to not be resizable
        ImageIcon logo = new ImageIcon("logo.png"); //create logo icon
        this.setIconImage(logo.getImage()); //change icon of frame
        this.getContentPane().setBackground(new Color(0xFB8604)); //change color of background

        //add components to panels
        mainTextPanel.add(mainTitle);
        searchPanel.add(searchField);
        searchPanel.add(button);
        resultsPanel.add(searchResults);
        addRecipePanel.add(addRecipeButton);

        //add panels to frame
        this.add(addRecipePanel);
        this.add(mainTextPanel);
        this.add(searchPanel);
        this.add(resultsPanel);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        search = searchField.getText();
        search = search.toLowerCase();
        filteredRecipes.clear();

        //ifDirExists = JSON.checkIfDirectoryExist(false);

        /*
        if(ifDirExists){
            if(JSON.isDirEmpty()){
                searchResults.setListData(new String[]{"No recipes found"});
                searchResults.setVisible(true);
            }
            else{
                File folder = new File("json");
                File[] listOfFiles = folder.listFiles();

                for (File file : listOfFiles) {
                    if (file.isFile()) {
                        recipes.add(JSON.convertJsonToObject(JSON.readFile(file.getName()), Recipe.class));
                    }
                }
                for (Recipe recipe : recipes) {
                    if (recipe.getRecipeName().toLowerCase().contains(search)) {
                        filteredRecipes.add(recipe);
                    }
                }
            }
        }


        else{
            searchResults.setListData(new String[]{"No files found"});
            searchResults.setVisible(true);
        }
        */
        for (Recipe recipe : recipes) {
            if (recipe.getRecipeName().toLowerCase().contains(search)) {
                filteredRecipes.add(recipe);
            }
        }

        if(filteredRecipes.size() > 0){
            searchResults.setListData(filteredRecipes.toArray());
            searchResults.setVisible(true);
        }
        else{
            searchResults.setListData(new String[]{"No results found"});
            searchResults.setVisible(true);
        }
    }
}

