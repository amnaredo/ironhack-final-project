import { Component, OnInit } from '@angular/core';
import { Profile } from '../models/profile';
import { ProfileService } from '../services/profile.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  profile: Profile = new Profile(0, '', '', '', '');

  constructor(
    private profileService: ProfileService
  ) { }

  ngOnInit(): void {
    this.getProfile(1);
  }

  getProfile(id: number): void {
    this.profileService.getProfile(id).subscribe(dataResult => {
      this.profile = dataResult;
    });
  }



}
