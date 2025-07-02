package org.example.binlookupservice.model;

import lombok.Data;

import java.util.List;

@Data
public class CardRangeData {
    private String startRange;
    private String endRange;
    private String threeDSMethodURL;

    // Optional fields if needed later
    private String actionInd;
    private String acsStartProtocolVersion;
    private String acsEndProtocolVersion;
    private List<String> acsInfoInd;
}
