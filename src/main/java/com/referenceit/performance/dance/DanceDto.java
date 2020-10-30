package com.referenceit.performance.dance;

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
public class DanceDto {

    private List<Author> authors;
    private String year;
    private String title;
    private String company;
    private String location;
    private String seenDate;

}
