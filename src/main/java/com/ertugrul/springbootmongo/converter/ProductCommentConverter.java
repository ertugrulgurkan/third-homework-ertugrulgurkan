package com.ertugrul.springbootmongo.converter;

import com.ertugrul.springbootmongo.dto.ProductCommentDto;
import com.ertugrul.springbootmongo.entity.ProductComment;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductCommentConverter {
    ProductCommentConverter INSTANCE = Mappers.getMapper(ProductCommentConverter.class);

    ProductComment convertProductCommentDtoToProductComment(ProductCommentDto productCommentDto);

    ProductCommentDto convertProductCommentToProductCommentDto(ProductComment productComment);

    List<ProductCommentDto> convertAllProductCommentListToProductCommentDtoList(List<ProductComment> productCommentList);
}
