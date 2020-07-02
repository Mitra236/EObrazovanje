export interface ProfessorCourseDetails {
  id: number;
  name: string;
  enrollmentDTOs: [
    {
      id: number;
      startDate: Date,
      endDate: Date,
      student: {
        id: number;
        username: string;
        password: string,
        firstName: string,
        lastName: string,
        email?: string,
        studyProgramme: {
            id: number;
            name: string,
            studentsDTO: [];
            coursesDTO: [];
        }
    },
    course?: null;
    }
  ]
}
