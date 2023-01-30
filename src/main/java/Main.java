import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Product boczek = new Product("Boczek", false, 340f, 30f, 40f, 2f);
        HashMap<Product, Float> listaProd = new HashMap<>();
        listaProd.put(boczek, 50f);
        Recipe recipe1 = new Recipe("Lasagne","Ugotuj sos bolognese i sos beszamelowy, zrób makaron, robisz warstwy na góre ser i jest",listaProd, 200f, false );
        new RecipeGUI();
    }
}