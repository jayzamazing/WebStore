package com.adrianjaylopez.webstore.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

/**
 * Repository used to persist image to database.
 * Created by Jay on 11/29/15.
 */
@Component
public interface ImageRepository extends JpaRepository<Image, Long> {
    Image findByFilename(String filename);

}
