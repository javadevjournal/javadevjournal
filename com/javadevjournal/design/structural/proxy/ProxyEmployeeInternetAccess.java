package javadevjournal.design.structural.proxy;

/**
 * @author Kunwar
 */
public class ProxyEmployeeInternetAccess implements InternetAccess {
    private String employeeName;
    private EmployeeInternetAccess employeeInternetAccess;

    public ProxyEmployeeInternetAccess(String employeeName) {
        this.employeeName = employeeName;
    }

    @Override
    public void grantInternetAccessToEmployees() {
        if (getRole(employeeName) > 4) {
            employeeInternetAccess = new EmployeeInternetAccess(employeeName);
            employeeInternetAccess.grantInternetAccessToEmployees();
        } else {
            System.out.println("No Internet access granted. Your job level is below 5");
        }
    }

    public int getRole(String empName) {
        //make a DB call to get the employee role and return it.
        return 31;
    }
}  