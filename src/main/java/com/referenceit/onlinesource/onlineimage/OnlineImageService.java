package com.referenceit.onlinesource.onlineimage;

import com.referenceit.reference.ReferenceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class OnlineImageService {

    private ReferenceService referenceService;
    private OnlineImageMapper onlineImageMapper;


    public OnlineImageResponse generateReference(OnlineImageDto onlineImageDto) {
        OnlineImage onlineImage = onlineImageMapper.fromDto(onlineImageDto);

        return createReference(onlineImage);
    }

    private OnlineImageResponse createReference(OnlineImage onlineImage) {
        OnlineImageResponse onlineImageResponse = new OnlineImageResponse();

        String author = referenceService.remakeAndAppendMultipleAuthors(onlineImage.getAuthors());
        String year = appendYear(onlineImage);
        onlineImageResponse.setAuthorAndYearPart(author + year);

        onlineImageResponse.setTitlePart(onlineImage.getTitle() + ". ");

        String availableFrom = "[Online image] Available from: " + onlineImage.getAvailableFrom();
        String accessedDate = " [Accessed " + onlineImage.getAccessedDate() + "].";
        onlineImageResponse.setRestReferenceBodyPart(availableFrom + accessedDate);

        return onlineImageResponse;
    }

    private String appendYear(OnlineImage onlineImage) {
        return " (" + onlineImage.getYear() + ") ";
    }

}
