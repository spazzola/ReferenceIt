package com.referenceit.onlinesource.marketresearch;

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
public class MarketResearchDto {

    private List<Author> authors;
    private String year;
    private String date;
    private String title;
    private String edition;
    private String availableFrom;
    private String accessedDate;

}
