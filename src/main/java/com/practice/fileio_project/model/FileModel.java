package com.practice.fileio_project.model;

import javax.persistence.*;
import java.io.File;

@Entity
@Table(name = "files")
public class FileModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "fileId")
    private Long fileId;
    @Column(name = "name")
    private String name;
    @Column(name = "fileData")
    private byte[] file;
    @Column(name = "contentType")
    private String contentType;

    //Constructor
    public FileModel() {
    }

    //Getters and setters
    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }
}
