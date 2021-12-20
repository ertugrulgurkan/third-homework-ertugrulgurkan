package com.ertugrul.springbootmongo.repository;

import com.ertugrul.springbootmongo.entity.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends MongoRepository<Category, String> {
}
