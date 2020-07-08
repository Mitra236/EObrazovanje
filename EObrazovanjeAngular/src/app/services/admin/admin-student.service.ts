import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { baseUrl } from '../url';
import { Professor } from 'src/app/types/professor';
import { throwError, Observable } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Student } from 'src/app/types/student';
import { Enrollment } from 'src/app/types/enrollment';

@Injectable({
  providedIn: 'root'
})
export class AdminStudentService {
  studentsUrl = baseUrl + 'students';

  constructor(private http: HttpClient) { }

  getStudent(id: number) {
    return this.http.get<Student>(this.studentsUrl + "/" + id);
  }

  addStudent(student: Student){
    console.log(student);
    return this.http.post<Student>(this.studentsUrl, student)
      .subscribe((response) => console.log(response),
      (error) => console.log(error));
  }

  updateStudent(student: Student) {
    return this.http.put<Student>(this.studentsUrl + "/",  student)
      .subscribe((response) => console.log(response),
      (error) => console.log(error));
  }

  removeStudent(id: number) : Observable<{}> {
    return this.http.delete(this.studentsUrl + id)
            .pipe(catchError(this.handleError))
  }


  getStudentEnrollments(studentId: Number) {
    return this.http.get<Enrollment[]>(this.studentsUrl + '/studentEnrollments/' + studentId);
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