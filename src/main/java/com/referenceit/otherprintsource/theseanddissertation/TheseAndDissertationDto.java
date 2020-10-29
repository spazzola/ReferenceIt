package com.referenceit.otherprintsource.theseanddissertation;

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
public class TheseAndDissertationDto {

    private List<Author> authors;
    private String year;
    private String title;
    private String designation;
    private String degreeLevel;
    private String institution;

}
