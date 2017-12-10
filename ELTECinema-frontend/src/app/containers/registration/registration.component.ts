import { Injectable, Component } from '@angular/core';
import {CinemaBackendService } from '../../services/cinemaBackend.service';
import { User } from '../../model/cinema.model';
import { Router } from '@angular/router';

@Component({
    selector: 'registration',
    templateUrl: './registration.component.html',
    styleUrls: ['./registration.component.css']
})
@Injectable()
export class RegistrationComponent {
    title = 'registration';
    user: User = {
        email: "",
        password: "",
        username: "",
        role: "USER"
    };
    passwordConfirm: string;

    constructor(private cinemaBackendService: CinemaBackendService, private router: Router) { console.log(this.cinemaBackendService.isLoggedIn); }

    register() {
        if (this.passwordConfirm != this.user.password) {
            alert("The passwords doesn't match!");
            return;
        }
        this.cinemaBackendService.register(this.user).subscribe(response => {
            alert("Registration successful!");
            this.router.navigate(['/login']);
        }, (err) => {console.log(err)});
    }
}
