import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

const mockDataRegistration = [
  {
    id: 1,
    course: {
      name: 'Objektno',
      courseCode: '12SIT',
    },
    examDate: '12.12.2020.',
    examRegistration: {
      paymentAmount: 200,
    },
    professor: {
      name: 'Sinisa Nikolic',
    },
  },
  {
    id: 2,
    course: {
      name: 'Matematika 2',
      courseCode: '13SIT',
    },
    examDate: '12.10.2020.',
    examRegistration: {
      paymentAmount: 200,
    },
    professor: {
      name: 'Marko Nikolic',
    },
  },
];
const mockDataUnregistration = [
  {
    id: 3,
    course: {
      name: 'Prijavljen',
      courseCode: '12SIT',
    },
    examDate: '12.12.2020.',
    examRegistration: {
      paymentAmount: 200,
    },
    professor: {
      name: 'Sinisa Nikolic',
    },
  },
];

@Component({
  selector: 'app-student-exams-active',
  templateUrl: './student-exams-active.component.html',
  styleUrls: ['./student-exams-active.component.css'],
})
export class StudentExamsActiveComponent implements OnInit {
  registration;
  exams;
  selectedExams = [];
  userAccountBalance = 1000;
  selectedExamsCost = 0;
  newUserAccountBalance = 1000;

  constructor(private router: Router) {}

  ngOnInit(): void {
    const registration = !this.router.url.toString().includes('unregister');
    this.registration = registration;
    this.exams = registration ? mockDataRegistration : mockDataUnregistration;
  }

  selectExam(exam: any) {
    const alreadySelected = this.selectedExams.find((e) => exam.id === e.id);

    if (alreadySelected === undefined) {
      this.selectedExams.push(exam);
      this.selectedExamsCost += exam.examRegistration.paymentAmount;
    } else {
      const filteredSelectedExams = this.selectedExams.filter(
        (e) => e.id !== alreadySelected.id
      );
      this.selectedExams = filteredSelectedExams;
      this.selectedExamsCost -= exam.examRegistration.paymentAmount;
    }

    this.calculateAccountBalance();
  }

  calculateAccountBalance() {
    this.registration
      ? (this.newUserAccountBalance =
          this.userAccountBalance - this.selectedExamsCost)
      : (this.newUserAccountBalance =
          this.userAccountBalance + this.selectedExamsCost);
  }

  isExamSelected(examId: string) {
    return this.selectedExams.find((e) => examId === e.id);
  }
}
