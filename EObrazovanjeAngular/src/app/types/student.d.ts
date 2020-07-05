import { StudyProgramme } from "./study.programme";

export interface Student {
  id: number;
  index: string;
  username: string;
  password?: string;
  firstName: string;
  lastName: string;
  email: string;
  phone: string;
  JMBG: string;
  giroAccountNumber?: string;
  yearOfEnrollment?: number;
  methodOfFinancing?: string;
  yearOfStudy?: number;
  timeEnrolled?: number;
  modelNumber?: string;
  personalReferenceNumber?: string;
  accountBalance?: number;
}
