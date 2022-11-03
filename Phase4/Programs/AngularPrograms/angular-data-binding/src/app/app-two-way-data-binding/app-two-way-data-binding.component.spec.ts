import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AppTwoWayDataBindingComponent } from './app-two-way-data-binding.component';

describe('AppTwoWayDataBindingComponent', () => {
  let component: AppTwoWayDataBindingComponent;
  let fixture: ComponentFixture<AppTwoWayDataBindingComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AppTwoWayDataBindingComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AppTwoWayDataBindingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
