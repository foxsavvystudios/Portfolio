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
    public Artist getArtistById(@PathVariable Long artistId) throws ArtistNotFoundException {
        return artistRepository.findById(artistId).orElseThrow(() -> new ArtistNotFoundException(artistId));
    }

    @PutMapping("/{artistId}")
    public Artist editArtist(@RequestBody Artist newArtist, @PathVariable Long artistId) throws ArtistNotFoundException {
        Artist artist = artistRepository.findById(artistId).orElseThrow(() -> new ArtistNotFoundException(artistId));
        newArtist.setArtistId(artist.getArtistId());
        return artistRepository.save(newArtist);
    }

    @DeleteMapping("/{artistId}")
    public void deleteArtist(@PathVariable Long artistId) throws ArtistNotFoundException {
        Artist artist = artistRepository.findById(artistId).orElseThrow(() -> new ArtistNotFoundException(artistId));
        artistRepository.delete(artist);
    }
}
