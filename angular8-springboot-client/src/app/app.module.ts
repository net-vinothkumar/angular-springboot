import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreateSubscriberComponent } from './create-subscriber/create-subscriber.component';
import { SubscriberDetailsComponent } from './subscriber-details/subscriber-details.component';
import { SubscriberListComponent } from './subscriber-list/subscriber-list.component';
import { UpdateSubscriberComponent } from './update-subscriber/update-subscriber.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    CreateSubscriberComponent,
    SubscriberDetailsComponent,
    SubscriberListComponent,
    UpdateSubscriberComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
