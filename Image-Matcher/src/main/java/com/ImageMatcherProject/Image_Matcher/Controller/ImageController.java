package com.ImageMatcherProject.Image_Matcher.Controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.ImageMatcherProject.Image_Matcher.Entity.Image;
import com.ImageMatcherProject.Image_Matcher.Service.ImageService;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/images")
public class ImageController {

    @Autowired
    private ImageService imageService;  

    @PostMapping("/upload")
    public ResponseEntity<?> uploadImage(
            @RequestParam("image") MultipartFile uploadedImage,
            @RequestParam("name") String name,
            @RequestParam("category") String category,
            @RequestParam("keywords") String keywords) {

        List<String> validTypes = Arrays.asList("image/jpeg", "image/png");
        if (!validTypes.contains(uploadedImage.getContentType())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Only JPG and PNG files are allowed!");
        }

        List<Image> similarImages = imageService.findImagesByMetadata(name, category, keywords);

        // Save the image even if no similar images are found
        imageService.saveImage(uploadedImage, name, category, keywords);

        if (similarImages.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No similar images found! Image uploaded successfully.");
        }
        return ResponseEntity.ok(similarImages);
    }
}









