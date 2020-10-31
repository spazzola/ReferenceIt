package com.referenceit.otherprintsource.dictionaryencyclopaedia;

import com.referenceit.reference.Author;
import com.referenceit.reference.Editor;
import com.referenceit.reference.ReferenceResponse;
import com.referenceit.reference.ReferenceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class DictAndEncyService {

    private ReferenceService referenceService;
    private DictAndEncyMapper dictAndEncyMapper;


    public ReferenceResponse generateReference(DictAndEncyDto dictAndEncyDto) {
        DictAndEncy dictAndEncy = dictAndEncyMapper.fromDto(dictAndEncyDto);

        return createReference(dictAndEncy);
    }

    private ReferenceResponse createReference(DictAndEncy dictAndEncy) {
        ReferenceResponse referenceResponse = new ReferenceResponse();

        List<Author> authors = dictAndEncy.getAuthors();

        String authorsPart = referenceService.remakeAndAppendMultipleAuthors(authors);
        String yearPart = appendYear(dictAndEncy);

        String chapterTitlePart = "";
        chapterTitlePart += appendChapterTitle(dictAndEncy) + "In: ";
        chapterTitlePart += remakeAndAppendMultipleEditors(dictAndEncy.getEditors()) + " ";
        referenceResponse.setFirstPartNormal(authorsPart + yearPart + chapterTitlePart);

        String bookTitlePart = appendBookTitle(dictAndEncy);
        referenceResponse.setItalicsPart(bookTitlePart);

        String thirdPartNormal = "";

        if (dictAndEncy.getVolumeNumber() != null) {
            thirdPartNormal += appendVolumeNumber(dictAndEncy);
        }
        if (dictAndEncy.getVolumeNumber() != null && checkIfIsNotFirstEdition(dictAndEncy)) {
            thirdPartNormal += ". ";
        }
        if (checkIfIsNotFirstEdition(dictAndEncy)) {
            String editionPart = appendEdition(dictAndEncy);
            thirdPartNormal += editionPart;
        }

        thirdPartNormal += appendPublicationPlace(dictAndEncy);
        thirdPartNormal += appendPublisher(dictAndEncy);

        String pagesPart = "";
        pagesPart += ", ";
        pagesPart += appendPages(dictAndEncy) + ".";
        thirdPartNormal += pagesPart;

        referenceResponse.setThirdPartNormal(thirdPartNormal);

        return referenceResponse;
    }

    private String remakeAndAppendMultipleEditors(List<Editor> editors) {
        String resultReference = "";
        if (checkIfIsOneWriter(editors)) {
            resultReference += remakeEditor(editors.get(0)) + " (ed.)";
        } else {
            if (editors.size() == 2) {
                resultReference += remakeEditor(editors.get(0)) + " and ";
                resultReference += remakeEditor(editors.get(1));

            }
            if (editors.size() == 3) {
                resultReference += remakeEditor(editors.get(0)) + ", ";
                resultReference += remakeEditor(editors.get(1)) + " and ";
                resultReference += remakeEditor(editors.get(2));
            }
            resultReference += " (eds.)";
        }


        return resultReference;
    }

    private boolean checkIfIsOneWriter(List<?> writers) {
        return writers.size() == 1;
    }

    private String remakeEditor(Editor editor) {
        String resultString = "";
        resultString += editor.getSurname().toUpperCase();
        resultString += ",";
        resultString += " " + editor.getFirstName().toUpperCase().charAt(0);
        if (hasEditorSecondName(editor)) {
            resultString += "." + editor.getSecondName().toUpperCase().charAt(0);
        }
        resultString += ".";

        return resultString;
    }

    private boolean hasEditorSecondName(Editor editor) {
        return editor.getSecondName() != null;
    }

    private String appendYear(DictAndEncy dictAndEncy) {
        return " (" + dictAndEncy.getYear() + ") ";
    }

    private String appendBookTitle(DictAndEncy dictAndEncy) {
        return dictAndEncy.getTitle();
    }

    private String appendChapterTitle(DictAndEncy dictAndEncy) {
        return dictAndEncy.getChapterTitle() + ". ";
    }

    private String appendPublicationPlace(DictAndEncy dictAndEncy) {
        return ". " +dictAndEncy.getPublicationPlace() + ": ";
    }

    private String appendPublisher(DictAndEncy dictAndEncy) {
        return dictAndEncy.getPublisher();
    }

    private String appendPages(DictAndEncy dictAndEncy) {
        return "pp. " + dictAndEncy.getPages();
    }

    private boolean checkIfIsNotFirstEdition(DictAndEncy dictAndEncy) {
        int edition;
        if (dictAndEncy.getEdition() == null || dictAndEncy.getEdition().equals("")) {
            edition = 1;
        } else {
            edition = Integer.valueOf(dictAndEncy.getEdition());
        }
        return edition > 1;
    }

    private String appendEdition(DictAndEncy dictAndEncy) {
        String resultEdition = "";
        int edition = Integer.valueOf(dictAndEncy.getEdition());
        if (edition == 2) {
            resultEdition += dictAndEncy.getEdition() + "nd ed";
        } else if (edition == 3) {
            resultEdition += dictAndEncy.getEdition() + "rd ed";
        } else if (edition > 3) {
            resultEdition += dictAndEncy.getEdition() + "th ed";
        }
        return resultEdition;
    }

    private String appendVolumeNumber(DictAndEncy dictAndEncy) {
        return ", Vol. " + dictAndEncy.getVolumeNumber();
    }

}
