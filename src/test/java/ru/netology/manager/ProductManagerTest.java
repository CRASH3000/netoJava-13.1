package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.repository.ProductRepository;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.domain.TShirt;


class ProductManagerTest {
    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);
    Product book1 = new Book(1, "Гарри Поттер и филосовский камень", 600, "Дж.К. Роулинг", 432, 2007);
    Product book2 = new Book(2, "Ходячий замок", 483, "Диана Джонс", 445, 2020);
    Product book3 = new Book(3, "Легенды и мифы Древней Японии", 1900, "Дэвис Хэдленд", 560, 2019);
    Product smartphone1 = new Smartphone(4, "MI 9", 25_000, "Xiaomi", "MIUI");
    Product smartphone2 = new Smartphone(5, "iPhone 7", 40_000, "Apple", "iOS");
    Product smartphone3 = new Smartphone(6, "Pixel", 30_000, "Google", "Android");
    Product TShirt1 = new TShirt(7, "polo", 582, "White", "XL");
    Product TShirt2 = new TShirt(8, "Футболка Death Note", 600, "Black", "M/L");
    Product TShirt3 = new TShirt(9, "Хлопковая футболка Гарри Поттер", 275, "Black", "S");

    @Test
    void addTest() {
        manager.add(book1);
        Product[] expected = {book1};
        Product[] actual = repository.getAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void addAllTest() {
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(TShirt1);
        Product[] expected = {book2, smartphone1, TShirt1};
        Product[] actual = repository.getAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void searchTestName() {
        manager.add(book2);
        manager.add(smartphone2);
        manager.add(TShirt2);
        String name = "Ходящий замок";
        Product[] expected = {};
        Product[] actual = manager.searchBy(name);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void searchTestAuthor() {
        manager.add(book3);
        manager.add(smartphone2);
        manager.add(TShirt1);
        String author = "Дэвис Хэдленд";
        Product[] expected = {};
        Product[] actual = manager.searchBy(author);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void searchTestOs() {
        manager.add(book1);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
        manager.add(TShirt1);
        String os = "Android";
        Product[] expected = {};
        Product[] actual = manager.searchBy(os);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void searchTestManufacturer() {
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
        String manufacturer = "Apple";
        Product[] expected = {};
        Product[] actual = manager.searchBy(manufacturer);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void searchTestСolorr() {
        manager.add(TShirt1);
        manager.add(TShirt2);
        manager.add(TShirt3);
        manager.add(smartphone1);
        String color = "Black";
        Product[] expected = {};
        Product[] actual = manager.searchBy(color);
        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    void searchTestAll() {
        manager.add(book1);
        manager.add(smartphone1);
        manager.add(TShirt3);
        String name = "Гарри Поттер";
        Product[] expected = {book1, TShirt3};
        Product[] actual = manager.searchBy(name);
        Assertions.assertArrayEquals(expected, actual);
    }


}
