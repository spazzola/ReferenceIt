package com.referenceit.onlinesource.email;

import com.referenceit.reference.ReferenceResponse;
import com.referenceit.reference.ReferenceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class EmailService {

    private EmailMapper emailMapper;
    private ReferenceService referenceService;


    public ReferenceResponse generateReference(EmailDto emailDto) {
        Email email = emailMapper.fromDto(emailDto);

        return createReference(email);
    }

    private ReferenceResponse createReference(Email email) {
        ReferenceResponse referenceResponse = new ReferenceResponse();

        String author = referenceService.remakeAndAppendMultipleAuthors(email.getAuthors());
        String year = appendYear(email);
        String titlePart = email.getTitle() + ". [Online] ";
        referenceResponse.setFirstPartNormal(author + year + titlePart);

        referenceResponse.setItalicsPart(email.getElectronicConference() + ", ");

        String dayAndMonthPart = appendDayAndMonth(email);

        String availableFrom = "Available from: " + email.getAvailableFrom();
        String accessedDate = " [Accessed " + email.getAccessedDate() + "].";
        referenceResponse.setThirdPartNormal(dayAndMonthPart + availableFrom + accessedDate);

        return referenceResponse;
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
