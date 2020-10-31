package com.referenceit.performance.plays;

import com.referenceit.reference.Author;
import com.referenceit.reference.ReferenceResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class PlaysService {

    private PlaysMapper playsMapper;


    public ReferenceResponse generateReference(PlaysDto playsDto) {
        Plays plays = playsMapper.fromDto(playsDto);

        return createReference(plays);
    }

    private ReferenceResponse createReference(Plays plays) {
        ReferenceResponse referenceResponse = new ReferenceResponse();

        referenceResponse.setItalicsPart(plays.getTitle());

        String author = appendAuthor(plays.getAuthors());
        String year = appendYear(plays);
        String directorName = appendDirectorName(plays);
        String companyName = appendCompanyNameIfExist(plays);
        String location = appendLocation(plays);
        String seenDate = appendSeenDate(plays);
        referenceResponse.setThirdPartNormal(author + year + directorName + companyName + location + seenDate);

        return referenceResponse;
    }

    private String appendAuthor(List<Author> authors) {
        return " by " +  remakeAuthor(authors.get(0)) + " ";
    }

    private String remakeAuthor(Author author) {
        String resultString = "";

        resultString += author.getFirstName().toUpperCase().charAt(0) + ".";
        if (author.getSecondName() != null) {
            resultString += author.getSecondName().toUpperCase().charAt(0) + ".";
        }
        resultString += " " + author.getSurname() + ".";

        return resultString;
    }

    private String appendYear(Plays plays) {
        return "(" + plays.getYear() + ") ";
    }

    private String appendDirectorName(Plays plays) {
        return "Directed by " + plays.getDirectorName().toUpperCase() + ". ";
    }

    private String appendCompanyNameIfExist(Plays plays) {
        if (plays.getCompanyName() != null) {
            return plays.getCompanyName() + ". ";
        }
        return "";
    }

    private String appendLocation(Plays plays) {
        return "[" + plays.getLocation() + ", ";
    }

    private String appendSeenDate(Plays plays) {
        return plays.getSeenDate() + "].";
    }

}
