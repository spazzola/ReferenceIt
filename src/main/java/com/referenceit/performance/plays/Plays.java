package com.referenceit.performance.plays;

import com.referenceit.otherprintsource.OtherPrintSource;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
public class Plays extends OtherPrintSource {

    private String directorName;
    private String companyName;
    private String location;
    private String seenDate;

}
