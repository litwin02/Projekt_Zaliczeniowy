import com.fasterxml.jackson.databind.JsonNode;

public class Product {
    private String fullProductName;
    private boolean isVegan;
    private float totalCaloriesPer100Gram;
    private float proteinIn100Gram;
    private float fatIn100Gram;
    private float carbsIn100Gram;
    private float servingSize;

    public String getFullProductName() {return fullProductName;}
    public void setFullProductName(String newProductName) {fullProductName=newProductName;}

    public boolean isVegan() {return isVegan;}
    public void setVegan(boolean vegan) {isVegan = vegan;}

    public float getCaloriesPerServing(float servingSize) {return totalCaloriesPer100Gram*servingSize/100;}
    public float getProteinPerServing(float servingSize) {return proteinIn100Gram*servingSize/100;}
    public float getFatPerServing(float servingSize) {return fatIn100Gram*servingSize/100;}
    public float getCarbsPerServing(float servingSize) {return carbsIn100Gram*servingSize/100;}

    public void setTotalCaloriesPer100Gram(float newTotalCaloriesPer100Gram) {totalCaloriesPer100Gram = newTotalCaloriesPer100Gram;}
    public void setProteinIn100Gram(float newProteinIn100Gram) {proteinIn100Gram = newProteinIn100Gram;}
    public void setFatIn100Gram(float newFatIn100Gram) {fatIn100Gram = newFatIn100Gram;}
    public void setCarbsIn100Gram(float newCarbsIn100Gram) {carbsIn100Gram = newCarbsIn100Gram;}
    public void setServingSize(float newServingSize) {servingSize = newServingSize;}
    public float getServingSize() {return servingSize;}
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
    public Product(){
        this.fullProductName = "";
        this.isVegan = false;
        this.totalCaloriesPer100Gram = 0;
        this.proteinIn100Gram = 0;
        this.fatIn100Gram = 0;
        this.carbsIn100Gram = 0;
    }

    @Override
    public String toString() {
        return this.fullProductName;
    }
}
