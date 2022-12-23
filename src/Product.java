public class Product {
    private String fullProductName;
    private boolean isVegan;
    private float totalCaloriesPer100Gram;
    private float proteinIn100Gram;
    private float fatIn100Gram;
    private float carbsIn100Gram;

    public String getFullProductName() {return fullProductName;}
    public void setFullProductName(String newProductName) {fullProductName=newProductName;}

    public boolean isVegan() {return isVegan;}
    public void setVegan(boolean vegan) {isVegan = vegan;}

    public float getTotalCaloriesPer100Gram() {return totalCaloriesPer100Gram;}
    public float getProteinIn100Gram() {return proteinIn100Gram;}
    public float getFatIn100Gram() {return fatIn100Gram;}
    public float getCarbsIn100Gram() {return carbsIn100Gram;}

    public float getCaloriesPerServing(float servingSize) {return totalCaloriesPer100Gram*servingSize/100;}
    public float getProteinPerServing(float servingSize) {return proteinIn100Gram*servingSize/100;}
    public float getFatPerServing(float servingSize) {return fatIn100Gram*servingSize/100;}
    public float getCarbsPerServing(float servingSize) {return carbsIn100Gram*servingSize/100;}

    public Product(String fullProductName, boolean isVegan, float totalCaloriesPer100Gram, float proteinIn100Gram, float fatIn100Gram, float carbsIn100Gram){
        this.fullProductName = fullProductName;
        this.isVegan = isVegan;
        this.totalCaloriesPer100Gram = totalCaloriesPer100Gram;
        this.proteinIn100Gram = proteinIn100Gram;
        this.fatIn100Gram = fatIn100Gram;
        this.carbsIn100Gram = carbsIn100Gram;
    }
    public Product(String fullProductName, boolean isVegan){
        this.fullProductName = fullProductName;
        this.isVegan = isVegan;
        this.totalCaloriesPer100Gram = 0;
        this.proteinIn100Gram = 0;
        this.fatIn100Gram = 0;
        this.carbsIn100Gram = 0;
    }
}
