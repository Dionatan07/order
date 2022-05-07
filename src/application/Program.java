package application;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner teclado = new Scanner(System.in);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Enter client data: ");
        System.out.print("Name: ");
        String name = teclado.nextLine();

        System.out.print("Email: ");
        String email = teclado.nextLine();

        System.out.print("Birth date (DD/MM/YYYY): ");
        Date birthDate = sdf.parse(teclado.next());

        Client client = new Client(name, email, birthDate);

        System.out.println("");
        System.out.println("Enter order data:");
        System.out.print("status: ");
        OrderStatus status = OrderStatus.valueOf(teclado.next());

        Order order = new Order(new Date(), status, client);

        System.out.print("How many items to this order? ");
        int n = teclado.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.println("");
            System.out.println("Enter #" + i + " item data:");
            System.out.print("Product name: ");
            teclado.nextLine();
            String productName = teclado.nextLine();

            System.out.print("Product price: ");
            double productPrice = teclado.nextDouble();

            Product product = new Product(productName, productPrice);

            System.out.print("Quantity:");
            int quantity = teclado.nextInt();

            OrderItem orderItem = new OrderItem(quantity, productPrice, product);

            order.addItem(orderItem);

        }
        System.out.println();
        System.out.println(order);
    }


}
