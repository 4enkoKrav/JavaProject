import { Routes } from "@angular/router";
import { UserComponent } from "./user/user.component";
import { NavComponent } from "src/nav/navbar.component";
import { AppComponent } from "./app.component";
import { AdminComponent } from "./admin/admin.component";
export const appRoutes: Routes = [
    { path: 'admin', component: AdminComponent },
    { path: 'user', component: UserComponent },
    { path: '', redirectTo: '/', pathMatch: 'full'}
];
