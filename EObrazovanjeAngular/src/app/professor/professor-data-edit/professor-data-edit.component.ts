import { Component, OnInit, OnDestroy } from '@angular/core';
import { ProfessorDataEdit } from 'src/app/types/professor-data-edit';
import { ProfessorService } from 'src/app/services/professor/professor.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Professor } from 'src/app/types/professor';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-professor-data-edit',
  templateUrl: './professor-data-edit.component.html',
  styleUrls: ['./professor-data-edit.component.css']
})
export class ProfessorDataEditComponent implements OnInit, OnDestroy {
  id: number;
  private subscription: Subscription;
  professor: ProfessorDataEdit;

  constructor(private professorService: ProfessorService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    this.id = +localStorage.getItem("id")
     this.getProfessor(+this.route.parent.snapshot.paramMap.get("id"));
  }

  getProfessor(id: number) {
    this.subscription = this.professorService.getProfessorEdit(id)
      .subscribe(data => {
        this.professor = data
      })
  }

  public edit(): void {
    this.professorService.editProfessorData(this.professor).subscribe(res => {
      this.router.navigate(['professor/', this.id])
    })
  }

  ngOnDestroy(): void {
    this.subscription.unsubscribe()
  }
}
