package com.referenceit.otherprintsource.exhibition;

import com.referenceit.otherprintsource.OtherPrintSource;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
public class Exhibition extends OtherPrintSource {

    private String itemType;
    private String location;
    private String date;
    private String exhibitionCatalogue;
    private boolean isItemFromExhibition;

}
