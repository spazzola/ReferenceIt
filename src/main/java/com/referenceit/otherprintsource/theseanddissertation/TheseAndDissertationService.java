package com.referenceit.otherprintsource.theseanddissertation;

import com.referenceit.reference.ReferenceResponse;
import com.referenceit.reference.ReferenceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class TheseAndDissertationService {

    private ReferenceService referenceService;
    private TheseAndDissertationMapper theseAndDissertationMapper;


    public ReferenceResponse generateReference(TheseAndDissertationDto theseAndDissertationDto) {
        TheseAndDissertation theseAndDissertation = theseAndDissertationMapper.fromDto(theseAndDissertationDto);

        return createReference(theseAndDissertation);
    }

    private ReferenceResponse createReference(TheseAndDissertation theseAndDissertation) {
        ReferenceResponse referenceResponse = new ReferenceResponse();

        String author = referenceService.remakeAndAppendMultipleAuthors(theseAndDissertation.getAuthors());
        String year = appendYear(theseAndDissertation);
        referenceResponse.setFirstPartNormal(author + year);

        String titlePart = theseAndDissertation.getTitle() + ". ";
        referenceResponse.setItalicsPart(titlePart);

        String designation = theseAndDissertation.getDesignation();
        String degreeLevel = appendDegreeLevel(theseAndDissertation);
        String institution = theseAndDissertation.getInstitution() + ".";
        referenceResponse.setThirdPartNormal(designation + degreeLevel + institution);

        return referenceResponse;
    }

    private String appendYear(TheseAndDissertation theseAndDissertation) {
        return " (" + theseAndDissertation.getYear() + ") ";
    }

    private String appendDegreeLevel(TheseAndDissertation theseAndDissertation) {
        return " (" + theseAndDissertation.getDegreeLevel().toUpperCase() + "), ";
    }

}
