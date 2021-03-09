import {Position } from './position'

export class Portfolio {

    // private Long id;
    // private String name;
    // private String description;
    // private List<PositionDTO> positions;
    // private Long idUserProfile;
    constructor(
        private _id: number,
        private _name: string,
        private _description: string,
        private _idUserProfile: number,
        private _positions: Position[]
    ) {  
    }

    public get id(): number {
        return this._id;
    }
    
    public get name(): string {
        return this._name;
    }

    public get description(): string {
        return this._description;
    }

    public get idUserProfile(): number {
        return this._idUserProfile;
    }

    public get positions(): Position[] {
        return this._positions;
    }

    public set id(id: number) {
        this._id = id;
    }

    public set name(name: string) {
        this._name = name;
    }

    public set description(description: string) {
        this._description = description;
    }

    public set idUserProfile(idUserProfile: number) {
        this._idUserProfile = idUserProfile;
    }

    public set positions(positions: Position[]) {
        this._positions = positions;
    }
    
}


