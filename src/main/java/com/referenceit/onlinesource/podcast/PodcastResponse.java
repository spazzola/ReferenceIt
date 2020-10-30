package com.referenceit.onlinesource.podcast;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PodcastResponse {

    private String authorAndYearPart;
    private String titlePart;
    private String restReferenceBodyPart;

}
