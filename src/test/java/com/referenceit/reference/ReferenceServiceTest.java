package com.referenceit.reference;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReferenceServiceTest {

    private ReferenceService referenceService = new ReferenceService();

    public ReferenceServiceTest() {

    }


    @Test
    public void shouldPassRemakeOneAuthorWithOneName() {
        //given
        List<Author> authors = Arrays.asList(new Author("Pamon", null, "Aldrick"));

        //when
        String authorsPart = referenceService.remakeAndAppendMultipleAuthors(authors);
        String expectedResult = "ALDRICK, P.";
        //then

        assertEquals(expectedResult, authorsPart);
    }

    @Test
    public void shouldPassRemakeTwoAuthorsWithOneName() {
        //given
        List<Author> authors = Arrays.asList(new Author("Daniel", "Karol", "Maimon"),
                                             new Author("Chrystian", "Mark", "Larens"));

        //when
        String authorsPart = referenceService.remakeAndAppendMultipleAuthors(authors);
        String expectedResult = "MAIMON, D.K. and LARENS, C.M.";
        //then

        assertEquals(expectedResult, authorsPart);
    }

    @Test
    public void shouldPassRemakeThreeAuthorsWithOneName() {
        //given
        List<Author> authors = Arrays.asList(new Author("Daniel", "Karol", "Maimon"),
                                             new Author("Chrystian", "Mark", "Larens"),
                                             new Author("Paul", "Yens", "Ralph"));

        //when
        String authorsPart = referenceService.remakeAndAppendMultipleAuthors(authors);
        String expectedResult = "MAIMON, D.K., LARENS, C.M. and RALPH, P.Y.";
        //then

        assertEquals(expectedResult, authorsPart);
    }

    @Test
    public void shouldPassRemakeFourAuthorsWithOneName() {
        //given
        List<Author> authors = Arrays.asList(
                new Author("Hubert", null, "Karau"),
                new Author("Daniel", null, "Delen"),
                new Author("Elen", null, "Turban"),
                new Author("Marek", null, "Radclife"));

        //when
        String authorsPart = referenceService.remakeAndAppendMultipleAuthors(authors);
        String expectedResult = "KARAU, H. et al.";
        //then

        assertEquals(expectedResult, authorsPart);
    }

    @Test
    public void shouldPassRemakeOneAuthorWithTwoNames() {
        //given
        List<Author> authors = Arrays.asList(new Author("Pamon", "Mark", "Aldrick"));

        //when
        String authorsPart = referenceService.remakeAndAppendMultipleAuthors(authors);
        String expectedResult = "ALDRICK, P.M.";
        //then

        assertEquals(expectedResult, authorsPart);
    }

    @Test
    public void shouldPassRemakeTwoAuthorsWithTwoNames() {
        //given
        List<Author> authors = Arrays.asList(new Author("Daniel", "Karol", "Maimon"),
                                             new Author("Chrystian", "Mark", "Larens"));

        //when
        String authorsPart = referenceService.remakeAndAppendMultipleAuthors(authors);
        String expectedResult = "MAIMON, D.K. and LARENS, C.M.";
        //then

        assertEquals(expectedResult, authorsPart);
    }

    @Test
    public void shouldPassRemakeThreeAuthorsWithTwoNames() {
        //given
        List<Author> authors = Arrays.asList(new Author("Daniel", "Karol", "Maimon"),
                                             new Author("Chrystian", "Mark", "Larens"),
                                             new Author("Paul", "Yens", "Ralph"));

        //when
        String authorsPart = referenceService.remakeAndAppendMultipleAuthors(authors);
        String expectedResult = "MAIMON, D.K., LARENS, C.M. and RALPH, P.Y.";
        //then

        assertEquals(expectedResult, authorsPart);
    }


}
