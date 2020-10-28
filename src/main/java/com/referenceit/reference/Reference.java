package com.referenceit.reference;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
public abstract class Reference {

    private String year;
    private List<Author> authors;
    private List<Editor> editors;

    //public abstract String createReference(Object object);
}
