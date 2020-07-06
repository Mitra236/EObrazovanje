export interface ExamRegistrationChecked {
  id: number,
  courseName?: string,
  student: {
    id: number,
    index: string,
    firstName: string,
    lastName: string,
  },
  courseProfessor?: string,
  finalGrade?: number,
  status: string,
  check: boolean,
  date: string
}
