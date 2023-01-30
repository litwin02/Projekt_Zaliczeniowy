import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class ProductSerializer extends JsonSerializer<Product> {
    @Override
    public void serialize(Product product, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
            throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("fullProductName", product.getFullProductName());
        jsonGenerator.writeBooleanField("isVegan", product.isVegan());
        jsonGenerator.writeNumberField("totalCaloriesPer100Gram", product.getCaloriesPerServing(1));
        jsonGenerator.writeNumberField("proteinIn100Gram", product.getProteinPerServing(1));
        jsonGenerator.writeNumberField("fatIn100Gram", product.getFatPerServing(1));
        jsonGenerator.writeNumberField("carbsIn100Gram", product.getCarbsPerServing(1));
        jsonGenerator.writeNumberField("servingSize", product.getServingSize());
        jsonGenerator.writeEndObject();
    }

}
