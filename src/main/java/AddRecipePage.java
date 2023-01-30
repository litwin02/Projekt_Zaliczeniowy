import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class AddRecipePage extends JFrame {
    private JTextField recipeNameField;
    private JTextField recipeDescriptionField;
    private JButton addProductsButton;
    private JLabel listofProductsLabel;
    private JButton addRecipeButton;
    private JButton cancelButton;
    public AddProductPage addProductPage;
    public AddRecipePage() {
        super("Add Recipe");

        Recipe recipe = new Recipe();

        JLabel recipeNameLabel = new JLabel("Recipe Name: ");
        recipeNameLabel.setFont(new Font("Helvetica", Font.BOLD,25));

        recipeNameField = new JTextField(20);
        recipeNameField.setFont(new Font("Helvetica", Font.BOLD,15));

        JLabel recipeDescriptionLabel = new JLabel("Recipe Description: ");
        recipeDescriptionLabel.setFont(new Font("Helvetica", Font.BOLD,25));

        recipeDescriptionField = new JTextField(20);
        recipeDescriptionField.setFont(new Font("Helvetica", Font.BOLD,15));

        listofProductsLabel = new JLabel("List of Products: ");
        listofProductsLabel.setVerticalAlignment(JLabel.TOP);
        listofProductsLabel.setFont(new Font("Helvetica", Font.BOLD,15));

        addProductsButton = new JButton("Add Products");
        addProductsButton.setBackground(new Color(0x342009));
        addProductsButton.setForeground(new Color(0xFEEEDC));
        addProductsButton.setFont(new Font("Helvetica", Font.BOLD,20));
        addProductsButton.setFocusable(false);

        ActionListener addProductListener = actionEvent -> {
            addProductPage = new AddProductPage();
            addProductPage.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                    recipe.addIngredient(addProductPage.product, addProductPage.product.getServingSize());
                    listofProductsLabel.setText("<html><body style='width: 380px;'>"+"List of products: " + recipe.getIngredientsAndServings().toString()+"</html>");
                }
            });
        };
        addProductsButton.addActionListener(addProductListener);

        addRecipeButton = new JButton("Add Recipe");
        addRecipeButton.setBackground(new Color(0x342009));
        addRecipeButton.setForeground(new Color(0xFEEEDC));
        addRecipeButton.setFont(new Font("Helvetica", Font.BOLD,20));
        addRecipeButton.setFocusable(false);

        ActionListener addRecipeListener = actionEvent -> {
            recipe.setRecipeName(recipeNameField.getText());
            recipe.setRecipeDescription(recipeDescriptionField.getText());
            JSON.writeToFile(JSON.convertObjectToJson(recipe), recipe.getRecipeName());
            this.dispose();
            new RecipeGUI();
        };
;       addRecipeButton.addActionListener(addRecipeListener);

        cancelButton = new JButton("Cancel");
        cancelButton.setBackground(new Color(0xFF0000));
        cancelButton.setForeground(new Color(0xFEEEDC));
        cancelButton.setFont(new Font("Helvetica", Font.BOLD,20));
        cancelButton.setFocusable(false);
        ActionListener cancelListener = actionEvent -> {
            this.dispose();
            new RecipeGUI();
        };
        cancelButton.addActionListener(cancelListener);

        //create panel and add components
        JPanel inputPanel = new JPanel();
        inputPanel.setBackground(new Color(0xFB8604));
        inputPanel.setLayout(new GridLayout(4, 4));
        inputPanel.add(recipeNameLabel);
        inputPanel.add(recipeNameField);
        inputPanel.add(recipeDescriptionLabel);
        inputPanel.add(recipeDescriptionField);
        inputPanel.add(listofProductsLabel);
        inputPanel.add(addProductsButton);
        inputPanel.add(addRecipeButton);
        inputPanel.add(cancelButton);

        //add components to frame
        this.add(inputPanel);


        //window setup
        this.setSize(1000, 800); //set size of frame x,y dimensions
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);
    }

}
