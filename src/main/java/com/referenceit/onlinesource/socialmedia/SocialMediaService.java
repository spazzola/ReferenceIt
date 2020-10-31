package com.referenceit.onlinesource.socialmedia;

import com.referenceit.reference.ReferenceResponse;
import com.referenceit.reference.ReferenceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class SocialMediaService {

    private ReferenceService referenceService;
    private SocialMediaMapper socialMediaMapper;


    public ReferenceResponse generateReference(SocialMediaDto socialMediaDto) {
        SocialMedia socialMedia = socialMediaMapper.fromDto(socialMediaDto);

        return createReference(socialMedia);
    }

    private ReferenceResponse createReference(SocialMedia socialMedia) {
        ReferenceResponse referenceResponse = new ReferenceResponse();

        String author = referenceService.remakeAndAppendMultipleAuthors(socialMedia.getAuthors());
        String year = appendYear(socialMedia);
        referenceResponse.setFirstPartNormal(author + year);

        referenceResponse.setItalicsPart(socialMedia.getTitle() + ". ");

        String websiteTitle = "[" + socialMedia.getWebsiteTitle() + "] ";
        String dayAndMonth = socialMedia.getDayAndMonth() + ". ";
        String availableFrom = "Available from: " + socialMedia.getAvailableFrom();
        String accessedDate = " [Accessed " + socialMedia.getAccessedDate() + "].";
        referenceResponse.setThirdPartNormal(websiteTitle + dayAndMonth + availableFrom + accessedDate);

        return referenceResponse;
    }

    private String appendYear(SocialMedia socialMedia) {
        return " (" + socialMedia.getYear() + ") ";
    }

}
