package com.referenceit.otherprintsource;

import com.referenceit.otherprintsource.britishstandard.BritishStandardDto;
import com.referenceit.otherprintsource.britishstandard.BritishStandardResponse;
import com.referenceit.otherprintsource.britishstandard.BritishStandardService;
import com.referenceit.otherprintsource.conferenceproceeding.ConferenceProceedingDto;
import com.referenceit.otherprintsource.conferenceproceeding.ConferenceProceedingResponse;
import com.referenceit.otherprintsource.conferenceproceeding.ConferenceProceedingService;
import com.referenceit.otherprintsource.dictionaryencyclopaedia.DictAndEncyDto;
import com.referenceit.otherprintsource.dictionaryencyclopaedia.DictAndEncyResponse;
import com.referenceit.otherprintsource.dictionaryencyclopaedia.DictAndEncyService;
import com.referenceit.otherprintsource.exhibition.ExhibitionDto;
import com.referenceit.otherprintsource.exhibition.ExhibitionResponse;
import com.referenceit.otherprintsource.exhibition.ExhibitionService;
import com.referenceit.otherprintsource.governmentpublication.GovernmentPublicationDto;
import com.referenceit.otherprintsource.governmentpublication.GovernmentPublicationResponse;
import com.referenceit.otherprintsource.governmentpublication.GovernmentPublicationService;
import com.referenceit.otherprintsource.legislation.LegislationDto;
import com.referenceit.otherprintsource.legislation.LegislationResponse;
import com.referenceit.otherprintsource.legislation.LegislationService;
import com.referenceit.otherprintsource.marketreport.MarketReportDto;
import com.referenceit.otherprintsource.marketreport.MarketReportResponse;
import com.referenceit.otherprintsource.marketreport.MarketReportService;
import com.referenceit.otherprintsource.musicscore.MusicScoreDto;
import com.referenceit.otherprintsource.musicscore.MusicScoreResponse;
import com.referenceit.otherprintsource.musicscore.MusicScoreService;
import com.referenceit.otherprintsource.theseanddissertation.TheseAndDissertationDto;
import com.referenceit.otherprintsource.theseanddissertation.TheseAndDissertationResponse;
import com.referenceit.otherprintsource.theseanddissertation.TheseAndDissertationService;
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
    public BritishStandardResponse generateBritishStandardReference(@RequestBody BritishStandardDto britishStandardDto) {
        return britishStandardService.generateReference(britishStandardDto);
    }

    @PostMapping("conferenceproceeding/create")
    public ConferenceProceedingResponse generateConferenceProceedingReference(@RequestBody ConferenceProceedingDto conferenceProceedingDto) {
        return conferenceProceedingService.generateReference(conferenceProceedingDto);
    }

    @PostMapping("/dictionaryandencyclopaedia/creat")
    public DictAndEncyResponse generateDictAndEncyReference(@RequestBody DictAndEncyDto dictAndEncyDto) {
        return dictAndEncyService.generateReference(dictAndEncyDto);
    }

    @PostMapping("/exhibition/create")
    public ExhibitionResponse generateExhibitionReference(@RequestBody ExhibitionDto exhibitionDto) {
        return exhibitionService.generateReference(exhibitionDto);
    }

    @PostMapping("/governmentpublication/create")
    public GovernmentPublicationResponse generateGovernmentPublicationReference(@RequestBody GovernmentPublicationDto governmentPublicationDto) {
        return governmentPublicationService.generateReference(governmentPublicationDto);
    }

    @PostMapping("/legislation/create")
    public LegislationResponse generateLegislationReference(@RequestBody LegislationDto legislationDto) {
        return legislationService.generateReference(legislationDto);
    }

    @PostMapping("marketreport/create")
    public MarketReportResponse generateMarketReportResponse(@RequestBody MarketReportDto marketReportDto) {
        return marketReportService.generateReference(marketReportDto);
    }

    @PostMapping("/musicscore/create")
    public MusicScoreResponse generateMusicScoreReference(@RequestBody MusicScoreDto musicScoreDto) {
        return musicScoreService.generateReference(musicScoreDto);
    }

    @PostMapping("theseanddissertation/create")
    public TheseAndDissertationResponse generateTheseAndDissertationResponse(@RequestBody TheseAndDissertationDto theseAndDissertationDto) {
        return theseAndDissertationService.generateReference(theseAndDissertationDto);
    }

}
