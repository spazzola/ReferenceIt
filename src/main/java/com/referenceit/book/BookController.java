package com.referenceit.book;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


@AllArgsConstructor
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/book")
public class BookController {

    private BookService bookService;


    @PostMapping("/create")
    public BookResponse generateBookReferences(@RequestBody BookDto bookDto) {
        return bookService.generateReference(bookDto);
    }

}
