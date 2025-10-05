package entities;

import interfaces.Buyable;

/**
 * @file Product.java
 * @brief Класс товара для системы Vinlab
 * @author VinLab Team
 * @version 1.0
 * @date 2024
 */

/**
 * @class Product
 * @brief Основной класс представляющий товар в системе Vinlab
 *
 * Класс Product представляет товар с базовыми характеристиками:
 * идентификатор, название, цена, количество на складе.
 * Реализует интерфейс Buyable для поддержки операций покупки.
 *
 * @see Buyable
 */
public class Product implements Buyable {

    /** @brief Уникальный идентификатор товара */
    private int id;

    /** @brief Название товара */
    private String name;

    /** @brief Цена товара за единицу */
    private double price;

    /** @brief Количество товара на складе */
    private int stockQuantity;

    /** @brief Описание товара */
    private String description;

    /**
     * @brief Конструктор по умолчанию
     *
     * Создает товар с пустыми значениями и нулевой ценой.
     */
    public Product() {
        this.id = 0;
        this.name = "";
        this.price = 0.0;
        this.stockQuantity = 0;
        this.description = "";
    }

    /**
     * @brief Параметризированный конструктор
     * @param id - уникальный идентификатор товара
     * @param name - название товара
     * @param price - цена товара
     * @param stockQuantity - количество на складе
     *
     * Создает товар с указанными параметрами.
     */
    public Product(int id, String name, double price, int stockQuantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.description = "";
    }

    /**
     * @brief Полный конструктор
     * @param id - уникальный идентификатор товара
     * @param name - название товара
     * @param price - цена товара
     * @param stockQuantity - количество на складе
     * @param description - описание товара
     */
    public Product(int id, String name, double price, int stockQuantity, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.description = description;
    }

    // Реализация методов интерфейса Buyable

    /**
     * @brief Выполняет покупку товара
     * @param quantity - количество товара для покупки
     * @return double - общая стоимость покупки
     *
     * @throws IllegalArgumentException если quantity <= 0 или товара недостаточно на складе
     */
    @Override
    public double buy(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Количество должно быть положительным");
        }

        if (!isAvailable(quantity)) {
            throw new IllegalArgumentException("Недостаточно товара на складе");
        }

        this.stockQuantity -= quantity;
        return this.price * quantity;
    }

    /**
     * @brief Проверяет доступность товара
     * @param quantity - количество для проверки
     * @return boolean - true если товар доступен
     */
    @Override
    public boolean isAvailable(int quantity) {
        return this.stockQuantity >= quantity && quantity > 0;
    }

    // Геттеры и сеттеры

    /**
     * @brief Получить идентификатор товара
     * @return int - идентификатор товара
     */
    public int getId() {
        return id;
    }

    /**
     * @brief Установить идентификатор товара
     * @param id - новый идентификатор
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @brief Получить название товара
     * @return String - название товара
     */
    public String getName() {
        return name;
    }

    /**
     * @brief Установить название товара
     * @param name - новое название
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @brief Получить цену товара
     * @return double - цена товара
     */
    public double getPrice() {
        return price;
    }

    /**
     * @brief Установить цену товара
     * @param price - новая цена
     * @throws IllegalArgumentException если price < 0
     */
    public void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Цена не может быть отрицательной");
        }
        this.price = price;
    }

    /**
     * @brief Получить количество на складе
     * @return int - количество на складе
     */
    public int getStockQuantity() {
        return stockQuantity;
    }

    /**
     * @brief Установить количество на складе
     * @param stockQuantity - новое количество
     * @throws IllegalArgumentException если stockQuantity < 0
     */
    public void setStockQuantity(int stockQuantity) {
        if (stockQuantity < 0) {
            throw new IllegalArgumentException("Количество не может быть отрицательным");
        }
        this.stockQuantity = stockQuantity;
    }

    /**
     * @brief Получить описание товара
     * @return String - описание товара
     */
    public String getDescription() {
        return description;
    }

    /**
     * @brief Установить описание товара
     * @param description - новое описание
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @brief Получить строковое представление товара
     * @return String - строковое представление
     */
    @Override
    public String toString() {
        return String.format("Product{id=%d, name='%s', price=%.2f, stock=%d}",
                           id, name, price, stockQuantity);
    }
}