package com.ertugrul.springbootmongo.converter;

import com.ertugrul.springbootmongo.dto.CategoryDto;
import com.ertugrul.springbootmongo.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoryConverter {

    CategoryConverter INSTANCE = Mappers.getMapper(CategoryConverter.class);

    CategoryDto convertCategoryToCategoryDto(Category category);

    List<CategoryDto> convertAllCategoryListToCategoryDtoList(List<Category> categoryList);

    Category convertCategoryDtoToCategory(CategoryDto categoryDto);

}
