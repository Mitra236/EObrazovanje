import { Component, OnInit } from '@angular/core';
import { ProfessorService } from 'src/app/services/professor/professor.service';
import { ActivatedRoute, Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-insert-exam-points',
  templateUrl: './insert-exam-points.component.html',
  styleUrls: ['./insert-exam-points.component.css']
})
export class InsertExamPointsComponent implements OnInit {
  examForm: FormGroup;
  examReg: number;

  constructor(
    private professorService: ProfessorService,
    private route: ActivatedRoute,
    private fb: FormBuilder,
    private router: Router) { }

  ngOnInit(): void {
    this.examReg = +this.route.snapshot.paramMap.get("id");
    this.examForm = this.fb.group({
      id: this.examReg,
      examPoints: [0, Validators.required],
      labPoints: [0, Validators.required]
    })
  }

  onSubmit() {
    this.professorService.addPoints(this.examForm.value).subscribe(res => {
      this.router.navigate(['professor/activeExams', 1])
    })
  }

}
