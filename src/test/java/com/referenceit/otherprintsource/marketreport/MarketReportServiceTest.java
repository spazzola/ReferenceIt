package com.referenceit.otherprintsource.marketreport;

import com.referenceit.reference.ReferenceResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MarketReportServiceTest {

    @Autowired
    private MarketReportService marketReportService;


    @Test
    public void shouldPassReferencingMarketReport() {
        //given
        MarketReportDto marketReportDto = MarketReportDto.builder()
                .nameOfIssuingBody("Mintel")
                .year("2016")
                .title("Researching and buying technology products: Mintel marketing report")
                .date("June 2016")
                .edition(null)
                .publicationPlace("London")
                .publisher("Mintel International")
                .reportNumber(null)
                .build();


        //when
        ReferenceResponse referenceResponse = marketReportService.generateReference(marketReportDto);

        String expectedResult = "MINTEL (2016) Researching and buying technology products: Mintel marketing report, June 2016. London: Mintel International.";

        //then
        assertEquals(expectedResult, referenceResponse.toString());
    }

}
