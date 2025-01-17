package com.ImageMatcherProject.Image_Matcher.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ImageMatcherProject.Image_Matcher.Entity.Image;


import java.util.List;

@Repository
public interface ImageRepo extends JpaRepository<Image, Long> {
    List<Image> findByNameAndCategoryAndKeywords(String name, String category, String keywords);

}