package com.referenceit.onlinesource.lecturenote;

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
public class LectureNoteServiceTest {

    @Autowired
    private LectureNoteService lectureNoteService;


    @Test
    public void shouldPassReferencingLectureNote() {
        //given
        List<Author> authors = Arrays.asList(new Author("Symen", "Marian", "Hall"));

        //when
        LectureNoteDto lectureNoteDto = LectureNoteDto.builder()
                .authors(authors)
                .year("2012")
                .title(" Critical analysis- meta-analysis & systematic reviews")
                .moduleCode("PHAR3504")
                .moduleName("Practitioner and patient")
                .teachingOrganisation("De Montfort University")
                .location("Hawthorn Building")
                .date("22nd November")
                .accessedDate("17/07/13")
                .build();

        LectureNoteResponse lectureNoteResponse = lectureNoteService.generateReference(lectureNoteDto);
        String referenceResult = "";
        referenceResult += lectureNoteResponse.getAuthorAndYearPart();
        referenceResult += lectureNoteResponse.getTitlePart();
        referenceResult += lectureNoteResponse.getRestReferenceBodyPart();

        //then
        String expectedResult = "HALL, S.M. (2012) Critical analysis- meta-analysis & systematic reviews, " +
                "from PHAR3504 Practitioner and patient. De Montfort University, Hawthorn Building on 22nd November. Available from Blackboard [Accessed 17/07/13].";

        assertEquals(expectedResult, referenceResult);
    }

}
