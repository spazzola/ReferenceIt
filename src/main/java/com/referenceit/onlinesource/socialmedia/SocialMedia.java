package com.referenceit.onlinesource.socialmedia;

import com.referenceit.otherprintsource.OtherPrintSource;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
public class SocialMedia extends OtherPrintSource {

    private String websiteTitle;
    private String dayAndMonth;
    private String availableFrom;
    private String accessedDate;

}
