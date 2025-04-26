package com.MeetIn_Ethiopia.MeetInEthiopia_Portal.domain.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Page {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;   // Example: Home, About, Events

    @Column(length = 10000)
    private String content;  // Main text content (rich text)

    private String slug;     // Example: /home, /about, /events

    private boolean published = true;

    // --- New Fields ---
    private String imageUrl;   // Link to an optional cover image
    private String videoUrl;   // Link to an optional video (YouTube, MP4, etc.)

    private String metaDescription;
    private String metaKeywords;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}

