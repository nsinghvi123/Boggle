public class testingPasses {
    private int value = 0;

    public testingPasses (int value){

        this.value = value;

    }

    public static void main(String[] args) {
        // testing pass by value in JAVA
        int OneValue = 2;
        addTwo(OneValue);
        System.out.println(OneValue);

        // testing pass by reference in JAVA
        testingPasses newTestObject = new testingPasses(50);
        addThree(newTestObject);
        System.out.println(newTestObject.value);




    }

    public static int addTwo(int value){
        value = value + 2;

        return value;
    }

    public static void addThree(testingPasses x){
        x.value = 53;
    }

}
