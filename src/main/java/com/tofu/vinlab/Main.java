package com.tofu.vinlab;

import com.tofu.vinlab.entities.Product;
import com.tofu.vinlab.entities.DiscountedProduct;
import com.tofu.vinlab.interfaces.Buyable;

/**
 * @file Main.java
 * @brief Главный класс приложения Vinlab
 * @author VinLab Team
 * @version 1.0
 * @date 2025
 */

/**
 * @mainpage VinLab Project Documentation
 *
 * @section intro_sec Введение
 *
 * Проект VinLab представляет собой систему управления товарами
 * с поддержкой операций покупки и учета скидок.
 *
 * @section classes_sec Основные классы
 * - Product: Базовый класс товара
 * - DiscountedProduct: Товар со скидкой
 * - Buyable: Интерфейс покупаемого товара
 *
 * @section usage_sec Использование
 *
 * Пример использования системы:
 * @code
 * Product bottles = new Product(1, "Вино", 1000.0, 10);
 * double total = bottle.buy(2);
 * @endcode
 */
public class Main {

    /**
     * @brief Главный метод приложения
     * @param args - аргументы командной строки
     *
     * Демонстрирует работу с классами Product и DiscountedProduct,
     * включая операции покупки через интерфейс Buyable.
     */
    public static void main(String[] args) {
        // Демонстрация базового товара
        Product product = new Product(1, "Vine", 1000.0, 5, "Proseco");
        demonstrateProduct(product);

        // Демонстрация товара со скидкой
        DiscountedProduct discountedProduct = new DiscountedProduct(2, "Shato", 500.0, 10, 15.0);
        demonstrateProduct(discountedProduct);

        // Демонстрация через интерфейс
        demonstrateBuyableInterface(product);
        demonstrateBuyableInterface(discountedProduct);
    }

    /**
     * @brief Демонстрация работы с товаром
     * @param product - демонстрируемый товар
     */
    private static void demonstrateProduct(Product product) {
        System.out.println("=== Демонстрация товара ===");
        System.out.println("Товар: " + product);
        System.out.println("Доступно 3 единицы: " + product.isAvailable(3));

        try {
            double total = product.buy(2);
            System.out.printf("Куплено 2 единицы. Общая стоимость: %.2f\n", total);
            System.out.println("Остаток на складе: " + product.getStockQuantity());
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка покупки: " + e.getMessage());
        }
        System.out.println();
    }

    /**
     * @brief Демонстрация работы через интерфейс Buyable
     * @param item - объект реализующий интерфейс Buyable
     */
    private static void demonstrateBuyableInterface(Buyable item) {
        System.out.println("=== Демонстрация через интерфейс ===");
        System.out.println("Доступно 5 единиц: " + item.isAvailable(5));

        try {
            double total = item.buy(1);
            System.out.printf("Куплено через интерфейс. Стоимость: %.2f\n", total);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка покупки через интерфейс: " + e.getMessage());
        }
        System.out.println();
    }
}