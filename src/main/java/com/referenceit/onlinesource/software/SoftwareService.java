package com.referenceit.onlinesource.software;

import com.referenceit.reference.ReferenceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class SoftwareService {

    private ReferenceService referenceService;
    private SoftwareMapper softwareMapper;


    public SoftwareResponse generateReference(SoftwareDto softwareDto) {
        Software software = softwareMapper.fromDto(softwareDto);

        return createReference(software);
    }

    private SoftwareResponse createReference(Software software) {
        SoftwareResponse softwareResponse = new SoftwareResponse();

        String author = referenceService.remakeAndAppendMultipleAuthors(software.getAuthors());
        String year = " (" + software.getYear() + ") ";
        softwareResponse.setAuthorAndYearPart(author + year);

        softwareResponse.setTitlePart(software.getTitle() + ". ");

        String version = "[Software] Version " + software.getVersion() + ". ";
        String publicationPlace = software.getPublicationPlace() + ": ";
        String publisher = software.getPublisher() + ".";
        softwareResponse.setRestReferenceBodyPart(version + publicationPlace + publisher);

        return softwareResponse;
    }

}
