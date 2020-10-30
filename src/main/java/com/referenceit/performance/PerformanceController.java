package com.referenceit.performance;

import com.referenceit.performance.dance.DanceDto;
import com.referenceit.performance.dance.DanceResponse;
import com.referenceit.performance.dance.DanceService;
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


    @PostMapping("/dance/create")
    public DanceResponse generateDanceReference(DanceDto danceDto) {
        return danceService.generateReference(danceDto);
    }

}
