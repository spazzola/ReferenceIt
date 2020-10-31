package com.referenceit.performance;

import com.referenceit.performance.dance.DanceDto;
import com.referenceit.performance.dance.DanceResponse;
import com.referenceit.performance.dance.DanceService;
import com.referenceit.performance.media.MediaDto;
import com.referenceit.performance.media.MediaService;
import com.referenceit.performance.plays.PlaysDto;
import com.referenceit.performance.plays.PlaysService;
import com.referenceit.reference.ReferenceResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/performance")
public class PerformanceController {

    private DanceService danceService;
    private PlaysService playsService;
    private MediaService mediaService;


    @PostMapping("/dance/create")
    public ReferenceResponse generateDanceReference(DanceDto danceDto) {
        return danceService.generateReference(danceDto);
    }

    @PostMapping("/plays/create")
    public ReferenceResponse generatePlaysReference(PlaysDto playsDto) {
        return playsService.generateReference(playsDto);
    }

    @PostMapping("/media/create")
    public ReferenceResponse generateMediaReference(MediaDto mediaDto) {
        return mediaService.generateReference(mediaDto);
    }

}
