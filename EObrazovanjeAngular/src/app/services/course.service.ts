import { Injectable } from '@angular/core';
import { baseUrl } from './url';
import { HttpClient, HttpErrorResponse, HttpResponse, HttpHeaders  } from '@angular/common/http';
import { throwError, Observable, of } from 'rxjs';
import { catchError } from 'rxjs/operators';


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
