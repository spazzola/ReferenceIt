package com.referenceit.otherprintsource.britishstandard;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.referenceit.otherprintsource.OtherPrintSource;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@JsonTypeName(value = "BritishStandard")
public class BritishStandard extends OtherPrintSource {

    private String authorisingOrganisationName;
    private String titleOfStandard;

    public BritishStandard() {

    }

}
