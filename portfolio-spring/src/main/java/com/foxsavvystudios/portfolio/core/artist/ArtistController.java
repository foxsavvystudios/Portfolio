package com.foxsavvystudios.portfolio.core.artist;

import com.foxsavvystudios.portfolio.core.exception.EntityNotFoundException;
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
}
