package com.foxsavvystudios.portfolio.core.artist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/artist")
public class ArtistController {

    private ArtistRepository artistRepository;

    public ArtistController(@Autowired ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
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
    public Artist getArtistById(@PathVariable Long artistId) throws EntityNotFoundException {
        return artistRepository.findById(artistId).orElseThrow(() -> new EntityNotFoundException(Artist.class, artistId));
    }

    @PutMapping("/{artistId}")
    public Artist editArtist(@RequestBody Artist newArtist, @PathVariable Long artistId) throws EntityNotFoundException {
        Artist artist = artistRepository.findById(artistId).orElseThrow(() -> new EntityNotFoundException(Artist.class, artistId));
        newArtist.setArtistId(artist.getArtistId());
        return artistRepository.save(newArtist);
    }

    @DeleteMapping("/{artistId}")
    public void deleteArtist(@PathVariable Long artistId) throws EntityNotFoundException {
        Artist artist = artistRepository.findById(artistId).orElseThrow(() -> new EntityNotFoundException(Artist.class, artistId));
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
