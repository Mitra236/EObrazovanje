import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { StudentServiceService } from 'src/app/services/student/student.service';
import { ExamRegistration } from 'src/app/types/exam-registration';

@Component({
  selector: 'app-student-exam-history',
  templateUrl: './student-exam-history.component.html',
  styleUrls: ['./student-exam-history.component.css'],
})
export class StudentExamHistoryComponent implements OnInit {
  title;
  exams;

  constructor(
    private router: Router,
    private studentService: StudentServiceService
  ) {}

  ngOnInit(): void {
    const route = this.router.url.split('/');
    const screen = route[route.length - 1];

    this.setData(screen);
  }

  setData(route: String) {
    switch (route) {
      case 'passed':
        this.title = 'Polozeni ispiti';
        this.studentService
          .getPassedExams()
          .subscribe((exams: ExamRegistration[]) => {
            this.exams = exams;
          });
        return;
      case 'failed':
        this.title = 'Nepolozeni ispiti';
        this.studentService
          .getFailedExams()
          .subscribe((exams: ExamRegistration[]) => {
            this.exams = exams;
          });
        return;
      default:
        this.title = 'Istorija polaganja';
        this.studentService
          .getTakenExams()
          .subscribe((exams: ExamRegistration[]) => {
            this.exams = exams;
          });
    }
  }
}
