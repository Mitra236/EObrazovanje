import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
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

  constructor(private http: HttpClient) {}

  getStudenById(id: number): Observable<Student> {
    return this.http.get<Student>(this.studentsUrl + id);
  }

  getListOfStudents(): Observable<Student[]> {
    return this.http.get<Student[]>(
      this.studentsUrl.substring(0, this.studentsUrl.length - 1)
    );
  }

  getTakenExams(id: number): Observable<ExamRegistration[]> {
    return this.http.get<ExamRegistration[]>(this.studentsUrl + id + '/exams');
  }

  getPassedExams(id: number): Observable<ExamRegistration[]> {
    return this.http.get<ExamRegistration[]>(
      this.studentsUrl + id + '/passed-exams'
    );
  }

  getCurrentExamRegistrations(id: number): Observable<ExamRegistration[]> {
    return this.http.get<ExamRegistration[]>(
      this.studentsUrl + id + '/registered-exam'
    );
  }

  getFailedExams(id: number): Observable<ExamRegistration[]> {
    return this.http.get<ExamRegistration[]>(
      this.studentsUrl + id + '/failed-exams'
    );
  }

  getCurrentExams(id: number): Observable<Exam[]> {
    return this.http.get<Exam[]>(baseUrl + 'exams/' + id + '/current');
  }

  getStudentTransactions(id: number): Observable<Transaction[]> {
    return this.http.get<Transaction[]>(
      this.studentsUrl + id + '/financial-card'
    );
  }
}
