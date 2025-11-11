package com.tofu.vinlab.service;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.tofu.vinlab.entities.product.Product;
import com.tofu.vinlab.interfaces.Buyable;

public class ProductDemoService {
    private static final Logger logger = Logger.getLogger(ProductDemoService.class.getName());

    /**
     * @brief Демонстрация работы через интерфейс Buyable
     * @param item - объект реализующий интерфейс Buyable
     */
    public void demonstrateBuyableInterface(Buyable item) {
        logger.info("=== Демонстрация через интерфейс ===");
        logger.log(Level.INFO, "Доступно 5 единиц: {0}", item.isAvailable(5));

        try {
            double total = item.buy(1);
            logger.log(Level.INFO, "Куплено через интерфейс. Стоимость: %.2f %n", total);
        } catch (IllegalArgumentException e) {
            logger.log(Level.WARNING, "Ошибка покупки через интерфейс: {}", e.getMessage());
        }
        logger.info("%n");
    }

    /**
     * @brief Демонстрация работы с товаром
     * @param product - демонстрируемый товар
     */
    public void demonstrateProduct(Product product) {
        logger.info("=== Демонстрация товара ===");
        logger.info("Товар: " + product);
        logger.info("Доступно 3 единицы: " + product.isAvailable(3));

        try {
            double total = product.buy(2);
            logger.log(Level.INFO, "Куплено 2 единицы. Общая стоимость: %.2f%n", total);
            logger.log(Level.INFO, "Остаток на складе: %d",  product.getStockQuantity());
        } catch (IllegalArgumentException e) {
            logger.warning("Ошибка покупки: " + e.getMessage());
        }
        logger.info("%n");
    }
}
