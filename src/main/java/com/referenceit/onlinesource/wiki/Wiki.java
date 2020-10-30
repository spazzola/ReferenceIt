package com.referenceit.onlinesource.wiki;

import com.referenceit.otherprintsource.OtherPrintSource;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
public class Wiki extends OtherPrintSource {

    private String availableFrom;
    private String accessedDate;

}
