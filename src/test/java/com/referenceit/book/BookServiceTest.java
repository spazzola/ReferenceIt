package com.referenceit.book;

import com.referenceit.reference.Author;
import com.referenceit.reference.Editor;
import com.referenceit.reference.ReferenceService;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookServiceTest {

    private ReferenceService referenceService = new ReferenceService();
    private BookMapper bookMapper = new BookMapper();
    private BookService bookService = new BookService(referenceService, bookMapper);

    public BookServiceTest() {
    }

    @Test
    public void shouldPassReferencingBookWithOneAuthorAndWithoutChapterAndEdition() {
        //given
        List<Author> authors = Arrays.asList(new Author("Simon", null, "Clarke"));
        Book book = Book.builder()
                .authors(authors)
                .title("Textile design")
                .year("2011")
                .publicationPlace("London")
                .publisher("Laurence King")
                .isWithChapter(false)
                .build();

        //when
        BookResponse bookResponse = bookService.createReference(book);

        //then
        String expectedResult = "CLARKE, S. (2011) Textile design. London: Laurence King.";

        assertEquals(expectedResult, bookResponse.toString());
    }


    @Test
    public void shouldPassReferencingBookWithOneAuthorAndEditionAndWithoutChapter() {
        //given
        List<Author> authors = Arrays.asList(new Author("Simon", null, "Seidman"));
        Book book = Book.builder()
                .authors(authors)
                .title("Contested knowledge")
                .year("2012")
                .edition("5")
                .publicationPlace("Hoboken, New Jersey")
                .publisher("Wiley-Blackwell")
                .isWithChapter(false)
                .build();

        //when
        BookResponse bookResponse = bookService.createReference(book);
        String resultReference = "";
        resultReference += bookResponse.getAuthorsPart();
        resultReference += bookResponse.getYearPart();
        resultReference += bookResponse.getBookTitlePart();
        resultReference += bookResponse.getEditionPart();
        resultReference += bookResponse.getPublisherAndPublicationPlacePart();

        //then
        String expectedResult = "SEIDMAN, S. (2012) Contested knowledge. 5th ed. Hoboken, New Jersey: Wiley-Blackwell.";

        assertEquals(expectedResult, resultReference);
    }

    @Test
    public void shouldPassReferencingBookWithTwoAuthorsAndWithoutChapterAndEdition() {
        //given
        List<Author> authors = Arrays.asList(
                new Author("Ramon", null, "Sharda"),
                new Author("Elen", null, "Turban"));
        Book book = Book.builder()
                .authors(authors)
                .title("Business intelligence: a managerial perspective on analytics")
                .year("2015")
                .edition("1")
                .publicationPlace("London")
                .publisher("Pearson Education")
                .isWithChapter(false)
                .build();

        //when
        BookResponse bookResponse = bookService.createReference(book);
        String resultReference = "";
        resultReference += bookResponse.getAuthorsPart();
        resultReference += bookResponse.getYearPart();
        resultReference += bookResponse.getBookTitlePart();
        resultReference += bookResponse.getPublisherAndPublicationPlacePart();

        //then
        String expectedResult = "SHARDA, R. and TURBAN, E. (2015) Business intelligence: a managerial perspective on analytics. London: Pearson Education.";

        assertEquals(expectedResult, resultReference);
    }

    @Test
    public void shouldPassReferencingBookWithThreeAuthorsAndWithoutChapterAndEdition() {
        //given
        List<Author> authors = Arrays.asList(
                new Author("Ramon", null, "Sharda"),
                new Author("Daniel", null, "Delen"),
                new Author("Elen", null, "Turban"));
        Book book = Book.builder()
                .authors(authors)
                .title("Business intelligence: a managerial perspective on analytics")
                .year("2015")
                .edition("1")
                .publicationPlace("London")
                .publisher("Pearson Education")
                .isWithChapter(false)
                .build();

        //when
        BookResponse bookResponse = bookService.createReference(book);
        String resultReference = "";
        resultReference += bookResponse.getAuthorsPart();
        resultReference += bookResponse.getYearPart();
        resultReference += bookResponse.getBookTitlePart();
        resultReference += bookResponse.getPublisherAndPublicationPlacePart();

        //then
        String expectedResult = "SHARDA, R., DELEN, D. and TURBAN, E. (2015) Business intelligence: a managerial perspective on analytics. London: Pearson Education.";

        assertEquals(expectedResult, resultReference);
    }

    @Test
    public void shouldPassReferencingBookWithMoreThanThreeAuthorsAndWithoutChapterAndEdition() {
        //given
        List<Author> authors = Arrays.asList(
                new Author("Hubert", null, "Karau"),
                new Author("Daniel", null, "Delen"),
                new Author("Elen", null, "Turban"),
                new Author("Marek", null, "Radclife"));
        Book book = Book.builder()
                .authors(authors)
                .title("Learning Spark")
                .year("2015")
                .edition("1")
                .publicationPlace("Sebastopol, Ca")
                .publisher("O’Reilly")
                .isWithChapter(false)
                .build();

        //when
        BookResponse bookResponse = bookService.createReference(book);
        String resultReference = "";
        resultReference += bookResponse.getAuthorsPart();
        resultReference += bookResponse.getYearPart();
        resultReference += bookResponse.getBookTitlePart();
        resultReference += bookResponse.getPublisherAndPublicationPlacePart();

        //then
        String expectedResult = "KARAU, H. et al. (2015) Learning Spark. Sebastopol, Ca: O’Reilly.";

        assertEquals(expectedResult, resultReference);
    }

    @Test
    public void shouldPassReferencingBookWithOneEditorAndWithoutChapterAndEdition() {
        //given
        List<Editor> editors = Arrays.asList(new Editor("Alan", null, "Furse"));
        Book book = Book.builder()
                .editors(editors)
                .title("Theatre in pieces: politics, poetics and interdisciplinary collaboration: an anthology of play texts 1966-2010")
                .year("2011")
                .publicationPlace("London")
                .publisher("Methuen Drama")
                .isWithChapter(false)
                .build();

        //when
        BookResponse bookResponse = bookService.createReference(book);
        String resultReference = "";
        resultReference += bookResponse.getEditorsPart();
        resultReference += bookResponse.getYearPart();
        resultReference += bookResponse.getBookTitlePart();
        resultReference += bookResponse.getPublisherAndPublicationPlacePart();

        //then
        String expectedResult = "FURSE, A. (ed.) (2011) Theatre in pieces: politics, poetics and interdisciplinary collaboration: an anthology of play texts 1966-2010. London: Methuen Drama.";

        assertEquals(expectedResult, resultReference);
    }

    @Test
    public void shouldPassReferencingBookWithTwoEditorsAndWithoutChapterAndEdition() {
        //given
        List<Editor> editors = Arrays.asList(new Editor("Alan", null, "Furse"),
                                             new Editor("Hans", null, "Schurk"));
        Book book = Book.builder()
                .editors(editors)
                .title("Theatre in pieces: politics, poetics and interdisciplinary collaboration: an anthology of play texts 1966-2010")
                .year("2011")
                .publicationPlace("London")
                .publisher("Methuen Drama")
                .isWithChapter(false)
                .build();

        //when
        BookResponse bookResponse = bookService.createReference(book);
        String resultReference = "";
        resultReference += bookResponse.getEditorsPart();
        resultReference += bookResponse.getYearPart();
        resultReference += bookResponse.getBookTitlePart();
        resultReference += bookResponse.getPublisherAndPublicationPlacePart();

        //then
        String expectedResult = "FURSE, A. and SCHURK, H. (eds.) (2011) Theatre in pieces: politics, poetics and interdisciplinary collaboration: an anthology of play texts 1966-2010. London: Methuen Drama.";

        assertEquals(expectedResult, resultReference);
    }

    @Test
    public void shouldPassReferencingBookWithThreeEditorsAndWithoutChapterAndEdition() {
        //given
        List<Editor> editors = Arrays.asList(new Editor("Alan", null, "Furse"),
                                             new Editor("Hans", null, "Schurk"),
                                             new Editor("Jan", null, "Kowalski"));
        Book book = Book.builder()
                .editors(editors)
                .title("Theatre in pieces: politics, poetics and interdisciplinary collaboration: an anthology of play texts 1966-2010")
                .year("2011")
                .publicationPlace("London")
                .publisher("Methuen Drama")
                .isWithChapter(false)
                .build();

        //when
        BookResponse bookResponse = bookService.createReference(book);
        String resultReference = "";
        resultReference += bookResponse.getEditorsPart();
        resultReference += bookResponse.getYearPart();
        resultReference += bookResponse.getBookTitlePart();
        resultReference += bookResponse.getPublisherAndPublicationPlacePart();

        //then
        String expectedResult = "FURSE, A., SCHURK, H. and KOWALSKI, J. (eds.) (2011) Theatre in pieces: politics, poetics and interdisciplinary collaboration: an anthology of play texts 1966-2010. London: Methuen Drama.";

        assertEquals(expectedResult, resultReference);
    }


    @Test
    public void shouldPassReferencingBookWithOneAuthorAndTwoEditorsAndWithChapterAndPagesWithoutAndEdition() {
        List<Author> authors = Arrays.asList(new Author("Hans", null, "Schurk"));
        List<Editor> editors = Arrays.asList(new Editor("Cyran", null, "Perren"),
                                             new Editor("Marian", null, "Mlecek"));
        Book book = Book.builder()
                .authors(authors)
                .editors(editors)
                .title("Perception in architecture: here and now")
                .chapterTitle("Manipulations in imagined space")
                .year("2015")
                .publicationPlace("Newcastle upon Tyne")
                .publisher("Cambridge Scholars Publishing")
                .pages("78-85")
                .isWithChapter(true)
                .build();

        //when
        BookResponse bookResponse = bookService.createReference(book);
        String resultReference = "";
        resultReference += bookResponse.getAuthorsPart();
        resultReference += bookResponse.getYearPart();
        resultReference += bookResponse.getChapterTitlePartWithEditors();
        resultReference += bookResponse.getBookTitlePart();
        resultReference += bookResponse.getPublisherAndPublicationPlacePart();
        resultReference += bookResponse.getPagesPart();


        //then
        String expectedResult = "SCHURK, H. (2015) Manipulations in imagined space. In: PERREN, C. and MLECEK, M. (eds.) Perception in architecture: here and now. Newcastle upon Tyne: Cambridge Scholars Publishing, pp. 78-85.";

        assertEquals(expectedResult, resultReference);
    }


}
