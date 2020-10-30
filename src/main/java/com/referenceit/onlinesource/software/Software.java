package com.referenceit.onlinesource.software;

import com.referenceit.otherprintsource.OtherPrintSource;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
public class Software extends OtherPrintSource {

    private String version;

}
