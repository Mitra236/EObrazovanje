import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminProfessorsListComponent } from './admin-professors-list.component';

describe('AdminProfessorsListComponent', () => {
  let component: AdminProfessorsListComponent;
  let fixture: ComponentFixture<AdminProfessorsListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminProfessorsListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminProfessorsListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
