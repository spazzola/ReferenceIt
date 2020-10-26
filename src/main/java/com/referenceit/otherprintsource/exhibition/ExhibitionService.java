package com.referenceit.otherprintsource.exhibition;

import com.referenceit.reference.ReferenceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ExhibitionService {

    private ExhibitionMapper exhibitionMapper;
    private ReferenceService referenceService;

    public ExhibitionResponse generateReference(ExhibitionDto exhibitionDto) {
        Exhibition exhibition = exhibitionMapper.fromDto(exhibitionDto);

        return createReference(exhibition);
    }

    private ExhibitionResponse createReference(Exhibition exhibition) {
        ExhibitionResponse exhibitionResponse = new ExhibitionResponse();

        String artistPart = referenceService.remakeAndAppendMultipleAuthors(exhibition.getAuthors());
        String yearPart = appendYear(exhibition);
        artistPart += yearPart;
        exhibitionResponse.setArtistAndYearPart(artistPart);

        String titlePart = appendTitle(exhibition);
        exhibitionResponse.setTitlePart(titlePart);

        if (!exhibition.isItemFromExhibition()) {
            String exhibitionCataloguePlacesAndPublisherPart = "";
            String exhibitionCatalogue = appendExhibitionCatalogue(exhibition);
            String exhibitionPlaceAndDate = appendExhibitionPlaceAndDate(exhibition);
            String publisherPlace = appendPublisherAndPlace(exhibition);

            exhibitionCataloguePlacesAndPublisherPart += exhibitionCatalogue + exhibitionPlaceAndDate + publisherPlace;
            exhibitionResponse.setExhibitionCataloguePlacesAndPublisherPart(exhibitionCataloguePlacesAndPublisherPart);

        } else {
            String itemTypePart = appendItemType(exhibition);
            String locationAndDatePart = appendLocationAndDate(exhibition);
            String itemTypeLocationAndDatePart = itemTypePart + locationAndDatePart;
            exhibitionResponse.setItemTypeLocationAndDate(itemTypeLocationAndDatePart);
        }

        return exhibitionResponse;
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

    private String appendLocationAndDate(Exhibition exhibition){
        return "[" + exhibition.getLocation() + ", " + exhibition.getDate() + "].";
    }

    private String appendExhibitionCatalogue(Exhibition exhibition) {
        return "[Catalogue of an exhibition held at the " + exhibition.getLocation();
    }

    private String appendExhibitionPlaceAndDate(Exhibition exhibition) {
        return exhibition.getLocation() + exhibition.getDate() + "]";
    }

    private String appendPublisherAndPlace(Exhibition exhibition) {
        return exhibition.getPublicationPlace() + ": " + exhibition.getPublisher();
    }
}
