package com.referenceit.journalarticles;

import com.referenceit.reference.Author;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JournalArticleService {

    public JournalArticleService() {

    }

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
            resultReference += remakeAuthor(authors.get(i - 1)) + "";
            if(checkIfAreMoreThanTwoAuthors(i, authors)) {
                if (checkIfAuthorIsPenultimate(i, authors)) {
                    resultReference += " and ";
                }
                else {
                    resultReference += ", ";
                }
            }
        }
        return resultReference;
    }

    private String remakeAuthor(Author author) {
        String resultString = "";
        resultString += author.getSurname().toUpperCase();
        resultString += ",";
        resultString += " " + author.getFirstName().toUpperCase().charAt(0);
        if (hasAuthorSecondName(author)) {
            resultString += "." + author.getSecondName().toUpperCase().charAt(0);
        }
        resultString += ".";

        return resultString;
    }

    private String appendAvailableFromAndAccessedDate(JournalArticle journalArticle) {
        String resultString = "";
        resultString += appendDotOrWhiteSpace(journalArticle);
        return resultString + "Available from: " + journalArticle.getAvailableFrom() + " [Accessed " + journalArticle.getAccessedDate() + "]";
    }

    private boolean hasAuthorSecondName(Author author) {
        return author.getSecondName() != null;
    }

    private boolean checkIfAuthorIsPenultimate(int loopIteration, List<Author> authors) {
        return (loopIteration + 1) == authors.size();
    }

    private boolean checkIfAreMoreThanTwoAuthors(int loopIteration, List<Author> authors) {
        return loopIteration != authors.size();
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
