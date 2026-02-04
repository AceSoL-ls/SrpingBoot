package com.example.app.controllers;

import com.example.app.PhotoRepository;
import com.example.app.models.Photo;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/photos")
public class PhotoController {

    private final PhotoRepository repo;

    // Constructor injection (Best practice)
    public PhotoController(PhotoRepository repo) {
        this.repo = repo;
    }

    // Use Iterable to avoid type mismatch with CrudRepository
    @GetMapping
    public Iterable<Photo> getAll() {
        return repo.findAll();
    }

    // Create a new photo
    @PostMapping
    public Photo create(@RequestBody Photo p) {
        return repo.save(p);
    }

    // Bonus: Add a Get by ID so you can see single photos
    @GetMapping("/{id}")
    public Photo get(@PathVariable Integer id) {
        return repo.findById(id).orElse(null);
    }
}