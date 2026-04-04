package dev.davisantos.library_api.dto;

import dev.davisantos.library_api.entities.Book;

public class BookDto {

    private Long id;

    public BookDto(Long id){
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
