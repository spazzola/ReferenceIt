package com.referenceit.onlinesource.podcast;

import com.referenceit.otherprintsource.OtherPrintSource;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
public class Podcast extends OtherPrintSource {

    private String dayAndMonth;
    private String availableFrom;
    private String accessedDate;

}
