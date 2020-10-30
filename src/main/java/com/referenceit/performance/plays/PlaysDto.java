package com.referenceit.performance.plays;

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
public class PlaysDto {

    private String title;
    private List<Author> authors;
    private String year;
    private String directorName;
    private String companyName;
    private String location;
    private String seenDate;

}
