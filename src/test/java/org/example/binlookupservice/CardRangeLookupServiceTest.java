package org.example.binlookupservice;

import org.example.binlookupservice.model.CardRangeData;
import org.example.binlookupservice.service.CardRangeLoaderService;
import org.example.binlookupservice.service.CardRangeLookupService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CardRangeLookupServiceTest {

    private CardRangeLoaderService loaderService;
    private CardRangeLookupService lookupService;

    @BeforeEach
    void setup() {
        loaderService = mock(CardRangeLoaderService.class);

        CardRangeData range1 = new CardRangeData();
        range1.setStartRange("4000000000000000");
        range1.setEndRange("4000009999999999");
        range1.setThreeDSMethodURL("https://url1.com");

        CardRangeData range2 = new CardRangeData();
        range2.setStartRange("5000000000000000");
        range2.setEndRange("5000009999999999");
        range2.setThreeDSMethodURL("https://url2.com");

        when(loaderService.getCardRanges()).thenReturn(List.of(range1));

        lookupService = new CardRangeLookupService(loaderService);
    }

    @Test
    void shouldReturnCorrectRangeWhenPanMatches() {
        String testPan = "4000001234567890";
        Optional<CardRangeData> result = lookupService.findMatchingRange(testPan);

        assertNotNull(result);
        assertEquals("https://url1.com", result.get().getThreeDSMethodURL());
    }

    @Test
    void shouldReturnNullWhenPanDoesNotMatch() {
        String testPan = "6000001234567890";
        Optional<CardRangeData> result = lookupService.findMatchingRange(testPan);

        assertTrue(result.isEmpty());
    }
}

