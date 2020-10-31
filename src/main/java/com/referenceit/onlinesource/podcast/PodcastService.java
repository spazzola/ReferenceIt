package com.referenceit.onlinesource.podcast;

import com.referenceit.reference.ReferenceResponse;
import com.referenceit.reference.ReferenceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class PodcastService {

    private ReferenceService referenceService;
    private PodcastMapper podcastMapper;


    public ReferenceResponse generateReference(PodcastDto podcastDto) {
        Podcast podcast = podcastMapper.fromDto(podcastDto);

        return createReference(podcast);
    }

    private ReferenceResponse createReference(Podcast podcast) {
        ReferenceResponse referenceResponse = new ReferenceResponse();

        String author = referenceService.remakeAndAppendMultipleAuthors(podcast.getAuthors());
        String year = appendYear(podcast);
        referenceResponse.setFirstPartNormal(author + year);

        referenceResponse.setItalicsPart(podcast.getTitle() + ". ");

        String publisher = "[Podcast] " + podcast.getPublisher() + ". ";
        String dayAndMonth = podcast.getDayAndMonth() + ". ";
        String availableFrom = "Available from: " + podcast.getAvailableFrom();
        String accessedDate = " [Accessed " + podcast.getAccessedDate() + "].";
        referenceResponse.setThirdPartNormal(publisher + dayAndMonth + availableFrom + accessedDate);

        return referenceResponse;
    }

    private String appendYear(Podcast podcast) {
        return " (" + podcast.getYear() + ")";
    }

}
