package org.example.binlookupservice.controller;

import org.example.binlookupservice.model.CardRangeData;
import org.example.binlookupservice.model.request.PanRequest;
import org.example.binlookupservice.service.CardRangeLookupService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/bin")
public class CardRangeController {
    private final CardRangeLookupService lookupService;

    public CardRangeController(CardRangeLookupService lookupService) {
        this.lookupService = lookupService;
    }

    @PostMapping("/lookup")
    public ResponseEntity<?> lookupByPan(@RequestBody PanRequest request) {
        Optional<CardRangeData> match = lookupService.findMatchingRange(request.getPan());
        return match
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
