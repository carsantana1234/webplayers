package org.webplayerslib.model;

import java.io.Serializable;
import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Transient;

import org.springframework.web.multipart.commons.CommonsMultipartFile;



/**
 * Entity to persist data
 * @author Socrates
 *
 */
@Entity(name="player")
public class EntityPlayer implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="id")
	private Integer id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="surname")
	private String surName;
	
	@Column(name="age")
	private Integer age;
	
	@Column(name="id_visible")
	private Integer state;

	@Lob
	@Column(name="photo")
	private Blob photo;
	
	@Column(name="photo_name")
	private String photoName;
	
	@Column(name="photo_base64")
	private byte[] photoBase64;
	
	@Transient
	private CommonsMultipartFile photoFile;
	
	@Transient
	private String photoBase64String;
	

	public String getPhotoBase64String() {
		return new String (this.photoBase64);
	}

	public byte[]  getPhotoBase64() {
		return photoBase64;
	}

	public void setPhotoBase64(byte[] photoBase64) {
		this.photoBase64 = photoBase64;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}



	public String getPhotoName() {
		return photoName;
	}

	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}

	public CommonsMultipartFile getPhotoFile() {
		return photoFile;
	}

	public void setPhotoFile(CommonsMultipartFile photoFile) {
		this.photoFile = photoFile;
	}

	public Blob getPhoto() {
		return photo;
	}

	public void setPhoto(Blob photo) {
		this.photo = photo;
	}
	
	
	
}
