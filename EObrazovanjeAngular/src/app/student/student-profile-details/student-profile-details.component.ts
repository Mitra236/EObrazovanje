import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

const mockData = {
  username: 'Tina',
  password: '****',
  index: 'SF25/2017',
  firstName: 'Valentina',
  lastName: 'Mackovic',
  email: 'mail@gmail.com',
  phoneNumber: '086172829',
  JMBG: '07119972828',
  yearOfEnrollment: '2017',
  methodOfFinancing: 'budget',
  yearOfStudy: '2',
  timeEnrolled: '1',
};

@Component({
  selector: 'app-student-profile-details',
  templateUrl: './student-profile-details.component.html',
  styleUrls: ['./student-profile-details.component.css'],
})
export class StudentProfileDetailsComponent implements OnInit {
  student;

  constructor(private route: ActivatedRoute) {}

  ngOnInit(): void {
    this.student = mockData;
  }
}
