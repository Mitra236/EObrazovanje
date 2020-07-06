import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { baseUrl } from '../url';
import { StudyProgramme } from 'src/app/types/study.programme';
import { Observable } from 'rxjs';
import { Course } from 'src/app/types/course';
import { ExamRegistrationChecked } from 'src/app/types/exam-registration-check';

@Injectable({
  providedIn: 'root'
})
export class AdminStudyProgrammeService {
  studyProgrammeUrl = baseUrl + 'studyProgrammes/';
  examRegistrationUrl = baseUrl + 'examRegistration/'

  constructor(private http: HttpClient) { }

  getStudyProgrammes() : Observable<StudyProgramme[]> {
    return this.http.get<StudyProgramme[]>(this.studyProgrammeUrl)
  }

  getStudyProgrammeCourses(id: number) : Observable<Course[]> {
    return this.http.get<Course[]>(this.studyProgrammeUrl + "courses?id=" + id);
  }

  getActiveExamsToCheck(id: number) : Observable<ExamRegistrationChecked[]> {
    return this.http.get<ExamRegistrationChecked[]>(this.examRegistrationUrl + "activeExamsAdmin?id=" + id);
  }

  checkExam(id: number) : Observable<{}> {
    return this.http.put(this.examRegistrationUrl + "check", id)
  }

}
