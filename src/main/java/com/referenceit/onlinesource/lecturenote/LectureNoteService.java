package com.referenceit.onlinesource.lecturenote;

import com.referenceit.reference.ReferenceResponse;
import com.referenceit.reference.ReferenceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class LectureNoteService {

    private ReferenceService referenceService;
    private LectureNoteMapper lectureNoteMapper;


    public ReferenceResponse generateReference(LectureNoteDto lectureNoteDto) {
        LectureNote lectureNote = lectureNoteMapper.fromDto(lectureNoteDto);

        return createReference(lectureNote);
    }

    private ReferenceResponse createReference(LectureNote lectureNote) {
        ReferenceResponse referenceResponse = new ReferenceResponse();

        String author = referenceService.remakeAndAppendMultipleAuthors(lectureNote.getAuthors());
        String year = appendYear(lectureNote);
        referenceResponse.setFirstPartNormal(author + year);

        referenceResponse.setItalicsPart(lectureNote.getTitle() + ", ");

        String moduleCode = "from " + lectureNote.getModuleCode() + " ";
        String moduleName = lectureNote.getModuleName() + ". ";
        String location = lectureNote.getTeachingOrganisation() + ", " + lectureNote.getLocation() + " on ";
        String date = lectureNote.getDate() + ". ";
        String availableFrom = "Available from Blackboard ";
        String accessedDate = "[Accessed " + lectureNote.getAccessedDate() + "].";
        referenceResponse.setThirdPartNormal(moduleCode + moduleName + location + date + availableFrom + accessedDate);

        return referenceResponse;
    }

    private String appendYear(LectureNote lectureNote) {
        return " (" + lectureNote.getYear() + ")";
    }

}
