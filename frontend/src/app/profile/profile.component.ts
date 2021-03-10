import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Profile } from '../models/profile';
import { ProfileService } from '../services/profile.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  profile: Profile = new Profile(0, '', '', '', '');

  photoUrl: string = 'https://t4.ftcdn.net/jpg/03/32/59/65/360_F_332596535_lAdLhf6KzbW6PWXBWeIFTovTii1drkbT.jpg';

  form: FormGroup;

  firstNameField: FormControl;
  lastNameField: FormControl;
  emailField: FormControl;
  photoUrlField: FormControl;


  constructor(
    private profileService: ProfileService
  ) {
   // Initialize Form Control fields
   this.firstNameField = new FormControl('', [ Validators.required ]);
   this.lastNameField = new FormControl('', [ Validators.required ]);
   this.emailField = new FormControl('', [ Validators.required, Validators.email ]);
   this.photoUrlField = new FormControl('', [ ]);

   // Initialzie Form Group
   this.form = new FormGroup({
     firstname: this.firstNameField,
     lastname: this.lastNameField,
     email: this.emailField,
     photourl: this.photoUrlField
   });

   }

  ngOnInit(): void {
    this.getProfile(1);
  }

  getProfile(id: number): void {
    this.profileService.getProfile(id).subscribe(dataResult => {
      this.profile = dataResult;
      if (this.profile.photoUrl.trim().length)
        this.photoUrl = this.profile.photoUrl;
    });
  }

  onSubmit(): void {
    this.profileService.updateProfile(this.profile.id, this.profile).subscribe(dataResult => {
      this.photoUrl = this.profile.photoUrl;
    });
    
  }


}
