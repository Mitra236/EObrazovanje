import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Exam } from 'src/app/types/exam';
import { ExamRegistration } from 'src/app/types/exam-registration';
import { Student } from 'src/app/types/student';
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

  getTakenExams(id: number): Observable<ExamRegistration[]> {
    return this.http.get<ExamRegistration[]>(this.studentsUrl + id + '/exams');
  }

  getPassedExams(id: number): Observable<ExamRegistration[]> {
    return this.http.get<ExamRegistration[]>(
      this.studentsUrl + id + '/passed-exams'
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
}
