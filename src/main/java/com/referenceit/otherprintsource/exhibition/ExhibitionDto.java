package com.referenceit.otherprintsource.exhibition;

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
public class ExhibitionDto {

    private List<Author> authors;
    private String title;
    private String year;
    private String publicationPlace;
    private String publisher;
    private String location;
    private String date;
    private String exhibitionCatalogue;
    private String itemType;
    private boolean isItemFromExhibition;

}
