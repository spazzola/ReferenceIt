package com.referenceit.onlinesource.blog;

import com.referenceit.otherprintsource.OtherPrintSource;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
public class Blog extends OtherPrintSource {

    private String postingTitle;
    private String siteTitle;
    private String dayAndMonth;
    private String availableFrom;
    private String accessedDate;

}
