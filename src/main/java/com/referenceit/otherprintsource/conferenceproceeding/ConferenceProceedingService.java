package com.referenceit.otherprintsource.conferenceproceeding;

import com.referenceit.reference.Author;
import com.referenceit.reference.ReferenceResponse;
import com.referenceit.reference.ReferenceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ConferenceProceedingService {

    private ReferenceService referenceService;
    private ConferenceProceedingMapper conferenceProceedingMapper;


    public ReferenceResponse generateReference(ConferenceProceedingDto conferenceProceedingDto) {
        ConferenceProceeding conferenceProceeding = conferenceProceedingMapper.fromDto(conferenceProceedingDto);

        return createReference(conferenceProceeding);
    }

    private ReferenceResponse createReference(ConferenceProceeding conferenceProceeding) {
        ReferenceResponse referenceResponse = new ReferenceResponse();
        List<Author> authors = conferenceProceeding.getAuthors();

        String authorsPart = referenceService.remakeAndAppendMultipleAuthors(authors);
        String yearPart = appendYear(conferenceProceeding);
        String titlePart = appendTitle(conferenceProceeding);
        referenceResponse.setFirstPartNormal(authorsPart + yearPart + titlePart);

        String titleOfConferenceProceedingsPart = appendTitleOfConferenceProceedings(conferenceProceeding);
        String placeAndDatePart = appendPlaceAndDate(conferenceProceeding);
        referenceResponse.setItalicsPart(titleOfConferenceProceedingsPart + placeAndDatePart);

        String publicationPlaceAndPublisherPart = appendPublicationPlaceAndPublisher(conferenceProceeding);
        String pagesPart = appendPages(conferenceProceeding);
        referenceResponse.setThirdPartNormal(publicationPlaceAndPublisherPart + pagesPart);

        return referenceResponse;
    }

    private String appendYear(ConferenceProceeding conferenceProceeding) {
        return " (" + conferenceProceeding.getYear() + ")";
    }

    private String appendTitle(ConferenceProceeding conferenceProceeding) {
        return " " + conferenceProceeding.getTitle() + ". In: ";
    }

    private String appendTitleOfConferenceProceedings(ConferenceProceeding conferenceProceeding) {
        return conferenceProceeding.getTitleOfConferenceProceedings() + ", ";
    }

    private String appendPlaceAndDate(ConferenceProceeding conferenceProceeding) {
        return conferenceProceeding.getPlace() + ", " + conferenceProceeding.getMonthAndYear() + ". ";
    }

    private String appendPublicationPlaceAndPublisher(ConferenceProceeding conferenceProceeding) {
        return conferenceProceeding.getPublicationPlace() + ": " + conferenceProceeding.getPublisher() + ", ";
    }

    private String appendPages(ConferenceProceeding conferenceProceeding) {
        return "pp. " + conferenceProceeding.getPages() + ".";
    }

}
