package com.referenceit.journalarticles;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/journalarticle")
public class JournalArticleController {

    private JournalArticleService journalArticleService;


    @PostMapping("/create")
    public JournalArticleResponse generateBookReferences(@RequestBody JournalArticleDto journalArticleDto) {

        return journalArticleService.generateReferences(journalArticleDto);
    }

}
