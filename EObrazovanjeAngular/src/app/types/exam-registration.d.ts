export interface ExamRegistration {
  id: number;
  date: string;
  examPoints?: number;
  labPoints?: number;
  status: string;
  courseName: string;
  courseProfessor: string;
  studentId?: number;
  finalGrade?: number;
  ECTS?: number;
}
