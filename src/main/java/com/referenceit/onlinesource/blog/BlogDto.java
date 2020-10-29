package com.referenceit.onlinesource.blog;

import com.referenceit.reference.Author;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BlogDto {

    private List<Author> authors;
    private String year;
    private String postingTitle;
    private String siteTitle;
    private String dayAndMonth;
    private String availableFrom;
    private String accessedDate;

}
