package com.referenceit.otherprintsource.theseanddissertation;

import com.referenceit.reference.ReferenceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class TheseAndDissertationService {

    private ReferenceService referenceService;
    private TheseAndDissertationMapper theseAndDissertationMapper;


    public TheseAndDissertationResponse generateReference(TheseAndDissertationDto theseAndDissertationDto) {
        TheseAndDissertation theseAndDissertation = theseAndDissertationMapper.fromDto(theseAndDissertationDto);

        return createReference(theseAndDissertation);
    }

    private TheseAndDissertationResponse createReference(TheseAndDissertation theseAndDissertation) {
        TheseAndDissertationResponse theseAndDissertationResponse = new TheseAndDissertationResponse();

        String author = referenceService.remakeAndAppendMultipleAuthors(theseAndDissertation.getAuthors());
        String year = appendYear(theseAndDissertation);
        theseAndDissertationResponse.setAuthorAndYearPart(author + year);

        String titlePart = theseAndDissertation.getTitle() + ". ";
        theseAndDissertationResponse.setTitlePart(titlePart);

        String designation = theseAndDissertation.getDesignation();
        String degreeLevel = appendDegreeLevel(theseAndDissertation);
        String institution = theseAndDissertation.getInstitution() + ".";
        theseAndDissertationResponse.setRestReferenceBodyPart(designation + degreeLevel + institution);

        return theseAndDissertationResponse;
    }

    private String appendYear(TheseAndDissertation theseAndDissertation) {
        return " (" + theseAndDissertation.getYear() + ") ";
    }

    private String appendDegreeLevel(TheseAndDissertation theseAndDissertation) {
        return " (" + theseAndDissertation.getDegreeLevel().toUpperCase() + "), ";
    }

}
