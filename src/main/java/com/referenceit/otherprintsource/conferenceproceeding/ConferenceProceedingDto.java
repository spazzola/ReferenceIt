package com.referenceit.otherprintsource.conferenceproceeding;

import com.referenceit.reference.Author;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConferenceProceedingDto {

    private List<Author> authors;
    private String year;
    private String publicationPlace;
    private String publisher;
    private String title;
    private String titleOfConferenceProceedings;
    private String place;
    private String monthAndYear;
    private String pages;

}
