package com.foxsavvystudios.portfolio.core.artist;

import com.foxsavvystudios.portfolio.core.portfolio.Portfolio;
import com.foxsavvystudios.portfolio.core.portfolio.PortfolioRepository;
import com.foxsavvystudios.portfolio.core.portfolio.PortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/artist")
public class ArtistController {

    private final ArtistRepository artistRepository;
    private final PortfolioRepository portfolioRepository;
    private final PortfolioService portfolioService;

    public ArtistController(@Autowired ArtistRepository artistRepository,
                            @Autowired PortfolioRepository portfolioRepository,
                            @Autowired PortfolioService portfolioService) {
        this.artistRepository = artistRepository;
        this.portfolioRepository = portfolioRepository;
        this.portfolioService = portfolioService;
    }

    @GetMapping
    public List<Artist> getAllArtists() {
        return artistRepository.findAll();
    }

    @PostMapping
    public Artist createArtist(@RequestBody Artist artist) {
        return artistRepository.save(artist);
    }

    @GetMapping("/{artistId}")
    public Artist getArtistById(@PathVariable Long artistId) throws ArtistNotFoundException {
        return artistRepository.findById(artistId).orElseThrow(() -> new ArtistNotFoundException(artistId));
    }

    @PutMapping("/{artistId}")
    public Artist editArtist(@RequestBody Artist newArtist,
                             @PathVariable Long artistId) throws ArtistNotFoundException {
        Artist artist = artistRepository.findById(artistId).orElseThrow(() -> new ArtistNotFoundException(artistId));
        newArtist.setArtistId(artist.getArtistId());
        return artistRepository.save(newArtist);
    }

    @DeleteMapping("/{artistId}")
    public void deleteArtist(@PathVariable Long artistId) throws ArtistNotFoundException {
        Artist artist = artistRepository.findById(artistId).orElseThrow(() -> new ArtistNotFoundException(artistId));
        artistRepository.delete(artist);
    }

    @PostMapping("/{artistId}/portfolio")
    public Portfolio createArtistPortfolio(@PathVariable Long artistId,
                                           @RequestBody Map<String, String> body)
            throws HttpClientErrorException, ArtistNotFoundException {
        if(!body.containsKey("directory")) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "directory field is required");
        }

        Artist artist = artistRepository.findById(artistId)
                .orElseThrow(() -> new ArtistNotFoundException(artistId));

        if(artist.getPortfolio() == null) {
            artist.setPortfolio(
                    portfolioService.createPortfolioFromDirectory(body.get("directory")));
        } else {
            artist.setPortfolio(
                    portfolioService.updatePortfolioFromDirectory(artist.getPortfolio(), body.get("directory")));
        }
        artistRepository.save(artist);

        return artist.getPortfolio();
    }
}
