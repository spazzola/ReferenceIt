package com.referenceit.journalarticles;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/journalarticle")
public class JournalArticleController {

    private JournalArticleService journalArticleService;


    @PostMapping("/create")
    public JournalArticleResponse generateBookReferences(@RequestBody JournalArticleDto journalArticleDto) {

        return journalArticleService.generateReferences(journalArticleDto);
    }

}
