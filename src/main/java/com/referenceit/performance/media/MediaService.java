package com.referenceit.performance.media;

import com.referenceit.reference.ReferenceResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class MediaService {

    private MediaMapper mediaMapper;


    public ReferenceResponse generateReference(MediaDto mediaDto) {
        Media media = mediaMapper.fromDto(mediaDto);

        return createReference(media);
    }

    private ReferenceResponse createReference(Media media) {
        ReferenceResponse referenceResponse = new ReferenceResponse();

        String title = appendTitle(media);
        referenceResponse.setItalicsPart(title);

        String year = appendYear(media);

        //TODO add else for individual contributor
        if (isReferenceTypeVideo(media)) {
            return processReferencingVideoType(media, referenceResponse, year);
        }
        if (isReferenceTypeBroadcast(media)) {
            return processReferencingBroadcastType(media, referenceResponse, year);
        }

        return referenceResponse;
    }

    private String appendTitle(Media media) {
        return media.getTitle() + ". ";
    }

    private String appendMediaType(Media media) {
        return "[" + media.getMediaType() + "] ";
    }

    private String appendYear(Media media) {
        return "(" + media.getYear() + ") ";
    }

    private String appendDirectorName(Media media) {
        return "Directed by " + media.getDirectorName().toUpperCase() + ". ";
    }

    private String appendProductionPlace(Media media) {
        return media.getProductionPlace() + ": ";
    }

    private String appendProductionCompany(Media media) {
        return media.getProductionCompany() + ".";
    }

    private boolean isReferenceTypeVideo(Media media) {
        return media.getReferenceType().toUpperCase().equals("VIDEO");
    }

    private ReferenceResponse processReferencingVideoType(Media media, ReferenceResponse referenceResponse, String year) {
        String mediaType = appendMediaType(media);
        String directorName = appendDirectorName(media);
        String productionPlace = appendProductionPlace(media);
        String productionCompany = appendProductionCompany(media);
        referenceResponse.setThirdPartNormal(year + mediaType + directorName + productionPlace + productionCompany);

        return referenceResponse;
    }

    private boolean isReferenceTypeBroadcast(Media media) {
        return media.getReferenceType().toUpperCase().equals("BROADCAST");
    }

    private ReferenceResponse processReferencingBroadcastType(Media media, ReferenceResponse referenceResponse, String year) {
        String episodeNumber = appendEpisodeNumberAndNameIfExist(media);
        String mediaType = appendMediaType(media);
        String channel = appendChannel(media);
        String date = appendExactDate(media);
        referenceResponse.setThirdPartNormal(year + episodeNumber + mediaType + channel + date);

        return referenceResponse;
    }

    private String appendEpisodeNumberAndNameIfExist(Media media) {
        String result = "";
        String episodeNumber = media.getEpisodeNumber();
        String episodeName = media.getEpisodeName();

        if (episodeNumber != null && episodeName != null) {
            return "Episode " + episodeNumber + ", " + episodeName + ". ";
        }

        if (episodeNumber != null) {
            result += "Episode " + episodeNumber;
        }
        if (episodeName != null) {
            result += episodeName;
        }

        return result + ". ";
    }

    private String appendChannel(Media media) {
        return media.getChannel().toUpperCase() + ". ";
    }

    private String appendExactDate(Media media) {
        return media.getBroadcastDate() + ", " + media.getBroadcastTime() + " hrs.";
    }

}
