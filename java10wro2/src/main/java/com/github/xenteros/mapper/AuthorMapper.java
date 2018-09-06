package com.github.xenteros.mapper;

import com.github.xenteros.dto.AuthorDto;
import com.github.xenteros.model.Author;
import com.github.xenteros.model.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toList;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
abstract class AuthorMapper {


    @Mappings({
            @Mapping(source = "address.street", target = "street"),
            @Mapping(source = "address.city", target = "city"),
            @Mapping(source = "address.state", target = "state")
    })
    abstract AuthorDto toAuthorDto(Author author);

    List<String> map(Set<Book> bookSet) {
        return bookSet.stream().map(Book::getTitle).collect(toList());
    }

}
