package com.referenceit.newspaperarticle;

import com.referenceit.reference.Author;
import com.referenceit.reference.ReferenceResponse;
import com.referenceit.reference.ReferenceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class NewspaperArticleService {

    private ReferenceService referenceService;
    private NewspaperArticleMapper newspaperArticleMapper;

    public ReferenceResponse generateReference(NewspaperArticleDto newspaperArticleDto) {
        NewspaperArticle newspaperArticle = newspaperArticleMapper.fromDto(newspaperArticleDto);

        return createReference(newspaperArticle);
    }

    private ReferenceResponse createReference(NewspaperArticle newspaperArticle) {
        ReferenceResponse referenceResponse = new ReferenceResponse();
        List<Author> authors = newspaperArticle.getAuthors();

        String authorsPart = referenceService.remakeAndAppendMultipleAuthors(authors);
        String yearPart = appendYear(newspaperArticle);
        String articleTitlePart = appendArticleTitle(newspaperArticle);
        referenceResponse.setFirstPartNormal(authorsPart + yearPart + articleTitlePart);

        String newspaperTitlePart = appendNewspaperTitleAndOnline(newspaperArticle);
        referenceResponse.setItalicsPart(newspaperTitlePart);

        String thirdPartNormal = "";
        thirdPartNormal += appendDayAndMonth(newspaperArticle);

        if (newspaperArticle.isOnlyAvailableOnline()) {
            thirdPartNormal += appendAvailableFromAndAccessedDatePart(newspaperArticle);
        } else {
           thirdPartNormal += appendPages(newspaperArticle);
        }
        referenceResponse.setThirdPartNormal(thirdPartNormal);

        return referenceResponse;
    }

    private String appendYear(NewspaperArticle newspaperArticle) {
        return " (" + newspaperArticle.getYear() + ")";
    }

    private String appendArticleTitle(NewspaperArticle newspaperArticle) {
        return " " + newspaperArticle.getArticleTitle() + ". ";
    }

    private String appendNewspaperTitleAndOnline(NewspaperArticle newspaperArticle) {
        String newspaperTitle = newspaperArticle.getNewspaperTitle();
        if (newspaperArticle.isOnlyAvailableOnline()) {
            return newspaperTitle + ". [Online] ";
        }
        else {
            return newspaperTitle + ", ";
        }
    }

    private String appendDayAndMonth(NewspaperArticle newspaperArticle) {
        String resultDayAndMonth = "";
        resultDayAndMonth += remakeDay(newspaperArticle);
        resultDayAndMonth += remakeMonth(newspaperArticle);

        return resultDayAndMonth;
    }

    private String remakeDay(NewspaperArticle newspaperArticle) {
        String resultDay = "";
        int day = Integer.valueOf(newspaperArticle.getDay());
        if (day == 1 || day == 21) {
            resultDay = newspaperArticle.getDay() + "st ";
        }
        else if (day == 2 || day == 22) {
            resultDay += newspaperArticle.getDay() + "nd ";
        } else if (day == 3 || day == 23) {
            resultDay += newspaperArticle.getDay() + "rd ";
        } else {
            resultDay += newspaperArticle.getDay() + "th ";
        }
        return resultDay;
    }

    private String remakeMonth(NewspaperArticle newspaperArticle) {
        final String month = newspaperArticle.getMonth();
        switch (month) {
            case "June":
            case "July":
                return month + ". ";
            default:
                return month.substring(0, 3) + ". ";
        }
    }

    private String appendPages(NewspaperArticle newspaperArticle) {
        return "p. " + newspaperArticle.getPages() + ".";
    }

    private String appendAvailableFromAndAccessedDatePart(NewspaperArticle newspaperArticle) {
        String availableFrom = newspaperArticle.getAvailableFrom();
        String accessedDate = newspaperArticle.getAccessedDate();
        return "Available from: " + availableFrom + " [Accessed " + accessedDate + "].";
    }

}
