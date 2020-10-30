package com.referenceit.onlinesource.systematicreview;

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
public class SystematicReviewServiceTest {

    @Autowired
    private SystematicReviewService systematicReviewService;


    @Test
    public void shouldPassReferencingSystematicReview() {
        //given
        List<Author> authors = Arrays.asList(
                new Author("Norbert", "Hulk", "Grant"),
                new Author("Daniel", null, "Delen"),
                new Author("Elen", null, "Turban"),
                new Author("Marek", null, "Radclife"));

        SystematicReviewDto systematicReviewDto = SystematicReviewDto.builder()
                .authors(authors)
                .year("2013")
                .reviewTitle("Elective preterm birth for fetal gastroschisis")
                .sourceTitle("Cochrane Database of Systematic Reviews")
                .issueNumber("6")
                .accessedDate("17/07/13")
                .build();

        //when
        SystematicReviewResponse systematicReviewResponse = systematicReviewService.generateReference(systematicReviewDto);
        String referenceResult = "";
        referenceResult += systematicReviewResponse.getAuthorYearAndReviewTitlePart();
        referenceResult += systematicReviewResponse.getSourceTitlePart();
        referenceResult += systematicReviewResponse.getIssueAndDatePart();

        //then
        String expectedResult = "GRANT, N.H. et al. (2013) Elective preterm birth for fetal gastroschisis. " +
                "[Systematic review] Cochrane Database of Systematic Reviews, Issue 6. [Accessed 17/07/13].";

        assertEquals(expectedResult, referenceResult);
    }

}
