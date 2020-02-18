import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


class Customer {
    private String name;
    private String country;

    Customer(String _name, String _country){
        this.name = _name;
        this.country = _country;
    }

    String getCountry() {
        return country;
    }

    private String getName() {
        return name;
    }

    static void printCustomerDetail(List<Customer> customerList){
        customerList.forEach( e -> System.out.println("Customer name : "+e.getName()+" Country : "+e.getCountry()));
    }
}


public class Example2 {

    public static void main(String[] args) {
        Map<Integer,Customer> customerMap = new HashMap<>();
        String country = "UK";

        customerMap.put(1, new Customer("Boris","UK"));
        customerMap.put(2, new Customer("William","UK"));
        customerMap.put(3, new Customer("Simon","UK"));
        customerMap.put(4, new Customer("Paul","Zimbabwe"));

        List<Customer> customerList = customerMap
                .entrySet()
                .stream()
                .filter(x -> x.getValue().getCountry().equals(country))
                .map(item -> item.getValue())
                .collect(Collectors.toList());

        Customer.printCustomerDetail(customerList);
    }
}
