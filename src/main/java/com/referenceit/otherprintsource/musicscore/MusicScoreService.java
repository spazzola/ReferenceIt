package com.referenceit.otherprintsource.musicscore;

import com.referenceit.reference.Author;
import com.referenceit.reference.ReferenceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class MusicScoreService {

    private MusicScoreMapper musicScoreMapper;


    public MusicScoreResponse generateReference(MusicScoreDto musicScoreDto) {
        MusicScore musicScore = musicScoreMapper.fromDto(musicScoreDto);

        return createReference(musicScore);
    }

    private MusicScoreResponse createReference(MusicScore musicScore) {
        MusicScoreResponse musicScoreResponse = new MusicScoreResponse();

        String composer = remakeAndAppendComposer(musicScore.getAuthors().get(0));
        String year = appendYear(musicScore);
        musicScoreResponse.setComposerAndYearPart(composer + year);

        String titlePart = musicScore.getTitle() + ". ";
        musicScoreResponse.setTitlePart(titlePart);

        String publisherAndPublicationPlacePart = appendPublisherAndPublicationPlace(musicScore);
        musicScoreResponse.setPublisherAndPublicationPlacePart(publisherAndPublicationPlacePart);

        return musicScoreResponse;
    }

    private String remakeAndAppendComposer(Author author) {
        String resultString = "";
        resultString += author.getSurname().toUpperCase();
        resultString += ",";
        resultString += " " + author.getFirstName().toUpperCase().charAt(0);
        if (author.getSecondName() != null) {
            resultString += ". " + author.getSecondName().toUpperCase().charAt(0);
        }
        resultString += ". ";

        return resultString;
    }

    private String appendYear(MusicScore musicScore) {
        return "(" + musicScore.getYear() + ") ";
    }

    private String appendPublisherAndPublicationPlace(MusicScore musicScore) {
        return "[Music score] " + musicScore.getPublicationPlace() + ": " + musicScore.getPublisher() + ".";
    }

}
