package entities;

import interfaces.Buyable;

/**
 * @file DiscountedProduct.java
 * @brief Производный класс товара со скидкой
 * @author VinLab Team
 * @version 1.0
 * @date 2024
 */

/**
 * @class DiscountedProduct
 * @brief Класс товара со скидкой, наследуется от Product
 *
 * Данный класс расширяет функциональность базового класса Product,
 * добавляя поддержку скидок на товары.
 *
 * @extends Product
 */
public class DiscountedProduct extends Product {

    /** @brief Размер скидки в процентах (0-100) */
    private double discountPercent;

    /**
     * @brief Конструктор товара со скидкой
     * @param id - идентификатор товара
     * @param name - название товара
     * @param price - исходная цена
     * @param stockQuantity - количество на складе
     * @param discountPercent - процент скидки
     */
    public DiscountedProduct(int id, String name, double price, int stockQuantity, double discountPercent) {
        super(id, name, price, stockQuantity);
        setDiscountPercent(discountPercent);
    }

    /**
     * @brief Получить цену со скидкой
     * @return double - цена с учетом скидки
     */
    public double getDiscountedPrice() {
        return getPrice() * (1 - discountPercent / 100);
    }

    /**
     * @brief Выполнить покупку товара со скидкой
     * @param quantity - количество товара
     * @return double - общая стоимость со скидкой
     */
    @Override
    public double buy(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Количество должно быть положительным");
        }

        if (!isAvailable(quantity)) {
            throw new IllegalArgumentException("Недостаточно товара на складе");
        }

        setStockQuantity(getStockQuantity() - quantity);
        return getDiscountedPrice() * quantity;
    }

    /**
     * @brief Получить размер скидки
     * @return double - процент скидки
     */
    public double getDiscountPercent() {
        return discountPercent;
    }

    /**
     * @brief Установить размер скидки
     * @param discountPercent - новый процент скидки
     * @throws IllegalArgumentException если скидка не в диапазоне 0-100
     */
    public void setDiscountPercent(double discountPercent) {
        if (discountPercent < 0 || discountPercent > 100) {
            throw new IllegalArgumentException("Скидка должна быть в диапазоне 0-100%");
        }
        this.discountPercent = discountPercent;
    }

    /**
     * @brief Строковое представление товара со скидкой
     * @return String - строковое представление
     */
    @Override
    public String toString() {
        return String.format("DiscountedProduct{id=%d, name='%s', price=%.2f, discount=%.1f%%, stock=%d}",
                getId(),
                getName(),
                getDiscountedPrice(),
                discountPercent,
                getStockQuantity()
        );
    }
}