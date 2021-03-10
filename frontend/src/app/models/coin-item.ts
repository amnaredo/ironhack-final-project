export class CoinItem {
    public get name(): string {
        return this._name;
    }
    public set name(value: string) {
        this._name = value;
    }
    public get symbol(): string {
        return this._symbol;
    }
    public set symbol(value: string) {
        this._symbol = value;
    }
    public get id(): string {
        return this._id;
    }
    public set id(value: string) {
        this._id = value;
    }

    constructor(
        private _id: string,
        private _symbol: string,
        private _name: string,
    ){}
}
