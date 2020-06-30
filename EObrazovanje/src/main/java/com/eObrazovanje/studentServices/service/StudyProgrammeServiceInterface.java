package com.eObrazovanje.studentServices.service;

import java.util.List;

import com.eObrazovanje.studentServices.DTO.CourseDTO;
import com.eObrazovanje.studentServices.DTO.ExamRegistrationDTO;
import com.eObrazovanje.studentServices.DTO.StudentDTO;
import com.eObrazovanje.studentServices.DTO.StudyProgrammeDTO;
import com.eObrazovanje.studentServices.entity.StudyProgramme;

public interface StudyProgrammeServiceInterface {
	
	StudyProgrammeDTO findOne(int id);
	List<StudyProgrammeDTO> findAll();
	List<CourseDTO> findCoursesByProgramme(int id);
	List<StudentDTO> findStudentsByProgramme(int id);
	int saveCourseToProgramme(StudyProgrammeDTO prog, CourseDTO coDTO);
	int saveStudentToProgramme(StudyProgramme studyProgramme);
	int save(StudyProgramme studyProgramme);
	boolean remove(int id);
	boolean removeCourseFromProgramme(int id, int programmeId);
	boolean removeStudentFromProgramme(int id);

}
