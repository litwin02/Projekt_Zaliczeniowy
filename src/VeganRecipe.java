import java.util.ArrayList;
import java.util.HashMap;

public class VeganRecipe extends Recipe {
    private boolean isVegan;

    public boolean isVegan() {return isVegan;}
    public void setVegan(boolean vegan) {isVegan = vegan;}

    public VeganRecipe(String recipeName, String recipeDescription, HashMap<Product, Float> ingredientsAndServings, ArrayList<String> instructions, float servingSize, float recipeRating, boolean isVegan){
        super(recipeName, recipeDescription, ingredientsAndServings, instructions, servingSize, recipeRating);
        this.isVegan = isVegan;
    }
}

