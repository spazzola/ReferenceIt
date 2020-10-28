package com.referenceit.reference;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@NoArgsConstructor
@Service
public class ReferenceService {


    public String remakeAndAppendMultipleAuthors(List<Author> authors) {
        if (authors.size() > 3) {
            return prepareStringForAuthor(authors.get(0));
        }

        return prepareStringForAuthors(authors);
    }

    private String prepareStringForAuthor(Author author) {
        return remakeAuthor(author) + " et al.";
    }

    private String prepareStringForAuthors(List<Author> authors) {
        final StringBuilder builder = new StringBuilder();

        for (int i = 0; i < authors.size() ; i++) {
            builder.append(remakeAuthor(authors.get(i)));
            if (i < authors.size() - 1) {
                if (i == authors.size() - 2) {
                    builder.append(" and ");
                } else {
                    builder.append(", ");
                }
            }
        }

        return builder.toString();
    }

    private String remakeAuthor(Author author) {
        String resultString = "";
        resultString += author.getSurname().toUpperCase();
        resultString += ",";
        resultString += " " + author.getFirstName().toUpperCase().charAt(0);
        if (hasAuthorSecondName(author)) {
            resultString += "." + author.getSecondName().toUpperCase().charAt(0);
        }
        resultString += ".";

        return resultString;
    }

    private boolean hasAuthorSecondName(Author author) {
        return author.getSecondName() != null;
    }

}
