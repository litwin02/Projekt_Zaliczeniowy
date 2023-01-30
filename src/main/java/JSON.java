import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class JSON {
    private static ObjectMapper mapper = getDefaultObjectMapper();

    private static ObjectMapper getDefaultObjectMapper() {
        SimpleModule module = new SimpleModule();
        ObjectMapper defaultMapper = new ObjectMapper();
        module.addDeserializer(Product.class, new ProductDeserializer());

        module.addSerializer(Recipe.class, new RecipeSerializer());
        module.addSerializer(Float.class, new FloatSerializer());
        module.addSerializer(Product.class, new ProductSerializer());
        defaultMapper.registerModule(module);
        return defaultMapper;
    }
    public static JsonNode getJsonNode(String json) {
        try {
            return mapper.readTree(json);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public static String convertObjectToJson(Object object) {
        try {
            return mapper.writeValueAsString(object);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static <A> A convertJsonToObject(String json, Class<A> classOfA) {
        try {
            return mapper.treeToValue(getJsonNode(json), classOfA);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean checkIfDirectoryExist(boolean saveMode) {
        File file = new File("json");
        if(saveMode)
        {
            if (!file.exists()) {
                file.mkdir();
                return true;
            }
        }
        else {
            if (!file.exists()) {
                return false;
            }
            else {
                return true;
            }
        }
        return false;
    }
    public static boolean isDirEmpty() {
        File file = new File("json");
        if (file.list().length == 0) {
            return true;
        }
        return false;
    }
    public static void writeToFile(String json, String fileName) {
        checkIfDirectoryExist(true);
        fileName = "json/"+fileName+".json";
        File file = new File(fileName);
        int i = 1;
        while (file.exists()) {
            file = new File(fileName+"("+i+")"+".json");
            i++;
        }
        try {
            mapper.writeValue(file, getJsonNode(json));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readFile(String fileName)
    {
        try {
            File file = new File("json/"+fileName);
            Scanner scanner = new Scanner(file);
            String json = "";
            while (scanner.hasNextLine()) {
                json += scanner.nextLine();
            }
            scanner.close();
            return json;
        }
        catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
