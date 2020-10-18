package com.referenceit.book;

import com.referenceit.reference.Author;
import com.referenceit.reference.Editor;
import com.referenceit.reference.ReferenceService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class BookService {

    private ReferenceService referenceService;


    public String generateReference(Book book) {
        String resultReference = "";
        List<Author> authors = book.getAuthors();
        List<Editor> editors = book.getEditors();

        if (editors != null && !book.isWithChapter()) {
            resultReference += remakeAndAppendMultipleEditors(editors);
        } else {
            resultReference += remakeAndAppendMultipleAuthors(authors);
        }
        resultReference += appendYear(book);
        if (book.isWithChapter()) {
            resultReference += appendChapterTitle(book);
            resultReference += "In: ";
            resultReference += remakeAndAppendMultipleEditors(book.getEditors()) + " ";
        }
        resultReference += appendBookTitle(book);
        if (checkIfIsNotFirstEdition(book)) {
            resultReference += appendEdition(book);
        }
        resultReference += appendPublicationPlace(book);
        resultReference += appendPublisher(book);
        if (book.isWithChapter()) {
            resultReference += ", ";
            resultReference += appendPages(book) + ".";
        } else {
            resultReference += ".";
        }

        return resultReference;
    }

    private String remakeAndAppendMultipleAuthors(List<Author> authors) {
        String resultReference = "";
        for (int i = 1; i <= authors.size(); i++) {
            if (checkIfAreMoreThanThreeWriters(authors)) {
                resultReference = "";
                Author firstAuthor = authors.get(0);
                resultReference += referenceService.remakeAuthor(firstAuthor) + " et al.";
            } else {
                resultReference += referenceService.remakeAuthor(authors.get(i - 1)) + "";
                if (referenceService.checkIfAreTwoOrThreeWriters(i, authors)) {
                    if (referenceService.checkIfWriterIsPenultimate(i, authors)) {
                        resultReference += " and ";
                    } else {
                        resultReference += ", ";
                    }
                }
            }
        }
        return resultReference;
    }

    private String remakeAndAppendMultipleEditors(List<Editor> editors) {
        String resultReference = "";
        if (checkIfIsOneWriter(editors)) {
            resultReference += remakeEditor(editors.get(0)) + " (ed.)";
        } else {
            if (editors.size() == 2) {
                resultReference += remakeEditor(editors.get(0)) + " and ";
                resultReference += remakeEditor(editors.get(1));

            }
            if (editors.size() == 3) {
                resultReference += remakeEditor(editors.get(0)) + ", ";
                resultReference += remakeEditor(editors.get(1)) + " and ";
                resultReference += remakeEditor(editors.get(2));
            }
            resultReference += " (eds.)";
        }


        return resultReference;
    }

    private boolean checkIfAreMoreThanThreeWriters(List<?> writers) {
        return writers.size() > 3;
    }

    private boolean checkIfIsOneWriter(List<?> writers) {
        return writers.size() == 1;
    }

    private String remakeEditor(Editor editor) {
        String resultString = "";
        resultString += editor.getSurname().toUpperCase();
        resultString += ",";
        resultString += " " + editor.getFirstName().toUpperCase().charAt(0);
        if (hasEditorSecondName(editor)) {
            resultString += "." + editor.getSecondName().toUpperCase().charAt(0);
        }
        resultString += ".";

        return resultString;
    }

    private boolean hasEditorSecondName(Editor editor) {
        return editor.getSecondName() != null;
    }

    private String appendYear(Book book) {
        return " (" + book.getYear() + ") ";
    }

    private String appendBookTitle(Book book) {
        return book.getTitle() + ". ";
    }

    private String appendChapterTitle(Book book) {
        return book.getChapterTitle() + ". ";
    }

    private String appendPublicationPlace(Book book) {
        return book.getPublicationPlace() + ": ";
    }

    private String appendPublisher(Book book) {
        return book.getPublisher();
    }

    private String appendPages(Book book) {
        return "pp. " + book.getPages();
    }

    private boolean checkIfIsNotFirstEdition(Book book) {
        int edition;
        if (book.getEdition() == null || book.getEdition().equals("")) {
            edition = 1;
        } else {
            edition = Integer.valueOf(book.getEdition());
        }
        return edition > 1;
    }

    private String appendEdition(Book book) {
        String resultEdition = "";
        int edition = Integer.valueOf(book.getEdition());
        if (edition == 2) {
            resultEdition += book.getEdition() + "nd ed. ";
        } else if (edition == 3) {
            resultEdition += book.getEdition() + "rd ed. ";
        } else if (edition > 3) {
            resultEdition += book.getEdition() + "th ed. ";
        }
        return resultEdition;
    }

}
