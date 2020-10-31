package com.referenceit.otherprintsource.britishstandard;

import com.referenceit.reference.ReferenceResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class BritishStandardServiceTest {

    @Autowired
    private BritishStandardService britishStandardService;


    @Test
    public void shouldPassReferencingBritishStandard() {
        //given
        String authorisingOrganisationName = "British standards institute";
        String year = "2016";
        String titleOfStandard = "BS ISO 6626-1: Internal Combustion engines. Piston rings. Part 1 Coil-spring-loaded oil control rings made of cast iron";
        String publicationPlace = "London";
        String publisher = "British Standards Institute";

        BritishStandardDto britishStandardDto = BritishStandardDto.builder()
                .authorisingOrganisationName(authorisingOrganisationName)
                .year(year)
                .titleOfStandard(titleOfStandard)
                .publicationPlace(publicationPlace)
                .publisher(publisher)
                .build();

        //when
        ReferenceResponse referenceResponse = britishStandardService.generateReference(britishStandardDto);

        String expectedResult = "BRITISH STANDARDS INSTITUTE (2016) BS ISO 6626-1: Internal Combustion engines. Piston rings. Part 1 Coil-spring-loaded oil control rings made of cast iron. London: British Standards Institute.";

        //then
        assertEquals(expectedResult, referenceResponse.toString());

    }

}