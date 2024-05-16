import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        operator[] operatorArray = new operator[100];
        customer[] customerArray = new customer[100];
        order[] orderArray = new order[100];
        int operatorCount = 0;
        int customerCount = 0;
        int orderCount = 0;

        try {
            File file = new File("content.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {

                // Read the next line from the file and split it into array of strings using ";"
                String[] data = scanner.nextLine().split(";");

                if (data.length == 0)
                    continue;
                // checks if the array string contains an empty string
                if (containEmptyStr(data) == 1)
                    continue;

                if ("operator".equals(data[0])) {
                    int op_id, op_wage;

                    // checks the number of columns
                    if (data.length != 7) {
                        continue;
                    }

                    try {
                        op_id = Integer.parseInt(data[5]);
                        op_wage = Integer.parseInt(data[6]);
                    } catch (Exception e) {
                        continue;
                    }

                    if (op_id <= 0 || op_wage <= 0) {
                        continue;
                    }

                    // Check if the operator ID is unique
                    if (isIDUnique(op_id, operatorArray, operatorCount, customerArray,
                            customerCount) == 0) {
                        continue;
                    }

                    operatorArray[operatorCount++] = new operator(data[1], data[2], data[3], data[4],
                            op_id,
                            op_wage);

                } else if ("retail_customer".equals(data[0])) {
                    int rcu_id, rcu_op_id;
                    // checks the number of columns
                    if (data.length != 7) {
                        continue;
                    }

                    try {
                        rcu_id = Integer.parseInt(data[5]);
                        rcu_op_id = Integer.parseInt(data[6]);
                    } catch (Exception e) {
                        continue;
                    }

                    if (rcu_id <= 0 || rcu_op_id <= 0) {
                        continue;
                    }

                    // Check if the customer ID is unique
                    if (isIDUnique(rcu_id, operatorArray, operatorCount, customerArray,
                            customerCount) == 0) {
                        continue;
                    }

                    customerArray[customerCount++] = new retail_customer(data[1], data[2], data[3], data[4],
                            rcu_id, rcu_op_id);

                } else if ("corporate_customer".equals(data[0])) {
                    int cu_id, cu_op_id;
                    // checks the number of columns
                    if (data.length != 8) {
                        continue;
                    }

                    try {
                        cu_id = Integer.parseInt(data[5]);
                        cu_op_id = Integer.parseInt(data[6]);
                    } catch (Exception e) {
                        continue;
                    }

                    if (cu_id <= 0 || cu_op_id <= 0) {
                        continue;
                    }

                    // Check if the customer ID is unique
                    if (isIDUnique(cu_id, operatorArray, operatorCount, customerArray,
                            customerCount) == 0) {
                        continue;
                    }
                    customerArray[customerCount++] = new corporate_customer(data[1], data[2], data[3],
                            data[4], cu_id, cu_op_id, data[7]);

                } else if ("order".equals(data[0])) {
                    int or_count, or_total_price, or_status, or_cu_id;
                    // checks the number of columns
                    if (data.length != 6) {
                        continue;
                    }

                    try {
                        or_count = Integer.parseInt(data[2]);
                        or_total_price = Integer.parseInt(data[3]);
                        or_status = Integer.parseInt(data[4]);
                        or_cu_id = Integer.parseInt(data[5]);
                    } catch (Exception e) {
                        continue;
                    }

                    // checks if status is in between 0 and 3
                    if (or_status > 3 || or_status < 0) {
                        continue;
                    }

                    if (or_count <= 0 || or_total_price <= 0 || or_cu_id <= 0) {
                        continue;
                    }

                    orderArray[orderCount++] = new order(data[1], or_count,
                            or_total_price,
                            or_status, or_cu_id);

                }
            }

            // adds the matching customer to the operator
            for (int i = 0; i < operatorCount; i++) {
                for (int j = 0; j < customerCount; j++) {
                    if (operatorArray[i].getID() == customerArray[j].getOperatorID()) {
                        operatorArray[i].defineCustomers(customerArray);
                    }
                }
            }

            // adds the matching order to the customer
            for (int i = 0; i < customerCount; i++) {
                for (int j = 0; j < orderCount; j++) {
                    if (customerArray[i].getID() == orderArray[j].getCustomerID()) {
                        customerArray[i].defineOrders(orderArray);
                    }
                }
            }

            System.out.println("Please enter your ID...");
            Scanner newScanner = new Scanner(System.in);

            // Check if input is an integer
            if (!newScanner.hasNextInt()) {
                System.err.println("Invalid input.");
                newScanner.close();
                scanner.close();
                return;
            }

            int ID = newScanner.nextInt();

            // Check if ID is below 0
            if (ID < 0) {
                System.err.println("Invalid input.");
                newScanner.close();
                scanner.close();
                return;
            }

            // looping through operator array to find the given id
            int found = 0;
            for (int i = 0; i < operatorCount; i++) {
                if (operatorArray[i].getID() == ID) {
                    operatorArray[i].printOperator();
                    found = 1;
                    break;
                }
            }
            // looping through customer array to find the given id
            if (found == 0) {
                for (int i = 0; i < customerCount; i++) {
                    if (customerArray[i].getID() == ID) {
                        customerArray[i].printCustomer();
                        found = 1;
                        break;
                    }
                }
            }
            if (found == 0) {
                System.out.println("No operator/customer was found with ID " + ID + ". Please try again.");
            }
            newScanner.close();
            scanner.close();

        } catch (Exception e) {
            System.err.println("An exception occurred: " + e.getClass().getSimpleName() + ": " + e.getMessage());
        }

    }

    private static int containEmptyStr(String[] strArr) {
        // checks if the string array contains an empty string
        for (String currStr : strArr) {
            if (currStr.equals("")) //
                return 1;
        }

        return 0;
    }

    private static int isIDUnique(int id, operator[] operatorArr, int opCount, customer[] customerArr,
            int custCount) {

        // checks if the id is unique by comparing with all operators
        for (int i = 0; i < opCount; i++) {
            if (operatorArr[i].getID() == id) {
                return 0;
            }
        }
        // checks if the id is unique by comparing with all customers
        for (int i = 0; i < custCount; i++) {
            if (customerArr[i].getID() == id) {
                return 0;
            }
        }

        return 1;
    }
}
