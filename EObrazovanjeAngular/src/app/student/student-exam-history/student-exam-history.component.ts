import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

const mockDataPassed = [
  {
    course: {
      name: 'Matematika',
      courseCode: 'SIT12',
      ECTS: '8',
    },
    examDate: '12.12.2020.',
    professor: {
      name: 'Marko Markovic',
    },
    finalGrade: '9',
  },
  {
    course: {
      name: 'URS',
      courseCode: 'SIT12',
      ECTS: '8',
    },
    examDate: '12.12.2020.',
    professor: {
      name: 'Marko Pantic',
    },
    finalGrade: '10',
  },
];

const mockDataFailed = [
  {
    course: {
      name: 'Uvod u racunarstvo',
      courseCode: 'SIT12',
      ECTS: '8',
    },
    examDate: '12.12.2020.',
    professor: {
      name: 'Petar Petrovic',
    },
    finalGrade: '/',
  },
];

@Component({
  selector: 'app-student-exam-history',
  templateUrl: './student-exam-history.component.html',
  styleUrls: ['./student-exam-history.component.css'],
})
export class StudentExamHistoryComponent implements OnInit {
  title;
  exams;

  constructor(private router: Router) {}

  ngOnInit(): void {
    const route = this.router.url.split('/');
    const screen = route[route.length - 1];

    this.setData(screen);
  }

  setData(route: String) {
    switch (route) {
      case 'passed':
        this.title = 'Polozeni ispiti';
        this.exams = mockDataPassed;
        return;
      case 'failed':
        this.title = 'Nepolozeni ispiti';
        this.exams = mockDataFailed;
        return;
      default:
        this.title = 'Istorija polaganja';
        this.exams = [...mockDataFailed, ...mockDataPassed];
    }
  }
}
