package org.example.binlookupservice.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import org.example.binlookupservice.model.CardRangeData;
import org.example.binlookupservice.model.PResMessage;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class CardRangeLoaderService {

    private final List<CardRangeData> cardRanges = new ArrayList<>();

    public List<CardRangeData> getCardRanges() {
        return cardRanges;
    }

    @PostConstruct
    public void loadCardRanges() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("700k-pres.json.data");
            PResMessage message = mapper.readValue(inputStream, PResMessage.class);
            cardRanges.addAll(message.getCardRangeData());
            System.out.println("Loaded " + cardRanges.size() + " card ranges.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
