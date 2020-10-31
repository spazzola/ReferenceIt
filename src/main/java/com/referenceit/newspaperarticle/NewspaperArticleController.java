package com.referenceit.newspaperarticle;

import com.referenceit.reference.ReferenceResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/newspaperarticle")
public class NewspaperArticleController {

    private NewspaperArticleService newspaperArticleService;

    @PostMapping("/create")
    public ReferenceResponse generateNewspaperArticleReferences(@RequestBody NewspaperArticleDto newspaperArticleDto) {
        return newspaperArticleService.generateReference(newspaperArticleDto);
    }

}
