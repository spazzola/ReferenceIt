package com.referenceit.otherprintsource.conferenceproceeding;

import com.referenceit.reference.Author;
import com.referenceit.reference.ReferenceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ConferenceProceedingService {

    private ReferenceService referenceService;
    private ConferenceProceedingMapper conferenceProceedingMapper;

    public ConferenceProceedingResponse generateReference(ConferenceProceedingDto conferenceProceedingDto) {
        ConferenceProceeding conferenceProceeding = conferenceProceedingMapper.fromDto(conferenceProceedingDto);

        return createReference(conferenceProceeding);
    }

    private ConferenceProceedingResponse createReference(ConferenceProceeding conferenceProceeding) {
        ConferenceProceedingResponse conferenceProceedingResponse = new ConferenceProceedingResponse();
        List<Author> authors = conferenceProceeding.getAuthors();

        String authorsPart = referenceService.remakeAndAppendMultipleAuthors(authors);
        conferenceProceedingResponse.setAuthorsPart(authorsPart);

        String yearPart = appendYear(conferenceProceeding);
        conferenceProceedingResponse.setYearPart(yearPart);

        String titlePart = appendTitle(conferenceProceeding);
        conferenceProceedingResponse.setTitlePart(titlePart);

        String titleOfConferenceProceedingsPart = appendTitleOfConferenceProceedings(conferenceProceeding);
        conferenceProceedingResponse.setTitleOfConferenceProceedingsPart(titleOfConferenceProceedingsPart);

        String placeAndDatePart = appendPlaceAndDate(conferenceProceeding);
        conferenceProceedingResponse.setPlaceAndDatePart(placeAndDatePart);

        String publicationPlaceAndPublisherPart = appendPublicationPlaceAndPublisher(conferenceProceeding);
        conferenceProceedingResponse.setPublicationPlaceAndPublisherPart(publicationPlaceAndPublisherPart);

        String pagesPart = appendPages(conferenceProceeding);
        conferenceProceedingResponse.setPages(pagesPart);

        return conferenceProceedingResponse;
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
