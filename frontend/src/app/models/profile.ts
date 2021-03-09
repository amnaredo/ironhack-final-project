export class Profile {
    
    constructor(
        private _id: number,
        private _firstName: string,
        private _lastName: string,
        private _email: string,
        private _photoUrl: string
    ) {  
    }

    public get id(): number {
        return this._id;
    }
    
    public get firstName(): string {
        return this._firstName;
    }

    public get lastName(): string {
        return this._lastName;
    }

    public get email(): string {
        return this._email;
    }

    public get photoUrl(): string {
        return this._photoUrl;
    }

    public set id(id: number) {
        this._id = id;
    }

    public set firstName(firstName: string) {
        this._firstName = firstName;
    }

    public set lastName(lastName: string) {
        this._lastName = lastName;
    }

    public set email(email: string) {
        this._email = email;
    }
    
    public set photoUrl(photoUrl: string) {
        this._photoUrl = photoUrl;
    }
    
}

