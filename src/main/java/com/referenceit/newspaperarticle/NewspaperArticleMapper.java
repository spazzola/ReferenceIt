package com.referenceit.newspaperarticle;

import org.springframework.stereotype.Component;

@Component
public class NewspaperArticleMapper {

    public NewspaperArticle fromDto(NewspaperArticleDto newspaperArticleDto) {
        return NewspaperArticle.builder()
                .authors(newspaperArticleDto.getAuthors())
                .year(newspaperArticleDto.getYear())
                .articleTitle(newspaperArticleDto.getArticleTitle())
                .newspaperTitle(newspaperArticleDto.getNewspaperTitle())
                .day(newspaperArticleDto.getDay())
                .month(newspaperArticleDto.getMonth())
                .pages(newspaperArticleDto.getPages())
                .availableFrom(newspaperArticleDto.getAvailableFrom())
                .accessedDate(newspaperArticleDto.getAccessedDate())
                .isOnlyAvailableOnline(newspaperArticleDto.isOnlyAvailableOnline())
                .build();
    }
}
