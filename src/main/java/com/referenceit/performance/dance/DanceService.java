package com.referenceit.performance.dance;

import com.referenceit.reference.ReferenceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class DanceService {

    private ReferenceService referenceService;
    private DanceMapper danceMapper;


    public DanceResponse generateReference(DanceDto danceDto) {
        Dance dance = danceMapper.fromDto(danceDto);

        return createReference(dance);
    }

    private DanceResponse createReference(Dance dance) {
        DanceResponse danceResponse = new DanceResponse();

        String author = referenceService.remakeAndAppendMultipleAuthors(dance.getAuthors());
        String year = appendYear(dance);
        danceResponse.setAuthorAndYearPart(author + year);

        String title = appendTitle(dance);
        danceResponse.setTitlePart(title);

        String company = appendCompanyIfExist(dance);
        String location = appendLocation(dance);
        String seenDate = appendSeenDate(dance);
        danceResponse.setRestReferenceBodyPart(company + location + seenDate);

        return danceResponse;
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
