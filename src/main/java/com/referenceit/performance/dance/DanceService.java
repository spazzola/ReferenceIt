package com.referenceit.performance.dance;

import com.referenceit.reference.ReferenceResponse;
import com.referenceit.reference.ReferenceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class DanceService {

    private ReferenceService referenceService;
    private DanceMapper danceMapper;


    public ReferenceResponse generateReference(DanceDto danceDto) {
        Dance dance = danceMapper.fromDto(danceDto);

        return createReference(dance);
    }

    private ReferenceResponse createReference(Dance dance) {
        ReferenceResponse referenceResponse = new ReferenceResponse();

        String author = referenceService.remakeAndAppendMultipleAuthors(dance.getAuthors());
        String year = appendYear(dance);
        referenceResponse.setFirstPartNormal(author + year);

        String title = appendTitle(dance);
        referenceResponse.setItalicsPart(title);

        String company = appendCompanyIfExist(dance);
        String location = appendLocation(dance);
        String seenDate = appendSeenDate(dance);
        referenceResponse.setThirdPartNormal(company + location + seenDate);

        return referenceResponse;
    }

    private String appendYear(Dance dance) {
        return " (" + dance.getYear() + ") ";
    }

    private String appendTitle(Dance dance) {
        return dance.getTitle() + ". ";
    }

    private String appendCompanyIfExist(Dance dance) {
        if (dance.getCompany() != null) {
            return dance.getCompany() + ". ";
        }
        return "";
    }

    private String appendLocation(Dance dance) {
        return "[" + dance.getLocation() + ", ";
    }

    private String appendSeenDate(Dance dance) {
        return dance.getSeenDate() + "].";
    }

}
