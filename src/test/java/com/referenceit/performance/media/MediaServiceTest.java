package com.referenceit.performance.media;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MediaServiceTest {

    @Autowired
    private MediaService mediaService;


    @Test
    public void shouldPassReferencingMediaTypeVideo() {
        //given
        MediaDto mediaDto = MediaDto.builder()
                .referenceType("video")
                .title("Rebel without a cause")
                .year("1983")
                .mediaType("Film")
                .directorName("NICHOLAS RAY")
                .productionPlace("USA")
                .productionCompany("Warner Bros")
                .build();

        //when
        MediaResponse mediaResponse = mediaService.generateReference(mediaDto);
        String referenceResult = "";
        referenceResult += mediaResponse.getTitlePart();
        referenceResult += mediaResponse.getRestReferenceBodyPart();

        //then
        String expectedResult = "Rebel without a cause. (1983) [Film] Directed by NICHOLAS RAY. USA: Warner Bros.";

        assertEquals(expectedResult, referenceResult);
    }

    @Test
    public void shouldPassReferencingMediaTypeBroadcastWithoutEpisodeNumberAndWithEpisodeName() {
        //given
        MediaDto mediaDto = MediaDto.builder()
                .referenceType("broadcast")
                .title("Panorama")
                .year("2016")
                .mediaType("TV")
                .episodeName("Antibiotic crisis")
                .channel("Bbc2")
                .broadcastDate("23rd May")
                .broadcastTime("2030")
                .build();

        //when
        MediaResponse mediaResponse = mediaService.generateReference(mediaDto);
        String referenceResult = "";
        referenceResult += mediaResponse.getTitlePart();
        referenceResult += mediaResponse.getRestReferenceBodyPart();

        //then
        String expectedResult = "Panorama. (2016) Antibiotic crisis. [TV] BBC2. 23rd May, 2030 hrs.";

        assertEquals(expectedResult, referenceResult);
    }

    @Test
    public void shouldPassReferencingMediaTypeBroadcastWithEpisodeNumberAndWithEpisodeName() {
        //given
        MediaDto mediaDto = MediaDto.builder()
                .referenceType("broadcast")
                .title("Doctor Who")
                .year("2015")
                .mediaType("TV")
                .episodeName("Hell bent")
                .episodeNumber("12")
                .channel("Bbc1")
                .broadcastDate("5th December")
                .broadcastTime("2000")
                .build();

        //when
        MediaResponse mediaResponse = mediaService.generateReference(mediaDto);
        String referenceResult = "";
        referenceResult += mediaResponse.getTitlePart();
        referenceResult += mediaResponse.getRestReferenceBodyPart();

        //then
        String expectedResult = "Doctor Who. (2015) Episode 12, Hell bent. [TV] BBC1. 5th December, 2000 hrs.";

        assertEquals(expectedResult, referenceResult);
    }


}
