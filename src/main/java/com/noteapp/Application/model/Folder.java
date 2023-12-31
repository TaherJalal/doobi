package com.noteapp.Application.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "folders")
public class Folder {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private Boolean isPrivate;
    private List<String> images= new ArrayList<>();

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @JsonManagedReference
    @ElementCollection
    @CollectionTable(name = "user_notes", joinColumns = @JoinColumn(name = "folder_id"))
    @Column(name = "note_ids", nullable = true)
    @OneToMany(mappedBy = "folder", cascade = CascadeType.ALL)
    private List<Note> notes = new ArrayList<>();
}
