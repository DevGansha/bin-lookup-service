package org.example.binlookupservice.model;

import lombok.Data;

import java.util.List;

@Data
public class PResMessage {
    private String serialNum;
    private String messageType;
    private String dsTransID;
    private String messageVersion;
    private String dsStartProtocolVersion;
    private String dsEndProtocolVersion;
    private String threeDSServerTransID;
    private List<CardRangeData> cardRangeData;
}
