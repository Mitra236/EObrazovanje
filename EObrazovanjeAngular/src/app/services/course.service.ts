import { Injectable } from '@angular/core';

interface Course {
  id: number;
  courseName: string;
  courseCode: string;
  ECTS: number;
  lectures: number;
  practicalClasses: number;
  studyProgramme: number;
}

@Injectable({
  providedIn: 'root'
})
export class CourseService {
  courses: [];

  constructor() { }

  getCourses() {
    return this.courses.splice;
  }
}
