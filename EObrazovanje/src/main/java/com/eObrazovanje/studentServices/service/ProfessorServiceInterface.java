package com.eObrazovanje.studentServices.service;

import java.util.List;
import com.eObrazovanje.studentServices.DTO.ProfessorDTO;
import com.eObrazovanje.studentServices.entity.Professor;

public interface ProfessorServiceInterface {

	Professor findOne(int id);
	List<ProfessorDTO> findAll();
	int save(Professor valuta);
}
