package com.eObrazovanje.studentServices.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eObrazovanje.studentServices.DTO.CourseDTO;
import com.eObrazovanje.studentServices.DTO.EnrollmentDTO;
import com.eObrazovanje.studentServices.DTO.EnrollmentToAddDTO;
import com.eObrazovanje.studentServices.DTO.ExamDTO;
import com.eObrazovanje.studentServices.DTO.ExamRegistrationDTO;
import com.eObrazovanje.studentServices.DTO.FinancialCardDTO;
import com.eObrazovanje.studentServices.DTO.StudentBasicInfoDTO;
import com.eObrazovanje.studentServices.DTO.StudentDTO;
import com.eObrazovanje.studentServices.DTO.StudentDetailsDTO;
import com.eObrazovanje.studentServices.entity.Course;
import com.eObrazovanje.studentServices.entity.EExamStatus;
import com.eObrazovanje.studentServices.entity.Enrollment;
import com.eObrazovanje.studentServices.entity.Exam;
import com.eObrazovanje.studentServices.entity.ExamRegistration;
import com.eObrazovanje.studentServices.entity.FinancialCard;
import com.eObrazovanje.studentServices.entity.Student;
import com.eObrazovanje.studentServices.entity.StudyProgramme;
import com.eObrazovanje.studentServices.repository.EnrollmentRepository;
import com.eObrazovanje.studentServices.repository.ExamRegistrationRepository;
import com.eObrazovanje.studentServices.repository.ExamRepository;
import com.eObrazovanje.studentServices.repository.FinancialCardRepository;
import com.eObrazovanje.studentServices.repository.StudentRepository;
import com.eObrazovanje.studentServices.repository.StudyProgrammeRepository;

import javassist.NotFoundException;

@Service
public class StudentService implements StudentServiceInterface {

	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	ExamRepository examRepository;
	
	@Autowired
	ExamRegistrationRepository examRegistrationRepository;
	
	@Autowired
	StudyProgrammeRepository studyProgrammeRepository;
	
	@Autowired
	EnrollmentRepository enrollmentRepository;
	
	@Autowired
	FinancialCardRepository financialCardRepository;

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

	@Override
	public List<ExamRegistrationDTO> findActiveExams(int id) {
		// TODO Auto-generated method stub
		Student student = studentRepository.findById(id).orElse(null);
		List<ExamRegistrationDTO> currentExams = new ArrayList<ExamRegistrationDTO>();

		Date currentDate = new Date(new java.util.Date().getTime());
		
		if(student != null ) {
			if(student.getExamsTaken().size() > 0) {
				for(ExamRegistration e : student.getExamsTaken()) {
					if(currentDate.before(e.getExam().getExam_date())) {
						currentExams.add(new ExamRegistrationDTO(e));
					}
				}
			}
		}
		
		return currentExams;
	}

	@Override
	public int registerExam(int studentId, int examId) {
		// TODO Auto-generated method stub
		Exam exam = examRepository.findById(examId).orElse(null);
		Student student = studentRepository.findById(studentId).orElse(null);
		
		if(exam != null && student != null) {
			ExamRegistration examReg = new ExamRegistration();
			examReg.setExam(exam);
			examReg.setStudent(student);
			examReg.setStatus(EExamStatus.ND);
			examReg.setExamPeriod(exam.getExamPeriod());
			examReg.setFinalGrade(5);
			examRegistrationRepository.save(examReg);
			
			double cost = exam.getExamPeriod().getPaymentAmount();
			FinancialCard transaction = new FinancialCard();
			transaction.setPaymentDate(new Date(new java.util.Date().getTime()));
			transaction.setPaymentAmount(cost);
			transaction.setPaymentDescription("Prijava ispita");
			transaction.setStudent(student);
			transaction.setTotalCost(cost);
			transaction.setTotalPayment(cost);
			
			financialCardRepository.save(transaction);
			
			student.setAccountBalance(student.getAccountBalance() - cost);
			studentRepository.save(student);
			return examReg.getId();
		}
		return 0;
	}

	@Override
	public List<ExamDTO> getCurrentExams(int id) {
		// TODO Auto-generated method stub
		Student student = studentRepository.findById(id).orElse(null);
		List<Exam> allExams = examRepository.findAll();
		List<Exam> currentExams = new ArrayList<>();
		
		Date currentDate = new Date(new java.util.Date().getTime());
		
		if(student != null) {
			for (Exam e : allExams) {
				if(e.getExamPeriod().getEndDate().after(currentDate) && 
						e.getExamPeriod().getStartDate().before(currentDate) && 
						e.getCourse().getStudyProgramme().getId() == student.getStudyProgramme().getId()) {
					
						currentExams.add(e);
					
				}
			}
		}
		
		if(student.getExamsTaken().size() > 0) {
			for(ExamRegistration eR : student.getExamsTaken()) {
				if(currentExams.contains(eR.getExam()) ) {
					currentExams.remove(eR.getExam());
				}
			}
		}
		
		List<ExamDTO> currentExamsDTOs = new ArrayList<>();
		
		for( Exam examToDTO : currentExams) {
			currentExamsDTOs.add(new ExamDTO(examToDTO));
		}
		
		return currentExamsDTOs;
	}
	
	@Override
	public List<EnrollmentDTO> enrollUserToProgrammeCourses(int studentId, int programmeId) {
		StudyProgramme prog = studyProgrammeRepository.findById(programmeId).orElse(null);


		List<EnrollmentDTO> enrollments = new ArrayList<EnrollmentDTO>();
		
		Student studentFromDB = studentRepository.findById(studentId).orElse(null);
		if(studentFromDB == null)
			return enrollments;
		
		for(Course c : prog.getCourses()) {
			Enrollment enrollment = new Enrollment();
			enrollment.setCourse(c);
			enrollment.setStudent(studentFromDB);
			enrollment.setStartDate(new Date(new java.util.Date().getTime()));

			Calendar cal = Calendar.getInstance();
			cal.setTime(enrollment.getStartDate());
			
			cal.add(Calendar.YEAR, 1);
			
			enrollment.setEndDate(new Date(cal.getTimeInMillis()));
			enrollmentRepository.save(enrollment);
			
			enrollments.add(new EnrollmentDTO(enrollment));
			
		}
		return enrollments;		
	}

	@Override
	public List<Student> findAllStudents() {
		return studentRepository.findAll();
	}
}
