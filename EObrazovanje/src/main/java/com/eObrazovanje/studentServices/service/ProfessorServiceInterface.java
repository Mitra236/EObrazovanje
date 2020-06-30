package com.eObrazovanje.studentServices.service;

import java.util.List;
import com.eObrazovanje.studentServices.DTO.ProfessorDTO;
import com.eObrazovanje.studentServices.DTO.ProfessorDataEditDTO;

public interface ProfessorServiceInterface {

	ProfessorDTO findOne(int id);
	List<ProfessorDTO> findAll();
	int save(ProfessorDTO professorDTO);
	void update(ProfessorDataEditDTO professorDataEditDTO);
}
