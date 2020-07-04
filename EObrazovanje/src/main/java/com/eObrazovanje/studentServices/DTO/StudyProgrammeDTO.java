package com.eObrazovanje.studentServices.DTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.eObrazovanje.studentServices.entity.Course;
import com.eObrazovanje.studentServices.entity.Professor;
import com.eObrazovanje.studentServices.entity.Student;
import com.eObrazovanje.studentServices.entity.StudyProgramme;

public class StudyProgrammeDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public int id;
	public String name;
	public List<StudentDetailsDTO> studentsDTO;
	public List<StudyProgrammeCourseDetailsDTO> coursesDTO;
	
	public StudyProgrammeDTO(StudyProgramme prog) {
		this.id = prog.getId();
		this.name = prog.getName();
		this.coursesDTO= new ArrayList<StudyProgrammeCourseDetailsDTO>();
		this.studentsDTO = new ArrayList<StudentDetailsDTO>();
		List<Student> students = prog.getStudents();
		for(Student s: students) {
			studentsDTO.add(new StudentDetailsDTO(s));
		}
		List<Course> courses = prog.getCourses();
		for(Course c:courses) {
			List<Professor> profs = c.getProfessors();
			Professor prof = null;
			if(profs != null)
				if(profs.size() > 0)
					prof = profs.get(0);
			
			coursesDTO.add(
					new StudyProgrammeCourseDetailsDTO(
							c.getId(), 
							c.getName(),
							c.getCourseCode(),
							(prof != null ? prof.getLastName() : "")
					)
			);
		}
	}
	
	
	public StudyProgrammeDTO() {
		super();
	}	
}
