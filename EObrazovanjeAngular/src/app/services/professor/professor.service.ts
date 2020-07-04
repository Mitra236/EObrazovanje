import { Injectable } from '@angular/core';
import { baseUrl } from '../url';
import { HttpClient, HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { throwError, Observable, of } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Course } from 'src/app/types/course';
import { ProfessorDataEdit } from 'src/app/types/professor-data-edit';
import { Professor } from 'src/app/types/professor';
import { ProfessorCourseDetails } from 'src/app/types/professor-course-details';
import { Exam } from 'src/app/types/exam';
import { Student } from 'src/app/types/student';
import { StudentBasicInfo } from 'src/app/types/student-basic-info';
import { Enrollment } from 'src/app/types/enrollment';

@Injectable({
  providedIn: 'root'
})
export class ProfessorService {
  professorsUrl = baseUrl + 'professors/';
  courseUrl = baseUrl + 'courses/';
  enrollmentUrl = baseUrl + 'enrollment/'
  examUrl = baseUrl + 'exams/'
  studentsUrl = baseUrl + 'students/'
  private headers = new Headers({ 'Content-Type': 'application/json' });

  constructor(private http: HttpClient) { }

  getProfessorEdit(id: number) : Observable<ProfessorDataEdit> {
    return this.http.get<ProfessorDataEdit>(this.professorsUrl + 'professorEdit?id=' + id)
            .pipe(catchError(this.handleError))
  }

  getProfessorsCourses(id: number) : Observable<Course[]> {
    return this.http.get<Course[]>(this.courseUrl + 'professorCourses/?id=' + id)
            .pipe(catchError(this.handleError));
  }

  getProfessorCourseDetails(id: number): Observable<ProfessorCourseDetails> {
    return this.http.get<ProfessorCourseDetails>(this.courseUrl + 'courseStudent?id=' + id)
              .pipe(catchError(this.handleError))
  }

  getExamsByPeriod(id: number, period: string): Observable<Exam[]> {
    return this.http.get<Exam[]>(this.examUrl + "period/?id=" + id + "&period=" + period)
  }

  getNotEnrolledStudents(id: number) : Observable<StudentBasicInfo[]> {
    return this.http.get<StudentBasicInfo[]>(this.studentsUrl + "enrollments/?id=" + id)
            .pipe(catchError(this.handleError))
  }

  getCourse(id: number) : Observable<Course> {
    return this.http.get<Course>(this.courseUrl + "course/?id=" + id)
              .pipe(catchError(this.handleError));
  }

  addEnrollment(enrollment: Enrollment) : Observable<Enrollment> {
    return this.http.post<Enrollment>(this.enrollmentUrl, enrollment)
              .pipe(catchError(this.handleError));
  }

  editProfessorData(professor: ProfessorDataEdit) : Observable<ProfessorDataEdit> {
    return this.http.put<ProfessorDataEdit>(this.professorsUrl, professor)
            .pipe(catchError(this.handleError));
  }

  deleteCourseEnrollment(id: number) : Observable<{}> {
    return this.http.delete(this.enrollmentUrl + id)
            .pipe(catchError(this.handleError))
  }

  handleError(error: HttpErrorResponse) {
    let errorMessage = 'Unknown error';

    error.error instanceof ErrorEvent ?
    errorMessage = `Error: ${error.error.message}` :
    errorMessage = `Error code: ${error.status}\nMessage: ${error.message}`

    window.alert(errorMessage)
    return throwError(errorMessage)
  }
}
