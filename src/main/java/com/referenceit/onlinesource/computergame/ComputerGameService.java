package com.referenceit.onlinesource.computergame;

import com.referenceit.reference.ReferenceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ComputerGameService {

    private ReferenceService referenceService;
    private ComputerGameMapper computerGameMapper;


    public ComputerGameResponse generateReference(ComputerGameDto computerGameDto) {
        ComputerGame computerGame = computerGameMapper.fromDto(computerGameDto);

        return createReference(computerGame);
    }

    private ComputerGameResponse createReference(ComputerGame computerGame) {
        ComputerGameResponse computerGameResponse = new ComputerGameResponse();

        String author = referenceService.remakeAndAppendMultipleAuthors(computerGame.getAuthors());
        String year = appendYear(computerGame);
        computerGameResponse.setAuthorAndYearPart(author + year);

        String titlePart = computerGame.getTitle() + ". ";
        computerGameResponse.setTitlepart(titlePart);

        String mediumOfItem = appendMediumOfItem(computerGame);
        String platform = computerGame.getPlatform() + ". ";
        String publicationPlaceAndPublisher = appendPublicationPlaceAndPublisher(computerGame);
        computerGameResponse.setRestReferenceBodyPart(mediumOfItem + platform + publicationPlaceAndPublisher);

        return computerGameResponse;
    }

    private String appendYear(ComputerGame computerGame) {
        return " (" + computerGame.getYear() + ") ";
    }

    private String appendMediumOfItem(ComputerGame computerGame) {
        return "[" + computerGame.getMediumOfItem() + "] ";
    }

    private String appendPublicationPlaceAndPublisher(ComputerGame computerGame) {
        return computerGame.getPublicationPlace() + ": " + computerGame.getPublisher() + ".";
    }

}
