export class PositionUpdate {

    // private BigDecimal amount;
    // private String description;
    // private LocalDateTime timestamp;
    constructor(
        private _id: number,
        private _amount: number,
        private _description: string, 
        private _timestamp: string,
    ) {}

    public get id(): number {
        return this._id;
    }
    public set id(value: number) {
        this._id = value;
    }
    
    public get amount(): number {
        return this._amount;
    }

    public get description(): string {
        return this._description
    }

    public get timestamp(): string {
        return this._timestamp;
    }

    public set amount(amount: number) {
        this._amount = amount;
    }

    public set description(description: string) {
        this._description = description;
    }

    public set timestamp(timestamp: string) {
        this._timestamp = timestamp;
    }
}
