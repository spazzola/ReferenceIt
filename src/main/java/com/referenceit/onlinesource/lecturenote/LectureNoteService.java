package com.referenceit.onlinesource.lecturenote;

import com.referenceit.reference.ReferenceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class LectureNoteService {

    private ReferenceService referenceService;
    private LectureNoteMapper lectureNoteMapper;


    public LectureNoteResponse generateReference(LectureNoteDto lectureNoteDto) {
        LectureNote lectureNote = lectureNoteMapper.fromDto(lectureNoteDto);

        return createReference(lectureNote);
    }

    private LectureNoteResponse createReference(LectureNote lectureNote) {
        LectureNoteResponse lectureNoteResponse = new LectureNoteResponse();

        String author = referenceService.remakeAndAppendMultipleAuthors(lectureNote.getAuthors());
        String year = appendYear(lectureNote);
        lectureNoteResponse.setAuthorAndYearPart(author + year);

        lectureNoteResponse.setTitlePart(lectureNote.getTitle() + ", ");
        String moduleCode = "from " + lectureNote.getModuleCode() + " ";
        String moduleName = lectureNote.getModuleName() + ". ";
        String location = lectureNote.getTeachingOrganisation() + ", " + lectureNote.getLocation() + " on ";
        String date = lectureNote.getDate() + ". ";
        String availableFrom = "Available from Blackboard ";
        String accessedDate = "[Accessed " + lectureNote.getAccessedDate() + "].";
        lectureNoteResponse.setRestReferenceBodyPart(moduleCode + moduleName + location + date + availableFrom + accessedDate);

        return lectureNoteResponse;
    }

    private String appendYear(LectureNote lectureNote) {
        return " (" + lectureNote.getYear() + ")";
    }

}
