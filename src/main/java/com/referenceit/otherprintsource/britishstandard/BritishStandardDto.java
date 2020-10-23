package com.referenceit.otherprintsource.britishstandard;

import com.referenceit.otherprintsource.OtherPrintSource;
import com.referenceit.reference.Author;
import com.referenceit.reference.Reference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class BritishStandardDto  {

    private List<Author> authors;
    private String year;
    private String publicationPlace;
    private String publisher;
    private String authorisingOrganisationName;
    private String titleOfStandard;

}
