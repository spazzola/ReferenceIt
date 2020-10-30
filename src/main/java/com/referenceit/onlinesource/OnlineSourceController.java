package com.referenceit.onlinesource;

import com.referenceit.onlinesource.blog.BlogDto;
import com.referenceit.onlinesource.blog.BlogResponse;
import com.referenceit.onlinesource.blog.BlogService;
import com.referenceit.onlinesource.computergame.ComputerGameDto;
import com.referenceit.onlinesource.computergame.ComputerGameResponse;
import com.referenceit.onlinesource.computergame.ComputerGameService;
import com.referenceit.onlinesource.email.EmailDto;
import com.referenceit.onlinesource.email.EmailResponse;
import com.referenceit.onlinesource.email.EmailService;
import com.referenceit.onlinesource.financialreport.FinancialReportDto;
import com.referenceit.onlinesource.financialreport.FinancialReportResponse;
import com.referenceit.onlinesource.financialreport.FinancialReportService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/onlinesource")
public class OnlineSourceController {

    private BlogService blogService;
    private ComputerGameService computerGameService;
    private EmailService emailService;
    private FinancialReportService financialReportService;


    @PostMapping("/blog/create")
    public BlogResponse generateBlogResponse(@RequestBody BlogDto blogDto) {
        return blogService.generateReference(blogDto);
    }

    @PostMapping("/computergame/create")
    public ComputerGameResponse generateComputerGameReference(@RequestBody ComputerGameDto computerGameDto) {
        return computerGameService.generateReference(computerGameDto);
    }

    @PostMapping("/email/create")
    public EmailResponse generateEmailReference(@RequestBody EmailDto emailDto) {
        return emailService.generateReference(emailDto);
    }

    @PostMapping("/financialreport/create")
    public FinancialReportResponse generateFinancialReportReference(@RequestBody FinancialReportDto financialReportDto) {
        return financialReportService.generateReference(financialReportDto);
    }

}
