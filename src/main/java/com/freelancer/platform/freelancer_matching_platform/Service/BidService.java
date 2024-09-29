package com.freelancer.platform.freelancer_matching_platform.Service;

import com.freelancer.platform.freelancer_matching_platform.Entity.Bid;
import com.freelancer.platform.freelancer_matching_platform.Repository.BidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BidService {

    private final BidRepository bidRepository;

    @Autowired
    public BidService(BidRepository bidRepository) {
        this.bidRepository = bidRepository;
    }

    // Yeni teklif ekleme
    public Bid addBid(Bid bid) {
        return bidRepository.save(bid);
    }

    // Tüm teklifleri listeleme
    public List<Bid> getAllBids() {
        return bidRepository.findAll();
    }

    // ID ile teklif bulma
    public Bid getBidById(Long id) {
        return bidRepository.findById(id).orElseThrow(() -> new RuntimeException("Teklif bulunamadı"));
    }

    // Teklif güncelleme
    public Bid updateBid(Long id, Bid updatedBid) {
        Bid existingBid = getBidById(id);
        existingBid.setAmount(updatedBid.getAmount());
        existingBid.setStatus(updatedBid.getStatus());
        // Diğer alanları güncelle...
        return bidRepository.save(existingBid);
    }

    // Teklif silme
    public void deleteBid(Long id) {
        bidRepository.deleteById(id);
    }

    // Proje için teklifleri listeleme
    public List<Bid> getBidsByProjectId(Long projectId) {
        return bidRepository.findByProjectId(projectId);
    }
}