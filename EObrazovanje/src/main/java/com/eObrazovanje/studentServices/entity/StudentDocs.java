package com.eObrazovanje.studentServices.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "student_docs")
public class StudentDocs implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "student_docs_id", unique = true, nullable = false)
	private int id;
	
	@Column(name = "student_docs_name", unique = true, nullable = false)
	private String name;
	
	@Column(name = "student_docs_mime_type", unique = false, nullable = false)
	private String mimeType;
	
	@Column(name = "student_docs_path", unique = true, nullable = false)
	private String path;
	
	@Column(name = "student_docs_date", unique = false, nullable = true)
	private Date docDate;

	@ManyToOne
    @JoinColumn(name = "student_docs", referencedColumnName = "student_id", nullable = false)
	private Student student_docs;

	public StudentDocs() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMimeType() {
		return mimeType;
	}

	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Date getDocDate() {
		return docDate;
	}

	public void setDocDate(Date docDate) {
		this.docDate = docDate;
	}

	public Student getStudent() {
		return student_docs;
	}

	public void setStudent(Student student) {
		this.student_docs = student;
	}

}
