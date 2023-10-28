package dev.arif.ratingservice.controller;

import dev.arif.ratingservice.models.Ratings;
import dev.arif.ratingservice.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {


    private final RatingService ratingService;

    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @GetMapping("/{productId}")
    public List<Ratings> getRatingByProductId(@PathVariable("productId") String productId){
        return ratingService.getRatingByProductId(productId);
    }

    @GetMapping("/rating/{id}")
    public Ratings getRatingById(@PathVariable("id") Long id){
        return ratingService.getRatingById(id);
    }
    @PostMapping("/")
    public Ratings saveRating(@RequestBody Ratings ratings){
        return ratingService.saveRating(ratings);
    }
    @DeleteMapping("/{id}")
    public void deleteRatingById(@PathVariable("id") Long id){
        ratingService.deleteRatingById(id);
    }
    @PutMapping("/{id}")
    public Ratings updateRatingById(@PathVariable("id") Long id, @RequestBody Ratings ratings){
        return ratingService.updateRatingById(id, ratings);
    }

    @GetMapping("/average/{productId}")
    public double getAverageRating(@PathVariable("productId") String productId){
        return ratingService.getAverageRating(productId);
    }

}
