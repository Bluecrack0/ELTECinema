import { Injectable, Component, OnInit } from '@angular/core';
import {CinemaBackendService} from '../../services/cinemaBackend.service';
import { User } from '../../model/cinema.model';
import { Router } from '@angular/router';
import { CookieService } from 'angular2-cookie/core';
import {AppComponent} from "../../app.component";

@Component({
    selector: 'login',
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit {

    message: string = '';

    ngOnInit() {
    }

    title = 'login';
    user: User = {
      id: 0,
      email: "asd@asd.com",
      password: "",
      username: "",
      role: "USER"
    };

    constructor(
                private cinemaBackendService: CinemaBackendService,
                private router: Router,
                private _cookieService:CookieService) {
      console.log(this.cinemaBackendService.isLoggedIn);
    }


    login() {
        if (this.cinemaBackendService.isLoggedIn) {
          this.router.navigate(['/screenings']);
        }

        this.cinemaBackendService.login(this.user).subscribe(response => {
            console.log(response);
            if (response != "login") { //;sikerült bejelentkezni
                this.cinemaBackendService.isLoggedIn = true;
                this.cinemaBackendService.user = this.user;
                this.router.navigate(['/screenings']);
            }
            else {
                alert("Hibás felhasználónév vagy jelszó!");
            }
        }, err => {
        });
    }
    register() {
        this.router.navigate(['/register']);
    }
}
