package com.referenceit.onlinesource.software;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SoftwareResponse {

    private String authorAndYearPart;
    private String titlePart;
    private String restReferenceBodyPart;

}
