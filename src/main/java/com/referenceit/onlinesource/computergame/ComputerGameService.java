package com.referenceit.onlinesource.computergame;

import com.referenceit.reference.ReferenceResponse;
import com.referenceit.reference.ReferenceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ComputerGameService {

    private ReferenceService referenceService;
    private ComputerGameMapper computerGameMapper;


    public ReferenceResponse generateReference(ComputerGameDto computerGameDto) {
        ComputerGame computerGame = computerGameMapper.fromDto(computerGameDto);

        return createReference(computerGame);
    }

    private ReferenceResponse createReference(ComputerGame computerGame) {
        ReferenceResponse referenceResponse = new ReferenceResponse();

        String author = referenceService.remakeAndAppendMultipleAuthors(computerGame.getAuthors());
        String year = appendYear(computerGame);
        referenceResponse.setFirstPartNormal(author + year);

        String titlePart = computerGame.getTitle() + ". ";
        referenceResponse.setItalicsPart(titlePart);

        String mediumOfItem = appendMediumOfItem(computerGame);
        String platform = computerGame.getPlatform() + ". ";
        String publicationPlaceAndPublisher = appendPublicationPlaceAndPublisher(computerGame);
        referenceResponse.setThirdPartNormal(mediumOfItem + platform + publicationPlaceAndPublisher);

        return referenceResponse;
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
