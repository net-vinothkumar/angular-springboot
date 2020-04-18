import { Component, OnInit } from '@angular/core';
import { Subscriber } from '../subscriber';
import { ActivatedRoute, Router } from '@angular/router';
import { SubscriberService } from '../subscriber.service';

@Component({
  selector: 'app-update-subscriber',
  templateUrl: './update-subscriber.component.html',
  styleUrls: ['./update-subscriber.component.css']
})
export class UpdateSubscriberComponent implements OnInit {

  id: number;
  subscriber: Subscriber;

  constructor(private route: ActivatedRoute,private router: Router,
    private subscriberService: SubscriberService) { }

  ngOnInit() {
    this.subscriber = new Subscriber();

    this.id = this.route.snapshot.params['id'];
    
    this.subscriberService.getSubscriber(this.id)
      .subscribe(data => {
        console.log(data)
        this.subscriber = data;
      }, error => console.log(error));
  }

  updateSubscriber() {
    this.subscriberService.updateSubscriber(this.id, this.subscriber)
      .subscribe(data => console.log(data), error => console.log(error));
    this.subscriber = new Subscriber();
    this.gotoList();
  }

  onSubmit() {
    this.updateSubscriber();    
  }

  gotoList() {
    this.router.navigate(['/subscribers']);
  }
}