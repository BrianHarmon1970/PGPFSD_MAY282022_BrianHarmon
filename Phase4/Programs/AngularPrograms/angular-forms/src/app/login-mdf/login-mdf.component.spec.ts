import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LoginMdfComponent } from './login-mdf.component';
import { FormGroup, FormControl } from '@angular/forms' ;
describe('LoginMdfComponent', () => {
  let component: LoginMdfComponent;
  let fixture: ComponentFixture<LoginMdfComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LoginMdfComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LoginMdfComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
