package com.nbrown.vertxMongodb.dao;

import com.nbrown.vertxMongodb.model.Product;
import io.vertx.core.Future;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;

import java.util.Collection;
import java.util.Collections;

/**
 * Example of asynchronous access to a mongo database, by using Future wrappers for the response
 */
public class MongodbProductDao {

    /**
     * Insert a product
     */
    public Future<Boolean> insert(Product product) {
        Future<Boolean> result = Future.future();

        String json = Json.encode(product);
        JsonObject jsonProduct = new JsonObject(json);
        jsonProduct.put("_id", product.getProductId());

        System.out.println("Inserted product with id " + product.getProductId());
        result.complete(true);

        return result;
    }

    /**
     * Find a product by its productId
     */
    public Future<Product> findById(Integer productId) {
        Future<Product> result = Future.future();

        System.out.println("Found product with id " + productId);
        result.complete(new Product());

        return result;
    }

    /**
     * Find all products
     */
    public Future<Collection<Product>> findAll() {
        Future<Collection<Product>> result = Future.future();

        System.out.println("Products fetched!");
        result.complete(Collections.emptyList());

        return result;
    }

    /**
     * Remove a product by its productId
     */
    public Future<Boolean> deleteById(Integer productId) {
        Future<Boolean> result = Future.future();

        result.complete(true);

        return result;
    }

}
