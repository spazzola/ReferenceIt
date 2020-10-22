package com.referenceit.newspaperarticle;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/newspaperarticle")
public class NewspaperArticleController {

    private NewspaperArticleService newspaperArticleService;

    @PostMapping("/create")
    public NewspaperArticleResponse generateNewspaperArticleReferences(@RequestBody NewspaperArticleDto newspaperArticleDto) {
        return newspaperArticleService.generateReference(newspaperArticleDto);
    }

}
