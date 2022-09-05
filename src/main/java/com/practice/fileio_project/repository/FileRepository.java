package com.practice.fileio_project.repository;

import com.practice.fileio_project.model.FileModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends JpaRepository<FileModel, Long> {
    FileModel findByName(String name);
}
