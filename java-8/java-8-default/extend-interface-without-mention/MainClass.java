//Extending an interface that contains a default method
//Example :  Don't mention anything about the 'default' method in the new interface.

interface FirstInterface {
    default public String getName() {
        return "Inside first interface";
    }
}

interface SecondInterface extends FirstInterface {
}

class MainClass implements SecondInterface {
    public static void main(String args[]) {
        MainClass mainClass = new MainClass();
        System.out.println(mainClass.getName());
    }
}
