export interface Course {
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
  professors?: [
    {
      id: number;
      username: string;
    }
  ]
  professorName?: string;
}
