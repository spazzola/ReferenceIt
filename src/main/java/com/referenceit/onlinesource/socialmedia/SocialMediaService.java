package com.referenceit.onlinesource.socialmedia;

import com.referenceit.reference.ReferenceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class SocialMediaService {

    private ReferenceService referenceService;
    private SocialMediaMapper socialMediaMapper;


    public SocialMediaResponse generateReference(SocialMediaDto socialMediaDto) {
        SocialMedia socialMedia = socialMediaMapper.fromDto(socialMediaDto);

        return createReference(socialMedia);
    }

    private SocialMediaResponse createReference(SocialMedia socialMedia) {
        SocialMediaResponse socialMediaResponse = new SocialMediaResponse();

        String author = referenceService.remakeAndAppendMultipleAuthors(socialMedia.getAuthors());
        String year = appendYear(socialMedia);
        socialMediaResponse.setAuthorAndYearPart(author + year);

        socialMediaResponse.setTitlePart(socialMedia.getTitle() + ". ");

        String websiteTitle = "[" + socialMedia.getWebsiteTitle() + "] ";
        String dayAndMonth = socialMedia.getDayAndMonth() + ". ";
        String availableFrom = "Available from: " + socialMedia.getAvailableFrom();
        String accessedDate = " [Accessed " + socialMedia.getAccessedDate() + "].";
        socialMediaResponse.setRestReferenceBodyPart(websiteTitle + dayAndMonth + availableFrom + accessedDate);

        return socialMediaResponse;
    }

    private String appendYear(SocialMedia socialMedia) {
        return " (" + socialMedia.getYear() + ") ";
    }

}
