import { Component, OnInit } from '@angular/core';
import { Router, NavigationEnd } from '@angular/router';
import { filter } from 'rxjs/operators';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {
  activeMenuItem: string = '';

  constructor(private router: Router) {}

  ngOnInit(): void {
    this.getActiveRoute();
    this.router.events
      .pipe(filter(event => event instanceof NavigationEnd))
      .subscribe(() => {
        this.getActiveRoute();
      });
  }

  setActiveMenuItem(menuItem: string) {
    this.activeMenuItem = menuItem;
  }

  private getActiveRoute(): void {
    const currentRoute = this.router.url;

    if (currentRoute === '/') {
      this.activeMenuItem = 'Home';
    } else if (currentRoute === '/about') {
      this.activeMenuItem = 'About';
    } else if (currentRoute === '/FourmateurExterne') {
      this.activeMenuItem = 'Postuler';
    } else if (currentRoute === '/access/evaluation') {
      this.activeMenuItem = 'Evaluation';
    } else {
      this.activeMenuItem = '';
    }
  }
}
