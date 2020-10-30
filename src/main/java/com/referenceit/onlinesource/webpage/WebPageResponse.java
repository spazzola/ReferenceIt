package com.referenceit.onlinesource.webpage;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WebPageResponse {

    private String authorAndYearPart;
    private String titlePart;
    private String restReferenceBodyPart;

}
