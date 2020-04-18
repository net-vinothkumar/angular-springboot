import { Subscriber } from '../subscriber';
import { Component, OnInit, Input } from '@angular/core';
import { SubscriberService } from '../subscriber.service';
import { SubscriberListComponent } from '../subscriber-list/subscriber-list.component';
import { Router, ActivatedRoute } from '@angular/router';


@Component({
  selector: 'app-subscriber-details',
  templateUrl: './subscriber-details.component.html',
  styleUrls: ['./subscriber-details.component.css']
})
export class SubscriberDetailsComponent implements OnInit {

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

  list(){
    this.router.navigate(['subscribers']);
  }
}
