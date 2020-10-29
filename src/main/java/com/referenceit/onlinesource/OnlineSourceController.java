package com.referenceit.onlinesource;

import com.referenceit.onlinesource.blog.BlogDto;
import com.referenceit.onlinesource.blog.BlogResponse;
import com.referenceit.onlinesource.blog.BlogService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/onlinesource")
public class OnlineSourceController {

    private BlogService blogService;


    @PostMapping("/blog/create")
    public BlogResponse generateBlogResponse(@RequestBody BlogDto blogDto) {
        return blogService.generateReference(blogDto);
    }

}
