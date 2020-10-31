package com.referenceit.otherprintsource.legislation;

import com.referenceit.reference.ReferenceResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class LegislationService {

    private LegislationMapper legislationMapper;


    public ReferenceResponse generateReference(LegislationDto legislationDto) {
        Legislation legislation = legislationMapper.fromDto(legislationDto);

        return createReference(legislation);
    }

    private ReferenceResponse createReference(Legislation legislation) {
        ReferenceResponse referenceResponse = new ReferenceResponse();

        String titlePart = appendTitle(legislation);
        String yearPart = appendYear(legislation);
        referenceResponse.setItalicsPart(titlePart + yearPart);

        String thirdPartNormal = "";
        if (legislation.isParliamentAct()) {
            thirdPartNormal += appendChapter(legislation);
        } else {
            thirdPartNormal += appendSiOrYearNumber(legislation);

        }

        String publisherAndPublicationPlacePart = appendPublisherAndPublicationPlace(legislation);
        referenceResponse.setThirdPartNormal(thirdPartNormal + publisherAndPublicationPlacePart);

        return referenceResponse;
    }

    private String appendTitle(Legislation legislation) {
        return legislation.getTitle() + " ";
    }

    private String appendYear(Legislation legislation) {
        return legislation.getYear() + " ";
    }

    private String appendChapter(Legislation legislation) {
        return "(c." + legislation.getChapterNumber() + "). ";
    }

    private String appendPublisherAndPublicationPlace(Legislation legislation) {
        return legislation.getPublicationPlace() + ": " + legislation.getPublisher() + ".";
    }

    private String appendSiOrYearNumber(Legislation legislation) {
        return "(SI " + legislation.getSiYearNumber() + "). ";
    }

}
