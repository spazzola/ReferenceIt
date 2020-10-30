package com.referenceit.performance.dance;

import com.referenceit.otherprintsource.OtherPrintSource;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
public class Dance extends OtherPrintSource {

    private String company;
    private String location;
    private String seenDate;

}
