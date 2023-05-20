package com.realestate.re.service;

import java.util.Set;

import com.realestate.re.model.re.Image;

public interface ImageService {

    public Image addImage(Image image);

    public Image getImage(Long iId);

    public Image updateImage(Image image);

    public void deleteImage(Long iId);

    public Set<Image> getImages();
    
}
