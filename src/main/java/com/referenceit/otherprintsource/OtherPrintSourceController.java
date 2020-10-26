package com.referenceit.otherprintsource;

import com.referenceit.otherprintsource.britishstandard.BritishStandardDto;
import com.referenceit.otherprintsource.britishstandard.BritishStandardResponse;
import com.referenceit.otherprintsource.britishstandard.BritishStandardService;
import com.referenceit.otherprintsource.conferenceproceeding.ConferenceProceedingDto;
import com.referenceit.otherprintsource.conferenceproceeding.ConferenceProceedingResponse;
import com.referenceit.otherprintsource.conferenceproceeding.ConferenceProceedingService;
import com.referenceit.otherprintsource.exhibition.ExhibitionDto;
import com.referenceit.otherprintsource.exhibition.ExhibitionResponse;
import com.referenceit.otherprintsource.exhibition.ExhibitionService;
import com.referenceit.otherprintsource.governmentpublication.GovernmentPublicationDto;
import com.referenceit.otherprintsource.governmentpublication.GovernmentPublicationResponse;
import com.referenceit.otherprintsource.governmentpublication.GovernmentPublicationService;
import com.referenceit.otherprintsource.legislation.LegislationDto;
import com.referenceit.otherprintsource.legislation.LegislationResponse;
import com.referenceit.otherprintsource.legislation.LegislationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController("/otherprintsource")
public class OtherPrintSourceController {

    private BritishStandardService britishStandardService;
    private ConferenceProceedingService conferenceProceedingService;
    private GovernmentPublicationService governmentPublicationService;
    private LegislationService legislationService;
    private ExhibitionService exhibitionService;


    @PostMapping("/britishstandard/create")
    public BritishStandardResponse generateBritishStandardReference(@RequestBody BritishStandardDto britishStandardDto) {
        return britishStandardService.generateReference(britishStandardDto);
    }

    @PostMapping("conferenceproceeding/create")
    public ConferenceProceedingResponse generateConferenceProceedingReference(@RequestBody ConferenceProceedingDto conferenceProceedingDto) {
        return conferenceProceedingService.generateReference(conferenceProceedingDto);
    }

    @PostMapping("/governmentpublication/create")
    public GovernmentPublicationResponse generateGovernmentPublicationReference(@RequestBody GovernmentPublicationDto governmentPublicationDto) {
        return governmentPublicationService.generateReference(governmentPublicationDto);
    }

    @PostMapping
    public ExhibitionResponse generateExhibitionReference(@RequestBody ExhibitionDto exhibitionDto) {
        return exhibitionService.generateReference(exhibitionDto);
    }

    @PostMapping("/legislation/create")
    public LegislationResponse generateLegislationReference(@RequestBody LegislationDto legislationDto) {
        return legislationService.generateReference(legislationDto);
    }
}
