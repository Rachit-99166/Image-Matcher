# Image Matcher Project

![Screenshot 2025-01-20 144550](https://github.com/user-attachments/assets/09fa8d84-4f99-4305-8d90-e088197dee34)


# Overview

The Image Matcher Project allows users to upload images and search for visually similar images based on metadata. Users can upload an image through file upload. Along with the image, users can input metadata such as name, category, and keywords. This project uses a Spring Boot backend and a responsive frontend built with HTML, CSS, and Bootstrap. The application is hosted on Microsoft Azure, ensuring scalability and reliability. For database it uses SQL and H2DB.


# Features

Image Upload:

 1.Supports uploading images in JPG or PNG formats.
Validates file size and type for security and consistency.

Metadata-Based Search:

1.Users can input metadata (e.g., name, category, and keywords) to enhance search accuracy.

Similarity Matching:

1.Retrieves images with similar metadata (e.g., category or keywords) from the database.

2.Uses an H2 Database for development and testing, with the ability to transition to a cloud-based database (e.g., Azure SQL or MongoDB) in production.

Responsive UI:

1.A clean and user-friendly interface optimized for desktops, tablets, and mobile devices.

Cloud Hosting:

1.Deployed on Azure App Service, leveraging the platform's scalability and global availability.

# How it works

User Input:

Users upload an image and optionally provide metadata (name, category, and keywords).

Backend Processing:

Validates the uploaded file (type and size).

Stores the image in Azure Blob Storage and metadata in the H2 Database during development or a cloud database in production.

Performs metadata-based searches to find similar images.

Search Results:

Displays similar images along with their metadata.

If no similar images are found, the uploaded image and metadata are stored for future reference.

# Example 

If a user uploads an image of a scientist with the following metadata:  (**Only One Word Allowed**)

Name: Einstein
Category: Scientist
Keywords: Physics

or 

Category: Scientist
Keywords: Physics

The system will:

Search for and display images of scientists with related metadata, such as "Physics" or "Scientist".

If no matching images exist, it stores the uploaded image and metadata for future reference which can be seen on website again when user hits submit.

# Supported Categories

Car,
Animal,
Electronics,
Buildings,
Sports,
Movies,
Scientist,
Athletes,
Colleges, and 
Companies.

Note: You can add your own category, name, and keyword with the supporting image.
