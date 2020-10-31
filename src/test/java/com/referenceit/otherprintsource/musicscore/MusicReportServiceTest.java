package com.referenceit.otherprintsource.musicscore;

import com.referenceit.reference.Author;
import com.referenceit.reference.ReferenceResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MusicReportServiceTest {

    @Autowired
    private MusicScoreService musicScoreService;


    @Test
    public void shouldPassReferencingMusicScore() {
        //given
        List<Author> authors = Arrays.asList(new Author("James", "Syndi", "Bach"));
        MusicScoreDto musicScoreDto = MusicScoreDto.builder()
                .authors(authors)
                .year("1970")
                .title("Organ music")
                .publicationPlace("New York")
                .publisher("Dover Publications")
                .build();

        //when
        ReferenceResponse referenceResponse = musicScoreService.generateReference(musicScoreDto);

        //then
        String expectedResult = "BACH, J. S. (1970) Organ music. [Music score] New York: Dover Publications.";

        assertEquals(expectedResult, referenceResponse.toString());
    }

}
