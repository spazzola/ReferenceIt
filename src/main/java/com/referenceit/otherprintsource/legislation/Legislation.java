package com.referenceit.otherprintsource.legislation;

import com.referenceit.otherprintsource.OtherPrintSource;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
public class Legislation extends OtherPrintSource {

    private String chapterNumber;
    private String siYearNumber;
    private boolean isParliamentAct;

}
