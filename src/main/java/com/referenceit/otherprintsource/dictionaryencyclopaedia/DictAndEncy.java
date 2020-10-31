package com.referenceit.otherprintsource.dictionaryencyclopaedia;

import com.referenceit.otherprintsource.OtherPrintSource;
import com.referenceit.reference.Editor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
public class DictAndEncy extends OtherPrintSource {

    private List<Editor> editors;
    private String edition;
    private String chapterTitle;
    private String title;
    private String volumeNumber;
    private String pages;

}
