package com.referenceit.onlinesource.podcast;

import com.referenceit.reference.Author;
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
public class PodcastServiceTest {

    @Autowired
    private PodcastService podcastService;


    @Test
    public void shouldPassReferencingPodcast() {
        //given
        List<Author> authors = Arrays.asList(new Author("Kevin", null, "Hopkin"));
        PodcastDto podcastDto = PodcastDto.builder()
                .authors(authors)
                .year("2008")
                .title(" The mythical daily water requirement")
                .publisher("Scientific American")
                .dayAndMonth("2nd April")
                .availableFrom("http://www.sciam.com/podcast/episode.cfm?id=0BD1CF72-E411-2EE5- A4CDEE3447E81C93")
                .accessedDate("19/06/13")
                .build();

        //when
        PodcastResponse podcastResponse = podcastService.generateReference(podcastDto);
        String referenceResult = "";
        referenceResult += podcastResponse.getAuthorAndYearPart();
        referenceResult += podcastResponse.getTitlePart();
        referenceResult += podcastResponse.getRestReferenceBodyPart();

        //then
        String expectedResult = "HOPKIN, K. (2008) The mythical daily water requirement. [Podcast] Scientific American. 2nd April. " +
                "Available from: http://www.sciam.com/podcast/episode.cfm?id=0BD1CF72-E411-2EE5- A4CDEE3447E81C93 [Accessed 19/06/13].";

        assertEquals(expectedResult, referenceResult);
    }

}
