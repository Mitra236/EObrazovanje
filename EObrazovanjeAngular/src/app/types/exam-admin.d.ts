export interface ExamAdmin {
  id: number,
  course: {
    id: number,
    name: string,
    professorName: string
  },
  date: string,
  classroom: string,
  period: string
}
