package com.noteapp.Application.repository;

import com.noteapp.Application.model.Folder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface FolderRepository extends JpaRepository<Folder, UUID> {
    Folder findFolderById(UUID id);
    @Query("SELECT f FROM Folder f WHERE f.isPrivate = false")
    List<Folder> findAllFolders();

    @Query("SELECT f FROM Folder f JOIN f.user u WHERE u.id = :id")
    List<Folder> findAllUserFolderByUserId(UUID id);

    @Query("SELECT f FROM Folder f JOIN f.user u WHERE u.id = :id AND f.isPrivate = true")
    List<Folder> findAllUserPrivateFolderByUserId(UUID id);

    Folder getFolderById(UUID id);

    @Query("DELETE from Folder f WHERE f.id= :id")
    String deleteFolderById(UUID id);
}
