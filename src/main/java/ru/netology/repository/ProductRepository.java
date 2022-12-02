package ru.netology.repository;

import ru.netology.domain.Product;

public class ProductRepository {
    private Product[] products = new Product[0];

    public void save(Product product) {
        int length = products.length + 1;
        Product[] tmp = new Product[length];
        System.arraycopy(products, 0, tmp, 0, products.length);
        int last = tmp.length - 1;
        tmp[last] = product;
        products = tmp;
    }

    public Product[] getAll() {
        return products;
    }


    public void removeId(int id) {

        if (findById(id) == null) {
            throw new NotFoundException("По вашему id: " + id + " ничего не найдено");
        }

        int length = products.length - 1;
        Product[] tmp = new Product[length];
        int index = 0;
        for (Product product : products) {
            if (product.getId() != id) {
                tmp[index] = product;
                index++;
            }
        }
        products = tmp;
        // return products;
    }


    public Product findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }


}





