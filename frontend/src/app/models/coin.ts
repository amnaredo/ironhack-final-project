export class Coin {
    public get currentPriceUSD(): number {
        return this._currentPriceUSD;
    }
    public set currentPriceUSD(value: number) {
        this._currentPriceUSD = value;
    }
    public get currentPriceEUR(): number {
        return this._currentPriceEUR;
    }
    public set currentPriceEUR(value: number) {
        this._currentPriceEUR = value;
    }
    public get currentPriceBTC(): number {
        return this._currentPriceBTC;
    }
    public set currentPriceBTC(value: number) {
        this._currentPriceBTC = value;
    }
    public get contractAddress(): string {
        return this._contractAddress;
    }
    public set contractAddress(value: string) {
        this._contractAddress = value;
    }
    public get imageThumb(): string {
        return this._imageThumb;
    }
    public set imageThumb(value: string) {
        this._imageThumb = value;
    }
    public get imageSmall(): string {
        return this._imageSmall;
    }
    public set imageSmall(value: string) {
        this._imageSmall = value;
    }
    public get imageLarge(): string {
        return this._imageLarge;
    }
    public set imageLarge(value: string) {
        this._imageLarge = value;
    }
    public get homepage(): string {
        return this._homepage;
    }
    public set homepage(value: string) {
        this._homepage = value;
    }
    public get description(): string {
        return this._description;
    }
    public set description(value: string) {
        this._description = value;
    }
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
        private _description: string,
        private _homepage: string,
        private _imageLarge: string,
        private _imageSmall: string,
        private _imageThumb: string,
        private _contractAddress: string,

        private _currentPriceBTC: number, 
        private _currentPriceEUR: number, 
        private _currentPriceUSD: number,

    ){}

    
}
