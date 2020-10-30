package com.referenceit.onlinesource.lecturenote;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LectureNoteResponse {

    private String authorAndYearPart;
    private String titlePart;
    private String restReferenceBodyPart;

}
