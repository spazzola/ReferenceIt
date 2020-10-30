package com.referenceit.onlinesource.podcast;

import com.referenceit.reference.ReferenceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class PodcastService {

    private ReferenceService referenceService;
    private PodcastMapper podcastMapper;


    public PodcastResponse generateReference(PodcastDto podcastDto) {
        Podcast podcast = podcastMapper.fromDto(podcastDto);

        return createReference(podcast);
    }

    private PodcastResponse createReference(Podcast podcast) {
        PodcastResponse podcastResponse = new PodcastResponse();

        String author = referenceService.remakeAndAppendMultipleAuthors(podcast.getAuthors());
        String year = appendYear(podcast);
        podcastResponse.setAuthorAndYearPart(author + year);

        podcastResponse.setTitlePart(podcast.getTitle() + ". ");

        String publisher = "[Podcast] " + podcast.getPublisher() + ". ";
        String dayAndMonth = podcast.getDayAndMonth() + ". ";
        String availableFrom = "Available from: " + podcast.getAvailableFrom();
        String accessedDate = " [Accessed " + podcast.getAccessedDate() + "].";
        podcastResponse.setRestReferenceBodyPart(publisher + dayAndMonth + availableFrom + accessedDate);

        return podcastResponse;
    }

    private String appendYear(Podcast podcast) {
        return " (" + podcast.getYear() + ")";
    }

}
