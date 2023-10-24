package task3;

import java.util.Scanner;

public class Price {

    private String nameProduct;
    private String nameShop;
    private double priceInUAH;

    public Price(String nameProduct, String nameShop, double priceInUAH) {
        this.nameProduct = nameProduct;
        this.nameShop = nameShop;
        this.priceInUAH = priceInUAH;
    }

    public String getNameShop() {
        return nameShop;
    }

    public int compareTo(Price other) {
        return nameShop.compareTo(other.nameShop);
    }

    public String toString() {
        return "Магазин: " + nameShop + ", Товар: " + nameProduct + ", Ціна: " + priceInUAH + " грн";
    }
}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Price[] prices = new Price[3];
        for (int i = 0; i < 3; i++) {
            System.out.println("Введіть дані про товар " + (i + 1));
            System.out.print("Назва товару: ");
            String nameProduct = scanner.nextLine();

            System.out.print("Назва магазину: ");
            String nameShop = scanner.nextLine();

            System.out.print("Ціна товару в гривнях: ");
            double priceInUAH = Integer.parseInt(scanner.nextLine());

            prices[i] = new Price(nameProduct, nameShop, priceInUAH);

            System.out.print("Введіть назву магазину для пошуку товарів: ");
            String searchShop = scanner.nextLine();

            boolean shopFound = false;

            for (Price price : prices) {
                if (price.getNameShop().equalsIgnoreCase(searchShop)) {
                    System.out.println(price);
                    shopFound = true;
                }
            }

            if (!shopFound) {
                System.err.println("Магазин з назвою '" + searchShop + "' не знайдено.");
            }
        }
    }
}