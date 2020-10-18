package com.referenceit.book;

import com.referenceit.reference.Author;
import com.referenceit.reference.Editor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    public BookService() {

    }

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
                resultReference += remakeAuthor(firstAuthor) + " et al.";
            } else {
                resultReference += remakeAuthor(authors.get(i - 1)) + "";
                if (checkIfAreTwoOrThreeWriters(i, authors)) {
                    if (checkIfWriterIsPenultimate(i, authors)) {
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
    /*private String remakeAndAppendMultipleEditors(List<Editor> editors) {
        String resultReference = "";
        for (int i = 1; i <= editors.size(); i++) {
            if (checkIfAreMoreThanThreeWriters(editors)) {
                resultReference = "";
                Editor firstEditor = editors.get(0);
                resultReference += remakeEditor(firstEditor) + " (eds.)";
            } else {
                resultReference += remakeEditor(editors.get(i - 1)) + "";
                if (checkIfAreTwoOrThreeWriters(i, editors)) {
                    if (checkIfWriterIsPenultimate(i, editors)) {
                        resultReference += " and ";
                    } else {
                        resultReference += ", ";
                    }
                }
                resultReference += " (ed.)";
            }
        }
        return resultReference;
    }*/

    private boolean checkIfAreMoreThanThreeWriters(List<?> writers) {
        return writers.size() > 3;
    }

    private boolean checkIfAreTwoOrThreeWriters(int loopIteration, List<?> writers) {
        return loopIteration != writers.size();
    }

    private boolean checkIfIsOneWriter(List<?> writers) {
        return writers.size() == 1;
    }

    private boolean checkIfWriterIsPenultimate(int loopIteration, List<?> writers) {
        return (loopIteration + 1) == writers.size();
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

    private boolean hasAuthorSecondName(Author author) {
        return author.getSecondName() != null;
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
