import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { baseUrl } from '../url';
import { StudyProgramme } from 'src/app/types/study.programme';
import { Observable } from 'rxjs';
import { Course } from 'src/app/types/course';
import { ExamRegistrationChecked } from 'src/app/types/exam-registration-check';
import { Exam } from 'src/app/types/exam';
import { ExamAdmin } from 'src/app/types/exam-admin';

@Injectable({
  providedIn: 'root'
})
export class AdminStudyProgrammeService {
  studyProgrammeUrl = baseUrl + 'studyProgrammes/';
  examRegistrationUrl = baseUrl + 'examRegistration/';
  examUrl = baseUrl + 'exams/';
  courseUrl = baseUrl + 'courses/';

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

  getCourses() : Observable<Course[]> {
    return this.http.get<Course[]>(this.courseUrl);
  }

  checkExam(id: number) : Observable<{}> {
    return this.http.put(this.examRegistrationUrl + "check", id)
  }

  getExams(id: number, period: string) : Observable<ExamAdmin[]> {
    return this.http.get<ExamAdmin[]>(this.examUrl + 'examsJanuary?id=' + id + '&period=' + period)
  }

  getExam(id: number) : Observable<ExamAdmin> {
    return this.http.get<ExamAdmin>(this.examUrl + "examAdmin?id=" + id)
  }

  updateExam(exam: ExamAdmin) : Observable<{}> {
    return this.http.put(this.examUrl, exam)
  }

  addExam(exam: ExamAdmin) : Observable<ExamAdmin> {
    return this.http.post<ExamAdmin>(this.examUrl + "add", exam)
  }

  delete(id: number) : Observable<{}> {
    return this.http.delete(this.examUrl + id)
  }
}
