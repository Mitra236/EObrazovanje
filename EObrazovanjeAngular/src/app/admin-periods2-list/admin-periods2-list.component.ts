import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

const mockData = [
  {
    name: 'Matematika',
    exam_points: 80,
    lab_points : 20,
    exam_date: "2020-04-04 12:30:00",
    class_room: 204
  },
  {
    name: 'Web programiranje',
    exam_points: 80,
    lab_points : 20,
    exam_date: "2020-04-04 12:30:00",
    class_room: 101
  },
  {
    name: 'Menadzment',
    exam_points: 80,
    lab_points : 20,
    exam_date: "2020-04-04 12:30:00",
    class_room: 402
  }
];
@Component({
  selector: 'app-admin-periods2-list',
  templateUrl: './admin-periods2-list.component.html',
  styleUrls: ['./admin-periods2-list.component.css']
})
export class AdminPeriods2ListComponent implements OnInit {
  examPeriod;
  constructor(private router: ActivatedRoute) { }

  ngOnInit(): void {
    this.examPeriod = mockData;
  }

}
