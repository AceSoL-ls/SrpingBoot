package com.example.app.controllers;

import com.example.app.PhotoRepository;
import com.example.app.models.Photo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/photos")
public class PhotoController {

    private final PhotoRepository repo;

    public PhotoController(PhotoRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Photo> getAll() {
        return repo.findAll();
    }

    @PostMapping
    public Photo create(@RequestBody Photo p) {
        return repo.save(p);
    }
}
