export interface Exam {
  id: number;
  examPoints?: number;
  labPoints?: number;
  course: {
    id: number;
    name: string;
    courseCode: string;
    ECTS?: number;
    lectures?: number;
    practicalClasses?: number;
    studyProgramme: {
      id: number;
      name: string;
    };
    professorName?: string;
  };
  date: string;
  paymentAmount?: number;
  examRegistrationDTOs: [];
}
