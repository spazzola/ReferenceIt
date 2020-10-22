package com.referenceit.newspaperarticle;

import com.referenceit.reference.Reference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class NewspaperArticleDto extends Reference {

    private String articleTitle;
    private String newspaperTitle;
    private String day;
    private String month;
    private String pages;
    private String availableFrom;
    private String accessedDate;
    private boolean isOnlyAvailableOnline;

}
