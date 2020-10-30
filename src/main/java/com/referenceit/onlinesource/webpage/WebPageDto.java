package com.referenceit.onlinesource.webpage;

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
public class WebPageDto {

    private List<Author> authors;
    private String year;
    private String title;
    private String responsibleOrganisation;
    private String availableFrom;
    private String accessedDate;

}
