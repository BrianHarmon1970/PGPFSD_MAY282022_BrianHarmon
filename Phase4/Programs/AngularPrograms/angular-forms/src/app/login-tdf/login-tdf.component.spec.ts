import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LoginTdfComponent } from './login-tdf.component';

describe('LoginTdfComponent', () => {
  let component: LoginTdfComponent;
  let fixture: ComponentFixture<LoginTdfComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LoginTdfComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LoginTdfComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
