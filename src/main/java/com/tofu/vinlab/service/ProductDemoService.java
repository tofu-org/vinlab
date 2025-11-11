package com.tofu.vinlab.service;

import java.util.logging.Logger;

import com.tofu.vinlab.entities.product.Product;
import com.tofu.vinlab.interfaces.Buyable;

public class ProductDemoService {
    private static final Logger logger = Logger.getLogger(ProductDemoService.class.getName());

    public ProductDemoService() {}

    /**
     * @brief Демонстрация работы через интерфейс Buyable
     * @param item - объект реализующий интерфейс Buyable
     */
    public void demonstrateBuyableInterface(Buyable item) {
        logger.info("=== Демонстрация через интерфейс ===");
        logger.info("Доступно 5 единиц: " + item.isAvailable(5));

        try {
            double total = item.buy(1);
            logger.info(String.format("Куплено через интерфейс. Стоимость: %.2f %n", total));
        } catch (IllegalArgumentException e) {
            logger.warning("Ошибка покупки через интерфейс: " + e.getMessage());
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
            logger.info(String.format("Куплено 2 единицы. Общая стоимость: %.2f\n", total));
            logger.info("Остаток на складе: " + product.getStockQuantity());
        } catch (IllegalArgumentException e) {
            logger.warning("Ошибка покупки: " + e.getMessage());
        }
        logger.info("%n");
    }
}
