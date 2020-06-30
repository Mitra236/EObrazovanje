import { Injectable } from '@angular/core';
import { baseUrl } from '../url';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { throwError } from 'rxjs';
// import { catchError } from 'rxjs/operators;
import { Course } from 'src/app/types/course';

@Injectable({
  providedIn: 'root'
})
export class ProfessorService {
  professorsUrl = baseUrl + 'professors/';
  courseUrl = baseUrl + 'courses/';

  constructor(private http: HttpClient) { }

  getProfessorsCourses(id: number) {
    return this.http.get<Course[]>(this.courseUrl + 'professorCourses/?id=' + id);
  }

  handleError(error: HttpErrorResponse) {
    let errorMessage = 'Unkonwn error';
    error.error instanceof ErrorEvent ?
    errorMessage = `Error: ${error.error.message}` :
    errorMessage = `Error code: ${error.status}\nMessage: ${error.message}`

    window.alert(errorMessage)
    return throwError(errorMessage)
  }
}
