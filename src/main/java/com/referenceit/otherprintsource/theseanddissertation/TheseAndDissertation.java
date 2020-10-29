package com.referenceit.otherprintsource.theseanddissertation;

import com.referenceit.otherprintsource.OtherPrintSource;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
public class TheseAndDissertation extends OtherPrintSource {

    private String designation;
    private String degreeLevel;
    private String institution;

}
