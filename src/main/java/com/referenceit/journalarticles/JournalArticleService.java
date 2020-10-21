package com.referenceit.journalarticles;

import com.referenceit.reference.Author;
import com.referenceit.reference.ReferenceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class JournalArticleService {

    private ReferenceService referenceService;
    private JournalArticleMapper journalArticleMapper;


    public JournalArticleResponse generateReferences(JournalArticleDto journalArticleDto) {
        JournalArticle journalArticle = journalArticleMapper.fromDto(journalArticleDto);

        return createReference(journalArticle);
    }

    public JournalArticleResponse createReference(JournalArticle journalArticle) {
        JournalArticleResponse journalArticleResponse = new JournalArticleResponse();
        List<Author> authors = journalArticle.getAuthors();


        String authorsPart = referenceService.remakeAndAppendMultipleAuthors(authors) + " ";
        journalArticleResponse.setAuthorsPart(authorsPart);

        String yearPart = appendYear(journalArticle) + " ";
        journalArticleResponse.setYearPart(yearPart);

        String articleTitlePart = appendArticleTitle(journalArticle);
        journalArticleResponse.setArticleTitlePart(articleTitlePart);

        String journalTitlePart = appendJournalTitle(journalArticle);
        journalArticleResponse.setJournalTitlePart(journalTitlePart);

        if (journalArticle.isOnlyAvailableOnline() && !journalArticle.isOpenAccessRepo()) {
            journalArticleResponse.setOnlinePart(". [Online] ");
        } else if (journalArticle.isOnlyAvailableOnline() && journalArticle.isOpenAccessRepo()) {
            journalArticleResponse.setForthcomingOrPostprintPart(" [Post-print]");
        }
        else {
            journalTitlePart += ", ";
            journalArticleResponse.setJournalTitlePart(journalTitlePart);
        }
        if (!journalArticle.isNotYetPrinted()) {
            String volIssueMonthPart = appendVolPartIssueMonthNumber(journalArticle);
            journalArticleResponse.setVolIssueMonthPart(volIssueMonthPart);
        }
        if (journalArticle.isOpenAccessRepo()) {
            String pagesPart = appendPages(journalArticle) + ".";
            journalArticleResponse.setPagesPart(pagesPart);
        }
        if (journalArticle.isOnlyAvailableOnline()) {
            String availableFromAndAccessedDatePart = appendAvailableFromAndAccessedDate(journalArticle) + ".";
            journalArticleResponse.setAvailableFromAndAccessedDatePart(availableFromAndAccessedDatePart);
        } else {
            String pagesPart = appendPages(journalArticle);
            journalArticleResponse.setPagesPart(", " + pagesPart);
            if (!journalArticle.isOpenAccessRepo()) {
                String dotPart = ".";
                journalArticleResponse.setDotPart(dotPart);
            }
        }
        String comaAndSpacePart = ", ";
        journalArticleResponse.setComaAndSpacePart(comaAndSpacePart);

        return journalArticleResponse;
    }

    private String appendAvailableFromAndAccessedDate(JournalArticle journalArticle) {
        String resultString = "";
        resultString += appendDotOrWhiteSpace(journalArticle);
        return resultString + "Available from: " + journalArticle.getAvailableFrom() + " [Accessed " + journalArticle.getAccessedDate() + "]";
    }

    private String appendYear(JournalArticle journalArticle) {
        if (journalArticle.isNotYetPrinted()) {
            return "(Forthcoming)";
        } else {
            return ("(" + journalArticle.getYear() + ")");
        }
    }

    public String appendArticleTitle(JournalArticle journalArticle) {
        return journalArticle.getArticleTitle() + ". ";
    }

    public String appendJournalTitle(JournalArticle journalArticle) {
        return journalArticle.getJournalTitle();
    }

    private String appendVolPartIssueMonthNumber(JournalArticle journalArticle) {
        String resultString = "";

        String volNumber = journalArticle.getVolNumber();
        if (volNumber != null) {
            resultString += volNumber + " ";
        }

        String partNumber = journalArticle.getPartNumber();
        if (partNumber != null) {
            resultString += "(" + partNumber + ")";
        }

        String issue = journalArticle.getIssue();
        if (issue != null) {
            resultString += " " + "(Issue " + issue +")";
        }

        String month = journalArticle.getMonth();
        if (month != null) {
            resultString += " " + "(Month " + issue +")";
        }
        return resultString;
    }

    private String appendPages(JournalArticle journalArticle) {
        return "pp. " + journalArticle.getPages();
    }

    private String appendDotOrWhiteSpace(JournalArticle journalArticle) {
        String resultString = "";
        if (journalArticle.isNotYetPrinted() && !journalArticle.isOpenAccessRepo()) {
            resultString += "";
        } else if (!journalArticle.isNotYetPrinted() && !journalArticle.isOpenAccessRepo()){
            resultString += ". ";
        } else {
            resultString += " ";
        }
        return resultString;
    }

}
