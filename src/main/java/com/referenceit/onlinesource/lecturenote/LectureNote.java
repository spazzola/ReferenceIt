package com.referenceit.onlinesource.lecturenote;

import com.referenceit.otherprintsource.OtherPrintSource;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
public class LectureNote extends OtherPrintSource {

    private String moduleCode;
    private String moduleName;
    private String teachingOrganisation;
    private String location;
    private String date;
    private String accessedDate;

}
