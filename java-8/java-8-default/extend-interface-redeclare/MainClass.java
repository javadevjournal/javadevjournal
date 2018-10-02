//Extending an interface that contains a default method
//Example :  Redeclare the 'default' method

interface FirstInterface {
    default public String getName() {
        return "Inside first interface";
    }
}

interface SecondInterface extends FirstInterface {
    public String getName();
}

public class MainClass implements SecondInterface {
    public static void main(String args[]) {
        MainClass mainClass = new MainClass();
        System.out.println(mainClass.getName());
    }

    @Override
    public String getName() {
        return "Inside MainClass";
    }
}
