package com.ImageMatcherProject.Image_Matcher.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ImageMatcherProject.Image_Matcher.Entity.Image;
import com.ImageMatcherProject.Image_Matcher.Repository.ImageRepo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ImageService {

    @Autowired
    private ImageRepo imageRepository;




    public List<Image> findImagesByMetadata(String name, String category) {
    if (name != null && !name.isEmpty() && category != null && !category.isEmpty()) {
        return imageRepository.findByNameAndCategory(name, category);
    }
    else if (name != null && !name.isEmpty()) {
        return imageRepository.findByName(name);
    }
    else if (category != null && !category.isEmpty()) {
        return imageRepository.findByCategory(category);
    }
    return new ArrayList<>();
}


    // public List<Image> findImagesByMetadata(String name, String category, String keywords) {
    //     return imageRepository.findByNameAndCategoryAndKeywords(name, category, keywords);
    // }
    public void saveImage(MultipartFile uploadedImage, String name, String category, String keywords) {
        try {
            Image image = new Image();
            image.setName(name);
            image.setCategory(category);
            image.setKeywords(keywords);
            image.setImageData(uploadedImage.getBytes());
            imageRepository.save(image);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to save image", e);
        }
    }

    public String convertToBase64(MultipartFile uploadedImage) {
        try {
            byte[] imageData = uploadedImage.getBytes();
            return java.util.Base64.getEncoder().encodeToString(imageData);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to convert image to Base64", e);
        }
    }

    
}



















