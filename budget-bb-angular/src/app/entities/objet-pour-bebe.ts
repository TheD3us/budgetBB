export interface Type {
    id: number;
    nom: string;
}

export interface Chronology {
    id: string;
    calendarType: string;
}

export interface DateCreation {
    year: number;
    month: string;
    dayOfMonth: number;
    dayOfWeek: string;
    era: string;
    dayOfYear: number;
    leapYear: boolean;
    monthValue: number;
    chronology: Chronology;
}

export interface Chronology2 {
    id: string;
    calendarType: string;
}

export interface DateModification {
    year: number;
    month: string;
    dayOfMonth: number;
    dayOfWeek: string;
    era: string;
    dayOfYear: number;
    leapYear: boolean;
    monthValue: number;
    chronology: Chronology2;
}

export interface ObjetBebe {
    id: number;
    nom: string;
    type: Type;
    valeur: number;
    dateCreation: DateCreation;
    dateModification: DateModification;
}