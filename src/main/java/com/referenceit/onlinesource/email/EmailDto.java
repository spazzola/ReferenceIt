package com.referenceit.onlinesource.email;

import com.referenceit.reference.Author;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmailDto {

    private List<Author> authors;
    private String year;
    private String title;
    private String electronicConference;
    private String dayAndMonth;
    private String availableFrom;
    private String accessedDate;
}
