package com.referenceit.onlinesource.blog;

import com.referenceit.reference.ReferenceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BlogService {

    private BlogMapper blogMapper;
    private ReferenceService referenceService;


    public BlogResponse generateReference(BlogDto blogDto) {
        Blog blog = blogMapper.fromDto(blogDto);

        return createReference(blog);
    }

    private BlogResponse createReference(Blog blog) {
        BlogResponse blogResponse = new BlogResponse();

        String author = referenceService.remakeAndAppendMultipleAuthors(blog.getAuthors());
        String year = appendYear(blog);
        String postingTitle = appendPostingTitle(blog);
        blogResponse.setAuthorYearAndPostingTitlePart(author + year + postingTitle);

        String siteTitle = blog.getSiteTitle() + ". ";
        blogResponse.setSiteTitlePart(siteTitle);

        String postedDay = blog.getDayAndMonth() + ". ";
        String availableFrom = "Available from: " + blog.getAvailableFrom();
        String accessedDay = " [Accessed " + blog.getAccessedDate() + "].";
        blogResponse.setRestReferenceBodyPart(postedDay + availableFrom + accessedDay);

        return blogResponse;
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
