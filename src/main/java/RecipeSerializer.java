import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.util.HashMap;

public class RecipeSerializer extends JsonSerializer<Recipe> {
    @Override
    public void serialize(Recipe recipe, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("recipeName", recipe.getRecipeDescription());
        jsonGenerator.writeStringField("recipeDescription", recipe.getRecipeDescription());
        jsonGenerator.writeObjectField("ingredientsAndServings", recipe.getIngredientsAndServings());
        jsonGenerator.writeNumberField("totalCaloriesPerServing", recipe.getTotalCaloriesPerServing());
        jsonGenerator.writeNumberField("proteinPerServing", recipe.getProteinPerServing());
        jsonGenerator.writeNumberField("fatPerServing", recipe.getFatPerServing());
        jsonGenerator.writeNumberField("carbsPerServing", recipe.getCarbsPerServing());
        jsonGenerator.writeNumberField("servingSize", recipe.getServingSize());
        jsonGenerator.writeBooleanField("isVegan", recipe.isVegan());
        jsonGenerator.writeEndObject();

    }
}
