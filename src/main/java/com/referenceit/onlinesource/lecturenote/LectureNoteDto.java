package com.referenceit.onlinesource.lecturenote;

import com.referenceit.reference.Author;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LectureNoteDto {

    private List<Author> authors;
    private String year;
    private String title;
    private String moduleCode;
    private String moduleName;
    private String teachingOrganisation;
    private String location;
    private String date;
    private String accessedDate;

}
