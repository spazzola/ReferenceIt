package com.referenceit.journalarticle;

import com.referenceit.journalarticles.*;
import com.referenceit.reference.Author;
import com.referenceit.reference.ReferenceService;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JournalArticleTest {


    private ReferenceService referenceService = new ReferenceService();
    JournalArticleMapper journalArticleMapper = new JournalArticleMapper();
    JournalArticleService journalArticleService = new JournalArticleService(referenceService, journalArticleMapper);

    public JournalArticleTest() {
    }


    /**
     *  Tests for different number of authors with one firstName
     */

    @Test
    public void shouldPassReferencingJournalArticleWithOneAuthorWithOneName() {
        //given
        List<Author> authors = Arrays.asList(new Author("Daniel", null, "Maimon"));

        JournalArticleDto journalArticleDto = JournalArticleDto.builder()
                .authors(authors)
                .year("2012")
                .articleTitle("Adolescents’ violent victimization in the neighbourhood: situational and contextual determinants")
                .journalTitle("British journal of criminology")
                .volNumber("52")
                .partNumber("4")
                .pages("808-833")
                .isOnlyAvailableOnline(false)
                .build();
        //when
        JournalArticleResponse journalArticleResponse = journalArticleService.generateReference(journalArticleDto);
        String resultReference = "";
        resultReference += journalArticleResponse.getAuthorsPart();
        resultReference += journalArticleResponse.getYearPart();
        resultReference += journalArticleResponse.getArticleTitlePart();
        resultReference += journalArticleResponse.getJournalTitlePart();
        resultReference += journalArticleResponse.getVolIssueMonthPart();
        resultReference += journalArticleResponse.getPagesPart();
        resultReference += journalArticleResponse.getDotPart();

        //then
        String expectedResult = "MAIMON, D. (2012) Adolescents’ violent victimization in the neighbourhood: situational and contextual determinants. British journal of criminology, 52 (4), pp. 808-833.";

        assertEquals(expectedResult, resultReference);
    }

    @Test
    public void shouldPassReferencingJournalArticleWithTwoAuthorsWithOneName() {
        //given
        List<Author> authors = Arrays.asList(new Author("Daniel", null, "Maimon"),
                                             new Author("Chrystian", null, "Larens"));

        JournalArticleDto journalArticleDto = JournalArticleDto.builder()
                .authors(authors)
                .year("2012")
                .articleTitle("Adolescents’ violent victimization in the neighbourhood: situational and contextual determinants")
                .journalTitle("British journal of criminology")
                .volNumber("52")
                .partNumber("4")
                .pages("808-833")
                .isOnlyAvailableOnline(false)
                .build();
        //when
        JournalArticleResponse journalArticleResponse = journalArticleService.generateReference(journalArticleDto);
        String resultReference = "";
        resultReference += journalArticleResponse.getAuthorsPart();
        resultReference += journalArticleResponse.getYearPart();
        resultReference += journalArticleResponse.getArticleTitlePart();
        resultReference += journalArticleResponse.getJournalTitlePart();
        resultReference += journalArticleResponse.getVolIssueMonthPart();
        resultReference += journalArticleResponse.getPagesPart();
        resultReference += journalArticleResponse.getDotPart();

        //then
        String expectedResult = "MAIMON, D. and LARENS, C. (2012) Adolescents’ violent victimization in the neighbourhood: situational and contextual determinants. British journal of criminology, 52 (4), pp. 808-833.";

        assertEquals(expectedResult, resultReference);
    }

    @Test
    public void shouldPassReferencingJournalArticleWithThreeAuthorsWithOneName() {
        //given
        List<Author> authors = Arrays.asList(new Author("Daniel", null, "Maimon"),
                                             new Author("Chrystian", null, "Larens"),
                                             new Author("Paul", null, "Ralph"));

        JournalArticleDto journalArticleDto = JournalArticleDto.builder()
                .authors(authors)
                .year("2012")
                .articleTitle("Adolescents’ violent victimization in the neighbourhood: situational and contextual determinants")
                .journalTitle("British journal of criminology")
                .volNumber("52")
                .partNumber("4")
                .pages("808-833")
                .isOnlyAvailableOnline(false)
                .build();
        //when
        JournalArticleResponse journalArticleResponse = journalArticleService.generateReference(journalArticleDto);
        String resultReference = "";
        resultReference += journalArticleResponse.getAuthorsPart();
        resultReference += journalArticleResponse.getYearPart();
        resultReference += journalArticleResponse.getArticleTitlePart();
        resultReference += journalArticleResponse.getJournalTitlePart();
        resultReference += journalArticleResponse.getVolIssueMonthPart();
        resultReference += journalArticleResponse.getPagesPart();
        resultReference += journalArticleResponse.getDotPart();

        //then
        String expectedResult = "MAIMON, D., LARENS, C. and RALPH, P. (2012) Adolescents’ violent victimization in the neighbourhood: situational and contextual determinants. British journal of criminology, 52 (4), pp. 808-833.";

        assertEquals(expectedResult, resultReference);
    }


    /**
     *  Test for different number of authors with two names
     */

    @Test
    public void shouldPassReferencingJournalArticleWithOneAuthorWithTwoNames() {
        //given
        List<Author> authors = Arrays.asList(new Author("Daniel", "Karol", "Maimon"));

        JournalArticleDto journalArticleDto = JournalArticleDto.builder()
                .authors(authors)
                .year("2012")
                .articleTitle("Adolescents’ violent victimization in the neighbourhood: situational and contextual determinants")
                .journalTitle("British journal of criminology")
                .volNumber("52")
                .partNumber("4")
                .pages("808-833")
                .isOnlyAvailableOnline(false)
                .build();
        //when
        JournalArticleResponse journalArticleResponse = journalArticleService.generateReference(journalArticleDto);
        String resultReference = "";
        resultReference += journalArticleResponse.getAuthorsPart();
        resultReference += journalArticleResponse.getYearPart();
        resultReference += journalArticleResponse.getArticleTitlePart();
        resultReference += journalArticleResponse.getJournalTitlePart();
        resultReference += journalArticleResponse.getVolIssueMonthPart();
        resultReference += journalArticleResponse.getPagesPart();
        resultReference += journalArticleResponse.getDotPart();

        //then
        String expectedResult = "MAIMON, D.K. (2012) Adolescents’ violent victimization in the neighbourhood: situational and contextual determinants. British journal of criminology, 52 (4), pp. 808-833.";

        assertEquals(expectedResult, resultReference);
    }

    @Test
    public void shouldPassReferencingJournalArticleWithTwoAuthorsWithTwoNames() {
        //given
        List<Author> authors = Arrays.asList(new Author("Daniel", "Karol", "Maimon"),
                new Author("Chrystian", "Mark", "Larens"));

        JournalArticleDto journalArticleDto = JournalArticleDto.builder()
                .authors(authors)
                .year("2012")
                .articleTitle("Adolescents’ violent victimization in the neighbourhood: situational and contextual determinants")
                .journalTitle("British journal of criminology")
                .volNumber("52")
                .partNumber("4")
                .pages("808-833")
                .isOnlyAvailableOnline(false)
                .build();
        //when
        JournalArticleResponse journalArticleResponse = journalArticleService.generateReference(journalArticleDto);
        String resultReference = "";
        resultReference += journalArticleResponse.getAuthorsPart();
        resultReference += journalArticleResponse.getYearPart();
        resultReference += journalArticleResponse.getArticleTitlePart();
        resultReference += journalArticleResponse.getJournalTitlePart();
        resultReference += journalArticleResponse.getVolIssueMonthPart();
        resultReference += journalArticleResponse.getPagesPart();
        resultReference += journalArticleResponse.getDotPart();


        //then
        String expectedResult = "MAIMON, D.K. and LARENS, C.M. (2012) Adolescents’ violent victimization in the neighbourhood: situational and contextual determinants. British journal of criminology, 52 (4), pp. 808-833.";

        assertEquals(expectedResult, resultReference);
    }

    @Test
    public void shouldPassReferencingJournalArticleWithThreeAuthorsWithTwoNames() {
        //given
        List<Author> authors = Arrays.asList(new Author("Daniel", "Karol", "Maimon"),
                new Author("Chrystian", "Mark", "Larens"),
                new Author("Paul", "Yens", "Ralph"));

        JournalArticleDto journalArticleDto = JournalArticleDto.builder()
                .authors(authors)
                .year("2012")
                .articleTitle("Adolescents’ violent victimization in the neighbourhood: situational and contextual determinants")
                .journalTitle("British journal of criminology")
                .volNumber("52")
                .partNumber("4")
                .pages("808-833")
                .isOnlyAvailableOnline(false)
                .build();
        //when
        JournalArticleResponse journalArticleResponse = journalArticleService.generateReference(journalArticleDto);
        String resultReference = "";
        resultReference += journalArticleResponse.getAuthorsPart();
        resultReference += journalArticleResponse.getYearPart();
        resultReference += journalArticleResponse.getArticleTitlePart();
        resultReference += journalArticleResponse.getJournalTitlePart();
        resultReference += journalArticleResponse.getVolIssueMonthPart();
        resultReference += journalArticleResponse.getPagesPart();
        resultReference += journalArticleResponse.getDotPart();

        //then
        String expectedResult = "MAIMON, D.K., LARENS, C.M. and RALPH, P.Y. (2012) Adolescents’ violent victimization in the neighbourhood: situational and contextual determinants. British journal of criminology, 52 (4), pp. 808-833.";

        assertEquals(expectedResult, resultReference);
    }


    /**
     *  Tests for available from online
     */

    @Test
    public void shouldPassReferencingJournalArticleAvailableOnlineWithOneAuthorWithOneName() {
        //given
        List<Author> authors = Arrays.asList(new Author("Tomas", null, "Heus"),
                                             new Author("Herold", "Jon", "Jonker"));

        JournalArticleDto journalArticleDto = JournalArticleDto.builder()
                .authors(authors)
                .year("2008")
                .articleTitle("Subsiding shells around shallow cumulous clouds")
                .journalTitle("Journal of atmospheric sciences")
                .volNumber("65")
                .partNumber("3")
                .isOnlyAvailableOnline(true)
                .availableFrom("doi:org/10.1175/2007Jas2322.1")
                .accessedDate("28/06/16")
                .build();
        //when
        JournalArticleResponse journalArticleResponse = journalArticleService.generateReference(journalArticleDto);
        String resultReference = "";
        resultReference += journalArticleResponse.getAuthorsPart();
        resultReference += journalArticleResponse.getYearPart();
        resultReference += journalArticleResponse.getArticleTitlePart();
        resultReference += journalArticleResponse.getJournalTitlePart();
        resultReference += journalArticleResponse.getOnlinePart();
        resultReference += journalArticleResponse.getVolIssueMonthPart();
        resultReference += journalArticleResponse.getAvailableFromAndAccessedDatePart();

        //then
        String expectedResult = "HEUS, T. and JONKER, H.J. (2008) Subsiding shells around shallow cumulous clouds. Journal of atmospheric sciences. [Online] 65 (3). Available from: doi:org/10.1175/2007Jas2322.1 [Accessed 28/06/16].";

        assertEquals(expectedResult, resultReference);
    }

    @Test
    public void shouldPassReferencingJournalArticleAvailableOnlineWithTwoAuthorsWithTwoNames() {
        //given
        List<Author> authors = Arrays.asList(new Author("Daniel", "Karol", "Maimon"),
                new Author("Chrystian", "Mark", "Larens"));

        JournalArticleDto journalArticleDto = JournalArticleDto.builder()
                .authors(authors)
                .year("2008")
                .articleTitle("Subsiding shells around shallow cumulous clouds")
                .journalTitle("Journal of atmospheric sciences")
                .volNumber("65")
                .partNumber("3")
                .isOnlyAvailableOnline(true)
                .availableFrom("doi:org/10.1175/2007Jas2322.1")
                .accessedDate("28/06/16")
                .build();
        //when
        JournalArticleResponse journalArticleResponse = journalArticleService.generateReference(journalArticleDto);
        String resultReference = "";
        resultReference += journalArticleResponse.getAuthorsPart();
        resultReference += journalArticleResponse.getYearPart();
        resultReference += journalArticleResponse.getArticleTitlePart();
        resultReference += journalArticleResponse.getJournalTitlePart();
        resultReference += journalArticleResponse.getOnlinePart();
        resultReference += journalArticleResponse.getVolIssueMonthPart();
        resultReference += journalArticleResponse.getAvailableFromAndAccessedDatePart();

        //then
        String expectedResult = "MAIMON, D.K. and LARENS, C.M. (2008) Subsiding shells around shallow cumulous clouds. Journal of atmospheric sciences. [Online] 65 (3). Available from: doi:org/10.1175/2007Jas2322.1 [Accessed 28/06/16].";

        assertEquals(expectedResult, resultReference);
    }

    @Test
    public void shouldPassReferencingJournalArticleAvailableOnlineWithThreeAuthorsWithTwoNames() {
        //given
        List<Author> authors = Arrays.asList(new Author("Daniel", "Karol", "Maimon"),
                                             new Author("Chrystian", "Mark", "Larens"),
                                             new Author("Paul", "Yens", "Ralph"));

        JournalArticleDto journalArticleDto = JournalArticleDto.builder()
                .authors(authors)
                .year("2008")
                .articleTitle("Subsiding shells around shallow cumulous clouds")
                .journalTitle("Journal of atmospheric sciences")
                .volNumber("65")
                .partNumber("3")
                .isOnlyAvailableOnline(true)
                .availableFrom("doi:org/10.1175/2007Jas2322.1")
                .accessedDate("28/06/16")
                .build();
        //when
        JournalArticleResponse journalArticleResponse = journalArticleService.generateReference(journalArticleDto);
        String resultReference = "";
        resultReference += journalArticleResponse.getAuthorsPart();
        resultReference += journalArticleResponse.getYearPart();
        resultReference += journalArticleResponse.getArticleTitlePart();
        resultReference += journalArticleResponse.getJournalTitlePart();
        resultReference += journalArticleResponse.getOnlinePart();
        resultReference += journalArticleResponse.getVolIssueMonthPart();
        resultReference += journalArticleResponse.getAvailableFromAndAccessedDatePart();

        //then
        String expectedResult = "MAIMON, D.K., LARENS, C.M. and RALPH, P.Y. (2008) Subsiding shells around shallow cumulous clouds. Journal of atmospheric sciences. [Online] 65 (3). Available from: doi:org/10.1175/2007Jas2322.1 [Accessed 28/06/16].";

        assertEquals(expectedResult, resultReference);
    }


    /**
     *  Tests for journal articles not yet printed
     */

    @Test
    public void shouldPassReferencingJournalArticleNotYetPrintedWithThreeAuthorsWithTwoNames() {
        //given
        List<Author> authors = Arrays.asList(new Author("Daniel", "Patrick", "Royall"),
                                             new Author("Bob", "Lauren", "Thiel"),
                                             new Author("Anthony", "Mark", "Donald"));

        JournalArticleDto journalArticleDto = JournalArticleDto.builder()
                .authors(authors)
                .year("2012")
                .articleTitle("Radiation damage of water in environmental scanning electron microscopy")
                .journalTitle("Journal of microscopy")
                .isOnlyAvailableOnline(true)
                .isNotYetPrinted(true)
                .availableFrom("http://onlinelibrary.wiley.com/doi/10.1046/j.1365-2818.2001.00948.x/full")
                .accessedDate("14/03/15")
                .build();

        //when
        JournalArticleResponse journalArticleResponse = journalArticleService.generateReference(journalArticleDto);
        String resultReference = "";
        resultReference += journalArticleResponse.getAuthorsPart();
        resultReference += journalArticleResponse.getYearPart();
        resultReference += journalArticleResponse.getArticleTitlePart();
        resultReference += journalArticleResponse.getJournalTitlePart();
        resultReference += journalArticleResponse.getOnlinePart();
        resultReference += journalArticleResponse.getAvailableFromAndAccessedDatePart();

        //then
        String expectedResult = "ROYALL, D.P., THIEL, B.L. and DONALD, A.M. (Forthcoming) Radiation damage of water in environmental scanning electron microscopy. Journal of microscopy. [Online] Available from: http://onlinelibrary.wiley.com/doi/10.1046/j.1365-2818.2001.00948.x/full [Accessed 14/03/15].";

        assertEquals(expectedResult, resultReference);
    }

    @Test
    public void shouldPassReferencingJournalArticleOpenAccessRepoAvailableOnlineWithTwoAuthors() {
        //given
        List<Author> authors = Arrays.asList(new Author("Daniel", null, "Palit"),
                                             new Author("Silva", "Cylion", "BHATTACHARYYA"));

        JournalArticleDto journalArticleDto = JournalArticleDto.builder()
                .authors(authors)
                .year("2014")
                .articleTitle("Adoption of cleaner cookstoves: barriers and way forward")
                .journalTitle("Boiling Point")
                .issue("64")
                .pages("6-9")
                .isOnlyAvailableOnline(true)
                .isOpenAccessRepo(true)
                .availableFrom("http://hdl.handle. net/2086/11599")
                .accessedDate("17/03/16")
                .build();
        //when
        JournalArticleResponse journalArticleResponse = journalArticleService.generateReference(journalArticleDto);
        String resultReference = "";
        resultReference += journalArticleResponse.getAuthorsPart();
        resultReference += journalArticleResponse.getYearPart();
        resultReference += journalArticleResponse.getArticleTitlePart();
        resultReference += journalArticleResponse.getJournalTitlePart();
        resultReference += journalArticleResponse.getForthcomingOrPostprintPart();
        resultReference += journalArticleResponse.getVolIssueMonthPart();
        resultReference += journalArticleResponse.getComaAndSpacePart();
        resultReference += journalArticleResponse.getPagesPart();
        resultReference += journalArticleResponse.getAvailableFromAndAccessedDatePart();

        //then
        String expectedResult = "PALIT, D. and BHATTACHARYYA, S.C. (2014) Adoption of cleaner cookstoves: barriers and way forward. Boiling Point [Post-print] (Issue 64), pp. 6-9. Available from: http://hdl.handle. net/2086/11599 [Accessed 17/03/16].";

        assertEquals(expectedResult, resultReference);
    }
}
