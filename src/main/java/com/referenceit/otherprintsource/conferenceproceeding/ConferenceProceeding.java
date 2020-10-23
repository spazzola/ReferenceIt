package com.referenceit.otherprintsource.conferenceproceeding;

import com.referenceit.otherprintsource.OtherPrintSource;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
public class ConferenceProceeding extends OtherPrintSource {

    private String titleOfConferenceProceedings;
    private String place;
    private String monthAndYear;
    private String pages;

}
