import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
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
}
