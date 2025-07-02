package org.example.binlookupservice.model;

import lombok.Data;

import java.util.List;

@Data
public class PResMessage {
    private String serialNum;
    private String messageType;
    private String dsTransID;
    private List<CardRangeData> cardRangeData;
}
