export interface Enrollment {
  id: number;
  startDate: number;
  endDate: number;
  student: {
    id: number;
    username: string;
    password: string;
    firstName: string;
    lastName: string;
    email?: string;
    studyProgramme: {
      id: number;
      name: string;
      studentsDTO: [];
      coursesDTO: [];
    }
  }
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
        studentsDTO: [];
        coursesDTO: [];
    },
    enrollmentDTOs: [];
    professors: [];
    professorName: string;
  }
}
