package com.referenceit.reference;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ReferenceResponse {

    private String firstPartNormal;
    private String italicsPart;
    private String thirdPartNormal;


    @Override
    public String toString() {
        String result = "";
        if (firstPartNormal != null) {
            result += firstPartNormal;
        } else {
            result += "";
        }

        if (italicsPart != null) {
            result += italicsPart;
        } else {
            result += "";
        }

        if (thirdPartNormal != null) {
            result += thirdPartNormal;
        } else {
            result += "";
        }

        return result;
    }

}
