package com.eObrazovanje.studentServices.service;

import java.util.List;
import com.eObrazovanje.studentServices.DTO.ProfessorDTO;
import com.eObrazovanje.studentServices.DTO.ProfessorDataEditDTO;
import com.eObrazovanje.studentServices.entity.Professor;

public interface ProfessorServiceInterface {

	ProfessorDataEditDTO findOneProfessor(int id);
	ProfessorDTO findOne(int id);
	List<ProfessorDTO> findAll();
	List<ProfessorDTO> findProfessorsForAdmin();
	int save(ProfessorDTO professorDTO);
	void updateAllData(ProfessorDTO professorDTO);
	boolean remove(int id);
	void update(ProfessorDataEditDTO professorDataEditDTO);
	List<Professor> findAllProfessors();
}
