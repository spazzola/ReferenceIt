package com.referenceit.journalarticles;

import com.referenceit.reference.Author;
import com.referenceit.reference.ReferenceResponse;
import com.referenceit.reference.ReferenceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class JournalArticleService {

    private ReferenceService referenceService;
    private JournalArticleMapper journalArticleMapper;


    public ReferenceResponse generateReference(JournalArticleDto journalArticleDto) {
        JournalArticle journalArticle = journalArticleMapper.fromDto(journalArticleDto);

        return createReference(journalArticle);
    }

    private ReferenceResponse createReference(JournalArticle journalArticle) {
        ReferenceResponse referenceResponse = new ReferenceResponse();

        List<Author> authors = journalArticle.getAuthors();
        String authorsPart = referenceService.remakeAndAppendMultipleAuthors(authors) + " ";
        String yearPart = appendYear(journalArticle) + " ";
        String articleTitlePart = journalArticle.getArticleTitle() + ". ";
        referenceResponse.setFirstPartNormal(authorsPart + yearPart + articleTitlePart);

        String journalTitlePart = journalArticle.getJournalTitle();
        referenceResponse.setItalicsPart(journalTitlePart);

        String thirdPartNormal = "";
        if (journalArticle.isOnlyAvailableOnline() && !journalArticle.isOpenAccessRepo()) {
            thirdPartNormal += ". [Online] ";
        } else if (journalArticle.isOnlyAvailableOnline() && journalArticle.isOpenAccessRepo()) {
            thirdPartNormal += " [Post-print]";
        } else {
            thirdPartNormal += ", ";
        }

        if (!journalArticle.isNotYetPrinted()) {
            thirdPartNormal += appendVolPartIssueMonthNumber(journalArticle);
        }

        if (journalArticle.isOpenAccessRepo()) {
            thirdPartNormal += ", " + appendPages(journalArticle) + ".";
        }

        if (journalArticle.isOnlyAvailableOnline()) {
            thirdPartNormal += appendAvailableFromAndAccessedDate(journalArticle) + ".";
        } else {
            String pagesPart = appendPages(journalArticle);
            thirdPartNormal += ", " + pagesPart;
            if (!journalArticle.isOpenAccessRepo()) {
                thirdPartNormal += ".";
            }
        }

        referenceResponse.setThirdPartNormal(thirdPartNormal);

        return referenceResponse;
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
        if (journalArticle.isNotYetPrinted() && !journalArticle.isOpenAccessRepo()) {
            return "";
        } else if (!journalArticle.isNotYetPrinted() && !journalArticle.isOpenAccessRepo()){
            return ". ";
        } else {
            return " ";
        }

    }

}
