package com.tofu.vinlab;

import com.tofu.vinlab.entities.product.Product;
import com.tofu.vinlab.entities.product.DiscountedProduct;
import com.tofu.vinlab.service.ProductDemoService;

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
        ProductDemoService demoService = new ProductDemoService();

        // Демонстрация базового товара
        Product product = new Product(1, "Vine", 1000.0, 5, "Proseco");
        demoService.demonstrateProduct(product);

        // Демонстрация товара со скидкой
        DiscountedProduct discountedProduct = new DiscountedProduct(2, "Shato", 500.0, 10, 15.0);
        demoService.demonstrateProduct(discountedProduct);

        // Демонстрация через интерфейс
        demoService.demonstrateBuyableInterface(product);
        demoService.demonstrateBuyableInterface(discountedProduct);
    }
}
