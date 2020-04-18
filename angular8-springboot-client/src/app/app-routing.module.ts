import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SubscriberListComponent } from './subscriber-list/subscriber-list.component';
import { CreateSubscriberComponent } from './create-subscriber/create-subscriber.component';
import { UpdateSubscriberComponent } from './update-subscriber/update-subscriber.component';
import { SubscriberDetailsComponent } from './subscriber-details/subscriber-details.component';


const routes: Routes = [

  { path: '', redirectTo: 'subscriber', pathMatch: 'full' },
  { path: 'subscribers', component: SubscriberListComponent },
  { path: 'add', component: CreateSubscriberComponent },
  { path: 'update/:id', component: UpdateSubscriberComponent },
  { path: 'details/:id', component: SubscriberDetailsComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
