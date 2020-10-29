package com.referenceit.onlinesource.blog;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BlogResponse {

    private String authorYearAndPostingTitlePart;
    private String siteTitlePart;
    private String restReferenceBodyPart;

}
