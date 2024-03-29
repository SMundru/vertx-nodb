package com.nbrown.vertxMongodb.service;

import java.util.Collection;

import com.nbrown.vertxMongodb.dao.MongodbProductDao;
import com.nbrown.vertxMongodb.model.Product;

import io.vertx.core.Future;
import io.vertx.core.Vertx;

public class ProductService implements IProductService {
    private MongodbProductDao productDao;

    /**
     * Provides asynchronous access to a mongo database, using a shared mongo client
     */
    public ProductService(Vertx vertx) {
		// Create the MongoDB client
    	productDao = new MongodbProductDao();
    }
    
    public Future<Boolean> create(Product e) {
        return productDao.insert(e);
    }

    public Future<Product> findById(Integer id) {
        return productDao.findById(id);
    }

    public Future<Collection<Product>> findAll() {
        return productDao.findAll();
    }

    public Future<Boolean> delete(Integer id) {
        return productDao.deleteById(id);
    }

}
