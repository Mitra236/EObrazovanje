import { Injectable } from '@angular/core';
import { baseUrl } from './url';
import { HttpClient, HttpErrorResponse, HttpResponse  } from '@angular/common/http';
import { throwError, Observable, of } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { StudyProgramme } from 'src/app/types/study.programme';
import { Student } from 'src/app/types/student';
import { Course } from 'src/app/types/course';


@Injectable({
  providedIn: 'root'
})
export class StudyProgrammeService {
  studyProgrammesUrl = baseUrl + 'studyProgrammes';

  constructor(private http: HttpClient) { }

  getListOfStudyProgrammes(): Observable<StudyProgramme[]> {
    return this.http.get<StudyProgramme[]>(this.studyProgrammesUrl);
  }

  handleError(error: HttpErrorResponse) {
    let errorMessage = 'Unknown error';

    error.error instanceof ErrorEvent ?
    errorMessage = `Error: ${error.error.message}` :
    errorMessage = `Error code: ${error.status}\nMessage: ${error.message}`

    window.alert(errorMessage)
    return throwError(errorMessage)
  }

  getListOfCoursesForProgramme(id: number): Observable<Course[]> {
    return this.http.get<Course[]>(this.studyProgrammesUrl + '/' + id + '/coursesByProgramme')
            .pipe(catchError(this.handleError));
  }

  getListOfStudentsForProgramme(id: number): Observable<Student[]> {
    return this.http.get<Student[]>(this.studyProgrammesUrl + '/' + id +'/studentsByProgramme')
            .pipe(catchError(this.handleError));
  }

}
