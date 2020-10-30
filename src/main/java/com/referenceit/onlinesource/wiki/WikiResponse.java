package com.referenceit.onlinesource.wiki;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WikiResponse {

    private String authorAndYearPart;
    private String title;
    private String restReferenceBodyPart;

}
