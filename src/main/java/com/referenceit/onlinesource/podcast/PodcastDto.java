package com.referenceit.onlinesource.podcast;

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
public class PodcastDto {

    private List<Author> authors;
    private String year;
    private String title;
    private String publisher;
    private String dayAndMonth;
    private String availableFrom;
    private String accessedDate;

}
