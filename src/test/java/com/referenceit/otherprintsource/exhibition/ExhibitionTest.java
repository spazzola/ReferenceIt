package com.referenceit.otherprintsource.exhibition;

import com.referenceit.reference.Author;
import com.referenceit.reference.ReferenceService;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExhibitionTest {

    private ExhibitionMapper exhibitionMapper = new ExhibitionMapper();
    private ReferenceService referenceService = new ReferenceService();
    private ExhibitionService exhibitionService = new ExhibitionService(exhibitionMapper, referenceService);

    public ExhibitionTest() {

    }


    @Test
    public void shouldPassReferencingExhibitionCatalogue() {
        //given
        List<Author> authors = Arrays.asList(new Author("Williams", null, "Harris"));
        ExhibitionDto exhibitionDto = ExhibitionDto.builder()
                .authors(authors)
                .year("1983")
                .title("William Harris as designer")
                .exhibitionCatalogue("")
                .isItemFromExhibition(false)
                .build();


        String expectedResult = "HARRIS, W. (1983) William Harris as designer. [Catalogue of an exhibition held at the Whitworth Art Gallery, 3 May – 4 June 1983] London: Arts Council.";
    }


    @Test
    public void shouldPassReferencingExhibitionItem() {
        //given
        List<Author> authors = Arrays.asList(new Author("Adam", null, "Calder"));
        ExhibitionDto exhibitionDto = ExhibitionDto.builder()
                .authors(authors)
                .year("c.1953")
                .title("Antennae with Red and Blue Dots")
                .itemType("Sculpture")
                .location("Tate Modern, London")
                .date("15th December 2015")
                .isItemFromExhibition(true)
                .build();

        //when
        ExhibitionResponse exhibitionResponse = exhibitionService.generateReference(exhibitionDto);
        String resultReference = "";
        resultReference += exhibitionResponse.getArtistAndYearPart();
        resultReference += exhibitionResponse.getTitlePart();
        resultReference += exhibitionResponse.getItemTypeLocationAndDate();

        //then
        String expectedResult = "CALDER, A. (c.1953) Antennae with Red and Blue Dots. [Sculpture] [Tate Modern, London, 15th December 2015].";

        assertEquals(expectedResult, resultReference);
    }

}
