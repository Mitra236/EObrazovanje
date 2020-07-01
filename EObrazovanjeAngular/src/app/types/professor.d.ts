export interface Professor {
  id: number;
  firstName: string;
  lastName: string;
  username: string;
  email: string;
  JMBG: string;
  phoneNumber?: string;
  biography?: string;
  academicTitle: string,
  position?: string,
  emplyeeFunction?: string,
  eCourseRole?: string,
  positionFrom?: Date,
  employeeFunctionFrom?: Date,
  courseDTOs?: []
}
