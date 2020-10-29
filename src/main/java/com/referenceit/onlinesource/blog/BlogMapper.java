package com.referenceit.onlinesource.blog;

import org.springframework.stereotype.Component;

@Component
public class BlogMapper {

    public Blog fromDto(BlogDto blogDto) {
        return Blog.builder()
                .authors(blogDto.getAuthors())
                .year(blogDto.getYear())
                .postingTitle(blogDto.getPostingTitle())
                .siteTitle(blogDto.getSiteTitle())
                .dayAndMonth(blogDto.getDayAndMonth())
                .availableFrom(blogDto.getAvailableFrom())
                .accessedDate(blogDto.getAccessedDate())
                .build();
    }

}
