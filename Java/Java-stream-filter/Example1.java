import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

enum OrderType {
    ONLINE,
    OFFLINE
}

class Order {
    private String customerName;
    private OrderType orderType;
    private float amount;

    Order(OrderType _orderType, float _amount, String _customerName){
        this.orderType = _orderType;
        this.amount = _amount;
        this.customerName = _customerName;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public float getAmount() {
        return amount;
    }

    public String getCustomerName() {
        return customerName;
    }

    static void printOrders(List<Order> orderList){
        orderList.forEach(e -> {
            System.out.println("Customer Name : "+e.getCustomerName()+", Order type : "+e.getOrderType()+" , Amount : "+e.getAmount());
        });
    }
}


public class Example1 {

    public static void main(String[] args) {
        Order[] orderArray = {new Order(OrderType.OFFLINE, 1000, "Bob"), new Order(OrderType.ONLINE, 500, "Rose"),
                new Order(OrderType.OFFLINE, 400, "Nancy"), new Order(OrderType.ONLINE, 1500, "Kate")};

        List<Order> orderList = Arrays.asList(orderArray);

        System.out.println("Given Orders : ");
        Order.printOrders(orderList);

        List<Order> offlineList = orderList.stream()
                .filter(item -> item.getOrderType().equals(OrderType.OFFLINE))
                .collect(Collectors.toList());

        System.out.println("Offline order list : ");
        Order.printOrders(offlineList);

        List<Order> belowThousandList = orderList.stream()
                .filter(item -> item.getAmount() < 1000)
                .collect(Collectors.toList());
        System.out.println("Orders with less than 1000 : ");
        Order.printOrders(belowThousandList);
    }
}