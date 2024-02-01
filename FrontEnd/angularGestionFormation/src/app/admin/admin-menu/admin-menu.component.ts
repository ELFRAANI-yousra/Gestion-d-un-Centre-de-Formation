import { Component } from '@angular/core';
import { Router, NavigationEnd } from '@angular/router';
import { filter } from 'rxjs/operators';


@Component({
  selector: 'app-admin-menu',
  templateUrl: './admin-menu.component.html',
  styleUrls: ['./admin-menu.component.css']
})
export class AdminMenuComponent {
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

    if (currentRoute === '/admin/formation') {
      this.activeMenuItem = 'formation';
    } else if (currentRoute === '/planification') {
      this.activeMenuItem = 'planification';
    } else if (currentRoute === '/assistant') {
      this.activeMenuItem = 'assistant';
    } else if (currentRoute === '/admin/formateur') {
      this.activeMenuItem = 'fourmateur';
    } else if (currentRoute === '/admin/formateurExterne') {
      this.activeMenuItem = 'formateurExterne';
    } else if (currentRoute === '/entreprise') {
      this.activeMenuItem = 'entreprise';
    } else if (currentRoute === '/admin/evaluation') {
      this.activeMenuItem = 'evaluation';
    }else {
      this.activeMenuItem = '';
    }
  }

  logout() {
    localStorage.removeItem('token');
    this.router.navigate(['/login']); 
  }
}
