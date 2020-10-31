package com.referenceit.onlinesource.blog;

import com.referenceit.reference.ReferenceResponse;
import com.referenceit.reference.ReferenceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BlogService {

    private BlogMapper blogMapper;
    private ReferenceService referenceService;


    public ReferenceResponse generateReference(BlogDto blogDto) {
        Blog blog = blogMapper.fromDto(blogDto);

        return createReference(blog);
    }

    private ReferenceResponse createReference(Blog blog) {
        ReferenceResponse referenceResponse = new ReferenceResponse();

        String author = referenceService.remakeAndAppendMultipleAuthors(blog.getAuthors());
        String year = appendYear(blog);
        String postingTitle = appendPostingTitle(blog);
        referenceResponse.setFirstPartNormal(author + year + postingTitle);

        String siteTitle = blog.getSiteTitle() + ". ";
        referenceResponse.setItalicsPart(siteTitle);

        String postedDay = blog.getDayAndMonth() + ". ";
        String availableFrom = "Available from: " + blog.getAvailableFrom();
        String accessedDay = " [Accessed " + blog.getAccessedDate() + "].";
        referenceResponse.setThirdPartNormal(postedDay + availableFrom + accessedDay);

        return referenceResponse;
    }

    private String appendYear(Blog blog) {
        return " (" + blog.getYear() + ") ";
    }

    private String appendPostingTitle(Blog blog) {
        if (blog.getPostingTitle() != null) {
            return blog.getPostingTitle() + ". [Weblog] ";
        }
        return "[Weblog] ";
    }

}
