import { Injectable } from '@angular/core';
import { User, Movie, Screening, Reservation } from '../model/cinema.model';
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { tap } from "rxjs/operators";

const BASE_URL = "http://localhost:8080/";

const httpOptions = {
  headers: new HttpHeaders(
    {'Content-Type': 'application/json'}
  )
};

@Injectable()
export class CinemaBackendService {

    isLoggedIn: boolean = false;
    user: User = {
      username: "Ismeretlen",
      password: "",
      email: "",
      role: "GUEST"
    };
    redirectUrl: string;

    constructor(private http: HttpClient) { }

    getNews() {
      return this.getNoParam<string>(BASE_URL + 'api/news/getAll');
    }
    isAdmin() {
        return !!parseInt(localStorage.getItem('isAdminValue'));
    }

    getLoggedInUser() {
        return this.getNoParam<string>(BASE_URL + 'user/getCurrentUser');
    }

    login(user: User) {
        localStorage.setItem('isAdminValue', (user.username == "admin") ? "1" : "0");
        this.get<string>(BASE_URL + 'user/login', user);
        return this.post<string>(BASE_URL + 'user/login', user);
    }

    logout(user: User) {
      return this.post<string>(BASE_URL + 'user/logout', user);
    }

    register(user: User) {
        this.get<string>(BASE_URL + 'user/register', user);
        return this.post<string>(BASE_URL + 'user/register', user);
    }

    getMovies() {
        return this.http.get<Movie[]>(BASE_URL + 'api/movies/getall');
    }

    addMovie(movie: Movie) {
        return this.http.post<void>(BASE_URL + 'api/movies/create', movie);
    }

    getScreeningsByMovie(movieId: number) {
        return this.http.get<Screening[]>(BASE_URL + 'api/screenings/getAllByMovie/' + movieId);
    }

    createScreening(screening: Screening) {
        return this.http.post<void>(BASE_URL + 'api/screenings/create', screening);
    }

    getAllReservationsToScreening(screeningId: number) {
        return this.http.get<Reservation[]>(BASE_URL + 'api/reservations/getAllToScreening/' + screeningId);
    }

    createReservation(reservation: Reservation) {
        return this.http.post<void>(BASE_URL + 'api/reservations/create', reservation);
    }

    deleteReservation(reservationId: number) {
        return this.http.delete<void>(BASE_URL + 'api/reservations/delete/' + reservationId);
    }

    getAllReservation() {
        return this.http.get<Reservation[]>(BASE_URL + 'api/reservations/getall');
    }

    get<TResponse>(action: string, params: any) {
        let url = action + '?' + Object.keys(params).map(key => key + '=' + params[key]).join('&');
        return this.http.get<TResponse>(url);
    }

    getNoParam<TResponse>(action: string) {
      return this.http.get<TResponse>(action);
    }

    post<TResponse>(action: string, params: any) {
        let url = action + '?' + Object.keys(params).map(key => key + '=' + params[key]).join('&');
        return this.http.post<TResponse>(url, {});
    }
}
