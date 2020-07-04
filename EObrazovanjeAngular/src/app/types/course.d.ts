export interface Course {
  id: number;
  name: string;
  courseCode: string;
  ECTS?: number;
  lectures?: number;
  practicalClasses?: number;
  enrollmentDTOs: [
    {
      id: number;
      startDate: Date;
      endDate: Date;
      student: {
        id: number;
        username: string
      }
      course: {
        id: number;
        name: string;
      }
    }
  ];
  studyProgramme: {
    id: number;
    name: string;
  };
  professors?: [
    {
      id: number;
      username: string;
    }
  ]
  professorName?: string;
}
