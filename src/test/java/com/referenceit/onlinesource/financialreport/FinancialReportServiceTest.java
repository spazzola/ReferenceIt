package com.referenceit.onlinesource.financialreport;

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
public class FinancialReportServiceTest {

    @Autowired
    private FinancialReportService financialReportService;


    @Test
    public void shouldPassReferencingFinancialReport() {
        //given
        List<Author> authors = Arrays.asList(new Author(null, null, "BUREAU VAN DIJK"));
        FinancialReportDto financialReportDto = FinancialReportDto.builder()
                .authors(authors)
                .year("2020")
                .title("Next PLC company report")
                .availableFrom("https://fame.bvdinfo.com/version-2020423/fame/1/Companies/Report")
                .accessedDate("13/05/20")
                .build();


        //when
        FinancialReportResponse financialReportResponse = financialReportService.generateReference(financialReportDto);
        String referenceResult = "";
        referenceResult += financialReportResponse.getAuthorAndYearPart();
        referenceResult += financialReportResponse.getTitlePart();
        referenceResult += financialReportResponse.getRestReferenceBodyPart();

        //then
        String expectedResult = "BUREAU VAN DIJK (2020) Next PLC company report. [Online] " +
                "Available from: https://fame.bvdinfo.com/version-2020423/fame/1/Companies/Report [Accessed 13/05/20].";

        assertEquals(expectedResult, referenceResult);
    }

}
