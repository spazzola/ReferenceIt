package com.referenceit.otherprintsource.musicscore;

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
public class MusicScoreDto {

    private List<Author> authors;
    private String year;
    private String title;
    private String publicationPlace;
    private String publisher;

}
