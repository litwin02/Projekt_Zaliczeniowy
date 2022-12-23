import java.util.ArrayList;
import java.util.HashMap;

public class Recipe {
    private String recipeName;
    private String recipeDescription;
    private HashMap<Product, Float> ingredientsAndServings;
    private ArrayList<String> instructions;
    private boolean isVegan;
    private float totalCaloriesPerServing;
    private float proteinPerServing;
    private float fatPerServing;
    private float carbsPerServing;
    private float servingSize;
    private float recipeRating;

    public String getRecipeName() {return recipeName;}
    public String getRecipeDescription() {return recipeDescription;}
    public void setRecipeName(String newRecipeName) {recipeName=newRecipeName;}
    public void setRecipeDescription(String newRecipeDescription) {recipeDescription = newRecipeDescription;}

    public boolean isVegan() {return isVegan;}
    public void setVegan(boolean vegan) {isVegan = vegan;}

    public float getTotalCaloriesPerServing() {return totalCaloriesPerServing;}
    public float getProteinPerServing() {return proteinPerServing;}
    public float getFatPerServing() {return fatPerServing;}
    public float getCarbsPerServing() {return carbsPerServing;}
    public float getServingSize() {return servingSize;}
    public void setServingSize(float newServingSize) {servingSize = newServingSize;}


}
