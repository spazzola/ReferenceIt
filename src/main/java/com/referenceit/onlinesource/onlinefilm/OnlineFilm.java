package com.referenceit.onlinesource.onlinefilm;

import com.referenceit.otherprintsource.OtherPrintSource;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
public class OnlineFilm extends OtherPrintSource {

    //private String sourceType;
    private String availableFrom;
    private String accessedDate;

}
