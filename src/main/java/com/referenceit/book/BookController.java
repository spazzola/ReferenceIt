package com.referenceit.book;

import com.referenceit.reference.ReferenceResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


@AllArgsConstructor
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/book")
public class BookController {

    private BookService bookService;


    @PostMapping("/create")
    public ReferenceResponse generateBookReferences(@RequestBody BookDto bookDto) {
        return bookService.generateReference(bookDto);
    }

}
