import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminPeriodsListComponent } from './admin-periods-list.component';

describe('AdminPeriodsListComponent', () => {
  let component: AdminPeriodsListComponent;
  let fixture: ComponentFixture<AdminPeriodsListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminPeriodsListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminPeriodsListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
