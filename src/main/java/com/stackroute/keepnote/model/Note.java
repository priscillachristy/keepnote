package com.stackroute.keepnote.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

//import org.hibernate.validator.constraints.NotEmpty;
//import org.joda.time.LocalDate;

/*
 * The class "Note" will be acting as the data model for the note Table in the database. Please
 * note that this class is annotated with @Entity annotation. Hibernate will scan all package for
 * any Java objects annotated with the @Entity annotation. If it finds any, then it will begin the
 * process of looking through that particular Java object to recreate it as a table in your database.
 */
@Entity
@Table(name="NOTE")
public class Note {
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID",nullable = false)
	private int id;
	@Column(name = "NOTETITLE",nullable = false)
	private String noteTitle;
	@Column(name = "NOTECONTENT",nullable = false)
	private String noteContent;
	@Column(name = "NOTESTATUS",nullable = false)
	private String noteStatus;
	@Column(name = "DT",nullable = false)
	private LocalDateTime dateTime;
	public Note() {

	}

	public Note(int i, String string, String string2, String string3, LocalDateTime localDate) {
		this.id=i;
		this.noteTitle=string;
		this.noteContent=string2;
		this.noteStatus=string3;
		this.dateTime=localDate;
		System.out.println("in const"+id+noteTitle+noteContent+noteStatus+dateTime);
	}

	public int getNoteId() {

		return id;
	}

	public String getNoteTitle() {

		return noteTitle;
	}

	public String getNoteContent() {

		return noteContent;
	}

	public String getNoteStatus() {

		return noteStatus;
	}

	public void setNoteId(int parseInt) {
		this.id=parseInt;
	}

	public void setNoteTitle(String parameter) {
		this.noteTitle=parameter;
	}

	public void setNoteContent(String parameter) {
		this.noteContent=parameter;
	}

	public void setNoteStatus(String parameter) {
		this.noteStatus=parameter;
	}

	public void setCreatedAt(LocalDateTime now) {
		this.dateTime=now;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + noteTitle + ", joiningDate="
				+ noteContent + ", salary=" + noteStatus + ", ssn=" + id + "]";
	}

}