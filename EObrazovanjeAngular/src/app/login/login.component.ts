import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { UserService } from '../services/user.service';

const mockData = [
  { username: 'tina', password: 'tinic', role: 'admin' },
  { username: 'pero', password: 'peric', role: 'student' },
  { username: 'marko', password: 'markovic', role: 'professor' },
];

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  users;
  loginForm;
  errorMessage = '';
  user: any;

  constructor(
    private formBuilder: FormBuilder,
    private router: Router,
    private route: ActivatedRoute,
    private userService: UserService
  ) {
    this.loginForm = this.formBuilder.group({
      username: '',
      password: '',
    });
  }

  ngOnInit() {
    this.users = mockData;
  }

  onSubmit(data) {
    // const user = this.users.find(
    //   (u) => u.username === data.username && u.password === data.password
    // );
    this.userService.login(data).subscribe(res => {
       this.user = res;
       localStorage.setItem("id", this.user.id)
       localStorage.setItem("role", this.user.role)

       if (this.user !== undefined) {
        console.log(this.user)
        this.userService.setUser(this.user);

        if (this.user.role === 'student') {
          this.router.navigate(['student']);
        } else if (this.user.role === 'professor') {
          this.router.navigate(['professor/', this.user.id]);
        } else if (this.user.role === 'admin') {
          this.router.navigate(['admin/students']);
        }
      } else {
        this.errorMessage = 'Incorrect username or password!';
      }

      this.loginForm.reset();
    })

  }
}
