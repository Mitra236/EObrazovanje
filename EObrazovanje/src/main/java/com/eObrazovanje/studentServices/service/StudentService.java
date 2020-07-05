package com.eObrazovanje.studentServices.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eObrazovanje.studentServices.DTO.ExamDTO;
import com.eObrazovanje.studentServices.DTO.ExamRegistrationDTO;
import com.eObrazovanje.studentServices.DTO.FinancialCardDTO;
import com.eObrazovanje.studentServices.DTO.StudentBasicInfoDTO;
import com.eObrazovanje.studentServices.DTO.StudentDTO;
import com.eObrazovanje.studentServices.DTO.StudentDetailsDTO;
import com.eObrazovanje.studentServices.entity.EExamStatus;
import com.eObrazovanje.studentServices.entity.Exam;
import com.eObrazovanje.studentServices.entity.ExamRegistration;
import com.eObrazovanje.studentServices.entity.FinancialCard;
import com.eObrazovanje.studentServices.entity.Student;
import com.eObrazovanje.studentServices.repository.StudentRepository;

@Service
public class StudentService implements StudentServiceInterface {

	@Autowired
	StudentRepository studentRepository;

	@Override
	public StudentDetailsDTO findOne(int id) {
		// TODO Auto-generated method stub
		Student student = studentRepository.findById(id).orElse(null);
		
		return new StudentDetailsDTO(student);
	}
	
	@Override
	public StudentDTO findOneForEnrollment(int id) {
		// TODO Auto-generated method stub
		Student student = studentRepository.findById(id).orElse(null);
		
		return new StudentDTO(student);
	}

	@Override
	public List<StudentDTO> findAll() {
		// TODO Auto-generated method stub
		List<Student> students = studentRepository.findAll();
		
		List<StudentDTO> studentsDTOs = new ArrayList<>();
		for(Student stud : students) {
			studentsDTOs.add(new StudentDTO(stud));
		}
		
		return studentsDTOs;
	}

	@Override
	public int save(Student student) {
		// TODO Auto-generated method stub
		return studentRepository.save(student).getId();
	}

	@Override
	public List<ExamRegistrationDTO> findPassedExams(int id) {
		// TODO Auto-generated method stub
		Student student = studentRepository.findById(id).orElse(null);
		List<ExamRegistrationDTO> passedExams = new ArrayList<ExamRegistrationDTO>();
		
		if(student != null && student.getExamsTaken() != null && student.getExamsTaken().size() > 0 ) {
			passedExams = filterExams(EExamStatus.Passed,student.getExamsTaken() );
		}
		
		return passedExams;
	}

	@Override
	public List<ExamRegistrationDTO> findFailedExams(int id) {
		// TODO Auto-generated method stub
		Student student = studentRepository.findById(id).orElse(null);
		List<ExamRegistrationDTO> failedExams = new ArrayList<ExamRegistrationDTO>();
		
		if(student != null && student.getExamsTaken() != null && student.getExamsTaken().size() > 0 ) {
			failedExams = filterExams(EExamStatus.Failed,student.getExamsTaken() );
		}
		
		return failedExams;
	}
	
	public List<ExamRegistrationDTO> filterExams(EExamStatus status, List<ExamRegistration> exams){
		List<ExamRegistration> filteredExams = new ArrayList<ExamRegistration>();
		
		for(ExamRegistration e : exams) {
			if(e.getStatus().equals(status)) {
				filteredExams.add(e);
			}
		}

		List<ExamRegistrationDTO> examsDTO = new ArrayList<ExamRegistrationDTO>();
		if(exams.size()>0) {
			for(ExamRegistration e : filteredExams) {
				examsDTO.add(new ExamRegistrationDTO(e));
			}
		}
		
		return examsDTO;
	}

	@Override
	public List<ExamRegistrationDTO> findTakenExams(int id) {
		// TODO Auto-generated method stub
		Student student = studentRepository.findById(id).orElse(null);
		
		List<ExamRegistration> exams = new ArrayList<ExamRegistration>();
		if(student != null) {
			exams = student.getExamsTaken();
		}
		
		List<ExamRegistrationDTO> examsDTO = new ArrayList<ExamRegistrationDTO>();
		if(exams.size() > 0) {
			for(ExamRegistration e : exams) {
				examsDTO.add(new ExamRegistrationDTO(e));
			}
		}

		return examsDTO;
	}

	@Override
	public List<StudentBasicInfoDTO> getNotEnrolledStudents(int id) {
		List<StudentBasicInfoDTO> studentsDTO = new ArrayList<>();
		List<Student> students = studentRepository.getNotEnrolledStudents(id);
		
		for (Student s: students) {
			studentsDTO.add(new StudentBasicInfoDTO(s));
		}
		
		return studentsDTO;
	}

	@Override
	public List<FinancialCardDTO> getFinancialCardInfo(int id) {
		List<FinancialCardDTO> studentsTransactionsDTO = new ArrayList<>();
		Student student = studentRepository.findById(id).orElse(null);
		
		if(student != null) {
			if(student.getFinancialCard().size() > 0) {
				for(FinancialCard fCard : student.getFinancialCard()) {
					studentsTransactionsDTO.add(new FinancialCardDTO(fCard));
				}
			}
		}
		// TODO Auto-generated method stub
		return studentsTransactionsDTO;
	}
}
