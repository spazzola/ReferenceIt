package com.referenceit.book;

import com.referenceit.reference.Author;
import com.referenceit.reference.Editor;
import com.referenceit.reference.ReferenceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private ReferenceService referenceService;
    private BookMapper bookMapper;

    public BookService(ReferenceService referenceService, BookMapper bookMapper) {
        this.referenceService = referenceService;
        this.bookMapper = bookMapper;
    }

    public BookResponse generateReference(BookDto bookDto) {
        Book book = bookMapper.fromDto(bookDto);

        return createReference(book);
    }

    private BookResponse createReference(Book book) {
        BookResponse bookResponse = new BookResponse();

        List<Author> authors = book.getAuthors();
        List<Editor> editors = book.getEditors();

        if (editors != null && !book.isWithChapter()) {
            String editorsPart = remakeAndAppendMultipleEditors(editors);
            bookResponse.setEditorsPart(editorsPart);
        } else {
            String authorsPart = referenceService.remakeAndAppendMultipleAuthors(authors);
            bookResponse.setAuthorsPart(authorsPart);
        }
        String yearPart = appendYear(book);
        bookResponse.setYearPart(yearPart);
        if (book.isWithChapter()) {
            String chapterTitlePart = "";
            chapterTitlePart += appendChapterTitle(book) + "In: ";
            chapterTitlePart += remakeAndAppendMultipleEditors(book.getEditors()) + " ";
            bookResponse.setChapterTitlePartWithEditors(chapterTitlePart);
        }
        String bookTitlePart = appendBookTitle(book);
        bookResponse.setBookTitlePart(bookTitlePart);
        if (checkIfIsNotFirstEdition(book)) {
            String editionPart = appendEdition(book);
            bookResponse.setEditionPart(editionPart);
        }
        String publisherAndPublicationPlacePart = "";
        publisherAndPublicationPlacePart += appendPublicationPlace(book);
        publisherAndPublicationPlacePart += appendPublisher(book);
        bookResponse.setPublisherAndPublicationPlacePart(publisherAndPublicationPlacePart);
        if (book.isWithChapter()) {
            String pagesPart = "";
            pagesPart += ", ";
            pagesPart += appendPages(book) + ".";
            bookResponse.setPagesPart(pagesPart);
        } else {
            String endOfPublicationPlace = bookResponse.getPublisherAndPublicationPlacePart();
            endOfPublicationPlace += ".";
            bookResponse.setPublisherAndPublicationPlacePart(endOfPublicationPlace);
        }

        return bookResponse;
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
