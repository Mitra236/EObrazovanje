import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

const mockData = [
  {
    examName: 'Matematika 1', 
    startDate: '2019-08-24',
    endDate: '2019-08-24'
  },
  {
    examName: 'Matematika 2', 
    startDate: '2019-08-25',
    endDate: '2019-08-25'
  },
];

@Component({
  selector: 'app-admin-exams-list',
  templateUrl: './admin-exams-list.component.html',
  styleUrls: ['./admin-exams-list.component.css']
})
export class AdminExamsListComponent implements OnInit {
  exams;
  constructor(private router: ActivatedRoute) { }

  ngOnInit(): void {
    this.exams = mockData;
  }

}
