import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateSubscriberComponent } from './create-subscriber.component';

describe('CreateSubscriberComponent', () => {
  let component: CreateSubscriberComponent;
  let fixture: ComponentFixture<CreateSubscriberComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreateSubscriberComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateSubscriberComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
