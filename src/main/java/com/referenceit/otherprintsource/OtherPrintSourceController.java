package com.referenceit.otherprintsource;

import com.referenceit.otherprintsource.britishstandard.BritishStandardDto;
import com.referenceit.otherprintsource.britishstandard.BritishStandardService;
import com.referenceit.otherprintsource.conferenceproceeding.ConferenceProceedingDto;
import com.referenceit.otherprintsource.conferenceproceeding.ConferenceProceedingService;
import com.referenceit.otherprintsource.dictionaryencyclopaedia.DictAndEncyDto;
import com.referenceit.otherprintsource.dictionaryencyclopaedia.DictAndEncyService;
import com.referenceit.otherprintsource.exhibition.ExhibitionDto;
import com.referenceit.otherprintsource.exhibition.ExhibitionService;
import com.referenceit.otherprintsource.governmentpublication.GovernmentPublicationDto;
import com.referenceit.otherprintsource.governmentpublication.GovernmentPublicationService;
import com.referenceit.otherprintsource.legislation.LegislationDto;
import com.referenceit.otherprintsource.legislation.LegislationService;
import com.referenceit.otherprintsource.marketreport.MarketReportDto;
import com.referenceit.otherprintsource.marketreport.MarketReportService;
import com.referenceit.otherprintsource.musicscore.MusicScoreDto;
import com.referenceit.otherprintsource.musicscore.MusicScoreService;
import com.referenceit.otherprintsource.theseanddissertation.TheseAndDissertationDto;
import com.referenceit.otherprintsource.theseanddissertation.TheseAndDissertationService;
import com.referenceit.reference.ReferenceResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/otherprintsource")
public class OtherPrintSourceController {

    private BritishStandardService britishStandardService;
    private ConferenceProceedingService conferenceProceedingService;
    private GovernmentPublicationService governmentPublicationService;
    private LegislationService legislationService;
    private ExhibitionService exhibitionService;
    private MusicScoreService musicScoreService;
    private DictAndEncyService dictAndEncyService;
    private MarketReportService marketReportService;
    private TheseAndDissertationService theseAndDissertationService;


    @PostMapping("/britishstandard/create")
    public ReferenceResponse generateBritishStandardReference(@RequestBody BritishStandardDto britishStandardDto) {
        return britishStandardService.generateReference(britishStandardDto);
    }

    @PostMapping("conferenceproceeding/create")
    public ReferenceResponse generateConferenceProceedingReference(@RequestBody ConferenceProceedingDto conferenceProceedingDto) {
        return conferenceProceedingService.generateReference(conferenceProceedingDto);
    }

    @PostMapping("/dictionaryandencyclopaedia/creat")
    public ReferenceResponse generateDictAndEncyReference(@RequestBody DictAndEncyDto dictAndEncyDto) {
        return dictAndEncyService.generateReference(dictAndEncyDto);
    }

    @PostMapping("/exhibition/create")
    public ReferenceResponse generateExhibitionReference(@RequestBody ExhibitionDto exhibitionDto) {
        return exhibitionService.generateReference(exhibitionDto);
    }

    @PostMapping("/governmentpublication/create")
    public ReferenceResponse generateGovernmentPublicationReference(@RequestBody GovernmentPublicationDto governmentPublicationDto) {
        return governmentPublicationService.generateReference(governmentPublicationDto);
    }

    @PostMapping("/legislation/create")
    public ReferenceResponse generateLegislationReference(@RequestBody LegislationDto legislationDto) {
        return legislationService.generateReference(legislationDto);
    }

    @PostMapping("marketreport/create")
    public ReferenceResponse generateMarketReportResponse(@RequestBody MarketReportDto marketReportDto) {
        return marketReportService.generateReference(marketReportDto);
    }

    @PostMapping("/musicscore/create")
    public ReferenceResponse generateMusicScoreReference(@RequestBody MusicScoreDto musicScoreDto) {
        return musicScoreService.generateReference(musicScoreDto);
    }

    @PostMapping("theseanddissertation/create")
    public ReferenceResponse generateTheseAndDissertationResponse(@RequestBody TheseAndDissertationDto theseAndDissertationDto) {
        return theseAndDissertationService.generateReference(theseAndDissertationDto);
    }

}
