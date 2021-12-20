package com.ertugrul.springbootmongo.repository;

import com.ertugrul.springbootmongo.entity.ProductComment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCommentRepository extends MongoRepository<ProductComment, String> {
}
