import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { AdminStudyProgrammeService } from 'src/app/services/admin/admin-study-programme.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Location } from '@angular/common';
import { Course } from 'src/app/types/course';

export enum EExamPeriod  {
  Januarski = "Januar",
  Februarski = "Februar",
  Aprilski = "April",
  Junski = "Jun",
  Julski = "Jul",
  Septembarski = "Septembar",
  Oktobarski = "Oktobar"
}

@Component({
  selector: 'app-admin-exam-add',
  templateUrl: './admin-exam-add.component.html',
  styleUrls: ['./admin-exam-add.component.css']
})
export class AdminExamAddComponent implements OnInit {
  periods = EExamPeriod;
  courses: Course[]
  examForm: FormGroup;

  constructor(
    private adminService: AdminStudyProgrammeService,
    private route: ActivatedRoute,
    private fb: FormBuilder,
    private router: Router) { }

  ngOnInit(): void {
    this.adminService.getCourses().subscribe(res => {
      this.courses = res;
    })
    this.getForm()
  }

  getForm() {
    this.examForm = this.fb.group({
      course: [0],
      period: [0],
      date: [''],
      classroom: ['']
    })
  }

  onSubmit() {
    this.adminService.addExam(this.examForm.value).subscribe(res => {
      this.router.navigate(['admin/periods'])
    })
  }

}
