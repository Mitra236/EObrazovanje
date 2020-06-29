import { Component, OnInit } from '@angular/core';
import { StudentServiceService } from 'src/app/services/student/student.service';
import { Student } from 'src/app/types/student';

@Component({
  selector: 'app-student-financing',
  templateUrl: './student-financing.component.html',
  styleUrls: ['./student-financing.component.css'],
})
export class StudentFinancingComponent implements OnInit {
  studentFinancialDetails;

  constructor(private studentService: StudentServiceService) {}

  ngOnInit(): void {
    this.getStudentDetails();
  }

  getStudentDetails(): void {
    this.studentService.getStudenById(1).subscribe((student: Student) => {
      this.studentFinancialDetails = student;
    });
  }
}
