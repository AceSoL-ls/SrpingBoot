package com.example.app.controllers;

import com.example.app.models.Photo;
import com.example.app.services.PhotoNotFound;
import com.example.app.view.PhotoView;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/photos")
public class PhotoController {
    private List<Photo> photos = new ArrayList<>();
    private PhotoView view;
    private Integer nextid = 1;

    public PhotoController() {
        photos.add(new Photo(nextid++, "2025", "Happy hour"));
        photos.add(new Photo(nextid++, "2012", "Matrix"));
        photos.add(new Photo(nextid++, "2019", "Hero"));
        photos.add(new Photo(nextid++, "2001", "Sid 3"));
    }
    @GetMapping("")
    public List<Photo> get(){
        return photos;
    }
    @GetMapping("/{id}")
    public Photo getid(@PathVariable Integer id){
        Photo n = null;
        for (Photo g : photos){
            if (g.getId()==id){
                return g;
            }
        }
        throw new PhotoNotFound();
    }

    @PostMapping("")
    public void post(@RequestBody Photo photo){
        photo.setId(nextid++);
        photos.add(photo);
    }

    @PutMapping("/{id}")
    public void put(@PathVariable Integer id, @RequestBody Photo photo){
        for (Photo g : photos){
            if (g.getId()==id){
                g.setTitle(photo.getTitle());
                g.setDate(photo.getDate());
            }
        }
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        for (Photo g : photos){
            if (g.getId()==id){
                photos.remove(g);
                break;
            }
        }
    }
}
