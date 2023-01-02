import java.util.ArrayList;
import java.util.HashMap;

public class Recipe {
    private String recipeName;
    private String recipeDescription;
    private HashMap<Product, Float> ingredientsAndServings;
    private ArrayList<String> instructions;

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

    public float getTotalCaloriesPerServing() {return totalCaloriesPerServing;}
    public float getProteinPerServing() {return proteinPerServing;}
    public float getFatPerServing() {return fatPerServing;}
    public float getCarbsPerServing() {return carbsPerServing;}
    public float getServingSize() {return servingSize;}
    public void setServingSize(float newServingSize) {servingSize = newServingSize;}

    public float getRecipeRating() {return recipeRating;}
    public Recipe(){
        recipeName = "No name";
        recipeDescription = "No description";
        ingredientsAndServings = new HashMap<Product, Float>();
        instructions = new ArrayList<String>();
        totalCaloriesPerServing = 0;
        proteinPerServing = 0;
        fatPerServing = 0;
        carbsPerServing = 0;
        servingSize = 0;
        recipeRating = 0;
    }
    public Recipe(String recipeName, String recipeDescription, HashMap<Product, Float> ingredientsAndServings, ArrayList<String> instructions, float servingSize, float recipeRating){
        this.recipeName = recipeName;
        this.recipeDescription = recipeDescription;
        this.ingredientsAndServings = ingredientsAndServings;
        this.instructions = instructions;
        this.servingSize = servingSize;
        this.recipeRating = recipeRating;
        this.totalCaloriesPerServing = 0;
        this.proteinPerServing = 0;
        this.fatPerServing = 0;
        this.carbsPerServing = 0;
        for (Product product : ingredientsAndServings.keySet()){
            this.totalCaloriesPerServing += product.getCaloriesPerServing(ingredientsAndServings.get(product));
            this.proteinPerServing += product.getProteinPerServing(ingredientsAndServings.get(product));
            this.fatPerServing += product.getFatPerServing(ingredientsAndServings.get(product));
            this.carbsPerServing += product.getCarbsPerServing(ingredientsAndServings.get(product));
        }
    }
}
