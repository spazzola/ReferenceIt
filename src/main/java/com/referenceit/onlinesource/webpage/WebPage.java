package com.referenceit.onlinesource.webpage;

import com.referenceit.otherprintsource.OtherPrintSource;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
public class WebPage extends OtherPrintSource {

    private String responsibleOrganisation;
    private String availableFrom;
    private String accessedDate;

}
