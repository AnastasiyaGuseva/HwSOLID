package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Liskov substitution principle - наследники класса Product могуь быть взаимозаменимы
        Product[] products = {new ChemicalProduct(), new FoodProduct()};
        //принцип DRY - повторяющийся вывод списка продуктов на экран выносим в отдельный метод
        printProucts(products);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите номер товара и количество или введите `end` ");
            String input = scanner.nextLine();
            if ("end".equals(input)) break;
            String[] parts = input.split(" ");
            int productNumber = Integer.parseInt(parts[0]) - 1;
            products[productNumber].setCount(Integer.parseInt(parts[1]));
        }
        printProucts(products);
        printBasket(products);
    }

    private static void printProucts(Product[] products) {
        System.out.println("Список возможных товаров для покупки: ");
        for (int i = 0; i < products.length; i++) {
            System.out.println((i + 1) + ". " + products[i]);
        }
    }

    private static void printBasket(Product[] products) {
        int costProducts = 0;
        System.out.println("Ваша корзина: ");
        for (Product product : products) {
            if (product.getCount() != 0) {
                costProducts += product.getCount() * product.getPrice();
                System.out.println(product + " 'количество'= " + product.getCount() + " шт."
                        + " 'цена'= " + product.getPrice() + " "
                        + " 'стоимость'= " + product.getCount() * product.getPrice());
            }
        }
        System.out.println("Итого: " + costProducts);
    }
}