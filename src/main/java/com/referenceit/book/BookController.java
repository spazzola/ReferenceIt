package com.referenceit.book;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@AllArgsConstructor
@RestController
@RequestMapping("/book")
public class BookController {

    private BookService bookService;


    @PostMapping("/create")
    public BookResponse generateBookReferences(@RequestBody BookDto bookDto) {

        return bookService.generateReferences(bookDto);
    }

}
