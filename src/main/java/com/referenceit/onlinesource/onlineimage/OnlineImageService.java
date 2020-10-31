package com.referenceit.onlinesource.onlineimage;

import com.referenceit.reference.ReferenceResponse;
import com.referenceit.reference.ReferenceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class OnlineImageService {

    private ReferenceService referenceService;
    private OnlineImageMapper onlineImageMapper;


    public ReferenceResponse generateReference(OnlineImageDto onlineImageDto) {
        OnlineImage onlineImage = onlineImageMapper.fromDto(onlineImageDto);

        return createReference(onlineImage);
    }

    private ReferenceResponse createReference(OnlineImage onlineImage) {
        ReferenceResponse referenceResponse = new ReferenceResponse();

        String author = referenceService.remakeAndAppendMultipleAuthors(onlineImage.getAuthors());
        String year = appendYear(onlineImage);
        referenceResponse.setFirstPartNormal(author + year);

        referenceResponse.setItalicsPart(onlineImage.getTitle() + ". ");

        String availableFrom = "[Online image] Available from: " + onlineImage.getAvailableFrom();
        String accessedDate = " [Accessed " + onlineImage.getAccessedDate() + "].";
        referenceResponse.setThirdPartNormal(availableFrom + accessedDate);

        return referenceResponse;
    }

    private String appendYear(OnlineImage onlineImage) {
        return " (" + onlineImage.getYear() + ") ";
    }

}
