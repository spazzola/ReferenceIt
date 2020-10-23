package com.referenceit.otherprintsource.conferenceproceeding;

import org.springframework.stereotype.Component;

@Component
public class ConferenceProceedingMapper {

    public ConferenceProceeding fromDto(ConferenceProceedingDto conferenceProceedingDto) {
        return ConferenceProceeding.builder()
                .year(conferenceProceedingDto.getYear())
                .publicationPlace(conferenceProceedingDto.getPublicationPlace())
                .publisher(conferenceProceedingDto.getPublisher())
                .authors(conferenceProceedingDto.getAuthors())
                .title(conferenceProceedingDto.getTitle())
                .titleOfConferenceProceedings(conferenceProceedingDto.getTitleOfConferenceProceedings())
                .place(conferenceProceedingDto.getPlace())
                .monthAndYear(conferenceProceedingDto.getMonthAndYear())
                .pages(conferenceProceedingDto.getPages())
                .build();
    }

}
