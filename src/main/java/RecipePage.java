import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class RecipePage extends JFrame {
    private JPanel recipeTitlePanel;
    private JPanel recipeDescriptionPanel;
    private JLabel recipeTitle;
    private JLabel recipeDescription;
    private JScrollPane recipeDescriptionScrollPane;
    private JPanel recipeIngredientsPanel;
    private JLabel recipeIngredients;
    private JPanel nutritionPanel;
    private JLabel nutrition;
    private JPanel backButtonPanel;
    private JButton backButton;
    RecipePage(Recipe recipe){
        super(recipe.getRecipeName());

        recipeTitlePanel = new JPanel();
        recipeTitlePanel.setBackground(new Color(0xFB8604));
        recipeTitlePanel.setBounds(0, 20, 1000, 50);

        recipeTitle = new JLabel(recipe.getRecipeName());
        recipeTitle.setFont(new Font("Helvetica", Font.BOLD,35));
        recipeTitle.setForeground(new Color(0xFEEEDC));
        recipeTitlePanel.add(recipeTitle);

        recipeDescriptionPanel = new JPanel();
        recipeDescriptionPanel.setBackground(new Color(0xFB8604));
        recipeDescriptionPanel.setBounds(0, 90, 1000, 300);

        recipeDescription = new JLabel();
        recipeDescription.setPreferredSize(new Dimension(1000, 800));
        recipeDescription.setText("<html><body style='width: 600px;'>" + recipe.getRecipeDescription() + "</body></html>"); //html tags to make the text wrap
        recipeDescription.setHorizontalAlignment(JLabel.LEFT);
        recipeDescription.setVerticalAlignment(JLabel.TOP);
        recipeDescription.setHorizontalTextPosition(JLabel.CENTER);
        recipeDescription.setVerticalTextPosition(JLabel.CENTER);
        recipeDescription.setFont(new Font("Helvetica", Font.BOLD,14));
        recipeDescription.setForeground(new Color(0x342009));

        recipeDescriptionScrollPane = new JScrollPane(recipeDescription, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        recipeDescriptionScrollPane.setPreferredSize(new Dimension(800, 300));
        recipeDescriptionPanel.add(recipeDescriptionScrollPane);

        recipeIngredientsPanel = new JPanel();
        recipeIngredientsPanel.setBackground(new Color(0xFB8604));
        recipeIngredientsPanel.setBounds(20, 410, 200, 200);

        recipeIngredients = new JLabel();
        recipeIngredients.setFont(new Font("Helvetica", Font.BOLD,16));
        recipeIngredients.setHorizontalAlignment(JLabel.LEFT);
        recipeIngredients.setVerticalAlignment(JLabel.TOP);
        recipeIngredients.setHorizontalTextPosition(JLabel.CENTER);
        recipeIngredients.setVerticalTextPosition(JLabel.CENTER);
        recipeIngredients.setPreferredSize(new Dimension(200, 200));
        recipeIngredients.setForeground(new Color(0x342009));
        recipeIngredients.setText("<html><body style='width: 600px;'>" + recipe.getIngredientsAndServings() + "</body></html>"); //html tags to make the text wrap
        recipeIngredientsPanel.add(recipeIngredients);

        nutritionPanel = new JPanel();
        nutritionPanel.setBackground(new Color(0xFB8604));
        nutritionPanel.setBounds(420, 410, 200, 200);

        nutrition = new JLabel();
        nutrition.setPreferredSize(new Dimension(200, 200));
        nutrition.setHorizontalAlignment(JLabel.LEFT);
        nutrition.setVerticalAlignment(JLabel.TOP);
        nutrition.setHorizontalTextPosition(JLabel.CENTER);
        nutrition.setVerticalTextPosition(JLabel.CENTER);
        nutrition.setText("<html><body style='width: 600px;'>" + "Total Calories: " + recipe.getTotalCaloriesPerServing() + "<br>" + "Protein: " + recipe.getProteinPerServing() + "<br>" + "Fat: " + recipe.getFatPerServing() + "<br>" + "Carbs: " + recipe.getCarbsPerServing() + "<br>" + "Is vegan: " + recipe.isVegan() + "</body></html>"); //html tags to make the text wrap
        nutrition.setFont(new Font("Helvetica", Font.BOLD,16));
        nutrition.setForeground(new Color(0x342009));
        nutritionPanel.add(nutrition);

        backButtonPanel = new JPanel();
        backButtonPanel.setBackground(new Color(0xFB8604));
        backButtonPanel.setBounds(800, 610, 200, 190);

        backButton = new JButton("Back");
        backButton.setFocusable(false);
        backButton.setPreferredSize(new Dimension(100, 50));
        backButton.setFont(new Font("Helvetica", Font.BOLD,16));
        backButton.setForeground(new Color(0x342009));
        backButton.setBackground(new Color(0xFEEEDC));
        backButton.addActionListener(e -> {
            this.dispose();
            new RecipeGUI();
        });
        backButtonPanel.add(backButton);

        this.add(backButtonPanel);
        this.add(recipeTitlePanel);
        this.add(recipeDescriptionPanel);
        this.add(recipeIngredientsPanel);
        this.add(nutritionPanel);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 800);
        this.setLayout(null);
        this.setVisible(true);
        this.setResizable(false);
        this.getContentPane().setBackground(new Color(0xFB8604));

        ImageIcon logo = new ImageIcon("logo.png");
        this.setIconImage(logo.getImage());
        this.getContentPane().setBackground(new Color(0xFB8604));

    }

    public static void main(String[] args) {
        HashMap product = new HashMap<Product, Float>();
        Product example = new Product("Test", true, 352, 80, 2.1f, 2.9f);
        product.put(example, 100f);
        Recipe recipe = new Recipe("Test", "Test", product, 100f, true);
        new RecipePage(recipe);

    }
}
