package org.example.binlookupservice.service;

import org.example.binlookupservice.model.CardRangeData;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
public class CardRangeLookupService {
    private final CardRangeLoaderService loaderService;

    public CardRangeLookupService(CardRangeLoaderService loaderService) {
        this.loaderService = loaderService;
    }

    public Optional<CardRangeData> findMatchingRange(String pan) {
        BigInteger panValue;

        try {
            panValue = new BigInteger(pan);
        } catch (NumberFormatException e) {
            return Optional.empty(); // Invalid PAN format
        }

        List<CardRangeData> ranges = loaderService.getCardRanges();

        for (CardRangeData range : ranges) {
            BigInteger start = new BigInteger(range.getStartRange());
            BigInteger end = new BigInteger(range.getEndRange());

            if (panValue.compareTo(start) >= 0 && panValue.compareTo(end) <= 0) {
                return Optional.of(range);
            }
        }

        return Optional.empty(); // No match
    }
}
