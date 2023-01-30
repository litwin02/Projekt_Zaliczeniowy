import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddProductPage extends JFrame {
    private JTextField productNameField;
    private JCheckBox veganCheckbox;
    private JTextField caloriesField;
    private JTextField proteinField;
    private JTextField fatField;
    private JTextField carbsField;
    private JTextField servingsField;
    private JButton addProductButton;
    private JButton cancelButton;
    public Product product;
    public boolean isAdded = false;
    public AddProductPage()
    {
        super("Add Product");

        product = new Product();

        JLabel productNameLabel = new JLabel("Product Name: ");
        productNameField = new JTextField(10);

        JLabel veganLabel = new JLabel("Vegan: ");
        veganCheckbox = new JCheckBox("Vegan");

        JLabel nutritionLabel = new JLabel("Nutrition Information per 100g:");

        JLabel caloriesLabel = new JLabel("Calories: ");
        caloriesField = new JTextField(10);

        JLabel proteinLabel = new JLabel("Protein: ");
        proteinField = new JTextField(10);

        JLabel fatLabel = new JLabel("Fat: ");
        fatField = new JTextField(10);

        JLabel carbsLabel = new JLabel("Carbs: ");
        carbsField = new JTextField(10);

        JLabel servingsLabel = new JLabel("Serving of this product in recipe:");
        servingsField = new JTextField(10);

        addProductButton = new JButton("Add Product");
        addProductButton.setBackground(new Color(0x342009));
        addProductButton.setForeground(new Color(0xFEEEDC));
        addProductButton.setFont(new Font("Helvetica", Font.BOLD,20));
        addProductButton.setFocusable(false);
        ActionListener addProductListener = actionEvent -> {
            product.setFullProductName(productNameField.getText());
            product.setVegan(veganCheckbox.isSelected());
            product.setTotalCaloriesPer100Gram(Integer.parseInt(caloriesField.getText()));
            product.setProteinIn100Gram(Integer.parseInt(proteinField.getText()));
            product.setFatIn100Gram(Integer.parseInt(fatField.getText()));
            product.setCarbsIn100Gram(Integer.parseInt(carbsField.getText()));
            product.setServingSize(Integer.parseInt(servingsField.getText()));
            isAdded = true;
            this.dispose();
        };
        addProductButton.addActionListener(addProductListener);


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

        JPanel inputPanel = new JPanel();
        inputPanel.setBackground(new Color(0xFB8604));
        inputPanel.setLayout(new GridLayout(9, 2));
        inputPanel.add(productNameLabel);
        inputPanel.add(productNameField);
        inputPanel.add(veganLabel);
        inputPanel.add(veganCheckbox);
        inputPanel.add(new JLabel());
        inputPanel.add(nutritionLabel);
        inputPanel.add(caloriesLabel);
        inputPanel.add(caloriesField);
        inputPanel.add(proteinLabel);
        inputPanel.add(proteinField);
        inputPanel.add(fatLabel);
        inputPanel.add(fatField);
        inputPanel.add(carbsLabel);
        inputPanel.add(carbsField);
        inputPanel.add(servingsLabel);
        inputPanel.add(servingsField);
        inputPanel.add(addProductButton);
        inputPanel.add(cancelButton);

        this.add(inputPanel);

        //window setup
        this.setSize(800, 600); //set size of frame x,y dimensions
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);
    }

    public static void main(String[] args) {
        new AddProductPage();
    }
}
