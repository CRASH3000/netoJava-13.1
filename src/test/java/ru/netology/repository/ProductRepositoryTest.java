package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.domain.TShirt;

public class ProductRepositoryTest {

    ProductRepository repository = new ProductRepository();

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
    public void saveOneProduct() {
        repository.save(smartphone1);
        Product[] expected = {smartphone1};
        Product[] actual = repository.getAll();
        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void SearchAll() {
        repository.save(book1);
        repository.save(smartphone1);
        repository.save(TShirt1);
        Product[] expected = {book1, smartphone1, TShirt1};
        Product[] actual = repository.getAll();
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void removeId() {
        repository.save(book1);
        repository.save(smartphone1);
        repository.save(TShirt1);
        repository.removeId(4);
        Product[] expected = {book1, TShirt1};
        Product[] actual = repository.getAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeAllId() {
        repository.save(book2);
        repository.save(smartphone2);
        repository.save(TShirt2);
        repository.removeId(2);
        repository.removeId(5);
        repository.removeId(8);
        Product[] expected = {};
        Product[] actual = repository.getAll();
        Assertions.assertArrayEquals(expected, actual);
    }


}
