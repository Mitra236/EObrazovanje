import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { FormGroup, FormBuilder, Validators, AbstractControl } from '@angular/forms';
import { AdminProfessorService } from 'src/app/services/admin/admin-professor.service';
import { Professor } from 'src/app/types/professor';

enum EPosition {
  FullTimeProfessor = "Full Time Professor",
  Docent = "Docent",
  Assistant = "Assistant",
  TeachingAssociate = "Teaching Associate",
  AssociateProfessor = "Associate Professor"
}

export enum EEmployeeFunction {
  Dean = "Dean",
  ViceDean = "Vice Dean",
  HeadOfDepartment = "Head of Departmant",
  MemberOfFacultyCouncil = "Member of Faculty Council"
}

@Component({
  selector: 'app-admin-add-user',
  templateUrl: './admin-add-user.component.html',
  styleUrls: ['./admin-add-user.component.css'],
})
export class AdminAddUserComponent implements OnInit {
  student;
  userForm: FormGroup;
  userEditForm: FormGroup;
  professorId: number;
  positions = EPosition;
  functions = EEmployeeFunction;
  professor: Professor;
  submitted = false;

  constructor(
    private adminProfessorService: AdminProfessorService,
    private router: Router,
    private fb: FormBuilder,
    private route: ActivatedRoute) {

    }

  ngOnInit(): void {
    this.student = this.router.url.toString().includes('student');

    if(!this.student && !this.route.snapshot.params['id']) {
      this.getProfessorAddData()
    } else if (!this.student) {
      this.getProfessor(+this.route.snapshot.params['id'])
      }
    }

    onSubmit() {
      if(!this.student && !this.route.snapshot.params['id']) {
        this.submitted = true;
        this.adminProfessorService.addProfessor(this.userForm.value).subscribe(res => {
          window.alert("Success")
          this.router.navigate(["admin/students"])
        });
      } else if(!this.student) {
        this.submitted = true;
        this.adminProfessorService.editProfessorData(this.userEditForm.value).subscribe(res => {
          window.alert("Success")
          this.router.navigate(["admin/professors/professorsForAdmin"])
        })
      }
    }

    getProfessorAddData() {
      this.userForm = this.fb.group({
        firstName: ['', Validators.required],
        lastName: ['', Validators.required],
        username: ['', Validators.required],
        email: ['', [Validators.required, Validators.email]],
        JMBG: ['', [Validators.required, Validators.minLength(13), Validators.maxLength(13)]],
        password: ['', Validators.required],
        phoneNumber: ['', this.numberValidator],
        biography: [''],
        academicTitle: ['', Validators.required],
        position: ['', Validators.required],
        emplyeeFunction: ['', Validators.required],
        positionFrom: [''],
        employeeFunctionFrom: ['']
      })
    }

    getProfessorEditData() {
      this.userEditForm = this.fb.group({
        id: +this.route.snapshot.params['id'],
        academicTitle: [this.professor.academicTitle, Validators.required],
        position: [this.professor.position],
        emplyeeFunction: [this.professor.emplyeeFunction],
        positionFrom: [this.professor.positionFrom],
        employeeFunctionFrom: [this.professor.employeeFunctionFrom]
      })
    }

    getProfessor(id: number) {
      this.adminProfessorService.getProfessor(id)
      .subscribe(data => {
        this.professor = data
        this.getProfessorEditData()
      })
    }

    numberValidator(
      control: AbstractControl
    ): { [key: string]: any } | null {
      const valid = /^\d+$/.test(control.value)
      return valid
        ? null
        : { invalidNumber: { valid: false, value: control.value } }
    }
}

