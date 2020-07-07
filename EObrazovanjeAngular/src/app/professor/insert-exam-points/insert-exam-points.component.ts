import { Component, OnInit } from '@angular/core';
import { ProfessorService } from 'src/app/services/professor/professor.service';
import { ActivatedRoute, Router, Params } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Exam } from 'src/app/types/exam';
import { switchMap } from 'rxjs/operators';

@Component({
  selector: 'app-insert-exam-points',
  templateUrl: './insert-exam-points.component.html',
  styleUrls: ['./insert-exam-points.component.css']
})
export class InsertExamPointsComponent implements OnInit {
  examForm: FormGroup;
  examReg: number;
  id: number;
  exam: Exam;

  constructor(
    private professorService: ProfessorService,
    private route: ActivatedRoute,
    private fb: FormBuilder,
    private router: Router) { }

  ngOnInit(): void {
    this.id = +localStorage.getItem("id")
    this.examReg = +this.route.snapshot.paramMap.get("id2");
    this.examForm = this.fb.group({
      id: this.examReg,
      examPoints: [0, [Validators.required, Validators.min(0), Validators.max(50)]],
      labPoints: [0, [Validators.required, Validators.min(0), Validators.max(50)]]
    })
  }

  onSubmit() {
    this.professorService.addPoints(this.examForm.value).subscribe(res => {
      this.router.navigate(['professor/', this.id, 'activeExams'])
    })
  }

}
