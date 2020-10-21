package com.referenceit.journalarticles;

import org.springframework.stereotype.Component;

@Component
public class JournalArticleMapper {

    public JournalArticle fromDto(JournalArticleDto journalArticleDto) {
        return JournalArticle.builder()
                .authors(journalArticleDto.getAuthors())
                .year(journalArticleDto.getYear())
                .articleTitle(journalArticleDto.getArticleTitle())
                .journalTitle(journalArticleDto.getJournalTitle())
                .volNumber(journalArticleDto.getVolNumber())
                .partNumber(journalArticleDto.getPartNumber())
                .issue(journalArticleDto.getIssue())
                .month(journalArticleDto.getMonth())
                .pages(journalArticleDto.getPages())
                .availableFrom(journalArticleDto.getAvailableFrom())
                .accessedDate(journalArticleDto.getAccessedDate())
                .isNotYetPrinted(journalArticleDto.isNotYetPrinted())
                .isOpenAccessRepo(journalArticleDto.isOpenAccessRepo())
                .isOnlyAvailableOnline(journalArticleDto.isOnlyAvailableOnline())
                .build();
    }

}
