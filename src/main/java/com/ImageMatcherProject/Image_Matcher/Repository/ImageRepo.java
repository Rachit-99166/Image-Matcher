package com.ImageMatcherProject.Image_Matcher.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ImageMatcherProject.Image_Matcher.Entity.Image;


import java.util.List;

@Repository
public interface ImageRepo extends JpaRepository<Image, Long> {
    // List<Image> findByNameAndCategoryAndKeywords(String name, String category, String keywords);

    List<Image> findByNameAndCategory(String name, String category);

    // Search by name
    List<Image> findByName(String name);

    // Search by category
    List<Image> findByCategory(String category);

}