package com.referenceit.onlinesource.onlineimage;

import com.referenceit.otherprintsource.OtherPrintSource;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
public class OnlineImage extends OtherPrintSource {

    private String availableFrom;
    private String accessedDate;

}
