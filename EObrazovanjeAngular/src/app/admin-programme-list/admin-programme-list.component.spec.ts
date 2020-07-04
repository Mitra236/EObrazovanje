import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminProgrammeListComponent } from './admin-programme-list.component';

describe('AdminProgrammeListComponent', () => {
  let component: AdminProgrammeListComponent;
  let fixture: ComponentFixture<AdminProgrammeListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminProgrammeListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminProgrammeListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
