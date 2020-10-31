package com.referenceit.onlinesource.onlinefilm;

import com.referenceit.reference.ReferenceResponse;
import com.referenceit.reference.ReferenceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class OnlineFilmService {

    private ReferenceService referenceService;
    private OnlineFilmMapper onlineFilmMapper;


    public ReferenceResponse generateReference(OnlineFilmDto onlineFilmDto) {
        OnlineFilm onlineFilm = onlineFilmMapper.fromDto(onlineFilmDto);

        return createReference(onlineFilm);
    }

    private ReferenceResponse createReference(OnlineFilm onlineFilm) {
        ReferenceResponse referenceResponse = new ReferenceResponse();

        String author = referenceService.remakeAndAppendMultipleAuthors(onlineFilm.getAuthors());
        String year = appendYear(onlineFilm);
        referenceResponse.setFirstPartNormal(author + year);

        referenceResponse.setItalicsPart(onlineFilm.getTitle() + ". ");

        String availableFrom = "[Online film] Available from: " + onlineFilm.getAvailableFrom();
        String accessedDate = " [Accessed " + onlineFilm.getAccessedDate() + "].";
        referenceResponse.setThirdPartNormal(availableFrom + accessedDate);

        return referenceResponse;
    }

    private String appendYear(OnlineFilm onlineFilm) {
        return " (" + onlineFilm.getYear() + ") ";
    }

}
