package com.referenceit.otherprintsource;

import com.referenceit.otherprintsource.britishstandard.BritishStandardDto;
import com.referenceit.otherprintsource.britishstandard.BritishStandardResponse;
import com.referenceit.otherprintsource.britishstandard.BritishStandardService;
import com.referenceit.otherprintsource.conferenceproceeding.ConferenceProceedingDto;
import com.referenceit.otherprintsource.conferenceproceeding.ConferenceProceedingResponse;
import com.referenceit.otherprintsource.conferenceproceeding.ConferenceProceedingService;
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


    @PostMapping("/britishstandard/create")
    public BritishStandardResponse generateBritishStandardReference(@RequestBody BritishStandardDto britishStandardDto) {
        return britishStandardService.generateReference(britishStandardDto);
    }

    @PostMapping("conferenceproceeding/create")
    public ConferenceProceedingResponse generateConferenceProceedingReference(@RequestBody ConferenceProceedingDto conferenceProceedingDto) {
        return conferenceProceedingService.generateReference(conferenceProceedingDto);
    }

}
