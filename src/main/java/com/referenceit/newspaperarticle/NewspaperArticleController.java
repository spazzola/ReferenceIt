package com.referenceit.newspaperarticle;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/newspaperarticle")
public class NewspaperArticleController {

    private NewspaperArticleService newspaperArticleService;

    @PostMapping("/create")
    public NewspaperArticleResponse generateNewspaperArticleReferences(@RequestBody NewspaperArticleDto newspaperArticleDto) {
        return newspaperArticleService.generateReference(newspaperArticleDto);
    }

}
