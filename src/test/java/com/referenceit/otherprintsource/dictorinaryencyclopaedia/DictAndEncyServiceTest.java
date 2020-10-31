package com.referenceit.otherprintsource.dictorinaryencyclopaedia;

import com.referenceit.otherprintsource.dictionaryencyclopaedia.DictAndEncyDto;
import com.referenceit.otherprintsource.dictionaryencyclopaedia.DictAndEncyService;
import com.referenceit.reference.Author;
import com.referenceit.reference.Editor;
import com.referenceit.reference.ReferenceResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DictAndEncyServiceTest {

    @Autowired
    private DictAndEncyService dictAndEncyService;


    @Test
    public void shouldPassReferencingDictionaryOrEncyclopaediasWithoutEditionWithVolumeNumber() {
        //given
        List<Author> authors = Arrays.asList(new Author("Raul", "Paul", "Kesner"));
        List<Editor> editors = Arrays.asList(new Editor("Vinc", "Synt", "Ramachandran"));
        DictAndEncyDto dictAndEncyDto = DictAndEncyDto.builder()
                .authors(authors)
                .editors(editors)
                .title("Encyclopedia of the human brain")
                .chapterTitle("Memory neurobiology")
                .year("2002")
                .publicationPlace("San Diego")
                .publisher("Academic Press")
                .volumeNumber("2")
                .pages("783-796")
                .build();

        //when
        ReferenceResponse referenceResponse = dictAndEncyService.generateReference(dictAndEncyDto);

        //then
        String expectedResult = "KESNER, R.P. (2002) Memory neurobiology. In: RAMACHANDRAN, V.S. (ed.) " +
                "Encyclopedia of the human brain, Vol. 2. San Diego: Academic Press, pp. 783-796.";

        assertEquals(expectedResult, referenceResponse.toString());
    }

    @Test
    public void shouldPassReferencingDictionaryOrEncyclopaediasWithVolumeNumberEdition() {
        //given
        List<Author> authors = Arrays.asList(new Author("Raul", "Paul", "Kesner"));
        List<Editor> editors = Arrays.asList(new Editor("Vinc", "Synt", "Ramachandran"));
        DictAndEncyDto dictAndEncyDto = DictAndEncyDto.builder()
                .authors(authors)
                .editors(editors)
                .title("Encyclopedia of the human brain")
                .chapterTitle("Memory neurobiology")
                .year("2002")
                .publicationPlace("San Diego")
                .publisher("Academic Press")
                .edition("3")
                .volumeNumber("2")
                .pages("783-796")
                .build();

        //when
        ReferenceResponse referenceResponse = dictAndEncyService.generateReference(dictAndEncyDto);

        //then
        String expectedResult = "KESNER, R.P. (2002) Memory neurobiology. In: RAMACHANDRAN, V.S. (ed.) " +
                "Encyclopedia of the human brain, Vol. 2. 3rd ed. San Diego: Academic Press, pp. 783-796.";

        assertEquals(expectedResult, referenceResponse.toString());
    }

    @Test
    public void shouldPassReferencingDictionaryOrEncyclopaediasWithoutEditionAndVolumeNumber() {
        //given
        List<Author> authors = Arrays.asList(new Author("Raul", "Paul", "Kesner"));
        List<Editor> editors = Arrays.asList(new Editor("Vinc", "Synt", "Ramachandran"));
        DictAndEncyDto dictAndEncyDto = DictAndEncyDto.builder()
                .authors(authors)
                .editors(editors)
                .title("Encyclopedia of the human brain")
                .chapterTitle("Memory neurobiology")
                .year("2002")
                .publicationPlace("San Diego")
                .publisher("Academic Press")

                .pages("783-796")
                .build();

        //when
        ReferenceResponse referenceResponse = dictAndEncyService.generateReference(dictAndEncyDto);

        //then
        String expectedResult = "KESNER, R.P. (2002) Memory neurobiology. In: RAMACHANDRAN, V.S. (ed.) " +
                "Encyclopedia of the human brain. San Diego: Academic Press, pp. 783-796.";

        assertEquals(expectedResult, referenceResponse.toString());
    }

}
