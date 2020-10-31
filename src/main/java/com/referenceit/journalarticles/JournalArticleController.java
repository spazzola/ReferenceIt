package com.referenceit.journalarticles;

import com.referenceit.reference.ReferenceResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/journalarticle")
public class JournalArticleController {

    private JournalArticleService journalArticleService;


    @PostMapping("/create")
    public ReferenceResponse generateBookReferences(@RequestBody JournalArticleDto journalArticleDto) {

        return journalArticleService.generateReference(journalArticleDto);
    }

}
