package com.referenceit.otherprintsource;

import com.referenceit.reference.Reference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;


@Data
@SuperBuilder
@AllArgsConstructor
public abstract class OtherPrintSource extends Reference {

    private String title;
    private String publicationPlace;
    private String publisher;

    public OtherPrintSource() {

    }

}
