package com.example.demoswagger.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.Collection;

@RestController
@RequestMapping("/api/book")
public class BookController {

//    @Autowired
//    private BookRepository repository;
    @Operation(summary = "Get a book by its id")
    @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Found the book",
            content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Book.class)) }),
    @ApiResponse(responseCode = "400", description = "Invalid id supplied",
            content = @Content),
    @ApiResponse(responseCode = "404", description = "Book not found",
            content = @Content) })
    @GetMapping("/{id}")
    public String findById(@PathVariable long id) {
        return "get";
    }

    @GetMapping("/")
    public String findBooks() {
        return "get collection";
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String updateBook(
            @PathVariable("id") final String id, @RequestBody final Book book) {
        return "update";
    }
}
