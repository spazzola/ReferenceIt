package com.referenceit.onlinesource;

import com.referenceit.onlinesource.blog.BlogDto;
import com.referenceit.onlinesource.blog.BlogResponse;
import com.referenceit.onlinesource.blog.BlogService;
import com.referenceit.onlinesource.computergame.ComputerGameDto;
import com.referenceit.onlinesource.computergame.ComputerGameResponse;
import com.referenceit.onlinesource.computergame.ComputerGameService;
import com.referenceit.onlinesource.email.EmailDto;
import com.referenceit.onlinesource.email.EmailResponse;
import com.referenceit.onlinesource.email.EmailService;
import com.referenceit.onlinesource.financialreport.FinancialReportDto;
import com.referenceit.onlinesource.financialreport.FinancialReportResponse;
import com.referenceit.onlinesource.financialreport.FinancialReportService;
import com.referenceit.onlinesource.marketresearch.MarketResearchDto;
import com.referenceit.onlinesource.marketresearch.MarketResearchResponse;
import com.referenceit.onlinesource.marketresearch.MarketResearchService;
import com.referenceit.onlinesource.onlinefilm.OnlineFilmDto;
import com.referenceit.onlinesource.onlinefilm.OnlineFilmResponse;
import com.referenceit.onlinesource.onlinefilm.OnlineFilmService;
import com.referenceit.onlinesource.onlineimage.OnlineImageDto;
import com.referenceit.onlinesource.onlineimage.OnlineImageResponse;
import com.referenceit.onlinesource.onlineimage.OnlineImageService;
import com.referenceit.onlinesource.podcast.PodcastDto;
import com.referenceit.onlinesource.podcast.PodcastResponse;
import com.referenceit.onlinesource.podcast.PodcastService;
import com.referenceit.onlinesource.socialmedia.SocialMediaDto;
import com.referenceit.onlinesource.socialmedia.SocialMediaResponse;
import com.referenceit.onlinesource.socialmedia.SocialMediaService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/onlinesource")
public class OnlineSourceController {

    private BlogService blogService;
    private ComputerGameService computerGameService;
    private EmailService emailService;
    private FinancialReportService financialReportService;
    private MarketResearchService marketResearchService;
    private OnlineFilmService onlineFilmService;
    private OnlineImageService onlineImageService;
    private PodcastService podcastService;
    private SocialMediaService socialMediaService;


    @PostMapping("/blog/create")
    public BlogResponse generateBlogResponse(@RequestBody BlogDto blogDto) {
        return blogService.generateReference(blogDto);
    }

    @PostMapping("/computergame/create")
    public ComputerGameResponse generateComputerGameReference(@RequestBody ComputerGameDto computerGameDto) {
        return computerGameService.generateReference(computerGameDto);
    }

    @PostMapping("/email/create")
    public EmailResponse generateEmailReference(@RequestBody EmailDto emailDto) {
        return emailService.generateReference(emailDto);
    }

    @PostMapping("/financialreport/create")
    public FinancialReportResponse generateFinancialReportReference(@RequestBody FinancialReportDto financialReportDto) {
        return financialReportService.generateReference(financialReportDto);
    }

    @PostMapping("/marketresearch/create")
    public MarketResearchResponse generateMarketResearchReference(@RequestBody MarketResearchDto marketResearchDto) {
        return marketResearchService.generateReference(marketResearchDto);
    }

    @PostMapping("/onlinefilm/create")
    public OnlineFilmResponse generateOnlineFilmReference(@RequestBody OnlineFilmDto onlineFilmDto) {
        return onlineFilmService.generateReference(onlineFilmDto);
    }

    @PostMapping("/onlineimage/create")
    public OnlineImageResponse generateOnlineImageReference(@RequestBody OnlineImageDto onlineImageDto) {
        return onlineImageService.generateReference(onlineImageDto);
    }

    @PostMapping("/podcast/create")
    public PodcastResponse generatePodcastReference(@RequestBody PodcastDto podcastDto) {
        return podcastService.generateReference(podcastDto);
    }

    @PostMapping("/socialmedia/create")
    public SocialMediaResponse generateSocialMediaReference(@RequestBody SocialMediaDto socialMediaDto) {
        return socialMediaService.generateReference(socialMediaDto);
    }

}
