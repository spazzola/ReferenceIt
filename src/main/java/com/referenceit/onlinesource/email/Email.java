package com.referenceit.onlinesource.email;

import com.referenceit.otherprintsource.OtherPrintSource;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
public class Email extends OtherPrintSource {

    private String electronicConference;
    private String dayAndMonth;
    private String availableFrom;
    private String accessedDate;

}
