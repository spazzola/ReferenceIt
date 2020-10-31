package com.referenceit.onlinesource.software;

import com.referenceit.reference.ReferenceResponse;
import com.referenceit.reference.ReferenceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class SoftwareService {

    private ReferenceService referenceService;
    private SoftwareMapper softwareMapper;


    public ReferenceResponse generateReference(SoftwareDto softwareDto) {
        Software software = softwareMapper.fromDto(softwareDto);

        return createReference(software);
    }

    private ReferenceResponse createReference(Software software) {
        ReferenceResponse referenceResponse = new ReferenceResponse();

        String author = referenceService.remakeAndAppendMultipleAuthors(software.getAuthors());
        String year = " (" + software.getYear() + ") ";
        referenceResponse.setFirstPartNormal(author + year);

        referenceResponse.setItalicsPart(software.getTitle() + ". ");

        String version = "[Software] Version " + software.getVersion() + ". ";
        String publicationPlace = software.getPublicationPlace() + ": ";
        String publisher = software.getPublisher() + ".";
        referenceResponse.setThirdPartNormal(version + publicationPlace + publisher);

        return referenceResponse;
    }

}
