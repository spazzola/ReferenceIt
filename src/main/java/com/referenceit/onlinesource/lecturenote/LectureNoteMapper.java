package com.referenceit.onlinesource.lecturenote;

import org.springframework.stereotype.Component;

@Component
public class LectureNoteMapper {

    public LectureNote fromDto(LectureNoteDto lectureNoteDto) {
        return LectureNote.builder()
                .authors(lectureNoteDto.getAuthors())
                .year(lectureNoteDto.getYear())
                .title(lectureNoteDto.getTitle())
                .moduleCode(lectureNoteDto.getModuleCode())
                .moduleName(lectureNoteDto.getModuleName())
                .teachingOrganisation(lectureNoteDto.getTeachingOrganisation())
                .location(lectureNoteDto.getLocation())
                .date(lectureNoteDto.getDate())
                .accessedDate(lectureNoteDto.getAccessedDate())
                .build();
    }

}
