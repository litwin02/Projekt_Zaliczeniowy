import java.util.ArrayList;
import java.util.HashMap;

public class Recipe {
    private String recipeName;
    private String recipeDescription;
    private HashMap<Product, Float> ingredientsAndServings;
    private float totalCaloriesPerServing;
    private float proteinPerServing;
    private float fatPerServing;
    private float carbsPerServing;
    private float servingSize;

    private boolean isVegan;

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
    public void setVegan(boolean vegan) {isVegan = vegan;}
    public boolean isVegan() {return isVegan;}
    public HashMap<Product, Float> getIngredientsAndServings() {return ingredientsAndServings;}
    public void setIngredientsAndServings(HashMap<Product, Float> newIngredientsAndServings) {ingredientsAndServings = newIngredientsAndServings;}
    public Recipe(){
        recipeName = "";
        recipeDescription = "";
        ingredientsAndServings = new HashMap<Product, Float>();
        totalCaloriesPerServing = 0;
        proteinPerServing = 0;
        fatPerServing = 0;
        carbsPerServing = 0;
        servingSize = 0;
        RecipeGUI.recipes.add(this);
    }
    public Recipe(String recipeName, String recipeDescription, HashMap<Product, Float> ingredientsAndServings, float servingSize, boolean isVegan){
        this.recipeName = recipeName;
        this.recipeDescription = recipeDescription;
        this.ingredientsAndServings = ingredientsAndServings;
        this.isVegan = isVegan;
        this.servingSize = servingSize;
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
        RecipeGUI.recipes.add(this);
    }
    public void addIngredient(Product product, float servings){
        ingredientsAndServings.put(product, servings);
        this.totalCaloriesPerServing += product.getCaloriesPerServing(servings);
        this.proteinPerServing += product.getProteinPerServing(servings);
        this.fatPerServing += product.getFatPerServing(servings);
        this.carbsPerServing += product.getCarbsPerServing(servings);
    }
    @Override
    public String toString() {
        return this.recipeName;
    }
}
