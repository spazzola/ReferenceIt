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



    public String generateReference(JournalArticle journalArticle) {
        String resultReference = "";
        List<Author> authors = journalArticle.getAuthors();

        resultReference += remakeAndAppendMultipleAuthors(authors) + " ";
        resultReference += appendYear(journalArticle) + " ";
        resultReference += appendTitles(journalArticle);

        if (journalArticle.isOnlyAvailableOnline() && !journalArticle.isOpenAccessRepo()) {
            resultReference += ". [Online] ";
        } else if (journalArticle.isOnlyAvailableOnline() && journalArticle.isOpenAccessRepo()){
            resultReference += " [Post-print]";
        }
        else {
            resultReference += ", ";
        }
        if (!journalArticle.isNotYetPrinted())
            resultReference += appendVolPartIssueMonthNumber(journalArticle);

        if (journalArticle.isOpenAccessRepo()) {
            resultReference += ", " + appendPages(journalArticle) + ".";
        }
        if (journalArticle.isOnlyAvailableOnline()) {
            resultReference += appendAvailableFromAndAccessedDate(journalArticle) + ".";
        } else {
            resultReference += ", ";
            resultReference += appendPages(journalArticle);
            if (!journalArticle.isOpenAccessRepo()) {
                resultReference += ".";
            }
        }
        return resultReference;
    }

    private String remakeAndAppendMultipleAuthors(List<Author> authors) {
        String resultReference = "";
        for (int i = 1; i <= authors.size(); i++) {
            resultReference += referenceService.remakeAuthor(authors.get(i - 1)) + "";
            if(referenceService.checkIfAreTwoOrThreeWriters(i, authors)) {
                if (referenceService.checkIfWriterIsPenultimate(i, authors)) {
                    resultReference += " and ";
                }
                else {
                    resultReference += ", ";
                }
            }
        }
        return resultReference;
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

    private String appendTitles(JournalArticle journalArticle) {
        return journalArticle.getArticleTitle() + ". " + journalArticle.getJournalTitle();
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
