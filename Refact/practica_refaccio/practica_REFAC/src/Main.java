import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String p = "Proves";

        int opcio;
        do {
            System.out.println("1. ");
            System.out.println("2. ");
            System.out.println("3. ");
            System.out.println("4. ");
            System.out.println("5. ");
            System.out.println("0. Acabar");

            opcio = scan.nextInt();
            scan.nextLine();
            switch (opcio) {
                case 1:
                    System.out.println("intro: ");
                    int num1 = scan.nextInt();
                    System.out.println("intro: ");
                    int num2 = scan.nextInt();
                    if (max(num1,num2)) {
                        System.out.println("aaa");
                    }
                    else System.out.println("bbb");
                    break;
                case 2:
                    double a=2;
                    double b=3;
                    double c=1;
                    calcEquacioSegongrau(a, b, c);
                    break;
                case 3:
                    List<OrderLineItem> lineItems = null;
                    Order asd = new Order(lineItems, 5.5);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("ATENCIÓ!!! \nHa de ser un valor entre 0 i 5");
            }
        } while (opcio != 0);
    }
    public static boolean max(int a, int b) {
        if(a > b) {
            return true;
        } else if (a == b) {
            return false;
        } else {
            return false;
        }
    }

    //REFACT: Aqui he aplicat Extraccio de metode, creant metodes de print

    public static void calcEquacioSegongrau(double a, double b, double c) {
        double D = b * b - 4 * a * c;
        if (D > 0) {
            double x1, x2;
            x1 = (-b - Math.sqrt(D)) / (2 * a);
            x2 = (-b + Math.sqrt(D)) / (2 * a);
            printRutes(x1,x2);
        }
         if (D == 0) {
            double x;
            x = -b / (2 * a);
             printUnaRuta(x);
        }
        else {
            zeroRutes();
        }
    }

    public static void printRutes(double x1, double x2){
        System.out.println("x1 = " + x1 + ", x2 = " + x2);
    }

    public static void printUnaRuta(double x){
        System.out.println("x = " + x);
    }

    public static void zeroRutes(){
        System.out.println("Equation has no roots");
    }



    //REFACT: En aquest cas, aqui he aplicat extraccio de classe, he creat una clase anomenat com Adreça
    public class Human {
        private String name;
        private String age;
        private Adreca adreca;

        public Human(String name, String age, Adreca adreca) {
            this.name = name;
            this.age = age;
            this.adreca = adreca;
        }
        public Adreca getAdreca(){
            return adreca;
        }

    }

    public static class Order {
        private List<OrderLineItem> lineItems;
        private double taxRate;

        public Order(List<OrderLineItem> lineItems, double taxRate) {
            this.lineItems = lineItems;
            this.taxRate = taxRate;
        }

        //REFACT: En aquest cas aqui he aplicat Extraccio de metode creant el metode calculaSubtotal()
        public double calculateTotalPrice() {
            double subtotal = calculaSubtotal();
            double tax = subtotal * taxRate;
            return subtotal + tax;
        }

        private double calculaSubtotal() {
            double subtotal = 0.0;
            for (OrderLineItem item : lineItems) {
                subtotal += item.getPrice();
            }
            return subtotal;
        }
    }



     public class OrderLineItem {
        private String productName;
        private int quantity;
        private double price;

        public OrderLineItem(String productName, int quantity, double price) {
            this.productName = productName;
            this.quantity = quantity;
            this.price = price;
        }
        public double getPrice() {
            return price * quantity;
        }
    }

    public  class Customer {
        private String firstName;
        private String lastName;

        public Customer(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public String getFullName() {
            return firstName + " " + lastName;
        }
    }
}