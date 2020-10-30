package com.referenceit.onlinesource.onlineimage;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OnlineImageResponse {

    private String authorAndYearPart;
    private String titlePart;
    private String restReferenceBodyPart;

}
