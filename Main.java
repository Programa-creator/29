package org.example;

import java.util.Scanner;

public class Main {
    private static ProductRepository productRepository = new ProductRepository();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cart cart = new Cart();

        while (true) {
            System.out.println("1. Show all products");
            System.out.println("2. Show product by id");
            System.out.println("3. Add product to cart");
            System.out.println("4. Remove product from cart");
            System.out.println("5. Show all products in cart");
            System.out.println("6. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    showAllProducts();
                    break;
                case 2:
                    showProductById();
                    break;
                case 3:
                    addProductToCart(cart);
                    break;
                case 4:
                    removeProductFromCart(cart);
                    break;
                case 5:
                    showAllProductsInCart(cart);
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private static void showAllProducts() {
        System.out.println("All products:");
        for (Product product : productRepository.getAllProducts()) {
            System.out.println(product.getId() + ". " + product.getName() + " - " + product.getPrice());
        }
    }

    private static void showProductById() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product id:");
        int id = scanner.nextInt();
        Product product = productRepository.getProductById(id);
        if (product != null) {
            System.out.println(product.getId() + ". " + product.getName() + " - " + product.getPrice());
        } else {
            System.out.println("Product not found");
        }
    }

    private static void addProductToCart(Cart cart) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product id:");
        int id = scanner.nextInt();
        Product product = productRepository.getProductById(id);
        if (product != null) {
            cart.addProduct(product);
            System.out.println("Product added to cart");
        } else {
            System.out.println("Product not found");
        }
    }

    private static void removeProductFromCart(Cart cart) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product id:");
        int id = scanner.nextInt();
        cart.removeProduct(id);
        System.out.println("Product removed from cart");
    }

    private static void showAllProductsInCart(Cart cart) {
        System.out.println("All products in cart:");
        for (Product product : cart.getAllProducts()) {
            System.out.println(product.getId() + ". " + product.getName() + " - " + product.getPrice());
        }
    }
}
