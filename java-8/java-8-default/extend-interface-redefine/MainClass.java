//Extending an interface that contains a default method
//Example :  Redefine the 'default' method

interface FirstInterface {
    default public String getName() {
        return "Inside first interface";
    }
}

interface SecondInterface extends FirstInterface {
    default public String getName() {
        return "Inside second interface";
    }
}

public class MainClass implements SecondInterface {
    public static void main(String args[]) {
        MainClass mainClass = new MainClass();
        System.out.println(mainClass.getName());
    }
}