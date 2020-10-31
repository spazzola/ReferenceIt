package com.referenceit.otherprintsource.exhibition;

import com.referenceit.reference.ReferenceResponse;
import com.referenceit.reference.ReferenceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ExhibitionService {

    private ExhibitionMapper exhibitionMapper;
    private ReferenceService referenceService;


    public ReferenceResponse generateReference(ExhibitionDto exhibitionDto) {
        Exhibition exhibition = exhibitionMapper.fromDto(exhibitionDto);

        return createReference(exhibition);
    }

    private ReferenceResponse createReference(Exhibition exhibition) {
        ReferenceResponse referenceResponse = new ReferenceResponse();

        String artistPart = referenceService.remakeAndAppendMultipleAuthors(exhibition.getAuthors());
        String yearPart = appendYear(exhibition);
        referenceResponse.setFirstPartNormal(artistPart + yearPart);

        String titlePart = appendTitle(exhibition);
        referenceResponse.setItalicsPart(titlePart);

        if (!exhibition.isItemFromExhibition()) {
            String exhibitionCataloguePlacesAndPublisherPart = "";
            String exhibitionCatalogue = appendExhibitionCatalogue(exhibition);
            String exhibitionPlaceAndDate = appendExhibitionDate(exhibition);
            String publisherPlace = appendPublisherAndPlace(exhibition);

            exhibitionCataloguePlacesAndPublisherPart += exhibitionCatalogue + exhibitionPlaceAndDate + publisherPlace;
            referenceResponse.setThirdPartNormal(exhibitionCataloguePlacesAndPublisherPart);
        } else {
            String itemTypePart = appendItemType(exhibition);
            String locationAndDatePart = appendLocationAndDate(exhibition);
            String itemTypeLocationAndDatePart = itemTypePart + locationAndDatePart;
            referenceResponse.setThirdPartNormal(itemTypeLocationAndDatePart);
        }

        return referenceResponse;
    }

    private String appendYear(Exhibition exhibition) {
        return " (" + exhibition.getYear() + ") ";
    }

    private String appendTitle(Exhibition exhibition) {
        return exhibition.getTitle() + ". ";
    }

    private String appendItemType(Exhibition exhibition) {
        return "[" + exhibition.getItemType() + "] ";
    }

    private String appendLocationAndDate(Exhibition exhibition) {
        return "[" + exhibition.getLocation() + ", " + exhibition.getDate() + "].";
    }

    private String appendExhibitionCatalogue(Exhibition exhibition) {
        return "[Catalogue of an exhibition held at the " + exhibition.getLocation() + ", ";
    }

    private String appendExhibitionDate(Exhibition exhibition) {
        return exhibition.getDate() + "] ";
    }

    private String appendPublisherAndPlace(Exhibition exhibition) {
        return exhibition.getPublicationPlace() + ": " + exhibition.getPublisher() + ".";
    }
}
