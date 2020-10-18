package com.referenceit.reference;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@NoArgsConstructor
@Service
public class ReferenceService {


    public String remakeAuthor(Author author) {
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

    public boolean checkIfWriterIsPenultimate(int loopIteration, List<?> writers) {
        return (loopIteration + 1) == writers.size();
    }

    public boolean checkIfAreTwoOrThreeWriters(int loopIteration, List<?> writers) {
        return loopIteration != writers.size();
    }

    private boolean hasAuthorSecondName(Author author) {
        return author.getSecondName() != null;
    }

}
