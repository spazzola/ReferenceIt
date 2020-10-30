package com.referenceit.onlinesource.email;

import org.springframework.stereotype.Component;

@Component
public class EmailMapper {

    public Email fromDto(EmailDto emailDto) {
        return Email.builder()
                .authors(emailDto.getAuthors())
                .year(emailDto.getYear())
                .title(emailDto.getTitle())
                .electronicConference(emailDto.getElectronicConference())
                .dayAndMonth(emailDto.getDayAndMonth())
                .availableFrom(emailDto.getAvailableFrom())
                .accessedDate(emailDto.getAccessedDate())
                .build();
    }

}
