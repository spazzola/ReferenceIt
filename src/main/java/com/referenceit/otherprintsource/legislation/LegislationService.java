package com.referenceit.otherprintsource.legislation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class LegislationService {

    private LegislationMapper legislationMapper;


    public LegislationResponse generateReference(LegislationDto legislationDto) {
        Legislation legislation = legislationMapper.fromDto(legislationDto);

        return createReference(legislation);
    }

    private LegislationResponse createReference(Legislation legislation) {
        LegislationResponse legislationResponse = new LegislationResponse();

        String titlePart = appendTitle(legislation);
        String yearPart = appendYear(legislation);
        legislationResponse.setTitleAndYearPart(titlePart + yearPart);

        if (legislation.isParliamentAct()) {
            String chapterPart = appendChapter(legislation);
            legislationResponse.setChapterPart(chapterPart);
        } else {
            String siOrYearNumberPart = appendSiOrYearNumber(legislation);
            legislationResponse.setSiOrYearNumber(siOrYearNumberPart);
        }

        String publisherAndPublicationPlacePart = appendPublisherAndPublicationPlace(legislation);
        legislationResponse.setPublisherAndPublicationPlacePart(publisherAndPublicationPlacePart);

        return legislationResponse;
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
