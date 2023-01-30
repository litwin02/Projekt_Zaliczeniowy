import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

public class ProductDeserializer extends JsonDeserializer<Product> {
    @Override
    public Product deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        String fullProductName = node.get("fullProductName").asText();
        boolean isVegan = node.get("isVegan").asBoolean();
        float totalCaloriesPer100Gram = node.get("totalCaloriesPer100Gram").asInt();
        float proteinIn100Gram = node.get("proteinIn100Gram").asInt();
        float fatIn100Gram = node.get("fatIn100Gram").asInt();
        float carbsIn100Gram = node.get("carbsIn100Gram").asInt();

        return new Product(fullProductName, isVegan, totalCaloriesPer100Gram, proteinIn100Gram, fatIn100Gram, carbsIn100Gram);
    }
}
