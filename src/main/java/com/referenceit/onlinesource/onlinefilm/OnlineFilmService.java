package com.referenceit.onlinesource.onlinefilm;

import com.referenceit.reference.ReferenceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class OnlineFilmService {

    private ReferenceService referenceService;
    private OnlineFilmMapper onlineFilmMapper;


    public OnlineFilmResponse generateReference(OnlineFilmDto onlineFilmDto) {
        OnlineFilm onlineFilm = onlineFilmMapper.fromDto(onlineFilmDto);

        return createReference(onlineFilm);
    }

    private OnlineFilmResponse createReference(OnlineFilm onlineFilm) {
        OnlineFilmResponse onlineFilmResponse = new OnlineFilmResponse();

        String author = referenceService.remakeAndAppendMultipleAuthors(onlineFilm.getAuthors());
        String year = appendYear(onlineFilm);
        onlineFilmResponse.setAuthorAndYearPart(author + year);

        onlineFilmResponse.setTitlePart(onlineFilm.getTitle() + ". ");

        String availableFrom = "[Online film] Available from: " + onlineFilm.getAvailableFrom();
        String accessedDate = " [Accessed " + onlineFilm.getAccessedDate() + "].";
        onlineFilmResponse.setRestReferenceBodyPart(availableFrom + accessedDate);

        return onlineFilmResponse;
    }

    private String appendYear(OnlineFilm onlineFilm) {
        return " (" + onlineFilm.getYear() + ") ";
    }

}
