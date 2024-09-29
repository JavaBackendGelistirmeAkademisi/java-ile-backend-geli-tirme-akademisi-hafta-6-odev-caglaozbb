package com.freelancer.platform.freelancer_matching_platform.Controller;

import com.freelancer.platform.freelancer_matching_platform.Entity.Bid;
import com.freelancer.platform.freelancer_matching_platform.Service.BidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bids")
public class BidController {

    private final BidService bidService;

    @Autowired
    public BidController(BidService bidService) {
        this.bidService = bidService;
    }

    // Yeni teklif ekleme
    @PostMapping
    public ResponseEntity<Bid> createBid(@RequestBody Bid bid) {
        Bid createdBid = bidService.addBid(bid);
        return ResponseEntity.ok(createdBid);
    }

    // Tüm teklifleri listeleme
    @GetMapping
    public ResponseEntity<List<Bid>> getAllBids() {
        List<Bid> bids = bidService.getAllBids();
        return ResponseEntity.ok(bids);
    }

    // ID ile teklifi bulma
    @GetMapping("/{id}")
    public ResponseEntity<Bid> getBidById(@PathVariable Long id) {
        Bid bid = bidService.getBidById(id);
        return ResponseEntity.ok(bid);
    }

    // Teklifi güncelleme
    @PutMapping("/{id}")
    public ResponseEntity<Bid> updateBid(@PathVariable Long id, @RequestBody Bid bid) {
        Bid updatedBid = bidService.updateBid(id, bid);
        return ResponseEntity.ok(updatedBid);
    }

    // Teklifi silme
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBid(@PathVariable Long id) {
        bidService.deleteBid(id);
        return ResponseEntity.noContent().build();
    }
}
