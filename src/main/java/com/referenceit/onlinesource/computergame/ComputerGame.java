package com.referenceit.onlinesource.computergame;


import com.referenceit.otherprintsource.OtherPrintSource;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
public class ComputerGame extends OtherPrintSource {

    private String mediumOfItem;
    private String platform;

}
