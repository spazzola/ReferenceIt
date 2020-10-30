package com.referenceit.onlinesource.email;

import com.referenceit.reference.ReferenceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class EmailService {

    private EmailMapper emailMapper;
    private ReferenceService referenceService;


    public EmailResponse generateReference(EmailDto emailDto) {
        Email email = emailMapper.fromDto(emailDto);

        return createReference(email);
    }

    private EmailResponse createReference(Email email) {
        EmailResponse emailResponse = new EmailResponse();

        String author = referenceService.remakeAndAppendMultipleAuthors(email.getAuthors());
        String year = appendYear(email);
        emailResponse.setAuthorAndYearPart(author + year);

        String titlePart = email.getTitle() + ". [Online] ";
        emailResponse.setTitlePart(titlePart);

        emailResponse.setElectronicConference(email.getElectronicConference() + ", ");

        String dayAndMonthPart = appendDayAndMonth(email);

        String availableFrom = "Available from: " + email.getAvailableFrom();
        String accessedDate = " [Accessed " + email.getAccessedDate() + "].";
        emailResponse.setRestReferenceBodyPart(dayAndMonthPart + availableFrom + accessedDate);

        return emailResponse;
    }

    private String appendYear(Email email) {
        return " (" + email.getYear() + ") ";
    }

    private String appendDayAndMonth(Email email) {
        System.out.println();
        String dayAndMonth = email.getDayAndMonth();
        if (dayAndMonth.endsWith(".")) {
            return email.getDayAndMonth() + " ";
        }
        return dayAndMonth + ". ";
    }

}
