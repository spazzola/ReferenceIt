package com.referenceit.onlinesource.onlinefilm;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OnlineFilmResponse {

    private String authorAndYearPart;
    private String titlePart;
    private String restReferenceBodyPart;

}
