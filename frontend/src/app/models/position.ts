import { PositionUpdate } from "./position-update";

export class Position {
    // private Long id;
    // private String coinId;
    // private BigDecimal amount;
    // private List<PositionUpdateDTO> updates;

    constructor(
        private _id: number,
        private _coinId: string,
        private _amount: number,
        private _updates: PositionUpdate[],
    ) {}

    public get id(): number {
        return this._id;
    }

    public get coinId(): string {
        return this._coinId;
    }

    public get amount(): number {
        return this._amount;
    }

    public get updates(): PositionUpdate[] {
        return this._updates;
    }

    public set id(id: number) {
        this._id = id;
    }

    public set coinId(coinId: string) {
        this._coinId = coinId;
    }

    public set amount(amount: number) {
        this._amount = amount;
    }

    public set updates(updates: PositionUpdate[]) {
        this._updates = updates;
    }
}

