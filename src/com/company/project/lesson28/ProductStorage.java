package com.company.project.lesson28;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class ProductStorage {
    private final List<Product> products;
    private final File file = new File("save.txt");
    private final int maxSize;

    public ProductStorage(List<Product> products, int maxSize) {
        this.products = products;
        this.maxSize = maxSize;
    }
    synchronized public void addProductToList(Product product)
              throws InterruptedException {
            while (products.size() /* == */ >= maxSize) wait();
            products.add(product);
            notify();
        product.add(product);
    }
    synchronized public void writeProductsFromList()
            throws InterruptedException {
        while (products.size() == 0) wait();
        Product removed = products.remove(0);
        try {
            Files.writeString(file.toPath(), removed.toString(),
                    StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        notify();
    }
}
