package com.referenceit.onlinesource.email;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmailResponse {

    private String authorAndYearPart;
    private String titlePart;
    private String electronicConference;
    private String restReferenceBodyPart;

}
