package com.realestate.re.service.impl;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.realestate.re.helper.ResourceNotFoundException;
import com.realestate.re.model.re.Image;
import com.realestate.re.repo.ImageRepository;
import com.realestate.re.service.ImageService;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageRepository imageRepository;

    @Override
    public Image addImage(Image image) {
        
        return this.imageRepository.save(image);
    }

    @Override
    public Image getImage(Long iId) {
        Optional<Image> image = this.imageRepository.findById(iId);
        if (image.isPresent()) {
            return image.get();
        } else {
            throw new ResourceNotFoundException("Image " + iId + " not found");
        }
    }

    @Override
    public Image updateImage(Image image) {
        Image image1 = new Image();
        image1.setiId(image.getiId());
        image1.setiUrl(image.getiUrl());
        image1.setProperty(image.getProperty());
        return this.imageRepository.save(image1);
    }

    @Override
    public void deleteImage(Long iId) {
        Image image = new Image();
        image.setiId(iId);
        this.imageRepository.delete(image);

    }

    @Override
    public Set<Image> getImages() {
        return new HashSet<>(this.imageRepository.findAll());

    }
    
}
