package com.referenceit.otherprintsource.governmentpublication;


import com.referenceit.otherprintsource.OtherPrintSource;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
public class GovernmentPublication extends OtherPrintSource {

    private String knowBy;
    private String nameOfKnowBy;
    private String title;
    private String nameOfIssuingBody;
    private String reportNumber;

}
