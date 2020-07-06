import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { tap } from 'rxjs/operators';
import { Exam } from 'src/app/types/exam';
import { ExamRegistration } from 'src/app/types/exam-registration';
import { Student } from 'src/app/types/student';
import { Transaction } from 'src/app/types/student-transaction';
import { baseUrl } from '../url';

@Injectable({
  providedIn: 'root',
})
export class StudentServiceService {
  studentsUrl = baseUrl + 'students/';
  id;

  constructor(private http: HttpClient) {
    this.id = localStorage.getItem('id');
  }

  getStudenById(): Observable<Student> {
    return this.http.get<Student>(this.studentsUrl + this.id);
  }

  getListOfStudents(): Observable<Student[]> {
    return this.http.get<Student[]>(
      this.studentsUrl.substring(0, this.studentsUrl.length - 1)
    );
  }

  getTakenExams(): Observable<ExamRegistration[]> {
    return this.http.get<ExamRegistration[]>(
      this.studentsUrl + this.id + '/exams'
    );
  }

  getPassedExams(): Observable<ExamRegistration[]> {
    return this.http.get<ExamRegistration[]>(
      this.studentsUrl + this.id + '/passed-exams'
    );
  }

  getCurrentExamRegistrations(): Observable<ExamRegistration[]> {
    return this.http.get<ExamRegistration[]>(
      this.studentsUrl + this.id + '/registered-exam'
    );
  }

  unregisterExam(examId: number): Observable<any> {
    return this.http
      .put(this.studentsUrl + this.id + '/unregistered-exam/' + examId, {})
      .pipe(
        tap((data) => console.log(data)),
        (e) => {
          return e;
        }
      );
  }

  registerExam(examId: number): Observable<any> {
    return this.http
      .post(this.studentsUrl + this.id + '/register-exam/' + examId, {})
      .pipe(
        tap((data) => console.log(data)),
        (e) => {
          console.log(e);
          return e;
        }
      );
  }

  getFailedExams(): Observable<ExamRegistration[]> {
    return this.http.get<ExamRegistration[]>(
      this.studentsUrl + this.id + '/failed-exams'
    );
  }

  getCurrentExams(): Observable<Exam[]> {
    return this.http.get<Exam[]>(this.studentsUrl + this.id + '/exams-current');
  }

  getStudentTransactions(): Observable<Transaction[]> {
    return this.http.get<Transaction[]>(
      this.studentsUrl + this.id + '/financial-card'
    );
  }
}
