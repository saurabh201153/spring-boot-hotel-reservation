import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { BookRoomComponent } from './book-room/book-room.component';
import { CancelBookingComponent} from './cancel-booking/cancel-booking.component';


const routes: Routes = [
	{ path: 'bookRoom', component: BookRoomComponent },
	{ path: 'cancelBooking', component: CancelBookingComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class HotelRoomRoutingModule { }
